package MicroCucumber;
import java.util.Timer;
import java.util.TimerTask;

public class sound_maker {

	private Microwave m;
	private Timer timer = new Timer();
	private static Boolean comprobador = false;
	public static Boolean getComprobador() {
		return comprobador;
	}

	private static int bips;

	public sound_maker(Microwave m) {
		this.m = m;
		detector();
	}

	public static void activate(int b) {
		comprobador = true;
		bips = b;
	}

	public void detector() {
		timer.scheduleAtFixedRate(new TimerTask() {
			
			public void run() {
				if (comprobador) {
					for (int i = 0; i < bips; i++) {
						m.getDisplay().setDisplay("beep");
						try {
							Thread.sleep(700);
							m.getDisplay().setDisplay("");
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					comprobador = false;
				}
			}
		}, 0, 10);
	}

}
