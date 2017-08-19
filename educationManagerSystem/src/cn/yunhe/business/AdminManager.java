package cn.yunhe.business;

import cn.yunhe.entity.Student;
import cn.yunhe.entity.Teacher;
import cn.yunhe.oop.utils.ScannerUtil;

/**
 * @author Administrator 管理员业务类 用来管理老师
 */
public class AdminManager {
	public static Teacher[] teachers = new Teacher[3];

	public AdminManager() {
		Teacher teacher1 = new Teacher("fuqi", "123", "符琦", 40, '男', "计算机4班", "教授", 10000);
		Student stu1 = new Student("yangxi", "123", "杨茜", 18, '女', "湖科大", "七区移动123", 100);
		teacher1.students[0] = stu1;
		teachers[0] = teacher1;
	}

	/*
	 * ---------------------------------可以 被继承的方法---------------------------------
	 */
	/**
	 * 1.登陆方法
	 */
	public void Login() {
		String account = ScannerUtil.getString("请输入账号：");
		String psw = ScannerUtil.getString("请输入密码：");
		boolean aIsTrue = comfirmPassword(account, psw);
		if (aIsTrue) {
			System.out.println("登陆成功");
			showMeun();
		} else {
			System.out.println("账号与密码不匹配");
		}
	}

	/**
	 * 2.验证账号和密码方法
	 * 
	 * @return 返回账号和密码验证是否正确
	 */
	public boolean comfirmPassword(String account, String psw) {
		if (account.equals("admin") && psw.equals("admin")) {
			return true;
		}
		return false;
	}

	/**
	 * 3.显示菜单
	 */
	public void showMeun() {
		System.out.println("---------------------------管理员----------------------------------");

		boolean isCon = true;
		while (isCon) {
			int chose = ScannerUtil.getInt("请选择对老师的操作：1---增加；2---删除；3---修改；4---查询；5---退出");
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
				System.out.println("退出管理员");
				break;
			default:
				System.out.println("输入错误");
				break;
			}
		}

	}
	/*-----------------------------自己私有的方法，被继承---------------------------------*/

	/**
	 * 4.添加新老师
	 */
	private void addTeacher() {
		int notNull = 0;
		String account = ScannerUtil.getString("请输入老师账号：");
		for (int i = 0; i < teachers.length; i++) {
			if (teachers[i] == null) {
				String psw = ScannerUtil.getString("请设置密码：");
				String name = ScannerUtil.getString("请输入姓名：");
				int age = ScannerUtil.getInt("请输入年龄：");
				char sex = ScannerUtil.getString("请输入性别：").charAt(0);
				String className = ScannerUtil.getString("请输入管理班级：");
				String teacher_Profession = ScannerUtil.getString("请输入职位：");
				int teacher_salary = ScannerUtil.getInt("请输入薪水：");
				Teacher newTeacher = new Teacher(account, psw, name, age, sex, className, teacher_Profession,
						teacher_salary);
				teachers[i] = newTeacher;
				System.out.println("添加成功！");
				break;
			} else {
				notNull++;
				if (teachers[i].getPersonAccount().equals(account)) {
					System.out.println("该老师已存在");
					return;
				}

			}
		}
		if (notNull == teachers.length) {
			System.out.println("教师已满");
		}
	}

	/**
	 * 5.删除老师
	 */
	private void deleteTeacher() {
		int haveCount = 0;
		int notHaveCount = 0;
		String account = ScannerUtil.getString("请输入要删除的教师的账号：");
		for (int i = 0; i < teachers.length; i++) {
			if (teachers[i] != null) {
				haveCount++;
				if (teachers[i].getPersonAccount().equals(account)) {
					boolean isYes = ScannerUtil.getBoolean("确定要删除该学号的学生吗？");
					if (isYes) {
						teachers[i] = null;
						System.out.println("删除成功！");
					}

				} else {
					notHaveCount++;
				}

			}
		}
		if (haveCount == notHaveCount) {
			System.out.println("你输入的教师不存在");
		}

	}

	/**
	 * 6.修改老师
	 */
	private void updateTeacher() {
		String account = ScannerUtil.getString("请输入要修改的教师的账号：");
		int haveCount = 0;
		int notHaveCount = 0;
		for (int i = 0; i < teachers.length; i++) {
			if (teachers[i] != null) {
				haveCount++;
				if (teachers[i].getPersonAccount().equals(account)) {
					String psw = ScannerUtil.getString("请设置新密码：");
					String name = ScannerUtil.getString("请输入新姓名：");
					int age = ScannerUtil.getInt("请输入新年龄：");
					char sex = ScannerUtil.getString("请输入新性别：").charAt(0);
					String className = ScannerUtil.getString("请输入管理新班级：");
					String teacher_Profession = ScannerUtil.getString("请输入新职位：");
					int teacher_salary = ScannerUtil.getInt("请输入新薪水：");
					teachers[i].setPersonPassword(psw);
					teachers[i].setPersonName(name);
					teachers[i].setPersonAge(age);
					teachers[i].setPersonSex(sex);
					teachers[i].setClassName(className);
					teachers[i].setTeacher_Profession(teacher_Profession);
					teachers[i].setTeacher_salary(teacher_salary);
					System.out.println("修改成功");
					break;
				} else {
					notHaveCount++;
				}
			}
		}
		if (haveCount == notHaveCount) {
			System.out.println("你输入的教师不存在！");
		}
	}

	/**
	 * 7、查询所有老师
	 */
	private void querryTeacher() {
		System.out.println(
				"账号：" + "\t" + "密码：" + "\t" + "姓名：" + "\t" + "性别" + "\t" + "管理班级：" + "\t" + "职位：" + "\t" + "薪水：");
		for (Teacher teacher : teachers) {
			if (teacher != null) {
				System.out.println(teacher.getPersonAccount() + "\t" + teacher.getPersonPassword() + "\t"
						+ teacher.getPersonName() + "\t" + teacher.getPersonSex() + "\t" + teacher.getClassName() + "\t"
						+ teacher.getTeacher_Profession() + "\t" + teacher.getTeacher_salary());
			}
		}
	}

}
