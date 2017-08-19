package cn.yunhe.business;

import cn.yunhe.entity.Student;
import cn.yunhe.entity.Teacher;
import cn.yunhe.oop.utils.ScannerUtil;

/**
 * @author Administrator ѧ��ҵ������� ѧ���Լ������Լ�
 */
public class StudentManager extends AdminManager {
	private Teacher currentTeacher;
	private Student currentStudent;

	/*-----------------��д����,1.��½��2.��֤���룬3.��ʾ�˵��ķ���--------------*/
	/**
	 * ��д���� 1.��½
	 */
	@Override
	public void Login() {
		int notNull = 0;
		int notHave = 0;
		String teacherAccount = ScannerUtil.getString("��������İ������˺ţ�");
		for (int i = 0; i < teachers.length; i++) {
			if (teachers[i] != null) {
				notNull++;
				if (teacherAccount.equals(teachers[i].getPersonAccount())) {
					currentTeacher = teachers[i];
					super.Login();
				} else {
					notHave++;
				}
			}
		}
		if (notNull == notHave) {
			System.out.println("������İ����β�����");
		}
	}

	/**
	 * ��д���� 2.��֤�˺�����
	 */
	@Override
	public boolean comfirmPassword(String account, String psw) {
		for (int i = 0; i < currentTeacher.students.length; i++) {
			if (currentTeacher.students[i] != null) {
				if (currentTeacher.students[i].getPersonAccount().equals(account)
						&& currentTeacher.students[i].getPersonPassword().equals(psw)) {
					currentStudent = currentTeacher.students[i];
					return true;
				}

			}
		}
		return false;
	}

	/**
	 * ��д���� 3.��ʾ�˵�
	 */
	@Override
	public void showMeun() {

		System.out.println("---------------------------ѧ����----------------------------------");
		boolean iscon = true;
		while (iscon) {
			int studentChose = ScannerUtil.getInt("��Ϣ����1--�޸����룻2--�޸���Ϣ��3--��ѯ��4--�˳���");
			switch (studentChose) {
			case 1:
				updatePsw();
				break;
			case 2:
				updateInfo();
				break;
			case 3:
				queryInfo();
				break;
			case 4:
				iscon = false;
				System.out.println("�˳���ʦ��");
				break;
			default:
				System.out.println("�������");
				break;
			}
		}
	}

	/*----------------- ����˽�еķ���--------------*/

	/**
	 * 1.�޸����룻
	 */
	private void updatePsw() {
		String newPsw = ScannerUtil.getString("�����������룺");
		currentStudent.setPersonPassword(newPsw);
		System.out.println("�޸�����ɹ�");

	}

	/**
	 * 2.�޸���Ϣ��
	 */
	private void updateInfo() {
		String psw = ScannerUtil.getString("�����������룺");
		String name = ScannerUtil.getString("��������������");
		int age = ScannerUtil.getInt("�����������䣺");
		char sex = ScannerUtil.getString("���������Ա�").charAt(0);
		String school = ScannerUtil.getString("��������ѧУ��");
		String adress = ScannerUtil.getString("�������µ�ַ��");
		int score = ScannerUtil.getInt("�������·�����");
		currentStudent.setPersonPassword(psw);
		currentStudent.setPersonName(name);
		currentStudent.setPersonAge(age);
		currentStudent.setPersonSex(sex);
		currentStudent.setStudentSchool(school);
		currentStudent.setStudentAddress(adress);
		currentStudent.setStudentScore(score);
		System.out.println("�޸ĳɹ���");
	}

	/**
	 * 3.��ѯ
	 */
	private void queryInfo() {
		System.out.println(
				"�˺ţ�" + "\t" + "���룺" + "\t" + "������" + "\t" + "�Ա�" + "\t" + "ѧУ��" + "\t" + "��ַ��" + "\t" + "������");
		System.out.println(currentStudent.getPersonAccount() + "\t" + currentStudent.getPersonPassword() + "\t"
				+ currentStudent.getPersonName() + "\t" + currentStudent.getPersonSex() + "\t" + currentStudent.getStudentSchool()
				+ "\t" + currentStudent.getStudentAddress() + "\t" + currentStudent.getStudentScore());
	}

}
