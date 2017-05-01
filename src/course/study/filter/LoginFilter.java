package course.study.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import course.study.operate.AdminOperate;
import course.study.operate.StudentOperate;
import course.study.vo.Admin;
import course.study.vo.Student;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		String userid = req.getParameter("userid");
		String password = req.getParameter("password");
		session.setAttribute("loginUser", userid);
		String loginUser = (String) session.getAttribute("loginUser");
		
		if(loginUser !=null){
			StudentOperate uo = new StudentOperate();
			AdminOperate ao = new AdminOperate();
			
			Student stu = new Student();
			Admin ad = new Admin();
			
			Map<String,Student> map_stu = new HashMap<String,Student>();
			Map<String,Student> map_stu0 = new HashMap<String,Student>();
			
			stu.setStu_id(userid);
			stu.setPassword(password);
			
			ad.setAd_id(userid);
			ad.setPassword(password);
			
			try{
				String rand = (String) session.getAttribute("rand");
				String input = request.getParameter("rand");
				if(rand.equals(input)){//验证码通过
					
					if(uo.get(stu)){//如果是学生登录
						session.setAttribute("student_login", "true");
						session.setAttribute("student", stu);
						request.getRequestDispatcher("/student_info.jsp").forward(request, response);
						
					}else if(ao.get(ad)){//管理员登录
						session.setAttribute("admin_login", "true");
						StudentOperate uo1 = new StudentOperate();
						map_stu = uo1.list();
						map_stu0 = map_stu;
						session.setAttribute("student", map_stu);
						session.setAttribute("all_student", map_stu0);
						
						request.getRequestDispatcher("/admin_info.jsp").forward(request, response);
					}else{//用户名或者密码错误
						request.setAttribute("flag", "false");
						request.getRequestDispatcher("/login.jsp").forward(request, response);
					}
				}else{//验证码错误
					request.setAttribute("Verification-Code", "false");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(session.getAttribute("student_login") == "true" || session.getAttribute("admin_login")=="true"){
			chain.doFilter(request, response);
		}else{//没有经过登录验证
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
