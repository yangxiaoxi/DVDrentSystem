package cn.yunhe.dvd;

public class DVDdatabase {
	String[] name;
	String[] state;
	String[] date;
	int[]  borrowCount;//用来装每本数借出的次数
	public DVDdatabase() {
		name = new String[50];
		name[0] = "我不喜欢这世界，我只喜欢你";
		name[1] = "霍乱时期的爱情                      ";
		name[2] = "追风筝的人                             ";
		name[3] = "一个人的朝圣                         ";
		
		state = new String[50];
		state[0] = "可借";
		state[1] = "可借";
		state[2] = "可借";
		state[3] = "借出";
		
		date = new String[50];
		date[0] = "2017-07-28";
		date[1] = "2017-07-21";
		date[2] = "2017-07-20";
		date[3] = "2017-07-10";
		
		borrowCount = new int[50];
		borrowCount[0] = 0;
		borrowCount[1] = 0;
		borrowCount[2] = 0;
		borrowCount[3] = 0;
	}

}
