package pasaplatos;

public class Pasaplatos {

	private String plato = null;

	public synchronized void dejar(String nuevo) throws InterruptedException {
		while(plato !=null) {
			System.out.println("pasaplatos lleno");
			wait();//cocinero
		}
		plato = nuevo;
		System.out.println("Se deja plato nuevo");
		notify();//camarero
		
	}
	public synchronized String recoger() throws InterruptedException {
		while(plato==null) {
			System.out.println("Espera q no hay platos");
			wait();//camarero
	 }
		String recogido=plato;
		this.plato=null;
		notify();//cocinero
		return recogido;
	}
	
	
}

