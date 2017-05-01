package course.study.operate;

import java.sql.Connection;
import java.util.Map;

import course.study.dao.ICourseDao;
import course.study.dbc.DatabaseConnection;
import course.study.factory.DaoFactory;
import course.study.vo.Course;

public class CourseOperate {
	private DatabaseConnection dbc = new DatabaseConnection();
	
	public Map<String,Course> list() throws Exception{
		try{
			Connection conn = this.dbc.getConnection();
			ICourseDao dao = DaoFactory.getICourseDaoInstance(conn);
			return dao.finfAll();
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}
	
	public Course getById(String course_id) throws Exception{
		try{
			Connection conn = this.dbc.getConnection();
			ICourseDao dao = DaoFactory.getICourseDaoInstance(conn);
			return dao.findById(course_id);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

}
