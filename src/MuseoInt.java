
class MuseoInt {

	private int ocupacion;
	PantallaInt pantallaint;

	public MuseoInt() {
		ocupacion = 0;
		pantallaint = PantallaInt.getPantallaInt();
	}

	public synchronized void entrar() {
		ocupacion = ocupacion + 1;
		pantallaint.escribir("Entra un visitante con intrínsecos. Hay " + ocupacion);
	}

	public synchronized void salir() {
		ocupacion = ocupacion - 1;
		pantallaint.escribir("Sale un visitante con intrínsecos. Hay " + ocupacion);
	}
}
