package MicroCucumber;

public abstract class State {
	protected Microwave micro;

	public State(Microwave s) {
		micro = s;
	}

	public abstract void door_opened();

	public abstract void door_closed();

	public abstract void item_placed();

	public abstract void item_removed();

	public abstract void power_inc();

	public abstract void power_dec();

	public abstract void power_reset();

	public abstract void timer_inc();

	public abstract void timer_dec();

	public abstract void timer_reset();

	public abstract void cooking_start();

	public abstract void cooking_stop();

	public abstract void tick();
}
