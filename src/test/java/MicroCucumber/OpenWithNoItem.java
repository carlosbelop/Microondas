package MicroCucumber;

public class OpenWithNoItem extends State{

	public OpenWithNoItem(Microwave s) {
		super(s);
		micro.getHeating().heating_off();
		micro.getLamp().lamp_on();
		micro.getTurntable().turntable_stop();
	}
	
	public void door_opened() {}

	
	public void door_closed() {
		micro.setStrategy(new ClosedWithNoItem(micro));
	}

	
	public void item_placed() {
		micro.setStrategy(new OpenWithItem(micro));
	}

	
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
