package MicroCucumber;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.*;

public class Test_Microwave {

	private Microwave m;

	@BeforeEach
	void start() {
		m = new Microwave();
	}

	/**
	 * 
	 * Test que comprueba si inicializa bien
	 * 
	 */

	@Test
	void testConstructor() {
		assertTrue(!m.getDoorOpen());
		Assertions.assertTrue(!m.getCooking());
		Assertions.assertTrue(!m.getWithItem());
		Assertions.assertTrue(!m.getHeating().isHeating());
		Assertions.assertEquals(0, m.getHeating().getPower());
		Assertions.assertEquals(0, m.getTimer());
	}

	/**
	 * 
	 * Test que comprueba que el Heating se inicia bien
	 * 
	 */

	@Test
	void Heating() {
		Assertions.assertTrue(!m.getHeating().isHeating());
		m.getHeating().heating_on();
		Assertions.assertTrue(m.getHeating().isHeating());
		Assertions.assertEquals(0, m.getHeating().getPower());
		m.getHeating().setPower(25);
		Assertions.assertEquals(25, m.getHeating().getPower());
		m.getHeating().heating_off();
		Assertions.assertTrue(!m.getHeating().isHeating());
	}

	/**
	 * 
	 * Test que comprueba que la Lamp se inicia bien
	 * 
	 */

	@Test
	void Lamparon() {
		Assertions.assertTrue(!m.getLamp().isLampOn());
		m.getLamp().lamp_on();
		Assertions.assertTrue(m.getLamp().isLampOn());
		m.getLamp().lamp_off();
		Assertions.assertTrue(!m.getLamp().isLampOn());
	}

	/**
	 * 
	 * Test que comprueba que el Turntable se inicia bien
	 * 
	 */

	@Test
	void Turntable() {
		Assertions.assertTrue(!m.getTurntable().isMoving());
		m.getTurntable().turntable_start();
		Assertions.assertTrue(m.getTurntable().isMoving());
		m.getTurntable().turntable_stop();
		Assertions.assertTrue(!m.getTurntable().isMoving());
	}

	/**
	 * 
	 * Test que comprueba que el Beeper se inicia bien
	 * 
	 */

	@Test
	void Beeper() {
		m.getBeeper().beep(3);
		Assertions.assertTrue(sound_maker.getComprobador());

	}

	/**
	 * 
	 * Test que comprueba que el Display se inicia bien
	 * 
	 */

	@Test
	void Display() {
		Assertions.assertEquals(m.getDisplay().getDisplay(), "");
		m.getDisplay().setDisplay("Cocinando");
		Assertions.assertEquals(m.getDisplay().getDisplay(), "Cocinando");
		m.getDisplay().clearDisplay();
		Assertions.assertEquals(m.getDisplay().getDisplay(), "");
		m.getDisplay().clearDisplay();
		Assertions.assertEquals(m.getDisplay().getDisplay(), "");
		m.getDisplay().setDisplay(null);
		Assertions.assertEquals(m.getDisplay().getDisplay(), null);
		m.getDisplay().setDisplay("Fin");
		Assertions.assertEquals(m.getDisplay().getDisplay(), "Fin");

	}

	/**
	 * 
	 * Test doorOpen
	 * 
	 */
	@Test
	void Door() {

		// Básico abre y cierra
		Assertions.assertTrue(!m.getDoorOpen());
		m.door_opened();
		Assertions.assertTrue(m.getDoorOpen());
		m.door_closed();
		Assertions.assertTrue(!m.getDoorOpen());

		// Forzamos fallos
		for (int i = 0; i < 9; i++) {
			m.door_closed();
		}
		Assertions.assertTrue(!m.getDoorOpen());
		m.item_placed();
		m.power_inc();
		m.timer_inc();
		Assertions.assertTrue(!m.getDoorOpen());
		m.door_opened();
		for (int i = 0; i < 9; i++) {
			m.door_opened();
		}
		Assertions.assertTrue(m.getDoorOpen());
		m.cooking_stop();
		m.cooking_start();
		Assertions.assertTrue(m.getDoorOpen());
	}

	/**
	 * 
	 * Test power
	 * 
	 */
	@Test
	void powerade() {

		Assertions.assertEquals(0, m.getHeating().getPower());
		m.power_inc();
		Assertions.assertEquals(100, m.getHeating().getPower());
		for (int i = 0; i < 9; i++) {
			m.power_dec();
		}
		Assertions.assertEquals(0, m.getHeating().getPower());
		for (int i = 0; i < 15; i++) {
			m.power_inc();
		}
		Assertions.assertEquals(1000, m.getHeating().getPower());
		m.power_reset();
		Assertions.assertEquals(0, m.getHeating().getPower());
		m.power_reset();
		Assertions.assertEquals(0, m.getHeating().getPower());

		// ¿le afectan otros métodos de microondas?
		m.power_inc();
		m.door_opened();
		m.door_closed();
		m.item_placed();
		m.item_removed();
		m.timer_inc();
		m.timer_dec();
		m.timer_reset();
		m.cooking_start();
		m.cooking_stop();
		Assertions.assertEquals(100, m.getHeating().getPower());

	}

	/**
	 * 
	 * Test timer
	 * 
	 */
	@Test
	void tiempo() {

		Assertions.assertEquals(0, m.getTimer());
		m.timer_inc();
		Assertions.assertEquals(30, m.getTimer());
		for (int i = 0; i < 9; i++) {
			m.timer_dec();
		}
		Assertions.assertEquals(0, m.getTimer());
		for (int i = 0; i < 15; i++) {
			m.timer_inc();
		}
		Assertions.assertEquals(450, m.getTimer());
		m.timer_reset();
		Assertions.assertEquals(0, m.getTimer());
		m.timer_reset();
		Assertions.assertEquals(0, m.getTimer());

		// ¿le afectan otros métodos de microondas?
		m.timer_inc();
		m.door_opened();
		m.door_closed();
		m.item_placed();
		m.item_removed();
		m.power_inc();
		m.power_dec();
		m.power_reset();
		m.cooking_start();
		m.cooking_stop();
		Assertions.assertEquals(30, m.getTimer());

		// cocinando
		m.door_opened();
		m.item_placed();
		m.door_closed();
		m.power_inc();
		m.cooking_start();
		try {
			Thread.sleep(1010); // espera un segundo para poder comprobar el tiempo bien
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		m.cooking_stop();
		Assertions.assertEquals(29, m.getTimer());
		m.cooking_start();
		try {
			Thread.sleep(1010); // espera un segundo para poder comprobar el tiempo bien
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		m.power_reset();
		Assertions.assertEquals(28, m.getTimer());

	}
	
	/**
	 * 
	 * Test en si está cocinando o no
	 * 
	 */

	@Test
	void cooking() {
		
		Assertions.assertTrue(!m.getCooking());
		m.timer_inc();
		m.power_inc();
		m.door_opened();
		m.item_placed();
		m.door_closed();
		m.cooking_start();
		Assertions.assertTrue(m.getCooking());
		m.cooking_stop();
		Assertions.assertTrue(!m.getCooking());
		m.cooking_start();
		Assertions.assertTrue(m.getCooking());
		m.door_opened();
		Assertions.assertTrue(!m.getCooking());
	}
	
	/**
	 * 
	 * Test de si tiene comida dentro o no
	 * 
	 */
	
	@Test
	void withItem() {
		
		Assertions.assertTrue(!m.getWithItem());
		m.door_opened();
		m.item_placed();
		Assertions.assertTrue(m.getWithItem());
		m.item_removed();
		Assertions.assertTrue(!m.getWithItem());

	}
	
	//Ahora testearé cada estado del microondas
	
	/**
	 * 
	 * ClosedWithNoItem
	 * 
	 */
	@Test
	void ClosedWithNoItem() {
		//Comprobación de sus componentes
		Assertions.assertFalse(m.getCooking());
		Assertions.assertFalse(m.getHeating().isHeating());
		Assertions.assertFalse(m.getLamp().isLampOn());
		Assertions.assertFalse(m.getTurntable().isMoving());
		Assertions.assertFalse(m.getDoorOpen());
		Assertions.assertFalse(m.getWithItem());
		
		Assertions.assertTrue(m.getEstado() instanceof ClosedWithNoItem);
		m.door_opened();
		Assertions.assertTrue(!(m.getEstado() instanceof ClosedWithNoItem));
		m.door_closed();
		Assertions.assertTrue(m.getEstado() instanceof ClosedWithNoItem);
		m.item_placed();
		Assertions.assertEquals("You need to open the door first", m.getDisplay().getDisplay());
		m.power_inc();
		Assertions.assertEquals("Power: 100", m.getDisplay().getDisplay());
		m.timer_inc();
		Assertions.assertEquals("Time: 30", m.getDisplay().getDisplay());
		m.cooking_start();
		Assertions.assertEquals("Introduce Item", m.getDisplay().getDisplay());
		m.item_removed();
		Assertions.assertEquals("You need to open the door first", m.getDisplay().getDisplay());

	}
	
	/**
	 * 
	 * OpenWithNoItem
	 * 
	 */
	@Test
	void OpenWithNoItem() {
		m.door_opened();
		//Comprobación de sus componentes
		Assertions.assertFalse(m.getCooking());
		Assertions.assertFalse(m.getHeating().isHeating());
		Assertions.assertTrue(m.getLamp().isLampOn());
		Assertions.assertFalse(m.getTurntable().isMoving());
		Assertions.assertTrue(m.getDoorOpen());
		Assertions.assertFalse(m.getWithItem());
		
		m.door_closed();
		
		Assertions.assertTrue(!(m.getEstado() instanceof OpenWithNoItem));
		m.door_opened();
		Assertions.assertTrue(m.getEstado() instanceof OpenWithNoItem);
		m.item_placed();
		Assertions.assertTrue(!(m.getEstado() instanceof OpenWithNoItem));
		m.item_removed();
		Assertions.assertTrue(!m.getWithItem());
		m.power_inc();
		Assertions.assertEquals("Power: 100", m.getDisplay().getDisplay());
		m.timer_inc();
		Assertions.assertEquals("Time: 30", m.getDisplay().getDisplay());
		m.cooking_start();
		Assertions.assertEquals("Introduce Item", m.getDisplay().getDisplay());
		m.item_removed();
		Assertions.assertEquals("There is no item", m.getDisplay().getDisplay());

	}
	
	/**
	 * 
	 * OpenWithItem
	 * 
	 */
	@Test
	void OpenWithItem() {
		m.door_opened();
		m.item_placed();
		//Comprobación de sus componentes
		Assertions.assertFalse(m.getCooking());
		Assertions.assertFalse(m.getHeating().isHeating());
		Assertions.assertTrue(m.getLamp().isLampOn());
		Assertions.assertFalse(m.getTurntable().isMoving());
		Assertions.assertTrue(m.getDoorOpen());
		Assertions.assertTrue(m.getWithItem());
		
		m.item_removed();
		m.door_closed();

		Assertions.assertTrue(!(m.getEstado() instanceof OpenWithItem));
		m.door_opened();
		m.item_placed();
		Assertions.assertTrue(m.getEstado() instanceof OpenWithItem);
		m.item_removed();
		Assertions.assertTrue(m.getEstado() instanceof OpenWithNoItem);
		m.item_placed();
		Assertions.assertTrue(m.getWithItem());
		m.power_inc();
		Assertions.assertEquals("Power: 100", m.getDisplay().getDisplay());
		m.timer_inc();
		Assertions.assertEquals("Time: 30", m.getDisplay().getDisplay());
		m.cooking_start();
		Assertions.assertEquals("Close the door", m.getDisplay().getDisplay());
			
	}
	
	/**
	 * 
	 * ClosedWithItem
	 * 
	 */
	@Test
	void ClosedWithItem() {
		m.door_opened();
		m.item_placed();
		m.door_closed();
		//Comprobación de sus componentes
		Assertions.assertFalse(m.getCooking());
		Assertions.assertFalse(m.getHeating().isHeating());
		Assertions.assertFalse(m.getLamp().isLampOn());
		Assertions.assertFalse(m.getTurntable().isMoving());
		Assertions.assertFalse(m.getDoorOpen());
		Assertions.assertTrue(m.getWithItem());

		m.door_opened();
		m.item_removed();
		m.door_closed();
		
		Assertions.assertFalse(m.getEstado() instanceof ClosedWithItem);
		m.door_opened();
		m.item_placed();
		m.door_closed();
		Assertions.assertTrue(m.getEstado() instanceof ClosedWithItem);
		m.item_removed();
		Assertions.assertEquals("You need to open the door first", m.getDisplay().getDisplay());
		m.item_placed();
		Assertions.assertEquals("You need to open the door first", m.getDisplay().getDisplay());
		Assertions.assertTrue(m.getWithItem());
		m.power_inc();
		Assertions.assertEquals("Power: 100", m.getDisplay().getDisplay());
		m.timer_inc();
		Assertions.assertEquals("Time: 30", m.getDisplay().getDisplay());
		m.cooking_start();
		Assertions.assertEquals(true, m.getCooking());

	}
	
	/**
	 * 
	 * Cooking
	 * 
	 */
	@Test
	void CookingState() {
		m.door_opened();
		m.item_placed();
		m.door_closed();
		m.timer_inc();
		m.power_inc();
		m.cooking_start();
		//Comprobación de sus componentes
		Assertions.assertTrue(m.getCooking());
		Assertions.assertTrue(m.getHeating().isHeating());
		Assertions.assertFalse(m.getLamp().isLampOn());
		Assertions.assertTrue(m.getTurntable().isMoving());
		Assertions.assertFalse(m.getDoorOpen());
		Assertions.assertTrue(m.getWithItem());
		
		m.door_opened();
		m.item_removed();
		m.door_closed();
		m.timer_reset();
		m.power_reset();
		
		Assertions.assertFalse(m.getEstado() instanceof Cooking);
		m.door_opened();
		m.item_placed();
		m.door_closed();
		m.timer_inc();
		m.power_inc();
		m.cooking_start();

		Assertions.assertTrue(m.getEstado() instanceof Cooking);
		m.item_removed();
		Assertions.assertEquals("You need to open the door first", m.getDisplay().getDisplay());
		m.item_placed();
		Assertions.assertEquals("You need to open the door first", m.getDisplay().getDisplay());
		Assertions.assertTrue(m.getWithItem());
		m.power_inc();
		Assertions.assertEquals("Power: 200", m.getDisplay().getDisplay());
		m.timer_inc();
		Assertions.assertEquals("Time: 60", m.getDisplay().getDisplay());
		m.cooking_start();
		Assertions.assertEquals(true, m.getCooking());
	}
	
}
