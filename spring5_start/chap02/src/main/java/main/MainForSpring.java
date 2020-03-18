package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import assembler.Assembler;
import chap02.ChangePasswordService;
import chap02.DuplicateMemberException;
import chap02.MemberInfoPrinter;
import chap02.MemberListPrinter;
import chap02.MemberNotFoundException;
import chap02.MemberRegistrService;
import chap02.RegisterRequest;
import chap02.VersionPrinter;
import chap02.WrongIdPasswordException;
import config.AppCtx;

public class MainForSpring {
	private static ApplicationContext ctx = null;
	public static void main(String[] args) throws IOException{
		ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("명령어를 입력하세요:");
			String command = reader.readLine();
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다");
				break;
			}
			if(command.startsWith("new ")) {
				processNewCommand(command.split(" "));
				continue;
			
			}
			else if(command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
				continue;
			}
			else if(command.equals("list")) {
				processListCommand();
				continue;
			}else if(command.startsWith("info ")) {
				processInfoCommand(command.split(" "));
				continue;
			}else if(command.equals("version")) {
				processVersion();
				continue;
			}
			
				
			printHelp();
		}
	}
	private static Assembler assembler = new Assembler();
	private static void processNewCommand(String[] args) {
		if(args.length !=5) {
			printHelp();
			return;
		}
		MemberRegistrService regSvc = ctx.getBean("memberRegSvc",MemberRegistrService.class);
		RegisterRequest req = new RegisterRequest();
		req.setEmail(args[1]);
		req.setName(args[2]);
		req.setPassword(args[3]);
		req.setConfirmPassword(args[4]);
		
		if(!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호확인이 하지 않습니다");
			return;
		}try {
			regSvc.regist(req);
			System.out.println("등록완료되었습니다");
			
		}catch(DuplicateMemberException e){
			System.out.println("이미 존재하는 메일입니다.");
			
		}
	}
	private static void processChangeCommand(String[] arg) {
		if(arg.length != 4) {
			printHelp();
			return;
		}
		ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc",ChangePasswordService.class);
		try {
			changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호를 변경하였습니다");
			
		}catch(MemberNotFoundException e) {
			System.out.println("존재하지않는 이메일입니다.");
		}catch(WrongIdPasswordException e) {
			
		}
	}
	private static void printHelp() {
		System.out.println("다시 입력하시오");
	}
	private static void processListCommand() {
		MemberListPrinter listPrinter = ctx.getBean("listPrinter",MemberListPrinter.class);
		listPrinter.printAll();
		
	}
	private static void processInfoCommand(String[] args) {
		if(args.length != 2) {
			printHelp();
			return;
		}
		MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter",MemberInfoPrinter.class);
		infoPrinter.printMemberInfo(args[1]);
	}
	private static void processVersion() {
		VersionPrinter printVersion = ctx.getBean("versionPrinter",VersionPrinter.class);
		printVersion.printVersion();
	}
}
