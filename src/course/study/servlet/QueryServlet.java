package course.study.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import course.study.operate.StudentOperate;
import course.study.vo.Student;

/**
 * Servlet implementation class QueryServlet
 */
@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String type = request.getParameter("type");
		String stu_id = request.getParameter("queryById");
		String stu_name = request.getParameter("queryByName");
		StudentOperate uo = new StudentOperate();
		Map<String,Student> map_stu = new HashMap<String,Student>();
		try{
			if("byId".equals(type)){//根据学号查找
				map_stu = uo.getById(stu_id);
				if(map_stu != null){
					session.setAttribute("student", map_stu);
					request.getRequestDispatcher("/admin_info.jsp").forward(request, response);
				}else{
					request.setAttribute("isStudent", "id");
					request.getRequestDispatcher("/admin_info.jsp").forward(request, response);
				}
			}else if("byName".equals(type)){//根据姓名查找
				map_stu = uo.getByName(stu_name);
				if(map_stu != null){
					session.setAttribute("student", map_stu);
					request.getRequestDispatcher("/admin_info.jsp").forward(request, response);
				}else{
					request.setAttribute("isStudent", "name");
					request.getRequestDispatcher("/admin_info.jsp").forward(request, response);
				}
				
			}else if("showAll".equals(type)){
				map_stu = uo.list();
				session.setAttribute("student", map_stu);
				request.getRequestDispatcher("/admin_info.jsp").forward(request, response);;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
