package montaje;

public class Taller {

	public static int BICICLETAS = 5;
	public static int FASES = 4;
	
	public static void main(String[]args) {
		
		LineaMontaje linea = new LineaMontaje(FASES);
		
		Operario soldadores = new Operario(linea, 0," suelda el cuadro de ", BICICLETAS, 300);
		Operario montadores = new Operario(linea, 1, "monta las ruedas de ", BICICLETAS, 200);
		Operario Pintores = new Operario(linea, 2, " pinta ",BICICLETAS, 400);
		Operario revisores = new Operario(linea, 3, " revisa ", BICICLETAS, 100);
		
		Thread soldador = new Thread(soldadores, "Soldador");
		Thread montador = new Thread(montadores, "Montador");
		Thread pintor = new Thread(Pintores, "Pintor");
		Thread revisor = new Thread(revisores, "Revisor");
		
		long tiempoInicio = System.currentTimeMillis();
		
		revisor.start();
		pintor.start();
		montador.start();
		soldador.start();
		
		try {
			revisor.join();
			pintor.join();
			montador.join();
			soldador.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long tiempoFin = System.currentTimeMillis();
        long tiempoTotal = tiempoFin - tiempoInicio;
		
        
        System.out.println("=== Fin de la jornada ===");
        System.out.println("Bicicletas terminadas: " + linea.getBicicletas());
        System.out.println("Tiempo: " + tiempoTotal + " ms");
	}
	
}
