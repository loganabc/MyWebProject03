package course.student.test;

import course.study.dao.impl.AdminDaoImpl;
import course.study.dbc.DatabaseConnection;
import course.study.vo.Admin;

public class test4AdminDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String admin_id = "admin";
		String admin_password = "123456";
		Admin ad = new Admin();
		ad.setAd_id(admin_id);
		ad.setPassword(admin_password);
		DatabaseConnection conne = new DatabaseConnection();
		AdminDaoImpl impl = new AdminDaoImpl(conne.getConnection());
		try {
			System.out.println(impl.findLogin(ad));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
