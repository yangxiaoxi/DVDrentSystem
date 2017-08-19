package cn.yunhe.business;

import cn.yunhe.entity.Student;
import cn.yunhe.entity.Teacher;
import cn.yunhe.oop.utils.ScannerUtil;

/**
 * @author Administrator 学生业务管理类 学生自己管理自己
 */
public class StudentManager extends AdminManager {
	private Teacher currentTeacher;
	private Student currentStudent;

	/*-----------------重写父类,1.登陆，2.验证密码，3.显示菜单的方法--------------*/
	/**
	 * 重写父类 1.登陆
	 */
	@Override
	public void Login() {
		int notNull = 0;
		int notHave = 0;
		String teacherAccount = ScannerUtil.getString("请输入你的班主任账号：");
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
			System.out.println("你输入的班主任不存在");
		}
	}

	/**
	 * 重写父类 2.验证账号密码
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
	 * 重写父类 3.显示菜单
	 */
	@Override
	public void showMeun() {

		System.out.println("---------------------------学生端----------------------------------");
		boolean iscon = true;
		while (iscon) {
			int studentChose = ScannerUtil.getInt("信息管理：1--修改密码；2--修改信息；3--查询，4--退出；");
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
				System.out.println("退出教师端");
				break;
			default:
				System.out.println("输入错误");
				break;
			}
		}
	}

	/*----------------- 自已私有的方法--------------*/

	/**
	 * 1.修改密码；
	 */
	private void updatePsw() {
		String newPsw = ScannerUtil.getString("请输入新密码：");
		currentStudent.setPersonPassword(newPsw);
		System.out.println("修改密码成功");

	}

	/**
	 * 2.修改信息；
	 */
	private void updateInfo() {
		String psw = ScannerUtil.getString("请设置新密码：");
		String name = ScannerUtil.getString("请输入新姓名：");
		int age = ScannerUtil.getInt("请输入新年龄：");
		char sex = ScannerUtil.getString("请输入新性别：").charAt(0);
		String school = ScannerUtil.getString("请输入新学校：");
		String adress = ScannerUtil.getString("请输入新地址：");
		int score = ScannerUtil.getInt("请输入新分数：");
		currentStudent.setPersonPassword(psw);
		currentStudent.setPersonName(name);
		currentStudent.setPersonAge(age);
		currentStudent.setPersonSex(sex);
		currentStudent.setStudentSchool(school);
		currentStudent.setStudentAddress(adress);
		currentStudent.setStudentScore(score);
		System.out.println("修改成功！");
	}

	/**
	 * 3.查询
	 */
	private void queryInfo() {
		System.out.println(
				"账号：" + "\t" + "密码：" + "\t" + "姓名：" + "\t" + "性别" + "\t" + "学校：" + "\t" + "地址：" + "\t" + "分数：");
		System.out.println(currentStudent.getPersonAccount() + "\t" + currentStudent.getPersonPassword() + "\t"
				+ currentStudent.getPersonName() + "\t" + currentStudent.getPersonSex() + "\t" + currentStudent.getStudentSchool()
				+ "\t" + currentStudent.getStudentAddress() + "\t" + currentStudent.getStudentScore());
	}

}
