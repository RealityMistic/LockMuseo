

import java.util.concurrent.Semaphore;

class MuseoSem {

	private int ocupacion;
	private Semaphore exclusion;
	private PantallaSem pantallasem;

	public MuseoSem() {
		ocupacion = 0;
		exclusion = new Semaphore(1);
		System.out.println("Se construye el museosem");
		pantallasem = PantallaSem.getPantallaSem();
	}

	public void entrar() throws InterruptedException {
		System.out.println("Se entra en el museosem");
		exclusion.acquire();
		try {
			ocupacion = ocupacion + 1;
			System.out.println(Integer.toString(ocupacion));
			pantallasem.escribir("Entra un visitante con semáforo. Hay " + ocupacion);
		} finally {
			exclusion.release();
		}
	}

	public void salir() throws InterruptedException {
		exclusion.acquire();
		try {
			ocupacion = ocupacion - 1;
			pantallasem.escribir("Sale un visitante con semáforo. Hay " + ocupacion);
		} finally {
			exclusion.release();
		}
	}
}
