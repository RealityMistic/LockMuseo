
class PantallaInt {

	private static PantallaInt pantallaint = new PantallaInt();

	public static PantallaInt getPantallaInt() {
		return pantallaint;
	}

	private PantallaInt() {
	}

	public synchronized void escribir(String texto) {
		System.out.println(texto);
	}
}
