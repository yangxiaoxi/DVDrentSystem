package cn.yunhe.entity;

/**
 * @author Administrator
 *  Person ʵ����
 */
public class Person {
	private String personAccount;//�˺�
	private String personPassword;//����
	private String personName;//����
	private int personAge;//����
	private char personSex;//�Ա�
	
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
