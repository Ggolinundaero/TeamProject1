package Service.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Admin.Stock.StockDAO;
import Model.Admin.Stock.StockVO;
import Service.CommandHandler;

import util.PageIndex;

public class Stock_listHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		StockDAO dao = StockDAO.getInstance();
		String s_query ="", search="", key ="";
		String url = "/Admin/stock/Stock_list.do";
		int totcount = 0; //총 게시물 카운트
		if(request.getParameter("key") != null) {
			key=request.getParameter("key");
			search = request.getParameter("search");
			s_query = search + " like '%" + key + "%'";
			totcount = dao.Stock_count(s_query);
		}else {
			totcount = dao.Stock_count();
		}
		
		int nowpage = 1;
		int maxlist = 10;
		int totpage =0 ;
		if (totcount%maxlist==0) {
			totpage = totcount / maxlist;
		}else {
			totpage = totcount / maxlist +1;
		}
		//페이지 번호가 입력될 경우
		if(request.getParameter("page") != null) {
			nowpage = Integer.parseInt(request.getParameter("page"));
		}
		int startpage= (nowpage -1)*maxlist +1;
		int endpage = nowpage* maxlist;
		int listcount = totcount-((nowpage-1)*maxlist);
		List<StockVO> list = null;
		if(key.equals("")) {
			list = dao.Stock_list(startpage, endpage);
		}else {
			list = dao.Stock_list(s_query,startpage,endpage);
		}
		String pageSkip="";
		if(key.equals("")) {
			pageSkip = PageIndex.pageList(nowpage, totpage, url, "");
		}else {
			pageSkip = PageIndex.pageListHan(nowpage, totpage, url, search,key);
		}
		
		request.setAttribute("page", nowpage);
		request.setAttribute("totcount", totcount);
		request.setAttribute("totpage", totpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("list", list);
		request.setAttribute("pageSkip", pageSkip);
		request.setAttribute("search", search);
		request.setAttribute("key", key);
		return "/Admin/stock/stock_list.jsp";

	}

}
