package Service.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Admin.Stock.StockDAO;
import Model.Admin.Stock.StockVO;
import Service.CommandHandler;

public class Stock_modify_pro_Handler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		StockDAO dao = StockDAO.getInstance();
		StockVO vo = new StockVO();
		String order_code = request.getParameter("order_code");
		vo.setStock_amount(Integer.parseInt(request.getParameter("amount")));
		vo.setResive_state(request.getParameter("resive_state"));
		int row = dao.Stock_modify(vo, order_code);
		int page = Integer.parseInt(request.getParameter("page"));
		request.setAttribute("order_code", order_code);
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		return "/Admin/stock/stock_modify_pro.jsp";
	}

}
