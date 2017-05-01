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
 * Servlet implementation class AdminAdd
 */
@WebServlet("/AdminAdd")
public class AdminAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		/** 将填写后表单的信息取出 **/
		String stu_id = request.getParameter("student_id");
		String stu_name = request.getParameter("name");
		String card_id = request.getParameter("card_id");
		String stu_class = request.getParameter("stu_class");
		String sex = request.getParameter("sex");
		String password = request.getParameter("password");
		String perovince = request.getParameter("perovince");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String interest = request.getParameter("interest");
		System.out.println(perovince);
		
		/** 将表单信息存到对象中 **/
		Student stu = new Student();
		stu.setAddress(address);
		stu.setCard_id(card_id);
		stu.setInterests(interest);
		stu.setName(stu_name);
		stu.setPassword(password);
		stu.setPerovince(perovince);
		stu.setSex(sex);
		stu.setStu_class(stu_class);
		stu.setStu_id(stu_id);
		stu.setTel(tel);
		
		StudentOperate uo = new StudentOperate();
		Map<String,Student> map_stu = new HashMap<String,Student>();
		try{
			if(uo.add(stu)){
				StudentOperate uo1 = new StudentOperate();
				map_stu = uo1.list();
				session.setAttribute("student", map_stu);
				request.setAttribute("add_success", "true");
				request.getRequestDispatcher("/admin_info.jsp").forward(request, response);
						
			}else{
				request.setAttribute("add_success", "false");
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
