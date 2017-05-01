package course.study.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import course.study.dao.IStudentDao;
import course.study.vo.Student;

public class StudentDaoImpl implements IStudentDao {
	
	private Connection conn = null;
	
	private PreparedStatement pstmt = null;
	
	private ResultSet rs = null;
	
	Student stu = new Student();
	
	Map<String,Student> map_stu = new HashMap<String,Student>();
	
	public StudentDaoImpl(Connection conn){
		this.conn = conn;
	}

	@Override
	public boolean doCreate(Student stu) throws Exception {
		// TODO Auto-generated method stub
		//创建学生
		String sql = "insert into student_info(student_id,student_name,"
				+ "card_id,class,sex,password,perovince,address,tel,interests)"
				+ "values(?,?,?,?,?,?,?,?,?,?);";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, stu.getStu_id());
		pstmt.setString(2, stu.getName());
		pstmt.setString(3, stu.getCard_id());
		pstmt.setString(4, stu.getStu_class());
		pstmt.setString(5, stu.getSex());
		pstmt.setString(6, stu.getPassword());
		pstmt.setString(7, stu.getPerovince());
		pstmt.setString(8, stu.getAddress());
		pstmt.setString(9, stu.getTel());
		pstmt.setString(10, stu.getInterests());
		
		int len = pstmt.executeUpdate();
		return true;
	}

	@Override
	public boolean findLogin(Student stu) throws Exception {
		// TODO Auto-generated method stub
		//查找学生，事实上是根据学生的学号和密码查询的
		//这里的代码还可以优化
		String sql = "SELECT * from student_info where student_id=? AND password=?;";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, stu.getStu_id());
		this.pstmt.setString(2, stu.getPassword());
		this.rs = this.pstmt.executeQuery();
		if(rs.next()){
			stu.setName(rs.getString("student_name"));
			stu.setCard_id(rs.getString("card_id"));
			stu.setStu_class(rs.getString("class"));
			stu.setSex(rs.getString("sex"));
			stu.setPassword(rs.getString("password"));
			stu.setPerovince(rs.getString("perovince"));
			stu.setAddress(rs.getString("address"));
			stu.setTel(rs.getString("tel"));
			stu.setInterests(rs.getString("interests"));
			return true;
		}
		return false;
	}

	@Override
	public boolean doUpdate(Student stu) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update student_info set student_name=?,card_id=?,"
				+ "class=?,sex=?,password=?,perovince=?,address=?,tel=?,"
				+ "interests=? where student_id=?;";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, stu.getName());
		this.pstmt.setString(2, stu.getCard_id());
		this.pstmt.setString(3, stu.getStu_class());
		this.pstmt.setString(4, stu.getSex());
		this.pstmt.setString(5, stu.getPassword());
		this.pstmt.setString(6, stu.getPerovince());
		this.pstmt.setString(7, stu.getAddress());
		this.pstmt.setString(8, stu.getTel());
		this.pstmt.setString(9, stu.getInterests());
		this.pstmt.setString(10, stu.getStu_id());
		
		int len = this.pstmt.executeUpdate();
		
		return true;
	}

	@Override
	public boolean doUpdate(String id, Student stu) throws Exception {
		// TODO Auto-generated method stub
		if(findById(stu.getStu_id()) == null || stu.getStu_id().equals(id)){
			String sql = "update student_info set student_id=?,student_name=?,card_id=?,"
					+ "class=?,sex=?,password=?,perovince=?,address=?,tel=?,interests=? where student_id = ?;";
					
			this.pstmt = this.conn.prepareStatement(sql);
			
			this.pstmt.setString(1, stu.getStu_id());
			this.pstmt.setString(2, stu.getName());
			this.pstmt.setString(3, stu.getCard_id());
			this.pstmt.setString(4, stu.getStu_class());
			this.pstmt.setString(5, stu.getSex());
			this.pstmt.setString(6, stu.getPassword());
			this.pstmt.setString(7, stu.getPerovince());
			this.pstmt.setString(8, stu.getAddress());
			this.pstmt.setString(9, stu.getTel());
			this.pstmt.setString(10, stu.getInterests());
			this.pstmt.setString(11, id);
			
			int len = pstmt.executeUpdate();
			
			return true;
		}
		return false;
	}

	@Override
	public boolean doRemove(String id) throws Exception {
		// TODO Auto-generated method stub
		//根据学生学号删除
		String sql = "delete from student_info where student_id = ?;";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		int len = pstmt.executeUpdate();
		if(len != 0){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public Map<String, Student> findById(String id) throws Exception {
		// TODO Auto-generated method stub
		
		String sql = "select * from student_info where student_id = ?;";
		Student stu = new Student();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		if(rs.next()){
			stu.setStu_id(rs.getString("student_id"));
			stu.setName(rs.getString("student_name"));
			stu.setCard_id(rs.getString("card_id"));
			stu.setStu_class(rs.getString("class"));
			stu.setSex(rs.getString("sex"));
			stu.setPassword(rs.getString("password"));
			stu.setPerovince(rs.getString("perovince"));
			stu.setAddress(rs.getString("address"));
			stu.setTel(rs.getString("tel"));
			stu.setInterests(rs.getString("interests"));
			
			map_stu.put(stu.getStu_id(), stu);
			return map_stu;
		}
		return null;
	}

	@Override
	public Map<String, Student> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		//使用姓名查找学生，可能一个姓名对应多个学生
		String sql = "select * from student_info where student_name = ?;";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			Student stu0 = new Student();
			stu0.setAddress(rs.getString("address"));
			stu0.setCard_id(rs.getString("card_id"));
			stu0.setInterests(rs.getString("interests"));
			stu0.setName(rs.getString("student_name"));
			stu0.setPassword(rs.getString("password"));
			stu0.setPerovince(rs.getString("perovince"));
			stu0.setSex(rs.getString("sex"));
			stu0.setStu_class(rs.getString("class"));
			stu0.setStu_id(rs.getString("student_id"));
			stu0.setTel(rs.getString("tel"));
			map_stu.put(stu0.getStu_id(), stu0);
			while(rs.next()){
				Student stu = new Student();
				
				stu.setAddress(rs.getString("address"));
				stu.setCard_id(rs.getString("card_id"));
				stu.setInterests(rs.getString("interests"));
				stu.setName(rs.getString("name"));
				stu.setPassword(rs.getString("password"));
				stu.setPerovince(rs.getString("perovince"));
				stu.setSex(rs.getString("sex"));
				stu.setStu_class(rs.getString("class"));
				stu.setStu_id(rs.getString("student_id"));
				stu.setTel(rs.getString("tel"));
				
				map_stu.put(stu.getStu_id(), stu);
			}
			return map_stu;
		}
		return null;
	}

	@Override
	public Map<String, Student> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from student_info;";
		this.pstmt = this.conn.prepareStatement(sql);
		this.rs = pstmt.executeQuery();
		while(rs.next()){
			Student stu = new Student();
			stu.setAddress(rs.getString("address"));
			stu.setCard_id(rs.getString("card_id"));
			stu.setInterests(rs.getString("interests"));
			stu.setName(rs.getString("student_name"));
			stu.setPassword(rs.getString("password"));
			stu.setPerovince(rs.getString("perovince"));
			stu.setSex(rs.getString("sex"));
			stu.setStu_class(rs.getString("class"));
			stu.setStu_id(rs.getString("student_id"));
			stu.setTel(rs.getString("tel"));
			map_stu.put(stu.getStu_id(), stu);
		}
		return map_stu;
		
	}

	@Override
	public Map<String, Integer> statisticsByPero() throws Exception {
		// TODO Auto-generated method stub
		Map<String,Integer> pero = new HashMap<String,Integer>();
		String sql = "select perovince,count(*) from student_info"
				+ " group by perovince;";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			pero.put(rs.getString(1),rs.getInt(2));
		}
		return pero;
		
	}

	@Override
	public Map<String, Integer> statisticsByInter() throws Exception {
		// TODO Auto-generated method stub
		Map<String,Integer> inter = new HashMap<String,Integer>();
		String sql = "select interests,count(*) from student_info"
				+ " group by interests";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			inter.put(rs.getString(1), rs.getInt(2));
		}
		return inter;
	}

}
