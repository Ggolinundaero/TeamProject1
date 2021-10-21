package Service.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Admin.Order.OrderDAO;
import Model.Admin.Order.OrderVO;
import Service.CommandHandler;

public class Order_partslistHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		OrderDAO dao = OrderDAO.getInstance();
		String s_query = "", addtag = "", query = "", key = "";

		int totcount = 0; // 게시글 총수
		// post 방식(검색일 경우)
		if (request.getParameter("key") != null) {
			// key = URLDecoder.decode(request.getParameter("key"));
			key = request.getParameter("key");
			query = request.getParameter("search");
			s_query = query + " like '%" + key + "%'";
			totcount = dao.bc_partsListCount(s_query);
		} else {
			totcount = dao.bc_partsListCount();
		}
		//select * from bc_lever where upper(company) like ('IST');
		List<OrderVO> list2 = null;
		if (key.equals("")) {
			list2 = dao.bc_partsList();
		} else {
			list2 = dao.bc_partsList(s_query);
		}
		request.setAttribute("totcount", totcount);
		request.setAttribute("plist", list2);
		request.setAttribute("search", query);
		request.setAttribute("key", key);
		return "/Admin/order/order_parts.jsp";
	}

}
