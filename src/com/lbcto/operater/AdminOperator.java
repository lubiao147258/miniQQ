package com.lbcto.operater;

import java.util.Scanner;

import com.lbcto.dao.IAdmin;
import com.lbcto.dao.impl.IAdminimpl;
import com.lbcto.vo.UserInfoVO;

public class AdminOperator {

	// 管理员登录
	public static void login() {
		int op;
		Scanner in = new Scanner(System.in);
		System.out.println("请输入账号：");
		String username = in.next();
		System.out.println("请输入密码：");
		String password = in.next();
		IAdmin iadmin = new IAdminimpl();
		if (iadmin.getLogin(username, password) == 1) {
			System.out.println("登录成功");
			System.out.println("=====欢迎使用迷你QQ管理系统=====");
			do {
				menu();
				op = in.nextInt();
				switch (op) {
				case 1:
					for (UserInfoVO UserInfoVO : iadmin.getUserInfoVOList()) {
						System.out.println(UserInfoVO);
					}
					break;
				case 2:
					System.out.println("请输入你要更新的编号：");
					int no = in.nextInt();
					System.out.println("请输入你要更新的天数：");
					int day = in.nextInt();
					iadmin.updateOnlineDayById(no, day);
					if(iadmin.updateOnlineDayById(no, day)==1){
						System.out.println("修改成功!!");
						for (UserInfoVO UserInfoVO : iadmin.getUserInfoVOList()) {
							System.out.println(UserInfoVO);
						}
					}else{
						System.out.println("修改失败!!");
					}
					
					break;
				case 3:

					break;
				case 4:

					break;
				case 5:

					break;
				case 6:
					System.exit(0);
					break;

				default:
					System.out.println("输入不合法");
					break;
				}
			} while (op != 6);

		} else {
			System.out.println("登录失败");
			login();
		}

	}

	public static void menu() {
		System.out.println("1、显示用户信息");
		System.out.println("2、更新在线天数");
		System.out.println("3、添加用户");
		System.out.println("4、更新用户等级");
		System.out.println("5、删除用户");
		System.out.println("6、退出");
	}
}
