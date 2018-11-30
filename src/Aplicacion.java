
class Aplicacion {

	public static void main(String[] args) {
		final int NUM_VISITANTES = 10;
		Museo museo = new Museo();
		MuseoSem museosem = new MuseoSem();
		MuseoInt museoint = new MuseoInt();
		Visitante[] visitantes = new Visitante[NUM_VISITANTES];
		for (int i = 0; i < visitantes.length; i++) {
			visitantes[i] = new Visitante(museo, null, null);
		}
		for (int i = 0; i < visitantes.length; i++) {
			visitantes[i].start();
		}
		for (int i = 0; i < visitantes.length; i++) {
			visitantes[i] = new Visitante(null, museosem, null);
		}
		for (int i = 0; i < visitantes.length; i++) {
			visitantes[i].start();
		}
		for (int i = 0; i < visitantes.length; i++) {
			visitantes[i] = new Visitante(null, null, museoint);
		}
		for (int i = 0; i < visitantes.length; i++) {
			visitantes[i].start();
		}
	}
}
