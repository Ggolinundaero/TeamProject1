package Service.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Admin.Stock.StockDAO;
import Model.Admin.Stock.StockVO;
import Service.CommandHandler;

public class Stock_viewHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		StockDAO dao = StockDAO.getInstance();
		String order_code = request.getParameter("order_code");
		StockVO vo = dao.stockView(order_code);
		int page = Integer.parseInt(request.getParameter("page"));
		request.setAttribute("vo",vo);
		request.setAttribute("page", page);
		return "/Admin/stock/stock_view.jsp";
	}

}
