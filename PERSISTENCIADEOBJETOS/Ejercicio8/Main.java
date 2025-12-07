package Ejercicio8;

public class Main {
    public static void main(String[] args) {
        ArchRefri refri = new ArchRefri("refri.json");

        refri.crearArchivo();

        refri.guardarAlimento(new Alimento("Leche", "2025-01-15", 2));
        refri.guardarAlimento(new Alimento("Queso", "2024-12-10", 0));
        refri.guardarAlimento(new Alimento("Pan", "2024-11-05", 5));
        refri.guardarAlimento(new Alimento("Mantequilla", "2025-03-20", 3));

        refri.mostrarTodos();

        refri.modificarPorNombre("Pan", new Alimento("Pan", "2024-11-15", 6));

        refri.eliminarPorNombre("Queso");

        refri.mostrarCaducadosAntes("2024-12-01");

        refri.eliminarCantidadCero();

        refri.buscarVencidos("2024-11-20");

        refri.alimentoMasCantidad();
    }
}