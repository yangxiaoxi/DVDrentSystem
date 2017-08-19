package cn.yunhe.entity;

/**
 * @author Administrator
 *  学生类 实体类 继承Person类
 */
public class Student  extends Person{
	   //账号，密码，姓名，年龄，性别 继承自Person类
       //学生自己的属性
	private String studentSchool;//学校
	private String studentAddress;//地址
	private  int studentScore;//分数
	public String getStudentSchool() {
		return studentSchool;
	}
	public void setStudentSchool(String studentSchool) {
		this.studentSchool = studentSchool;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public int getStudentScore() {
		return studentScore;
	}
	public void setStudentScore(int studentScore) {
		this.studentScore = studentScore;
	}
	public Student() {
		super();
	}
	public Student(String personAccount, String personPassword, String personName, int personAge, char personSex,String studentSchool, String studentAddress, int studentScore) {
		super(personAccount, personPassword, personName, personAge, personSex);
		this.studentSchool = studentSchool;
		this.studentAddress = studentAddress;
		this.studentScore = studentScore;
	}
	
	
	
}
