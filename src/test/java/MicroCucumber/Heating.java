package MicroCucumber;

public class Heating {
	private Boolean heating;
	private Integer power;

	public Heating() {
		heating = false;
		power = 0;
	}

	public void heating_on() {
		heating = true;
	}

	public void heating_off() {
		heating = false;
	}

	public Boolean isHeating() {
		return heating;
	}

// arreglar el uso del atributo de clase power y usar el getPower() y setPower() en todo el programa
	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

}
