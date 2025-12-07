package Ejercicio2;

public class Main {
    public static void main(String[] args) {
        ArchivoTrabajador archivo = new ArchivoTrabajador();

        archivo.crearArchivo();

        archivo.guardarTrabajador(new Trabajador("Ana", 12345, 2500));
        archivo.guardarTrabajador(new Trabajador("Luis", 23456, 3000));
        archivo.guardarTrabajador(new Trabajador("Marta", 34567, 2800));
        archivo.guardarTrabajador(new Trabajador("Jorge", 45678, 3200));

        archivo.aumentaSalario(500, new Trabajador("Ana", 0, 0));

        System.out.println("\n=== Trabajador con mayor salario ===");
        Trabajador mayor = archivo.mayorSalario();
        if (mayor != null) mayor.mostrar();

        archivo.ordenarPorSalario();
        System.out.println("\n=== Trabajadores ordenados por salario ===");
        for (Trabajador t : archivo.leerTrabajadores()) {
            t.mostrar();
        }
    }
}