package cn.yunhe.dvd;

import java.util.Scanner;

public class DVDRentTest {
	public static void main(String[] args) {
		show_select();//չʾѡ��Ĳ���;
	}
	private static void show_select() {
		System.out.println("---------------------------DVD����ϵͳ----------------------------");
		System.out.println("1.   ����DVD");
		System.out.println("2.   �鿴DVD");
		System.out.println("3.   ɾ��DVD");
		System.out.println("4.   ���DVD");
		System.out.println("5.   �黹DVD");
		System.out.println("6.   �˳�ϵͳ");
		DVDRent dvdRent = new DVDRent();
		Scanner scan = new Scanner(System.in);
		DVDdatabase database = new DVDdatabase();
		int type = scan.nextInt();
		while (true) {
			switch (type) {
			case 1:
				System.out.println("��������Ҫ����������");
				String newBook = scan.next();
				dvdRent.addDvd(database.name,database.state,database.date,newBook);
				break;
			case 2:
				dvdRent.queryAllDvd(database.name,database.state,database.date,database.borrowCount);
				break;
			case 3:
				System.out.println("��������Ҫɾ���������ţ�");
				dvdRent.deleteDvd(database.name,database.state,database.date,database.name[scan.nextInt()]);
				break;
			case 4:
				System.out.println("������Ҫ���������");
				String brrowBook = scan.next();
				dvdRent.borrowDvd(database.name,database.state,database.date,database.borrowCount,brrowBook);
				break;
			case 5:
				System.out.println("������Ҫ�黹������");
				dvdRent.repayDvd(database.name,database.state,database.date,scan.next());
				break;
			case 6:
				System.out.println("ллʹ�ã����˳�ϵͳ");
				break;
			}
			type = scan.nextInt();
		}
	}
}
