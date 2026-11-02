package almacen;

// Autor: Tu Nombre
public class AlmacenTienda {
    public static void main(String[] args) {
        // Datos base
        String[] productos = {"Auriculares", "Cargador USB", "Funda móvil", "Ratón", "Teclado", "Cable HDMI", "Webcam", "Altavoz", "Powerbank", "Memoria USB"};
        int[] stock = {12, 40, 5, 18, 3, 25, 7, 30, 2, 50};
        int[] minimo = {20, 30, 15, 10, 10, 20, 10, 15, 15, 40};
        int[] importes = {35, 80, 12, 64, 50, 49, 120, 22, 75, 18, 90, 45, 33, 150, 60, 27, 52, 8, 99, 41, 70, 15, 55, 38, 200, 47, 66, 29, 85, 10};

        ControlStock tareaStock = new ControlStock(productos, stock, minimo);
        ProcesadorPedidos tareaPedidos = new ProcesadorPedidos(importes);

        Thread hStock = new Thread(tareaStock, "Stock");
        hStock.setPriority(Thread.MAX_PRIORITY);
        
        Thread hPedidos = new Thread(tareaPedidos, "Pedidos");
        hPedidos.setPriority(Thread.MIN_PRIORITY);

        hStock.start();
        hPedidos.start();

        try {
            hStock.join(); // Esperamos solo a que termine de revisar el stock
            int unidadesComprar = tareaStock.getUnidadesAPedir();
            System.out.println("Orden: comprar " + unidadesComprar + " unidades al proveedor (Pedidos está " + hPedidos.getState() + ")");

            CompraProveedor tareaCompra = new CompraProveedor(unidadesComprar);
            Thread hCompra = new Thread(tareaCompra, "Compra");
            hCompra.setPriority(Thread.NORM_PRIORITY);
            hCompra.start();

            // Esperamos a los hilos restantes
            hPedidos.join();
            hCompra.join();

            System.out.println("=== Informe del almacén ===");
            System.out.println("Productos a reponer: " + tareaStock.getProductosAReponer() + " (" + unidadesComprar + " unidades)");
            System.out.println("Compra al proveedor: " + tareaCompra.getTotal() + " €");
            System.out.println("Pedidos: " + tareaPedidos.getFacturado() + " € facturados, " + tareaPedidos.getEnviosGratis() + " con envío gratis");
            System.out.println("Pedido máximo: " + tareaPedidos.getPedidoMaximo() + " €");

        } catch (InterruptedException e) {
            System.out.println("El hilo principal fue interrumpido.");
        }
    }
}