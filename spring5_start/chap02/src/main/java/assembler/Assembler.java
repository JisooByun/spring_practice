package assembler;

import chap02.ChangePasswordService;
import chap02.MemberDao;
import chap02.MemberRegistrService;

public class Assembler {
	private MemberDao memberDao;
	private MemberRegistrService regSvc;
	private ChangePasswordService pwdSvc;
	
	
	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegistrService();
		pwdSvc = new ChangePasswordService();
//		pwdSvc.setMemberDao(memberDao);
	}
	public MemberDao getMemberDao() {
		return memberDao;
		
	}
	public MemberRegistrService getMemberRegistrService() {
		return regSvc;
	}
	public ChangePasswordService getChangePasswordService() {
		return pwdSvc;
	}
}
/*
Assembler assembler = new Assembler(); // 1. Assembler클래스에서 인스턴스를 만들고 생성자를 통해 memberDao()가 생성되고 pwdSvc에 set으로 memberDao주입한다.
ChangePasswordService changePwdSvc = assembler.getChangePasswordService(); // 2. pwdSvc객체를 가져오고 changePwdSvc에 위에서 생성된 pwdSvc 넣어준다
 																				그 객체의 changePassword 메소드를 이욯한다. 안에는 memberDao가 있다
changePwdSvc.changePassword("bjs1616@gmail.com", "1234","newpwd")
*/