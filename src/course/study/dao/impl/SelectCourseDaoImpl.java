package course.study.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import course.study.dao.ISelectCourseDao;
import course.study.vo.Course;
import course.study.vo.SelectCourseInfo;

public class SelectCourseDaoImpl implements ISelectCourseDao {
	
	private Connection conn = null;
	
	private PreparedStatement pstmt = null;
	
	private ResultSet rs = null;
	
	Course cou = new Course();
	
	List<SelectCourseInfo>list_sel_cou = new ArrayList<SelectCourseInfo>();
	
	public SelectCourseDaoImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public List<SelectCourseInfo> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from select_courses;";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			list_sel_cou.add(new SelectCourseInfo(rs.getString("student_id"),rs.getString("course_id")));
		}
		return list_sel_cou;
	}

	@Override
	public List<SelectCourseInfo> findById(String student_id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from select_courses where student_id=?;";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, student_id);
		rs = pstmt.executeQuery();
		if(rs.next()){
			list_sel_cou.add(new SelectCourseInfo(rs.getString("student_id"),rs.getString("course_id")));
			while(rs.next()){
				list_sel_cou.add(new SelectCourseInfo(rs.getString("student_id"),rs.getString("course_id")));
			}
			return list_sel_cou;
		}
		return null;
	}

	@Override
	public boolean doCreate(SelectCourseInfo sci) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into select_courses(student_id,"
				+ "course_id) values(?,?);";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, sci.getStudent_id());
		pstmt.setString(2, sci.getCourse_id());
		int len = pstmt.executeUpdate();
		return true;
		
	}

	@Override
	public Map<String, Integer> statisticsByCou() throws Exception {
		// TODO Auto-generated method stub
		Map<String,Integer> cou = new HashMap<String,Integer>();
		String sql = "select student_id, count(*) from select_courses"
				+ " group by student_id;";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			cou.put(rs.getString(1), rs.getInt(2));
		}
		return cou;
		
	}

}
