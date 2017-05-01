package course.study.dao;

import java.util.List;
import java.util.Map;

import course.study.vo.SelectCourseInfo;

public interface ISelectCourseDao {
	public List<SelectCourseInfo> findAll() throws Exception;
	public List<SelectCourseInfo> findById(String Student_id)throws Exception;
	public boolean doCreate(SelectCourseInfo sci) throws Exception;
	public Map<String,Integer> statisticsByCou()throws Exception;
	

}
