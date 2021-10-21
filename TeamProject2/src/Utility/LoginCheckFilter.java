package Utility;

import javax.servlet.Filter;

public class LoginCheckFilter implements Filter {
	/*
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest =(HttpServletRequest) request;
		String url = httpRequest.getRequestURI();
		System.out.println(url);

		HttpSession session = httpRequest.getSession();
		memberVO member = (memberVO) session.getAttribute("userid");
		boolean bool = false;
		if(member != null) {
			HttpServletResponse htt = (HttpServletResponse) response;
			htt.sendRedirect("/");
			
			if(session.getAttribute("sub3815") != null) {
				bool = true;
			}
		}
		if(bool) {
			chain.doFilter(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/AdminLogin/index.jsp");
			rd.forward(request, response);
		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}
*/
}

