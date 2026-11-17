package panelVuelos;

public class Panel {

	public static final int PREVISTA = 600;
	
	private int retraso;
	private int salida;
	
	public Panel() {
		this.retraso=0;
		this.salida=PREVISTA;
	}
	
	public int getRetraso() {
		return retraso;
	}
	public void setRetraso(int retraso) {
		this.retraso = retraso;
	}
	public int getSalida() {
		return salida;
	}
	public void setSalida(int salida) {
		this.salida = salida;
	}
	
	public String hora(int minutos) {
		int h =minutos/60;
		int m = minutos % 60;
		return String.format("%02d:%02d", h, m);
		}
	
	public boolean esCoherente() {
	    if (salida == (PREVISTA + retraso)) {
	        return true;
	    } else {
	        return false;
	    }
	}
	
}
