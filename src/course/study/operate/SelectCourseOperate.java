package course.study.operate;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import course.study.dao.ISelectCourseDao;
import course.study.dbc.DatabaseConnection;
import course.study.factory.DaoFactory;
import course.study.vo.SelectCourseInfo;

public class SelectCourseOperate {
	private DatabaseConnection dbc = new DatabaseConnection();
	public List<SelectCourseInfo> getById(String student_id)throws Exception{
		try{
			Connection conn = this.dbc.getConnection();
			ISelectCourseDao dao = DaoFactory.getISelectCourseDaoInstance(conn);
			return dao.findById(student_id);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}
	
	public boolean add(SelectCourseInfo sci) throws Exception{
		try{
			Connection conn = this.dbc.getConnection();
			ISelectCourseDao dao = DaoFactory.getISelectCourseDaoInstance(conn);
			return dao.doCreate(sci);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}
	
	public List<SelectCourseInfo> list() throws Exception{
		try{
			Connection conn = this.dbc.getConnection();
			ISelectCourseDao dao = DaoFactory.getISelectCourseDaoInstance(conn);
			return dao.findAll();
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}
	
	public Map<String, Integer> countByCou() throws Exception{
		try{
			Connection conn = this.dbc.getConnection();
			ISelectCourseDao dao = DaoFactory.getISelectCourseDaoInstance(conn);
			return dao.statisticsByCou();
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

}
