package Service.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Admin.Stock.StockDAO;
import Service.CommandHandler;

public class Stock_Delete_Handler implements CommandHandler {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String order_code = request.getParameter("order_code");
		StockDAO dao = StockDAO.getInstance();
		int row = dao.Stock_delete(order_code);
		int page = Integer.parseInt(request.getParameter("page"));
		request.setAttribute("order_code", order_code);
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		return "/Admin/stock/stock_delete_pro.jsp";
	}
}
