package Service.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Admin.Acount.AccountDAO;
import Model.Admin.Acount.AccountVO;
import Service.CommandHandler;

public class Acount_game_proHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		AccountVO vo = new AccountVO();
		AccountDAO dao = AccountDAO.getInstance();
		
		
		
		vo.setMachine_code(request.getParameter("machine_code"));
		vo.setCash(Integer.parseInt(request.getParameter("cash")));
		vo.setCard(Integer.parseInt(request.getParameter("card")));
		int row = dao.Gameinsert(vo);
		request.setAttribute("row", row);
		
		
		return "/Admin/order/order_lever.jsp";
	}

}
