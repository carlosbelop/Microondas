package MicroCucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
	private Microwave m;
	
	@Given ("a closed microwave with no item")
	public void a_closed_microwave_with_no_item() {
		m=new Microwave();
	}
	
	@Given ("an opened microwave with no item")
	public void opened_microwave_with_no_item() {
		m=new Microwave();
		m.door_opened();
	}
	
	@Given ("an opened microwave with an item inside it")
	public void opened_microwave_with_an_item() {
		m=new Microwave();
		m.door_opened();
		m.item_placed();
	}
	
	@Given ("a closed microwave with an item inside it")
	public void closed_microwave_with_an_item() {
		m=new Microwave();
		m.door_opened();
		m.item_placed();
		m.door_closed();
	}
	
	@Given ("a microwave microwaving")
	public void microwaving() {
		m=new Microwave();
		m.door_opened();
		m.item_placed();
		m.door_closed();
		m.timer_inc();
		m.power_inc();
		m.cooking_start();
	}
		
	@When ("I open the microwave")
	public void open_microwave() {
		m.door_opened();
	}
	
	@When ("I close the microwave")
	public void close_microwave() {
		m.door_closed();
	}
	
	@When ("I introduce an item")
	public void insert_item() {
		m.item_placed();
	}
	
	@When ("I press the time decrement button")
	public void time_dec() {
		m.timer_dec();
	}
	
	@When ("I press the time increment button")
	public void time_inc() {
		m.timer_inc();
	}
	
	@When ("I press the power decrement button")
	public void power_dec() {
		m.power_dec();
	}
	
	@When ("I press the power increment button")
	public void power_inc() {
		m.power_inc();
	}
	
	@When ("I press power_inc button {int} times")
	public void set_power(int p) {
		for (int i=0;i<p;i++) {
		m.power_inc();
		}
	}
	
	@When ("I press time_inc button {int} times")
	public void set_timer(int t) {
		for (int i=0;i<t;i++) {
			m.timer_inc();
		}
	}
	
	@When ("I press the cook button")
	public void start_cooking() {
		m.cooking_start();
	}
	
	@When ("I press the power reset button")
	public void power_reset() {
		m.power_reset();
	}
	
	@When ("I press the timer reset button")
	public void timer_reset() {
		m.timer_reset();
	}
	
	@Then ("it is not heating")
	public void not_heating() {
		Assertions.assertFalse(m.getHeating().isHeating());
	}
	
	@Then ("it is heating")
	public void heating() {
		Assertions.assertTrue(m.getHeating().isHeating());
	}
	
	@Then ("the lamp of the microwave is off")
	public void lamp_is_off() {
		Assertions.assertFalse(m.getLamp().isLampOn());
	}
	
	@Then ("the lamp of the microwave is on")
	public void lamp_is_on() {
		Assertions.assertTrue(m.getLamp().isLampOn());
	}
	
	@Then ("the turntable is still")
	public void still_turntable() {
		Assertions.assertFalse(m.getTurntable().isMoving());
	}
	
	@Then ("the turntable is moving")
	public void moving_turntable() {
		Assertions.assertTrue(m.getTurntable().isMoving());
	}
	
	@Then ("it is not cooking right now")
	public void not_cooking() {
		Assertions.assertFalse(m.getCooking());
	}
	
	@Then ("it is empty")
	public void is_empty() {
		Assertions.assertFalse(m.getWithItem());
	}
	
	@Then ("it is not empty")
	public void not_empty() {
		Assertions.assertTrue(m.getWithItem());
	}
	
	@Then ("the door is closed")
	public void the_door_is_closed() {
		Assertions.assertFalse(m.getDoorOpen());
	}
	
	@Then ("the door is opened")
	public void the_door_is_opened() {
		Assertions.assertTrue(m.getDoorOpen());
	}
	
	@Then ("it is closed without anything in it")
	public void state_ClosedWithNoItem() {
		Assertions.assertTrue(m.getEstado() instanceof ClosedWithNoItem);
	}
	
	@Then ("it is opened without anything in it")
	public void state_OpenWithNoItem() {
		Assertions.assertTrue(m.getEstado() instanceof OpenWithNoItem);
	}
	
	@Then ("it is opened with an item in it")
	public void state_OpenWithItem() {
		Assertions.assertTrue(m.getEstado() instanceof OpenWithItem);
	}
	
	@Then ("it is closed with an item in it")
	public void state_ClosedWithItem() {
		Assertions.assertTrue(m.getEstado() instanceof ClosedWithItem);
	}
	
	@Then ("it is cooking")
	public void cooking() {
		Assertions.assertTrue(m.getEstado() instanceof Cooking);
	}
	
	@Then ("it warns me with {string}")
	public void open_door_first(String s) {
		Assertions.assertEquals(s,m.getDisplay().getDisplay());
	}
	
	@Then ("it sets timer to {int} seconds")
	public void tiempo(int t) {
		Assertions.assertEquals(t,m.getTimer());
	}
	
	@Then ("it sets power to {int}")
	public void power(int p) {
		Assertions.assertEquals(p,m.getHeating().getPower());
	}
	
	@Then ("the display should show {string}")
	public void display_power(String s) {
		Assertions.assertEquals(s,m.getDisplay().getDisplay());
	}
	
	@Then ("it cooks")
	public void cocking() {
		Assertions.assertTrue(m.getCooking());
	}
	
	@Then ("it is not cooking")
	public void notcocking() {
		Assertions.assertFalse(m.getCooking());
	}
	
}
