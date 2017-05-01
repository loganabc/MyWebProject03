package course.study.servlet;

import java.io.IOException;
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
import course.study.vo.Student;

/**
 * Servlet implementation class StudentSelectCourses
 */
@WebServlet("/StudentSelectCourses")
public class StudentSelectCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSelectCourses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Student stu = (Student) session.getAttribute("student");
		SelectCourseInfo sci = new SelectCourseInfo();
		String course_id[] = request.getParameterValues("course");
		
		//ÒÑÑ¡¿Î³Ì
		Map<String,Course> selected_courses_info = (Map<String, Course>) session.getAttribute("selected_courses_info");
		Map<String,Course> not_selected = (Map<String, Course>) session.getAttribute("not_selected");
		if(course_id != null){
			for(int x = 0;x<course_id.length;x++){
				SelectCourseOperate sco = new SelectCourseOperate();
				sci.setStudent_id(stu.getStu_id());
				sci.setCourse_id(course_id[x]);
				try{
					sco.add(sci);
					CourseOperate co1 = new CourseOperate();
					selected_courses_info.put(course_id[x], co1.getById(course_id[x]));
					not_selected.remove(course_id[x]);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			session.setAttribute("selected_courses_info", selected_courses_info);
			session.setAttribute("not_selected", not_selected);
			request.setAttribute("is_select", "true");
			request.getRequestDispatcher("/select-courses.jsp").forward(request, response);
		}else{
			request.setAttribute("is_select", "false");
			request.getRequestDispatcher("/select-courses.jsp").forward(request, response);
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
