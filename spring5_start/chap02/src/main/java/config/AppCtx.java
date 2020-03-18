package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chap02.ChangePasswordService;
import chap02.Client;
import chap02.Client2;
import chap02.MemberDao;
import chap02.MemberInfoPrinter;
import chap02.MemberListPrinter;
import chap02.MemberPrinter;
import chap02.MemberRegistrService;
import chap02.MemberSummaryPrinter;
import chap02.VersionPrinter;

@Configuration
public class AppCtx {
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	@Bean
	public MemberRegistrService memberRegSvc() {
		return new MemberRegistrService();
	}
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		return pwdSvc;	
	}
	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter();
	}
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		return infoPrinter;
		
	}
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVerison(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
	@Bean
	public Client client() {
		Client client = new Client();
		client.setHost("host");
		return client;
	}
	@Bean
	public Client2 client2() {
		Client2 client2 = new Client2();
		client2.setHost("host2");
		return client2;
	}
}
