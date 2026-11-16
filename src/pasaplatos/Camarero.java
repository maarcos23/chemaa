package pasaplatos;

public class Camarero implements Runnable{

	private Pasaplatos pase;
	private int cantidad;
	
	public Camarero(Pasaplatos pase, int cantidad) {
		this.pase=pase;
		this.cantidad=cantidad;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
			try {
				for (int i=0; i<cantidad; i++) {
					
				String plato = pase.recoger();
				Thread.sleep(300);
				System.out.println(Thread.currentThread().getName()+" sirve: "+ plato);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}


