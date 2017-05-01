package course.study.operate;

import java.sql.Connection;
import java.util.Map;

import course.study.dao.IStudentDao;
import course.study.dbc.DatabaseConnection;
import course.study.factory.DaoFactory;
import course.study.vo.Student;

public class StudentOperate {
	
	private DatabaseConnection dbc = new DatabaseConnection();
	
	public boolean add(Student stu)throws Exception{
		try{
			Connection conn = this.dbc.getConnection();
			
			IStudentDao dao = DaoFactory.getIStudentDaoInstance(conn);
			if(dao.findById(stu.getStu_id())==null){
				return dao.doCreate(stu);
			}
			return false;
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}
	
	public boolean get(Student stu)throws Exception{
		try{
			Connection conn = this.dbc.getConnection();
			IStudentDao dao = DaoFactory.getIStudentDaoInstance(conn);
			return dao.findLogin(stu);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}
	
	public boolean update(Student stu) throws Exception{
		try{
			Connection conn = this.dbc.getConnection();
			IStudentDao dao = DaoFactory.getIStudentDaoInstance(conn);
			return dao.doUpdate(stu);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		
	}
	
	public boolean update(String id,Student stu) throws Exception{
		try{
			Connection conn = this.dbc.getConnection();
			IStudentDao dao = DaoFactory.getIStudentDaoInstance(conn);
			return dao.doUpdate(id, stu);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}
	
	public boolean delete(String id) throws Exception{
		try{
			Connection conn = this.dbc.getConnection();
			IStudentDao dao = DaoFactory.getIStudentDaoInstance(conn);
			if(dao.findById(id)!=null){
				return dao.doRemove(id);
			}
			return false;
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}
	
	public Map<String,Student>list() throws Exception{
		try{
			Connection conn = this.dbc.getConnection();
			IStudentDao dao = DaoFactory.getIStudentDaoInstance(conn);
			return dao.findAll();
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}
	
	public Map<String,Student> getById(String id)throws Exception{
		try{
			Connection conn = this.dbc.getConnection();
			IStudentDao dao = DaoFactory.getIStudentDaoInstance(conn);
			return dao.findById(id);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}
	
	public Map<String,Student>getByName(String name)throws Exception{
		try{
			Connection conn = this.dbc.getConnection();
			IStudentDao dao = DaoFactory.getIStudentDaoInstance(conn);
			return dao.findByName(name);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}
	
	public Map<String, Integer> countByPero() throws Exception{
		try{
			Connection conn = this.dbc.getConnection();
			IStudentDao dao = DaoFactory.getIStudentDaoInstance(conn);
			return dao.statisticsByPero();
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}
	
	public Map<String ,Integer> countByInter() throws Exception{
		try{
			Connection conn = this.dbc.getConnection();
			IStudentDao dao = DaoFactory.getIStudentDaoInstance(conn);
			return dao.statisticsByInter();
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}
	

}
