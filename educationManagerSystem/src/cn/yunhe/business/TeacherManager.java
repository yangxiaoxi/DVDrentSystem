package cn.yunhe.business;

import cn.yunhe.entity.Student;
import cn.yunhe.entity.Teacher;
import cn.yunhe.oop.utils.ScannerUtil;

/**
 * @author Administrator 教师业务管理类， 可以管理学生
 */
public class TeacherManager extends AdminManager {

	public Teacher currentTeacher;
	public TeacherManager() {
	}

	/* 重写父类方法,1.验证密码，2.显示菜单的方法 */
	/**
	 * 重写父类 2.验证密码
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
	 * 重写父类 3.显示菜单
	 */
	@Override
	public void showMeun() {
		System.out.println("---------------------------教师端----------------------------------");
		boolean iscon = true;
		while (iscon) {
			int teacherChose = ScannerUtil.getInt("班级管理：1--增加学生；2--删除学生；3--修改学生，4--查询学生；5--退出");
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
				System.out.println("退出教师端");
				break;
			default:
				System.out.println("输入错误");
				break;
			}
		}

	}

	/* 自己私有的方法 */
	/**
	 * 1.增加学生；
	 */
	private void addStudent() {
		int notNull = 0;
		String account = ScannerUtil.getString("请输入学生账号：");
		for (int i = 0; i < currentTeacher.students.length; i++) {
			if (currentTeacher.students[i] == null) {
				String psw = ScannerUtil.getString("请设置密码：");
				String name = ScannerUtil.getString("请输入姓名：");
				int age = ScannerUtil.getInt("请输入年龄：");
				char sex = ScannerUtil.getString("请输入性别：").charAt(0);
				String school = ScannerUtil.getString("请输入学校：");
				String adress = ScannerUtil.getString("请输入学生地址：");
				int score = ScannerUtil.getInt("请输入如分数：");
				Student newStudent = new Student(account, psw, name, age, sex, school, adress, score);
				currentTeacher.students[i] = newStudent;
				System.out.println("添加成功！");
				break;
			} else {
				notNull++;
				if (currentTeacher.students[i].getPersonAccount().equals(account)) {
					System.out.println("你输入的学生已存在");
					return ;
				}
			}
		}
		if (notNull == currentTeacher.students.length) {
			System.out.println("学生招满了");
		}

	}

	/**
	 * 2.删除学生；
	 */
	private void deleteStudent() {
		int haveCount = 0;
		int notHaveCount = 0;
		String account = ScannerUtil.getString("请输入要删除的学生的账号：");
			for(int i=0;i<currentTeacher.students.length;i++) {
				if(currentTeacher.students[i]!=null) {
					haveCount++;
					if(currentTeacher.students[i].getPersonAccount().equals(account) ) {
						boolean isYes = ScannerUtil.getBoolean("确定要删除该学号的学生吗？");
						if(isYes) {
							currentTeacher.students[i]=null;
							System.out.println("删除成功！");
						}
						
					}else {
						notHaveCount++;
					}
					
				}
			}
			if(haveCount == notHaveCount) {
				System.out.println("你输入的学生不存在");
			}
		
	}

	/**
	 * 3.修改学生；
	 */
	private void updateStudent() {
		String account = ScannerUtil.getString("请输入要修改的教师的账号：");
		int haveCount = 0;
		int notHaveCount = 0;
		for (int i = 0; i < currentTeacher.students.length; i++) {
			if (currentTeacher.students[i] != null) {
				haveCount++;
				if (currentTeacher.students[i].getPersonAccount().equals(account) ){
					String psw = ScannerUtil.getString("请设置密码：");
					String name = ScannerUtil.getString("请输入姓名：");
					int age = ScannerUtil.getInt("请输入年龄：");
					char sex = ScannerUtil.getString("请输入性别：").charAt(0);
					String school = ScannerUtil.getString("请输入学校：");
					String adress = ScannerUtil.getString("请输入学生地址：");
					int score = ScannerUtil.getInt("请输入如分数：");
					currentTeacher.students[i].setPersonPassword(psw);
					currentTeacher.students[i].setPersonName(name);
					currentTeacher.students[i].setPersonAge(age);
					currentTeacher.students[i].setPersonSex(sex);
					currentTeacher.students[i].setStudentSchool(school);
					currentTeacher.students[i].setStudentAddress(adress);
					currentTeacher.students[i].setStudentScore(score);
					System.out.println("修改成功");
					break;
				} else {
					notHaveCount++;
				}
			}
		}
		if(haveCount==notHaveCount) {
			System.out.println("你输入的教师不存在！");
		}
	}

	/**
	 * 4.删除学生
	 */
	private void queryStudent() {
		System.out.println(
				"账号：" + "\t" + "密码：" + "\t" + "姓名：" + "\t" + "性别" + "\t" + "学校：" + "\t" + "地址：" + "\t" + "分数：");
		for (Student student : currentTeacher.students) {
			if (student != null) {
				System.out.println(student.getPersonAccount() + "\t" + student.getPersonPassword() + "\t"
						+ student.getPersonName() + "\t" + student.getPersonSex() + "\t" + student.getStudentSchool()
						+ "\t" + student.getStudentAddress() + "\t" + student.getStudentScore());
			}
		}
	}

}
