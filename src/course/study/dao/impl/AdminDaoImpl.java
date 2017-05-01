package course.study.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import course.study.dao.IAdminDao;
import course.study.vo.Admin;

public class AdminDaoImpl implements IAdminDao {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public AdminDaoImpl(Connection conn){
		this.conn = conn;
	}

	@Override
	public boolean findLogin(Admin ad) throws Exception {
		// TODO Auto-generated method stub
		
		String sql = "select * from admin_info WHERE admin_id=? AND admin_password=?;";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, ad.getAd_id());
		this.pstmt.setString(2, ad.getPassword());
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			ad.setAd_id(rs.getString("admin_id"));
			ad.setPassword(rs.getString("admin_password"));
			return true;
		}
		return false;
	}

}
