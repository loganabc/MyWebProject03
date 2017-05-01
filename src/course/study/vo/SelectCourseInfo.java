package course.study.vo;

import java.io.Serializable;

public class SelectCourseInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String student_id;
	
	private String course_id;

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	
	public SelectCourseInfo(){
		
	}
	
	public SelectCourseInfo(String student_id,String course_id){
		this.student_id = student_id;
		this.course_id = course_id;
	}

}
