package MicroCucumber;
import java.util.Timer;
import java.util.TimerTask;

public class Cooking extends State {

	Timer timer = new Timer();

	public Cooking(Microwave s) {
		super(s);
		micro.getHeating().heating_on();
		micro.getLamp().lamp_off();
		micro.getTurntable().turntable_start();
		micro.item_placed();
		micro.door_closed();
		cooking_start();
	}

	public void door_opened() {
		timer.cancel();
		micro.setCooking(false);
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
		timer.cancel();
		micro.setCooking(false);
		micro.setStrategy(new ClosedWithItem(micro));

	}

	public void power_reset() {
		timer.cancel();
		micro.setCooking(false);
		micro.setStrategy(new ClosedWithItem(micro));

	}

	public void timer_inc() {
	}

	public void timer_dec() {
		timer.cancel();
		micro.setCooking(false);
		micro.setStrategy(new ClosedWithItem(micro));
	}

	public void timer_reset() {
		timer.cancel();
		micro.setCooking(false);
		micro.setStrategy(new ClosedWithItem(micro));
		micro.getDisplay().clearDisplay();
	}

	public void cooking_start() {
		micro.setCooking(true);
		micro.getDisplay().clearDisplay();
		timer.scheduleAtFixedRate(new TimerTask() {

			public void run() {

				System.out.println("Time left: " + micro.getTimer());
				tick();

				if (micro.getTimer() < 0) {
					timer.cancel();
					micro.setCooking(false);
					micro.getBeeper().beep(3);
					micro.getDisplay().setDisplay("Enjoy your meal");
				}
			}
		}, 1000, 1000);
		
	}

	public void cooking_stop() {
		micro.setStrategy(new ClosedWithItem(micro));
		timer.cancel();
		micro.setCooking(false);

	}

	public void tick() {
		micro.getDisplay().setDisplay(micro.getTimer().toString());
		micro.tick();
	}


}
