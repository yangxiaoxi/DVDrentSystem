package cn.yunhe.business;

import cn.yunhe.entity.Student;
import cn.yunhe.entity.Teacher;
import cn.yunhe.oop.utils.ScannerUtil;

/**
 * @author Administrator ����Աҵ���� ����������ʦ
 */
public class AdminManager {
	public static Teacher[] teachers = new Teacher[3];

	public AdminManager() {
		Teacher teacher1 = new Teacher("fuqi", "123", "����", 40, '��', "�����4��", "����", 10000);
		Student stu1 = new Student("yangxi", "123", "����", 18, 'Ů', "���ƴ�", "�����ƶ�123", 100);
		teacher1.students[0] = stu1;
		teachers[0] = teacher1;
	}

	/*
	 * ---------------------------------���� ���̳еķ���---------------------------------
	 */
	/**
	 * 1.��½����
	 */
	public void Login() {
		String account = ScannerUtil.getString("�������˺ţ�");
		String psw = ScannerUtil.getString("���������룺");
		boolean aIsTrue = comfirmPassword(account, psw);
		if (aIsTrue) {
			System.out.println("��½�ɹ�");
			showMeun();
		} else {
			System.out.println("�˺������벻ƥ��");
		}
	}

	/**
	 * 2.��֤�˺ź����뷽��
	 * 
	 * @return �����˺ź�������֤�Ƿ���ȷ
	 */
	public boolean comfirmPassword(String account, String psw) {
		if (account.equals("admin") && psw.equals("admin")) {
			return true;
		}
		return false;
	}

	/**
	 * 3.��ʾ�˵�
	 */
	public void showMeun() {
		System.out.println("---------------------------����Ա----------------------------------");

		boolean isCon = true;
		while (isCon) {
			int chose = ScannerUtil.getInt("��ѡ�����ʦ�Ĳ�����1---���ӣ�2---ɾ����3---�޸ģ�4---��ѯ��5---�˳�");
			switch (chose) {
			case 1:
				addTeacher();
				break;
			case 2:
				deleteTeacher();
				break;
			case 3:
				updateTeacher();
				break;
			case 4:
				querryTeacher();
				break;
			case 5:
				isCon = false;
				System.out.println("�˳�����Ա");
				break;
			default:
				System.out.println("�������");
				break;
			}
		}

	}
	/*-----------------------------�Լ�˽�еķ��������̳�---------------------------------*/

	/**
	 * 4.�������ʦ
	 */
	private void addTeacher() {
		int notNull = 0;
		String account = ScannerUtil.getString("��������ʦ�˺ţ�");
		for (int i = 0; i < teachers.length; i++) {
			if (teachers[i] == null) {
				String psw = ScannerUtil.getString("���������룺");
				String name = ScannerUtil.getString("������������");
				int age = ScannerUtil.getInt("���������䣺");
				char sex = ScannerUtil.getString("�������Ա�").charAt(0);
				String className = ScannerUtil.getString("���������༶��");
				String teacher_Profession = ScannerUtil.getString("������ְλ��");
				int teacher_salary = ScannerUtil.getInt("������нˮ��");
				Teacher newTeacher = new Teacher(account, psw, name, age, sex, className, teacher_Profession,
						teacher_salary);
				teachers[i] = newTeacher;
				System.out.println("��ӳɹ���");
				break;
			} else {
				notNull++;
				if (teachers[i].getPersonAccount().equals(account)) {
					System.out.println("����ʦ�Ѵ���");
					return;
				}

			}
		}
		if (notNull == teachers.length) {
			System.out.println("��ʦ����");
		}
	}

	/**
	 * 5.ɾ����ʦ
	 */
	private void deleteTeacher() {
		int haveCount = 0;
		int notHaveCount = 0;
		String account = ScannerUtil.getString("������Ҫɾ���Ľ�ʦ���˺ţ�");
		for (int i = 0; i < teachers.length; i++) {
			if (teachers[i] != null) {
				haveCount++;
				if (teachers[i].getPersonAccount().equals(account)) {
					boolean isYes = ScannerUtil.getBoolean("ȷ��Ҫɾ����ѧ�ŵ�ѧ����");
					if (isYes) {
						teachers[i] = null;
						System.out.println("ɾ���ɹ���");
					}

				} else {
					notHaveCount++;
				}

			}
		}
		if (haveCount == notHaveCount) {
			System.out.println("������Ľ�ʦ������");
		}

	}

	/**
	 * 6.�޸���ʦ
	 */
	private void updateTeacher() {
		String account = ScannerUtil.getString("������Ҫ�޸ĵĽ�ʦ���˺ţ�");
		int haveCount = 0;
		int notHaveCount = 0;
		for (int i = 0; i < teachers.length; i++) {
			if (teachers[i] != null) {
				haveCount++;
				if (teachers[i].getPersonAccount().equals(account)) {
					String psw = ScannerUtil.getString("�����������룺");
					String name = ScannerUtil.getString("��������������");
					int age = ScannerUtil.getInt("�����������䣺");
					char sex = ScannerUtil.getString("���������Ա�").charAt(0);
					String className = ScannerUtil.getString("����������°༶��");
					String teacher_Profession = ScannerUtil.getString("��������ְλ��");
					int teacher_salary = ScannerUtil.getInt("��������нˮ��");
					teachers[i].setPersonPassword(psw);
					teachers[i].setPersonName(name);
					teachers[i].setPersonAge(age);
					teachers[i].setPersonSex(sex);
					teachers[i].setClassName(className);
					teachers[i].setTeacher_Profession(teacher_Profession);
					teachers[i].setTeacher_salary(teacher_salary);
					System.out.println("�޸ĳɹ�");
					break;
				} else {
					notHaveCount++;
				}
			}
		}
		if (haveCount == notHaveCount) {
			System.out.println("������Ľ�ʦ�����ڣ�");
		}
	}

	/**
	 * 7����ѯ������ʦ
	 */
	private void querryTeacher() {
		System.out.println(
				"�˺ţ�" + "\t" + "���룺" + "\t" + "������" + "\t" + "�Ա�" + "\t" + "����༶��" + "\t" + "ְλ��" + "\t" + "нˮ��");
		for (Teacher teacher : teachers) {
			if (teacher != null) {
				System.out.println(teacher.getPersonAccount() + "\t" + teacher.getPersonPassword() + "\t"
						+ teacher.getPersonName() + "\t" + teacher.getPersonSex() + "\t" + teacher.getClassName() + "\t"
						+ teacher.getTeacher_Profession() + "\t" + teacher.getTeacher_salary());
			}
		}
	}

}
