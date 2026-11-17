package panelVuelos;

public class Operador implements Runnable{
	
	private Panel panel;
	private ControlPanel control;
	private int actualizaciones;
	
	public Operador(Panel panel, ControlPanel control, int actualizaciones) {
		this.panel = panel;
		this.control = control;
		this.actualizaciones = actualizaciones;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i =0; i < actualizaciones; i++) {
			try {
				Thread.sleep(250);
				
				control.empezarEscritura();
				
				int r = panel.getRetraso()+15;
				panel.setRetraso(r);
				
				Thread.sleep(200);

				int s = panel.PREVISTA +r;
				panel.setSalida(s);
			
				control.terminarEscritura();
				
				System.out.println("Operador actualiza: retraso "+r+
						" min, salida "+ panel.hora(s));
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
