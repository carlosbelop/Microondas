package MicroCucumber;

public class Beeper {

	public void beep(Integer d) {
		sound_maker.activate(d);
		try {
			Thread.sleep(d*1150); //pongo 1.15 segundos por cada bip
			//para poder hacer el test y que compruebe el boolean de sound_maker
			//es decir, le pongo menos tiempo por numero que en sound_maker (que son 700+500=1200)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
