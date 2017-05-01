package course.study.dao;

import java.util.Map;

import course.study.vo.Course;

public interface ICourseDao {
	public Course findById(String course_id)throws Exception;
	public Map<String,Course> finfAll() throws Exception;

}
