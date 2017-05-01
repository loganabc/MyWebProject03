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
 * Servlet implementation class AdminDelete
 */
@WebServlet("/AdminDelete")
public class AdminDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String stu_id = request.getParameter("stu_id");
		StudentOperate uo = new StudentOperate();
		Map<String,Student> map_stu = new HashMap<String,Student>();
		try{
			if(uo.delete(stu_id)){
				StudentOperate uo1 = new StudentOperate();
				map_stu = uo1.list();
				session.setAttribute("student", map_stu);
				request.setAttribute("delete_success", "true");
				request.getRequestDispatcher("/admin_info.jsp").forward(request, response);
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
