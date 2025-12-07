package Ejercicio3;

public class Main {
    public static void main(String[] args) {
        ArchivoProducto archivo = new ArchivoProducto("productos.json");

        archivo.crearArchivo();

        archivo.guardarProducto(new Producto("Arroz", 101, 12.5f));
        archivo.guardarProducto(new Producto("Azúcar", 102, 8.0f));
        archivo.guardarProducto(new Producto("Leche", 103, 15.0f));
        archivo.guardarProducto(new Producto("Aceite", 104, 20.0f));

        System.out.println("\n=== Buscar producto codigo 103 ===");
        Producto buscado = archivo.buscarProducto(103);
        if (buscado != null) buscado.mostrar();
        else System.out.println("Producto no encontrado.");

        System.out.println("\n=== Promedio de precios ===");
        System.out.println(archivo.promedioPrecios());

        System.out.println("\n=== Producto mas caro ===");
        Producto caro = archivo.productoMasCaro();
        if (caro != null) caro.mostrar();
    }
}

