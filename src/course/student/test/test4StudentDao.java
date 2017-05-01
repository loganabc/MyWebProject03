package course.student.test;

import course.study.dao.impl.StudentDaoImpl;
import course.study.dbc.DatabaseConnection;
import course.study.vo.Student;

public class test4StudentDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String stu_id = "002";
		
		String name = "xiaochen";
		
		String card_id = "002";
		
		String stu_class = "2";
		
		String sex = "man";
		
		String password = "123";
		
		String perovince = "shanghai";
		
		String address = "shanghai";
		
		String tel = "123456789";
		
		String interests = "reading";
		Student stu = new Student(stu_id,name,card_id,stu_class,
				sex,password,perovince,address,tel,interests);
		DatabaseConnection conne = new DatabaseConnection();
		StudentDaoImpl impl = new StudentDaoImpl(conne.getConnection());
		try {
			boolean x = impl.findLogin(stu);
			System.out.println(x);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
