package chap02;

public class Client2 {

	private String host;
	
	public void setHost(String host) {
		this.host = host;
	}
	public void connect() {
		System.out.println("연결했습니다.");
		
	}
	public void send() {
		System.out.println("보냈습니다"+host);
	}
	public void close() {
		System.out.println("연결을 해제하였습니다.");
	}
}
