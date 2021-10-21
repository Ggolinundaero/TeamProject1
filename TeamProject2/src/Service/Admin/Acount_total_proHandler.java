package Service.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Admin.Acount.AccountDAO;
import Model.Admin.Acount.AccountVO;
import Service.CommandHandler;

public class Acount_total_proHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		AccountVO vo = new AccountVO();
		AccountDAO dao = AccountDAO.getInstance();
		vo.setOrder_fee(Integer.parseInt(request.getParameter("order_fee")));
		vo.setRepair_fee(Integer.parseInt(request.getParameter("repair_fee")));
		vo.setTuning_fee(Integer.parseInt(request.getParameter("tuning_fee")));
		vo.setMaintain_fee(Integer.parseInt(request.getParameter("maintain_fee")));
		vo.setCash_sales(Integer.parseInt(request.getParameter("cash_sales")));
		vo.setCard_sales(Integer.parseInt(request.getParameter("card_sales")));
		vo.setAccount_total(Integer.parseInt(request.getParameter("account_total")));
		int row = dao.Totalinsert(vo);
		request.setAttribute("row", row);
		
		
		
		
		return "/Admin/order/order_lever.jsp";
	}

}
