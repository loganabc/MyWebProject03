package course.study.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import course.study.operate.SelectCourseOperate;
import course.study.operate.StudentOperate;
import course.study.vo.Student;

/**
 * Servlet implementation class CourseStatistics
 */
@WebServlet("/CourseStatistics")
public class CourseStatistics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseStatistics() {
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
			Map<String,Integer>cou = new HashMap<String,Integer>();
			SelectCourseOperate sco = new SelectCourseOperate();
			cou = sco.countByCou();
			
			Set<Map.Entry<String, Integer>> set3 = cou.entrySet();
			Iterator<Entry<String, Integer>> iter3 = set3.iterator();
			
			Map<Student,Integer> cou0 = new HashMap<Student,Integer>();
			//取得全部学生信息
			StudentOperate so = new StudentOperate();
			Map<String,Student> all_student = new HashMap<String,Student>();
			all_student = so.list();
			
			Set<Map.Entry<String, Student>> set1 = all_student.entrySet();
			Iterator<Map.Entry<String, Student>> iter1 = set1.iterator();
			while(iter1.hasNext()){
				Map.Entry<String, Student> me1 = iter1.next();
				cou0.put(me1.getValue(), 0);//将所有学生选课赋值为0
			}
			
			while(iter3.hasNext()){
				Map.Entry<String, Integer> me3 = iter3.next();
				String student_id = me3.getKey();
				
				Set<Map.Entry<Student, Integer>> set2 = cou0.entrySet();
				Iterator<Map.Entry<Student, Integer>> iter2 = set2.iterator();
				while(iter2.hasNext()){
					Map.Entry<Student, Integer> me2 = iter2.next();
					if(me2.getKey().getStu_id().equals(student_id)){
						Student stu = me2.getKey();
						cou0.remove(me2.getKey());
						cou0.put(stu, me3.getValue());
						break;
					}
				}
			}
			
			List<Map.Entry<Student, Integer>> list = new ArrayList<Map.Entry<Student,Integer>>(cou0.entrySet());
			Collections.sort(list,new Comparator<Map.Entry<Student, Integer>>() {
				public int compare(Entry<Student, Integer>o1,Entry<Student, Integer>o2){
					return o2.getValue().compareTo(o1.getValue());
				}
			});
			session.setAttribute("list", list);
			request.getRequestDispatcher("/admin_course_statistics.jsp").forward(request, response);
			
			
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
