package cn.yunhe.dvd;

public class DVDdatabase {
	String[] name;
	String[] state;
	String[] date;
	int[]  borrowCount;//����װÿ��������Ĵ���
	public DVDdatabase() {
		name = new String[50];
		name[0] = "�Ҳ�ϲ�������磬��ֻϲ����";
		name[1] = "����ʱ�ڵİ���                      ";
		name[2] = "׷���ݵ���                             ";
		name[3] = "һ���˵ĳ�ʥ                         ";
		
		state = new String[50];
		state[0] = "�ɽ�";
		state[1] = "�ɽ�";
		state[2] = "�ɽ�";
		state[3] = "���";
		
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
