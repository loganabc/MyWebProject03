package course.study.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import course.study.dao.ICourseDao;
import course.study.vo.Course;

public class CourseDaoImpl implements ICourseDao {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	Course cou = new Course();
	Map<String, Course> map_cou = new HashMap<String,Course>();
	
	public CourseDaoImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public Course findById(String course_id) throws Exception {
		// TODO Auto-generated method stub
		
		String sql = "select * from course_info where course_id=?;";
		Course cou = new Course();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, course_id);
		rs = pstmt.executeQuery();
		if(rs.next()){
			cou.setCourse_id(rs.getString("course_id"));
			cou.setCourse_name(rs.getString("course_name"));
			return cou;
		}
		return null;
	}

	@Override
	public Map<String, Course> finfAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from course_info;";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			Course cou = new Course();
			cou.setCourse_id(rs.getString("course_id"));
			cou.setCourse_name(rs.getString("course_name"));
			map_cou.put(cou.getCourse_id(), cou);
		}
		return map_cou;
	}

}
