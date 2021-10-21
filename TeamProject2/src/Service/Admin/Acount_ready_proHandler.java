package Service.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Admin.Acount.AccountDAO;
import Model.Admin.Acount.AccountVO;
import Service.CommandHandler;

public class Acount_ready_proHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		AccountVO vo = new AccountVO();
		AccountDAO dao = AccountDAO.getInstance();
		
		vo.setOH(Integer.parseInt(request.getParameter("OH")));
		vo.setFH(Integer.parseInt(request.getParameter("FH")));
		vo.setOT(Integer.parseInt(request.getParameter("OT")));
		vo.setFT(Integer.parseInt(request.getParameter("FT")));
		vo.setTT(Integer.parseInt(request.getParameter("TT")));
		vo.setFTT(Integer.parseInt(request.getParameter("FTT")));
		vo.setTotal(Integer.parseInt(request.getParameter("total")));
		vo.setStartdate(request.getParameter("startdate"));
		int row = dao.Startinsert(vo);
		int r = 0;
		r = dao.StardDay();
		
		request.setAttribute("row", row);
		
		
		return "/Admin/order/order_lever.jsp";
	}

}
