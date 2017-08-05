package cn.yunhe.dvd;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DVDRent {
	String DVDName;
	String DVDState;
	String date;
	private SimpleDateFormat format;
	// private DVDRent[] DVDs;
	// DVDdatabase dvdDatabase;

	 
	/**
	 * ����dvd
	 * @param name  ������Ҫ����dvd���ֵ�����
	 * @param state ������Ҫ����dvd ״̬������
	 * @param date  ������Ҫ����dvd ���ڵ�����
	 * @param newBook   ������Ҫ����������
	 */
	public void addDvd(String[] name, String[] state, String[] date,String newBook) {
		for(int i=0;i<name.length;i++) {
			if(name[i]==null) {
				name[i] = newBook;
				state[i] ="�ɽ�";
				format = new SimpleDateFormat("yyyy-MM-dd");
				date[i] = format.format(new Date());
				break;
			}
		}
		
		System.out.println( "������"+newBook);
	}

	/**
	 * ɾ��dvd
	 */
	public void deleteDvd(String[] name, String[] state, String[] date, String deleteBook) {
		for (int i = 0; i < name.length; i++) {
			if (name[i].equals(deleteBook)) {
				System.out.println("ɾ����" + name[i]);
				moveArry(name,i);
//				name[i] = name[i + 1];
				moveArry(state,i);
//				state[i] = state[i + 1];
				moveArry(date,i);
//				date[i] = date[i + 1];
				 break;
				// continue;
			}
		}
	}
	/**
	 * �ú�����ר��Ϊɾ�����������һ��Ԫ�ض�ר�ų���ĺ�������ʾ��ɾ����������ĳһ��Ԫ��ʱ����Ԫ�غ��������ȫ����ǰ�ƶ�һ��λ��
	 * @param a������Ҫɾ������һ����������
	 * @param i������Ҫɾ�������������λ��
	 */
	public  void moveArry( String[] a,int i) {
		for(int j=i;j<a.length-i;j++) {
			a[j] = a[j+1];
		}
	}
 
	/**
	 * �鿴dvd
	 * @param name
	 * @param state
	 * @param date
	 * @param borrowCount  ÿ����Ľ��ȥ�Ĵ���
	 */
	public void queryAllDvd(String[] name, String[] state, String[] date,int[] borrowCount) {
		System.out.println("\t"+ "����   " + "\t"+ "\t"+ "\t"+ "\t"+"״̬ " + "\t"+ " ����"+"\t"+"\t"+"���ȥ����");
		for (int i = 0; i < name.length; i++) {
			if (name[i] == null) {
				break;
			}
			System.out.print("\t" + name[i] + "\t");
			System.out.print("\t" + state[i] + "\t");
			System.out.print(date[i]);
			System.out.println("\t"+borrowCount[i]);

		}

	}

	/**
	 * ���dvd
	 */
	public void borrowDvd(String[] name, String[] state, String[] date,int[] brorrowCount,String borrowBook) {
		for(int i=0;i<name.length;i++) {
				if(state[i].equals("�ɽ�")&&name[i].trim().equals(borrowBook)) {
					name[i] = borrowBook;
					state[i] = "���";
					format = new SimpleDateFormat("yyyy-MM-dd");
					date[i] = format.format(new Date());
					brorrowCount[i] = brorrowCount[i] + 1;//������ʾ���ȥ�Ĵ���
					break;
				} 
		}
		
		System.out.println( "�����"+borrowBook);
	}

	/**
	 * �黹dvd
	 * @throws ParseException 
	 */
	public void repayDvd(String[] name, String[] state, String[] date,String repyBook){
		int rentMoney = 0;
		for(int i=0;i<name.length;i++) {
			if(name[i].equals(repyBook) ) {
				name[i] = repyBook;
				state[i] ="�ɽ�";
				format = new SimpleDateFormat("yyyy-MM-dd");
				Date returnDate = new Date();
				try {
					rentMoney = (int)(returnDate.getTime()-format.parse(date[i]).getTime())/(1000*60*60*24)+1;
				} catch (ParseException e) {
					e.printStackTrace();
				}
			   date[i] = format.format(returnDate);
				break;
			}
		}
		System.out.println("�黹��"+repyBook);
		System.out.println("��֧�����"+rentMoney+"Ԫ");
	}

}
