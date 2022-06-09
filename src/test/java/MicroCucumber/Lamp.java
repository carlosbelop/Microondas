package MicroCucumber;

public class Lamp {

	private Boolean lampOn;

	public Lamp() {
		lampOn = false;
	}

	public void lamp_on() {
		lampOn = true;
	}

	public void lamp_off() {
		lampOn = false;
	}

	public Boolean isLampOn() {

		return lampOn;
	}

}
