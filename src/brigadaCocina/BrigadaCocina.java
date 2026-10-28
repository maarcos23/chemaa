package brigadaCocina;

public class BrigadaCocina {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Abre la cocina el hilo: "+ Thread.currentThread().getName());
		
		//paso 2 Creamos los hilos
		Thread ana = new Thread(new Cocinero("paella", 4), "Ana");
		Thread luis = new Thread(new Cocinero("Gazpacho", 3), "Luis");
		Thread marta = new Thread(new Cocinero("tarta", 5), "Marta");
		
		ana.setPriority(Thread.MAX_PRIORITY);
		luis.setPriority(Thread.MAX_PRIORITY);
		
		//lanzar hilos
		ana.start();
		luis.start();
		marta.start();
	
		//la jefa de cocina esta esperando
		try {
			Thread.sleep(1200);
			
			//hace q espere a q los cocineros terminen
			ana.join();
			luis.join();
			marta.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("El estado de Ana al final ha sido: "+ ana.getState());
		System.out.println("El estado de Luis al final ha sido: "+ luis.getState());
		System.out.println("El estado de Marta al final ha sido: "+ marta.getState());
	}

}