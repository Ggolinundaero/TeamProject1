package Service.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Admin.Acount.AccountDAO;
import Model.Admin.Acount.AccountVO;
import Service.CommandHandler;

public class Acount_shop_proHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		AccountVO vo = new AccountVO();
		AccountDAO dao = AccountDAO.getInstance();
		
		vo.setCard_charge(Integer.parseInt(request.getParameter("card_charge")));
		vo.setCash(Integer.parseInt(request.getParameter("cash")));
		vo.setCard(Integer.parseInt(request.getParameter("card")));
		vo.setCash_charge(Integer.parseInt(request.getParameter("cash_charge")));
		int row = dao.Shopinsert(vo);
		request.setAttribute("row", row);
		
		
		return "/Admin/order/order_lever.jsp";
	}

}
