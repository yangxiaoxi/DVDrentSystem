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
   		int choseLogin = ScannerUtil.getInt("请选择：1--学生登陆；2--老师登陆；3--管理员登陆；0--退出");
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
   				System.out.println("退出系统");
   				isContinue = false;
   				break;
   			default:
   				System.out.println("选择错误");
   				break;
   			}
       }
		  
		

	}

}
