package chap02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ChangePasswordService {
	@Autowired
	private MemberDao memberDao; //자동으로 해당타입의 bean을  찾아서 넣는다.
	
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if(member ==null) throw new MemberNotFoundException();
		member.changePassword(oldPwd, newPwd);
		memberDao.update(member);
	}
	
//	public void setMemberDao(MemberDao memberDao) {
//		this.memberDao = memberDao;
//		
//	}
}
