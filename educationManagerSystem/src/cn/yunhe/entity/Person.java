package cn.yunhe.entity;

/**
 * @author Administrator
 *  Person 实体类
 */
public class Person {
	private String personAccount;//账号
	private String personPassword;//密码
	private String personName;//姓名
	private int personAge;//年龄
	private char personSex;//性别
	
	public String getPersonAccount() {
		return personAccount;
	}
	public void setPersonAccount(String personAccount) {
		this.personAccount = personAccount;
	}
	public String getPersonPassword() {
		return personPassword;
	}
	public void setPersonPassword(String personPassword) {
		this.personPassword = personPassword;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public int getPersonAge() {
		return personAge;
	}
	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}
	public char getPersonSex() {
		return personSex;
	}
	public void setPersonSex(char personSex) {
		this.personSex = personSex;
	}
	public Person() {
	}
	public Person(String personAccount, String personPassword, String personName, int personAge, char personSex) {
		this.personAccount = personAccount;
		this.personPassword = personPassword;
		this.personName = personName;
		this.personAge = personAge;
		this.personSex = personSex;
	}
	
	
	
	
}
