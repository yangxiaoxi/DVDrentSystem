import cn.yunhe.business.AdminManager;
import cn.yunhe.business.StudentManager;
import cn.yunhe.business.TeacherManager;
import cn.yunhe.oop.utils.ScannerUtil;

public class EducationSystemMain {

	
	 
	public static void main(String[] args) {
       AdminManager adminManager = new AdminManager();
       AdminManager teacherManager  = new TeacherManager();
       AdminManager studentManager = new StudentManager();
       boolean isContinue = true;
       while(isContinue) {
   		int choseLogin = ScannerUtil.getInt("��ѡ��1--ѧ����½��2--��ʦ��½��3--����Ա��½��0--�˳�");
   			switch (choseLogin) {
   			case 1:
   				studentManager.Login();
   				break;
   			case 2:
   				  teacherManager.Login();
   				break;
   			case 3:
   				 adminManager.Login();
   				break;
   			case 0:
   				System.out.println("�˳�ϵͳ");
   				isContinue = false;
   				break;
   			default:
   				System.out.println("ѡ�����");
   				break;
   			}
       }
		  
		

	}

}
