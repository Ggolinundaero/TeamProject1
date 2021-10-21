package Service.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Admin.Recive.ReceiveDAO;
import Model.Admin.Recive.ReceiveVO;
import Service.CommandHandler;
import Utility.PageIndex;

public class Recive_listHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		ReceiveDAO dao = ReceiveDAO.getInstance();
		String s_query = "", addtag = "", query = "", key = "";

		int totcount = 0; // 게시글 총수
		// post 방식(검색일 경우)
		if (request.getParameter("key") != null) {
			// key = URLDecoder.decode(request.getParameter("key"));
			key = request.getParameter("key");
			query = request.getParameter("search");
			s_query = query + " like '%" + key + "%'";
			addtag = "&search=" + query + "&key=" + key;
			totcount = dao.RecevieListCount(s_query);
		} else {
			totcount = dao.RecevieListCount();
		}

		int nowpage = 1; // 현재 페이지
		int maxlist = 10; // 페이지당 글 수
		int totpage = 1; // 총 페이지수

		if (totcount % maxlist == 0) {
			totpage = totcount / maxlist;
		} else {
			totpage = totcount / maxlist + 1;
		}

		if (request.getParameter("page") != null) {
			nowpage = Integer.parseInt(request.getParameter("page"));
		}

		int pagestart = (nowpage - 1) * maxlist + 1;
		int endpage = nowpage * maxlist;
		int listcount = totcount - ((nowpage - 1) * maxlist);

		List<ReceiveVO> list = null;
		if (key.equals("")) {
			list = dao.ReceiveList(pagestart, endpage);
		} else {
			list = dao.ReceiveList(s_query, pagestart, endpage);
		}
		String pageSkip = "";
		if (key.equals("")) {
			pageSkip = PageIndex.pageList(nowpage, totpage, "/Admin/recive/Receive_list.do", addtag);
		} else {
			pageSkip = PageIndex.pageListHan(nowpage, totpage, "/Admin/recive/Receive_list.do", query, key);
		}
		request.setAttribute("totcount", totcount);
		request.setAttribute("list", list);
		request.setAttribute("listcount", listcount);
		request.setAttribute("page", nowpage);
		request.setAttribute("totpage", totpage);
		request.setAttribute("pageSkip", pageSkip);
		request.setAttribute("search", query);
		request.setAttribute("key", key);
		return null;
	}

}
