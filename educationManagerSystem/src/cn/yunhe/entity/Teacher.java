package cn.yunhe.entity;

/**
 * @author Administrator
 * 老师实体类，继承Person类
 */
public class Teacher  extends Person{
	public Student [] students = new Student[10];
	//账号，密码，姓名，年龄，性别 继承自Person类
	//老师自己的属性 
	private String className;// 班级名称
	private String teacher_Profession;//，职称，
	private double teacher_salary;//薪水
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getTeacher_Profession() {
		return teacher_Profession;
	}
	public void setTeacher_Profession(String teacher_Profession) {
		this.teacher_Profession = teacher_Profession;
	}
	public double getTeacher_salary() {
		return teacher_salary;
	}
	public void setTeacher_salary(double teacher_salary) {
		this.teacher_salary = teacher_salary;
	}
	public Teacher(){
		
	}
	public Teacher(String personAccount, String personPassword, String personName, int personAge, char personSex,String className, String teacher_Profession, double teacher_salary) {
		super(personAccount, personPassword, personName, personAge, personSex);
		this.className = className;
		this.teacher_Profession = teacher_Profession;
		this.teacher_salary = teacher_salary;
	}
	 
	
	
	
	
}
