package Service.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Admin.Order.OrderDAO;
import Model.Admin.Order.OrderVO;
import Model.Admin.Stock.StockDAO;
import Model.Admin.Stock.StockVO;
import Service.CommandHandler;

public class stock_write_proHandler implements CommandHandler{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		StockDAO dao = StockDAO.getInstance();
		StockVO vo = new StockVO();
		OrderVO vo1 = new OrderVO();
		String order_code = request.getParameter("order_code");
		vo.setCompany_name(request.getParameter("company_name"));
		vo.setStock(request.getParameter("stock"));		
		vo.setStock_amount(Integer.parseInt(request.getParameter("stock_amount")));
		vo.setModel_name(request.getParameter("model_name"));
		vo.setModel_price(Integer.parseInt(request.getParameter("model_price")));
		vo.setKinds(request.getParameter("kinds"));
		vo.setOrder_code(request.getParameter("order_code"));
		vo.setOption_status(request.getParameter("option_status"));
		vo.setParts_status(request.getParameter("parts_status"));
		int row = dao.Stock_insert(vo);
		vo1.setResive_state(request.getParameter("resive_state"));
		int row1 = dao.update(vo1, order_code);
		int page = Integer.parseInt(request.getParameter("page"));
		request.setAttribute("row", row);
		request.setAttribute("row1", row1);
		request.setAttribute("page", page);
		return "/Admin/stock/stock_write_pro.jsp";
	}

}
