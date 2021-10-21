package Service.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Admin.Acount.AccountDAO;
import Model.Admin.Acount.AccountVO;
import Service.CommandHandler;

public class Acount_tuning_proHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		AccountVO vo = new AccountVO();
		AccountDAO dao = AccountDAO.getInstance();
		
		
		vo.setRepair_machine(request.getParameter("repair_machine"));
		vo.setRepair_comment(request.getParameter("repair_comment"));
		vo.setRepair_pay(Integer.parseInt(request.getParameter("repair_pay")));
		int row = dao.Tuninginsert(vo);
		request.setAttribute("row", row);
		
		
		return "/Admin/order/order_lever.jsp";
	}

}
