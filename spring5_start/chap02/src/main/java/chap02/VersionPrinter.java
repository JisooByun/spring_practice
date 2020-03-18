package chap02;

public class VersionPrinter {
	private int majorVersion;
	private int minorVersion;
	public void printVersion() {
		System.out.printf("현재버전은 %d.%d 입니다",majorVersion,minorVersion);
		
	}
	public void setMajorVerison(int majorVersion) {
		this.majorVersion = majorVersion;
	}
	public void setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
	}
}
