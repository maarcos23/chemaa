package panelVuelos;

public class Pantalla implements Runnable{

	private Panel panel;
	private ControlPanel control;
	private int lecturas;
	private int msPausa;
	private int incoherentes =0;
	
	public Pantalla(Panel panel, ControlPanel control, int lecturas, int msPausa) {
		this.panel = panel;
		this.control = control;
		this.lecturas = lecturas;
		this.msPausa = msPausa;
	}
	
	public int getIncoherentes() {
		return incoherentes;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String hilo = Thread.currentThread().getName();
		
		for(int i =0; i<lecturas; i++) {
		
		try {
			control.empezarLectura();	
			int r = panel.getRetraso();
			Thread.sleep(100);
			int s = panel.getSalida();
			control.terminarLectura();
			
			String horaSalida = panel.hora(s);
			if (s != (Panel.PREVISTA + r)) {
				incoherentes++;
				System.out.println(hilo+" ¡INCOHERENTE!: retraso "+r+
						" min pero salida "+horaSalida);
			}else {
				System.out.println(hilo+ "muestra: retraso "+r+" min, salida "+horaSalida);
			}
			
			Thread.sleep(msPausa);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		}
		
		
	}

}
