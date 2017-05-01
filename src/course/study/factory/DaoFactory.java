package course.study.factory;

import java.sql.Connection;

import course.study.dao.IAdminDao;
import course.study.dao.ICourseDao;
import course.study.dao.ISelectCourseDao;
import course.study.dao.IStudentDao;
import course.study.dao.impl.AdminDaoImpl;
import course.study.dao.impl.CourseDaoImpl;
import course.study.dao.impl.SelectCourseDaoImpl;
import course.study.dao.impl.StudentDaoImpl;

public class DaoFactory {
	public static IStudentDao getIStudentDaoInstance(Connection conn){
		return new StudentDaoImpl(conn);
	}
	
	public static IAdminDao getIAdminDaoInstance(Connection conn){
		return new AdminDaoImpl(conn);
	}
	
	public static ICourseDao getICourseDaoInstance(Connection conn){
		return new CourseDaoImpl(conn);
	}
	
	public static ISelectCourseDao getISelectCourseDaoInstance(Connection conn){
		return new SelectCourseDaoImpl(conn);
	}

}
