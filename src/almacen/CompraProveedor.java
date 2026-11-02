package almacen;

public class CompraProveedor implements Runnable{

	private int unidades;
	private int total =0;
	
	public CompraProveedor(int unidades) {
		this.unidades = unidades;
	}
	public int getTotal () { return total;}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String nombre = Thread.currentThread().getName();
		int prioridad = Thread.currentThread().getPriority();
		System.out.println(nombre + " empieza con " + unidades +
				" unidades (prioridad " + prioridad + ")");
		
		try {
			Thread.sleep(300);
		}catch( InterruptedException  e){
			System.out.println(nombre + " interrumpido.");
		}
		if(unidades == 0) {
			System.out.println(nombre + "termina : no hace falta pedir nada");
			return;
		}
		int precio =5;
		if(unidades >= 100) {
			precio =3;
		}else if(unidades >= 50) {
			precio =4;
		}
		int coste = unidades + precio;
		int transporte = 20;
		if(coste < 200) {
			int total = coste + transporte;
		}else {
			int total = coste;
		}
		System.out.println(nombre + " termina: " + unidades + " uds a " +
				precio + " €/ud = " + coste + " €, transporte " + transporte +
				" €, total " + total + " €.");
	}
	
}
