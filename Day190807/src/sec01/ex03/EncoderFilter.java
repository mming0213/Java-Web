//package sec01.ex03;
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//
///**
// * Servlet Filter implementation class EncoderFilter
// */
//@WebFilter("/*") //WebFilter �ֳ����̼��� �̿��� ��� ��û�� ���͸� ��ġ�� ��.
//public class EncoderFilter implements Filter { //����� ���� ���ʹ� �ݵ�� Filter�������̽��� �����ؾ���.
//	ServletContext context;
//    /**
//     * Default constructor. 
//     */
//    public EncoderFilter() {
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see Filter#destroy()
//	 */
//	public void destroy() {
//		// TODO Auto-generated method stub
//		System.out.println("destory ȣ��");
//	}
//
//	/**
//	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
//	 */
//	//doFilter() �ȿ��� ���� ���� ��� ����.
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		// TODO Auto-generated method stub
//		// place your code here
//
//		// pass the request along the filter chain
//		System.out.println("doFilter ȣ��");
//		request.setCharacterEncoding("utf-8"); //�ѱ� ���ڵ� ���� �۾�.
//		response.setContentType("text/html;charset=utf-8");
//		String context = ((HttpServletRequest)request).getContextPath();
//		String pathinfo = ((HttpServletRequest)request).getRequestURI();
//		String realPath = request.getRealPath(pathinfo);
//		String mesg = " Context ����:" + context
//						+"\n URI����: "+ pathinfo
//						+"\n ������ ���: " + realPath;
//		System.out.println(mesg);
//		long begin = System.currentTimeMillis(); //��û ���Ϳ��� ��û ó�� ���� �ð��� ����.
//		chain.doFilter(request, response); //���� ���ͷ� �ѱ�� �۾� ����.
//		
//		long end = System.currentTimeMillis(); //��û ���Ϳ��� ��û ó�� ���� �ð��� ����.
//		System.out.println("�۾� �ð�:" + (end-begin)+"ms");
//	}
//
//	/**
//	 * @see Filter#init(FilterConfig)
//	 */
//	public void init(FilterConfig fConfig) throws ServletException {
//		// TODO Auto-generated method stub
//		System.out.println("utf-8 ���ڵ�......");
//		context = fConfig.getServletContext();
//	}
//
//}
