package cn.yunhe.entity;

/**
 * @author Administrator
 *  ѧ���� ʵ���� �̳�Person��
 */
public class Student  extends Person{
	   //�˺ţ����룬���������䣬�Ա� �̳���Person��
       //ѧ���Լ�������
	private String studentSchool;//ѧУ
	private String studentAddress;//��ַ
	private  int studentScore;//����
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
