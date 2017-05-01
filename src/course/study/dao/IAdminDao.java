package course.study.dao;

import course.study.vo.Admin;

public interface IAdminDao {
	public boolean findLogin(Admin ad)throws Exception;

}
