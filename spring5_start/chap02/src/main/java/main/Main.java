package main;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import chap02.Client;
import chap02.Client2;
import config.AppCtx;

public class Main {

	
	public static void main(String[] args) throws IOException{
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		Client2 client2 = ctx.getBean("client2",Client2.class);
		client2.send();
		ctx.close();
		//client도 생성할때 afterpropertiesset과 destroy가 실행되는데 이는 어차피 ctx를 할당할때 빈이 생성되므로 빈 생성될때 메소드가 발동되어 출력되는것임 대신 client의 send메소드는 실행안됨
	}
}
