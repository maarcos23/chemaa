package almacen;

public class ProcesadorPedidos implements Runnable{

	private int[]importes;
	private int facturado =0;
	private int enviosGratis =0;
	private int pedidoMaximo =0;
	
	public ProcesadorPedidos(int[]importes) {
		this.importes= importes;
	}
	
	public int getFacturado() { return facturado;}
	public int getEnviosGratis() { return enviosGratis;}
	public int getPedidoMaximo() {return pedidoMaximo;}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		String nombre = Thread.currentThread().getName();
		int prioridad = Thread.currentThread().getPriority();
		System.out.println(nombre + " empieza (prioridad " + prioridad+ ")");
		
		try {
			for(int i =0; i<importes.length; i++) {
				Thread.sleep(100);
				int importe = importes[i];
				
				if(importe >= 50) {
					facturado += importe;
					enviosGratis++;
				}else {
					facturado +=(importe + 5);
				}
				
				if (importe > pedidoMaximo) {
					pedidoMaximo = importe;
				}
				
				if((i + 1) % 10 ==0) {
					System.out.println(nombre + (i +1)+ " pedidos procesos, "+
							facturado+ " € facturados");	
				}
				
			}
			
		}catch( InterruptedException e) {
			System.out.println(nombre + " interrumpido");
		}
		System.out.println(nombre + " termina: "+ facturado + " € facturados, "+
				enviosGratis+ "encios gratis, pedido maximo "+ pedidoMaximo+ "€");
	}
	
}
