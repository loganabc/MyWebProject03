package course.study.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
 * Servlet implementation class StudentCourseCenter
 */
@WebServlet("/StudentCourseCenter")
public class StudentCourseCenter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentCourseCenter() {
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
		CourseOperate co = new CourseOperate();
		SelectCourseOperate sco = new SelectCourseOperate();
		
		Map<String,Course> all_course = new HashMap<String,Course>();
		List<SelectCourseInfo> selected_courses = new ArrayList<SelectCourseInfo>();
		Map<String,Course> selected_courses_info = new HashMap<String,Course>();
		try{
			all_course = co.list();
			selected_courses = sco.getById(stu.getStu_id());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Map<String,Course> not_selected = all_course;
		if(selected_courses != null){
			Iterator<SelectCourseInfo> iter1 = selected_courses.iterator();
			System.out.println("1");
			while(iter1.hasNext()){
				SelectCourseInfo str = iter1.next();
				Set<Map.Entry<String, Course>> set = not_selected.entrySet();
				Iterator<Map.Entry<String, Course>> iter2 = set.iterator();
				while(iter2.hasNext()){
					Map.Entry<String, Course> me = iter2.next();
					if(str.getCourse_id().equals(me.getKey())){//该学生已经选了该课程
						selected_courses_info.put(me.getKey(), me.getValue());
						not_selected.remove(me.getKey());
						break;
					}
				}
			}
		}
		session.setAttribute("selected_courses_info", selected_courses_info);
		session.setAttribute("not_selected", not_selected);
		request.getRequestDispatcher("/select-courses.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
