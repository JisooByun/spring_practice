package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Appcontext.class);
		Greeter g = ctx.getBean("greeter",Greeter.class); //Appcontext의 bean으로 지정한 greater함수를 가져온다.greeter 빈은 Greeter 클래스의 인스턴스 
		//를 생성하고 setter을 통해 지정된 포맷으로 만들어준뒤 Greeter타입의 객체로 반환한다.  
		String msg = g.greet("스프링");//그럼 Greeter타입의 객체는 greeter()메소드를 가지고잇고 그것을 실행시켜서 "스프링"과 포맷이 결합된 형태로 나온다.
		System.out.println(msg);
		ctx.close();
	}
}
