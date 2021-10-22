package Service.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Admin.Order.OrderVO;
import Model.Admin.Stock.StockDAO;
import Service.CommandHandler;

public class stock_writeHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		int page = Integer.parseInt(request.getParameter("page"));
		String order_code = request.getParameter("order_code");
		StockDAO dao = StockDAO.getInstance();
		OrderVO vo = dao.insertRe(order_code);
		request.setAttribute("page", page);
		request.setAttribute("vo", vo);
		return "/Admin/stock/stock_write.jsp";
	}

}
