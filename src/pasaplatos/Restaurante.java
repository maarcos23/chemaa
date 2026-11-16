package pasaplatos;

public class Restaurante {
	
	public static void main(String[]args) {
		Pasaplatos pasaplatos = new Pasaplatos();
		String[]platos = {"Paella", "Gazpacho", "Tortilla", "Croquetas", "Tarta"};
		
		Thread cocinero = new Thread(new Cocinero(platos, pasaplatos),  "Cocinero");
		Thread camarero = new Thread(new Camarero(pasaplatos, platos.length),"Camarero");
	
	cocinero.start();
	camarero.start();
	
	try {
		cocinero.join();
		camarero.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Servicio terminado");
	}

}
