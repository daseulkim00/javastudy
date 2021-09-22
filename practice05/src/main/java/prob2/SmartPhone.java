package prob2;

public class SmartPhone extends MusicPhone {

	@Override
	public void execute(String function) {
		if (function.equals("음악")) {
			playMusic();
			return;
		} else if (function.equals("앱")) {
			executeApp();
			return;
		}
		super.execute(function);
	}

	public void playMusic() {
		System.out.println("다운로드해서 음악재생");
	}

	public void executeApp() {
		System.out.println("앱실행");
	}

	

	//다운로드해서 음악재생
	//통화기능시작
	//앱실행
	
}
