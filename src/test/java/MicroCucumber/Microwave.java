package MicroCucumber;
public class Microwave {
	private Boolean doorOpen;
	private Integer power;
	private Integer timer; 
	private Boolean cooking;
	private Boolean withItem; 
	private State estado;
	private Heating heating;
	private Lamp lamp;
	private Turntable turntable;
	private Display display;
	private Beeper beeper;
	private sound_maker s;

	public Microwave() {
		doorOpen = false;
		power = 0;
		timer = 0;
		cooking = false;
		withItem = false;
		heating = new Heating();
		lamp = new Lamp();
		turntable = new Turntable();
		display = new Display();
		beeper = new Beeper();
		estado = new ClosedWithNoItem(this);
		s=new sound_maker(this);
	}
	public Heating getHeating() {
		return heating;
	}
	public Lamp getLamp() {
		return lamp;
	}
	public Turntable getTurntable() {
		return turntable;
	}
	public Display getDisplay() {
		return display;
	}
	public Beeper getBeeper() {
		return beeper;
	}
	public Integer getTimer() {
		return timer;
	}
	public Boolean getCooking() {
		return cooking;
	}

	public void setCooking(Boolean cooking) {
		this.cooking = cooking;
	}
	
	public Boolean getWithItem() {
		return withItem;
	}
	
	public Boolean getDoorOpen() {
		return doorOpen;
	}

	public void setStrategy(State x) {
		estado = x;
	}

	public State getEstado() {
		return estado;
	}

	public void door_opened() {
		doorOpen = true;
		estado.door_opened();

	}

	public void door_closed() {
		doorOpen = false;
		estado.door_closed();
	}

	public void item_placed() {
		if (doorOpen) {

			withItem = true;
			estado.item_placed();

		} else {
			display.setDisplay("You need to open the door first");
		}
	}

	public void item_removed() {
		if (doorOpen) {
			withItem = false;
			estado.item_removed();
		} else {
			display.setDisplay("You need to open the door first");
		}
	}

	public void power_inc() {

		estado.power_inc();
		if (power < 1000) {
			power += 100;
		}
		heating.setPower(power);
		display.setDisplay("Power: " + power.toString());

	}

	public void power_dec() {

		if (power - 100 <= 0) {
			estado.power_dec();
			power = 0;
		} else {
			power -= 100;
		}
		heating.setPower(power);
		display.setDisplay("Power: " + power.toString());

	}

	public void power_reset() {
		power = 0;
		heating.setPower(power);
		estado.power_reset();
		display.setDisplay("Power: " + power.toString());

	}

	public void timer_inc() {
		timer += 30;
		display.setDisplay("Time: " + timer.toString());

	}

	public void timer_dec() {

		if (timer - 30 <= 0) {
			estado.timer_dec();
			timer = 0;
		} else {
			timer -= 30;
		}
		display.setDisplay("Time: " + timer.toString());

	}

	public void timer_reset() {

		estado.timer_reset();
		timer = 0;
		display.setDisplay("Time: " + timer.toString());

	}

	public void cooking_start() {

		if (timer > 0 && power > 0 && !cooking)
			estado.cooking_start();

		if (timer <= 0)
			display.setDisplay("Choose cooking time");

		if (power <= 0)
			display.setDisplay("Choose cooking power");
	}

	public void cooking_stop() {

		estado.cooking_stop();
	}

	public void tick() {

		timer--;
		display.setDisplay("Time: " + timer.toString());

	}


}
