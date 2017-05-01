package course.study.dao;

import java.util.Map;

import course.study.vo.Student;

public interface IStudentDao {
	
	public boolean doCreate(Student stu)throws Exception;
	public boolean findLogin(Student stu)throws Exception;
	public boolean doUpdate(Student stu)throws Exception;
	public boolean doUpdate(String id,Student stu)throws Exception;
	public boolean doRemove(String id)throws Exception;
	
	public Map<String,Student> findById(String id)throws Exception;
	public Map<String,Student> findByName(String name) throws Exception;
	public Map<String,Student> findAll() throws Exception;
	public Map<String,Integer> statisticsByPero() throws Exception;
	public Map<String,Integer> statisticsByInter() throws Exception;

}
