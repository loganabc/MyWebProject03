package course.study.vo;

import java.io.Serializable;

public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String stu_id;
	
	private String name;
	
	private String card_id;
	
	private String stu_class;
	
	private String sex;
	
	private String password;
	
	private String perovince;
	
	private String address;
	
	private String tel;
	
	private String interests;

	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public String getStu_class() {
		return stu_class;
	}

	public void setStu_class(String stu_class) {
		this.stu_class = stu_class;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPerovince() {
		return perovince;
	}

	public void setPerovince(String perovince) {
		this.perovince = perovince;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Student(){
		
	}
	
	public Student(String stu_id,String name,String card_id,String stu_class
			,String sex,String password,String perovince,String address,String tel,
			String interests){
		this.stu_id = stu_id;
		this.name = name;
		this.card_id = card_id;
		this.stu_class = stu_class;
		this.sex = sex;
		this.password = password;
		this.perovince = perovince;
		this.address = address;
		this.tel = tel;
		this.interests = interests;
	}
	
	public String toString(){
		String d = new String("Ñ§ºÅ£º" + stu_id + "£¬ÐÕÃû£º" +name);
		return d;
	}

}
