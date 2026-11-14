package brigadaCocina;

public class BrigadaCocina {
	
	
	public static void main(String[]args) {
		
		System.out.println("Abre la cocina el hilo: "+Thread.currentThread().getName());
		
		Thread ana = new Thread(new Cocinero("paella", 4), "Ana");
		Thread luis = new Thread(new Cocinero("Gazpacho", 3), "Luis");
		Thread marta = new Thread(new Cocinero("Tarta", 5),"Marta");	
		
		System.out.println("Estado de Ana antes del start: "+ ana.getState());
		ana.start();
		luis.start();
		marta.start();
		
		try {
			Thread.sleep(1200);
			System.out.println("Estado de Ana durante el trabajo: "+ ana.getState());
			ana.join();
			luis.join();
			marta.join();
			System.out.println("Estado de Ana al final: "+ana.getState());
			System.out.println("La jefa cierra la cocina.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}