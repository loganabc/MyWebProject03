package course.study.operate;

import java.sql.Connection;

import course.study.dao.IAdminDao;
import course.study.dbc.DatabaseConnection;
import course.study.factory.DaoFactory;
import course.study.vo.Admin;

public class AdminOperate {
	private DatabaseConnection dbc = new DatabaseConnection();
	public boolean get(Admin ad) throws Exception{
		try{
			Connection conn = this.dbc.getConnection();
			IAdminDao dao = DaoFactory.getIAdminDaoInstance(conn);
			return dao.findLogin(ad);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

}
