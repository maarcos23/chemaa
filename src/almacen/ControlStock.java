package almacen;

public class ControlStock implements Runnable{

	private String[] productos;
	private int [] stock;	
	private int[] minimo;
	private int productosAReponer = 0;
	private int unidadesAPedir = 0;
	
	public ControlStock(String[] productos, int [] stock, int[] minimo) {
		// TODO Auto-generated constructor stub
	
	this.productos = productos;
	this.stock = stock;
	this.minimo = minimo;
		
	}
	
	
	public int getProductosAReponer() { return productosAReponer; }
    public int getUnidadesAPedir() { return unidadesAPedir; }
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		String nombre = Thread.currentThread().getName();
		int prioridad = Thread.currentThread().getPriority();
		System.out.println(nombre + "empieza (prioridad "+ prioridad+ ")");
		try {
			for(int i = 0; i< productos.length; i++) {
				Thread.sleep(200);
				if(stock[i]< minimo[i]) {
					int unidades = (minimo[i]*2) -stock[i];
					productosAReponer ++;
					unidadesAPedir += unidades;
					System.out.println(nombre + ": reponer " +
					productos[i] + " (" + unidades + " uds)");
				}
			}
				}catch(InterruptedException e) {
					System.out.println(nombre + "interrumpido");
				}
				System.out.println(nombre + " termina: " + productosAReponer +
				" productos a reponer, " + unidadesAPedir + " unidades en total.");
			}
}
