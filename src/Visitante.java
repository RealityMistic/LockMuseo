

class Visitante extends Thread {

	private Museo museo;
	private MuseoSem museosem;
	private MuseoInt museoint;

	public Visitante(Museo museo, MuseoSem museosem, MuseoInt museoint) {
		if (museo != null) this.museo = museo;
		if (museosem !=null) this.museosem = museosem;
		if (museoint != null) this.museoint = museoint;
	}
	

	public void run() {
		Pantalla pantalla = Pantalla.getPantalla();
		PantallaSem pantallasem = PantallaSem.getPantallaSem();
		PantallaInt pantallaint = PantallaInt.getPantallaInt();
		if (museo!= null) {
			for (int i  = 0; i < 10; i++) {
				museo.entrar();
				pantalla.escribir("Viendo el museo con cerrojo");
				for (int j = 0; j < (int) 10000 * Math.random(); j++) ;
				museo.salir();
				pantalla.escribir("Otras cosas");
				for (int j = 0; j < (int) 10000 * Math.random(); j++) ;
			}
		}
		try {
			
			if (museosem != null) {
					museosem.entrar();
					pantallasem.escribir("Viendo el museo con semáforo");
					for (int j = 0; j < (int) 10000 * Math.random(); j++) ;
					museosem.salir();
					pantallasem.escribir("Otras cosas");
					for (int j = 0; j < (int) 10000 * Math.random(); j++) ;
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		if (museoint != null)
		{
			for (int i  = 0; i < 10; i++) {
				museoint.entrar();
				pantallaint.escribir("Viendo el museo con intrínsecos");
				for (int j = 0; j < (int) 10000 * Math.random(); j++) ;
				museoint.salir();
				pantallaint.escribir("Otras cosas");
				for (int j = 0; j < (int) 10000 * Math.random(); j++) ;
			}
		}
	}
}
