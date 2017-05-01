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

/**
 * Servlet implementation class StudentStatistics
 */
@WebServlet("/StudentStatistics")
public class StudentStatistics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentStatistics() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			HttpSession session = request.getSession();
			Map<String, Integer> pero = new HashMap<String ,Integer>();
			Map<String,Integer> inter = new HashMap<String,Integer>();
			StudentOperate so1 = new StudentOperate();
			StudentOperate so2 = new StudentOperate();
			pero = so1.countByPero();
			inter = so2.countByInter();
			session.setAttribute("pero", pero);
			session.setAttribute("inter", inter);
			request.getRequestDispatcher("/admin_student_statistics.jsp").forward(request, response);
			
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
