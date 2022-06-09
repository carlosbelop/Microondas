package MicroCucumber;

public class ClosedWithNoItem extends State {

	public ClosedWithNoItem(Microwave s) {
		super(s);
		micro.getHeating().heating_off();
		micro.getLamp().lamp_off();
		micro.getTurntable().turntable_stop();
	}
	
	public void door_opened() {
		micro.setStrategy(new OpenWithNoItem(micro));
	}

	
	public void door_closed() {}

	
	public void item_placed() {}

	
	public void item_removed() {
		micro.getDisplay().setDisplay("There is no item");

	}

	
	public void power_inc() {}

	
	public void power_dec() {}

	
	public void power_reset() {}

	
	public void timer_inc() {}

	
	public void timer_dec() {}

	
	public void timer_reset() {}

	
	public void cooking_start() {
		micro.getDisplay().setDisplay("Introduce Item");
	}

	
	public void cooking_stop() {}

	
	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
