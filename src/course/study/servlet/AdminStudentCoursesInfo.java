package course.study.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import course.study.operate.CourseOperate;
import course.study.operate.SelectCourseOperate;
import course.study.vo.Course;
import course.study.vo.SelectCourseInfo;

/**
 * Servlet implementation class AdminStudentCoursesInfo
 */
@WebServlet("/AdminStudentCoursesInfo")
public class AdminStudentCoursesInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminStudentCoursesInfo() {
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
			
			Map<String,Course> map_cou = new HashMap<String,Course>();
			String student_id = request.getParameter("student_id");
			SelectCourseOperate sco = new SelectCourseOperate();
			List<SelectCourseInfo> list_sel_cou = new ArrayList<SelectCourseInfo>();
			list_sel_cou = sco.getById(student_id);
			Iterator<SelectCourseInfo> iter = list_sel_cou.iterator();
			while(iter.hasNext()){
				SelectCourseInfo sci = iter.next();
				CourseOperate co = new CourseOperate();
				map_cou.put(sci.getCourse_id(), co.getById(sci.getCourse_id()));
			}
			session.setAttribute("map_cou", map_cou);
			request.getRequestDispatcher("/admin_student_courses_info.jsp").forward(request, response);
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
