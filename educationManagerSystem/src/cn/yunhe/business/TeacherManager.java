package cn.yunhe.business;

import cn.yunhe.entity.Student;
import cn.yunhe.entity.Teacher;
import cn.yunhe.oop.utils.ScannerUtil;

/**
 * @author Administrator ��ʦҵ������࣬ ���Թ���ѧ��
 */
public class TeacherManager extends AdminManager {

	public Teacher currentTeacher;
	public TeacherManager() {
	}

	/* ��д���෽��,1.��֤���룬2.��ʾ�˵��ķ��� */
	/**
	 * ��д���� 2.��֤����
	 */
	@Override
	public boolean comfirmPassword(String account, String psw) {
		for (int i = 0; i < teachers.length; i++) {
			if (teachers[i] != null) {
				if (teachers[i].getPersonAccount().equals(account) && teachers[i].getPersonPassword().equals(psw)) {
					currentTeacher = teachers[i];
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
		System.out.println("---------------------------��ʦ��----------------------------------");
		boolean iscon = true;
		while (iscon) {
			int teacherChose = ScannerUtil.getInt("�༶����1--����ѧ����2--ɾ��ѧ����3--�޸�ѧ����4--��ѯѧ����5--�˳�");
			switch (teacherChose) {
			case 1:
				addStudent();
				break;
			case 2:
				deleteStudent();
				break;
			case 3:
				updateStudent();
				break;
			case 4:
				queryStudent();
				break;
			case 5:
				iscon = false;
				System.out.println("�˳���ʦ��");
				break;
			default:
				System.out.println("�������");
				break;
			}
		}

	}

	/* �Լ�˽�еķ��� */
	/**
	 * 1.����ѧ����
	 */
	private void addStudent() {
		int notNull = 0;
		String account = ScannerUtil.getString("������ѧ���˺ţ�");
		for (int i = 0; i < currentTeacher.students.length; i++) {
			if (currentTeacher.students[i] == null) {
				String psw = ScannerUtil.getString("���������룺");
				String name = ScannerUtil.getString("������������");
				int age = ScannerUtil.getInt("���������䣺");
				char sex = ScannerUtil.getString("�������Ա�").charAt(0);
				String school = ScannerUtil.getString("������ѧУ��");
				String adress = ScannerUtil.getString("������ѧ����ַ��");
				int score = ScannerUtil.getInt("�������������");
				Student newStudent = new Student(account, psw, name, age, sex, school, adress, score);
				currentTeacher.students[i] = newStudent;
				System.out.println("��ӳɹ���");
				break;
			} else {
				notNull++;
				if (currentTeacher.students[i].getPersonAccount().equals(account)) {
					System.out.println("�������ѧ���Ѵ���");
					return ;
				}
			}
		}
		if (notNull == currentTeacher.students.length) {
			System.out.println("ѧ��������");
		}

	}

	/**
	 * 2.ɾ��ѧ����
	 */
	private void deleteStudent() {
		int haveCount = 0;
		int notHaveCount = 0;
		String account = ScannerUtil.getString("������Ҫɾ����ѧ�����˺ţ�");
			for(int i=0;i<currentTeacher.students.length;i++) {
				if(currentTeacher.students[i]!=null) {
					haveCount++;
					if(currentTeacher.students[i].getPersonAccount().equals(account) ) {
						boolean isYes = ScannerUtil.getBoolean("ȷ��Ҫɾ����ѧ�ŵ�ѧ����");
						if(isYes) {
							currentTeacher.students[i]=null;
							System.out.println("ɾ���ɹ���");
						}
						
					}else {
						notHaveCount++;
					}
					
				}
			}
			if(haveCount == notHaveCount) {
				System.out.println("�������ѧ��������");
			}
		
	}

	/**
	 * 3.�޸�ѧ����
	 */
	private void updateStudent() {
		String account = ScannerUtil.getString("������Ҫ�޸ĵĽ�ʦ���˺ţ�");
		int haveCount = 0;
		int notHaveCount = 0;
		for (int i = 0; i < currentTeacher.students.length; i++) {
			if (currentTeacher.students[i] != null) {
				haveCount++;
				if (currentTeacher.students[i].getPersonAccount().equals(account) ){
					String psw = ScannerUtil.getString("���������룺");
					String name = ScannerUtil.getString("������������");
					int age = ScannerUtil.getInt("���������䣺");
					char sex = ScannerUtil.getString("�������Ա�").charAt(0);
					String school = ScannerUtil.getString("������ѧУ��");
					String adress = ScannerUtil.getString("������ѧ����ַ��");
					int score = ScannerUtil.getInt("�������������");
					currentTeacher.students[i].setPersonPassword(psw);
					currentTeacher.students[i].setPersonName(name);
					currentTeacher.students[i].setPersonAge(age);
					currentTeacher.students[i].setPersonSex(sex);
					currentTeacher.students[i].setStudentSchool(school);
					currentTeacher.students[i].setStudentAddress(adress);
					currentTeacher.students[i].setStudentScore(score);
					System.out.println("�޸ĳɹ�");
					break;
				} else {
					notHaveCount++;
				}
			}
		}
		if(haveCount==notHaveCount) {
			System.out.println("������Ľ�ʦ�����ڣ�");
		}
	}

	/**
	 * 4.ɾ��ѧ��
	 */
	private void queryStudent() {
		System.out.println(
				"�˺ţ�" + "\t" + "���룺" + "\t" + "������" + "\t" + "�Ա�" + "\t" + "ѧУ��" + "\t" + "��ַ��" + "\t" + "������");
		for (Student student : currentTeacher.students) {
			if (student != null) {
				System.out.println(student.getPersonAccount() + "\t" + student.getPersonPassword() + "\t"
						+ student.getPersonName() + "\t" + student.getPersonSex() + "\t" + student.getStudentSchool()
						+ "\t" + student.getStudentAddress() + "\t" + student.getStudentScore());
			}
		}
	}

}
