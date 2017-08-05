package cn.yunhe.dvd;

import java.util.Scanner;

public class DVDRentTest {
	public static void main(String[] args) {
		show_select();//展示选择的操作;
	}
	private static void show_select() {
		System.out.println("---------------------------DVD租赁系统----------------------------");
		System.out.println("1.   新增DVD");
		System.out.println("2.   查看DVD");
		System.out.println("3.   删除DVD");
		System.out.println("4.   借出DVD");
		System.out.println("5.   归还DVD");
		System.out.println("6.   退出系统");
		DVDRent dvdRent = new DVDRent();
		Scanner scan = new Scanner(System.in);
		DVDdatabase database = new DVDdatabase();
		int type = scan.nextInt();
		while (true) {
			switch (type) {
			case 1:
				System.out.println("请输入需要新增书名：");
				String newBook = scan.next();
				dvdRent.addDvd(database.name,database.state,database.date,newBook);
				break;
			case 2:
				dvdRent.queryAllDvd(database.name,database.state,database.date,database.borrowCount);
				break;
			case 3:
				System.out.println("请输入你要删除的书的序号：");
				dvdRent.deleteDvd(database.name,database.state,database.date,database.name[scan.nextInt()]);
				break;
			case 4:
				System.out.println("请输入要借的书名：");
				String brrowBook = scan.next();
				dvdRent.borrowDvd(database.name,database.state,database.date,database.borrowCount,brrowBook);
				break;
			case 5:
				System.out.println("请输入要归还的书名");
				dvdRent.repayDvd(database.name,database.state,database.date,scan.next());
				break;
			case 6:
				System.out.println("谢谢使用，已退出系统");
				break;
			}
			type = scan.nextInt();
		}
	}
}
