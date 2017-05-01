package course.study.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
 * Servlet implementation class AdminSelectStudent
 */
@WebServlet("/AdminSelectStudent")
public class AdminSelectStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSelectStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Map<String,Student> map_selected_stu = new HashMap<String,Student>();
		
		try{
			//��ȡȫ��ѧ����Ϣ
			Map<String,Student> map_stu = new HashMap<String,Student>();
			StudentOperate uo1 = new StudentOperate();
			map_stu = uo1.list();
			Set<Map.Entry<String, Student>> set = map_stu.entrySet();
			Iterator<Map.Entry<String, Student>> iter = set.iterator();
			while(iter.hasNext()){
				Map.Entry<String, Student> me = iter.next();
				SelectCourseOperate sco = new SelectCourseOperate();
				if(sco.getById(me.getKey())!=null){//��ѧ����ѡ��
					map_selected_stu.put(me.getKey(), me.getValue());
				}
			}
			session.setAttribute("student", map_stu);//������ҳʱ��ʾȫ��ѧ����Ϣ
			session.setAttribute("map_selected_stu", map_selected_stu);
			request.getRequestDispatcher("/admin_selected_student.jsp").forward(request, response);
			
		}catch(Exception e){
			System.out.println("1");
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
