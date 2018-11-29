

import java.util.concurrent.Semaphore;

class PantallaSem {

	private static PantallaSem pantallasem = new PantallaSem();

	public static PantallaSem getPantallaSem() {
		return pantallasem;
	}

	private Semaphore exclusion;

	private PantallaSem() {
		exclusion = new Semaphore(1);
	}

	public void escribir(String texto) throws InterruptedException {
		exclusion.acquire();
		try {
			System.out.println(texto);
		} finally {
			exclusion.release();
		}
	}
}
