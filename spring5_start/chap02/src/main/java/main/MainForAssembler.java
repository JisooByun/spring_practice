package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import assembler.Assembler;
import chap02.ChangePasswordService;
import chap02.DuplicateMemberException;
import chap02.MemberNotFoundException;
import chap02.MemberRegistrService;
import chap02.RegisterRequest;
import chap02.WrongIdPasswordException;

public class MainForAssembler {

	public static void main(String[] args) throws IOException{
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
			printHelp();
		}
	}
	private static Assembler assembler = new Assembler();
	private static void processNewCommand(String[] args) {
		if(args.length !=5) {
			printHelp();
			return;
		}
		MemberRegistrService regSvc = assembler.getMemberRegistrService();
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
		ChangePasswordService changePwdSvc = assembler.getChangePasswordService();
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
}
