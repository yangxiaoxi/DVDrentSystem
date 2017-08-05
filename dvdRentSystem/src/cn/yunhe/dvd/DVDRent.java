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
	 * 新增dvd
	 * @param name  传入需要保存dvd名字的数组
	 * @param state 传入需要保存dvd 状态的数组
	 * @param date  传入需要保存dvd 日期的数组
	 * @param newBook   传入需要新增的书名
	 */
	public void addDvd(String[] name, String[] state, String[] date,String newBook) {
		for(int i=0;i<name.length;i++) {
			if(name[i]==null) {
				name[i] = newBook;
				state[i] ="可借";
				format = new SimpleDateFormat("yyyy-MM-dd");
				date[i] = format.format(new Date());
				break;
			}
		}
		
		System.out.println( "新增了"+newBook);
	}

	/**
	 * 删除dvd
	 */
	public void deleteDvd(String[] name, String[] state, String[] date, String deleteBook) {
		for (int i = 0; i < name.length; i++) {
			if (name[i].equals(deleteBook)) {
				System.out.println("删除了" + name[i]);
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
	 * 该函数是专门为删除数组里面的一个元素而专门抽出的函数，表示当删除数组里面某一个元素时，该元素后面的数据全部向前移动一个位置
	 * @param a传入需要删除其中一个数的数组
	 * @param i传入需要删除数据在数组的位置
	 */
	public  void moveArry( String[] a,int i) {
		for(int j=i;j<a.length-i;j++) {
			a[j] = a[j+1];
		}
	}
 
	/**
	 * 查看dvd
	 * @param name
	 * @param state
	 * @param date
	 * @param borrowCount  每本书的借出去的次数
	 */
	public void queryAllDvd(String[] name, String[] state, String[] date,int[] borrowCount) {
		System.out.println("\t"+ "书名   " + "\t"+ "\t"+ "\t"+ "\t"+"状态 " + "\t"+ " 日期"+"\t"+"\t"+"借出去次数");
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
	 * 借出dvd
	 */
	public void borrowDvd(String[] name, String[] state, String[] date,int[] brorrowCount,String borrowBook) {
		for(int i=0;i<name.length;i++) {
				if(state[i].equals("可借")&&name[i].trim().equals(borrowBook)) {
					name[i] = borrowBook;
					state[i] = "借出";
					format = new SimpleDateFormat("yyyy-MM-dd");
					date[i] = format.format(new Date());
					brorrowCount[i] = brorrowCount[i] + 1;//用来表示借出去的次数
					break;
				} 
		}
		
		System.out.println( "借出了"+borrowBook);
	}

	/**
	 * 归还dvd
	 * @throws ParseException 
	 */
	public void repayDvd(String[] name, String[] state, String[] date,String repyBook){
		int rentMoney = 0;
		for(int i=0;i<name.length;i++) {
			if(name[i].equals(repyBook) ) {
				name[i] = repyBook;
				state[i] ="可借";
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
		System.out.println("归还了"+repyBook);
		System.out.println("请支付租金："+rentMoney+"元");
	}

}
