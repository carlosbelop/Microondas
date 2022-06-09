package MicroCucumber;

public class ClosedWithItem extends State {

	public ClosedWithItem(Microwave s) {
		super(s);
		micro.getHeating().heating_off();
		micro.getLamp().lamp_off();
		micro.getTurntable().turntable_stop();
	}

	public void door_opened() {
		micro.setStrategy(new OpenWithItem(micro));
	}

	public void door_closed() {
	}

	public void item_placed() {
	}

	public void item_removed() {
	}

	public void power_inc() {
	}

	public void power_dec() {
	}

	public void power_reset() {
	}

	public void timer_inc() {
	}

	public void timer_dec() {
	}

	public void timer_reset() {
	}

	public void cooking_start() {
		micro.setStrategy(new Cooking(micro));

	}

	public void cooking_stop() {
	}

	public void tick() {
		// TODO Auto-generated method stub

	}


}
