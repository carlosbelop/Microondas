package MicroCucumber;

public class Turntable {

	private Boolean turntableOn;

	public Turntable() {
		turntableOn = false;
	}

	public void turntable_start() {
		turntableOn = true;
	}

	public void turntable_stop() {
		turntableOn = false;
	}

	public Boolean isMoving() {
		return turntableOn;
	}

}
