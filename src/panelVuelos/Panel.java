package panelVuelos;

public class Panel {
    public static final int PREVISTA = 600;
    
    private int retraso = 0;
    private int salida = PREVISTA;
    
    public int getRetraso() {
        return retraso;
    }
    public void setRetraso (int retraso) {
        this.retraso = retraso;
    }
    public int getSalida() {
        return salida;
    }
    public void setSalida (int salida) {
        this.salida = salida;
    }
    
    public static String hora (int minutos) {
        return String.format("%d:%02d", minutos / 60, minutos % 60);
    }
}