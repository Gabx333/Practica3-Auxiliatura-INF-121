package Ejercicio8;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ArchRefri {
    private String nombreArchivo;

    public ArchRefri(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void crearArchivo() {
        try {
            FileWriter writer = new FileWriter(nombreArchivo);
            writer.write("[]");
            writer.close();
            System.out.println("Archivo de alimentos creado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // a) Guardar o agregar alimento
    public void guardarAlimento(Alimento a) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(nombreArchivo));
            Alimento[] lista = gson.fromJson(reader, Alimento[].class);
            reader.close();

            ArrayList<Alimento> temp = new ArrayList<>();
            if (lista != null) for (Alimento al : lista) temp.add(al);
            temp.add(a);

            FileWriter writer = new FileWriter(nombreArchivo);
            writer.write(gson.toJson(temp));
            writer.close();
            System.out.println("Alimento guardado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // a) Modificar alimento por nombre
    public void modificarPorNombre(String nombre, Alimento nuevo) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(nombreArchivo));
            Alimento[] lista = gson.fromJson(reader, Alimento[].class);
            reader.close();

            ArrayList<Alimento> temp = new ArrayList<>();
            if (lista != null) {
                for (Alimento al : lista) {
                    if (al.nombre.equalsIgnoreCase(nombre)) temp.add(nuevo);
                    else temp.add(al);
                }
            }

            FileWriter writer = new FileWriter(nombreArchivo);
            writer.write(gson.toJson(temp));
            writer.close();
            System.out.println("Alimento modificado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // a) Eliminar alimento por nombre
    public void eliminarPorNombre(String nombre) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(nombreArchivo));
            Alimento[] lista = gson.fromJson(reader, Alimento[].class);
            reader.close();

            ArrayList<Alimento> temp = new ArrayList<>();
            if (lista != null) {
                for (Alimento al : lista) {
                    if (!al.nombre.equalsIgnoreCase(nombre)) temp.add(al);
                }
            }

            FileWriter writer = new FileWriter(nombreArchivo);
            writer.write(gson.toJson(temp));
            writer.close();
            System.out.println("Alimento eliminado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // b) Mostrar alimentos que caducaron antes de una fecha X
    public void mostrarCaducadosAntes(String fechaX) {
        Alimento[] lista = leerAlimentos();
        System.out.println("=== Alimentos caducados antes de " + fechaX + " ===");
        for (Alimento a : lista) {
            if (a.fechaDeVencimiento.compareTo(fechaX) < 0) a.mostrar();
        }
    }

    // c) Eliminar alimentos con cantidad 0
    public void eliminarCantidadCero() {
        Alimento[] lista = leerAlimentos();
        ArrayList<Alimento> temp = new ArrayList<>();
        for (Alimento a : lista) if (a.cantidad > 0) temp.add(a);

        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter(nombreArchivo);
            writer.write(gson.toJson(temp));
            writer.close();
            System.out.println("Alimentos con cantidad 0 eliminados.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // d) Buscar alimentos vencidos (antes de hoy)
    public void buscarVencidos(String fechaHoy) {
        Alimento[] lista = leerAlimentos();
        System.out.println("=== Alimentos vencidos hasta " + fechaHoy + " ===");
        for (Alimento a : lista) {
            if (a.fechaDeVencimiento.compareTo(fechaHoy) < 0) a.mostrar();
        }
    }

    // e) Mostrar alimento con más cantidad
    public void alimentoMasCantidad() {
        Alimento[] lista = leerAlimentos();
        if (lista.length == 0) return;
        Alimento max = lista[0];
        for (Alimento a : lista) if (a.cantidad > max.cantidad) max = a;
        System.out.println("=== Alimento con mas cantidad ===");
        max.mostrar();
    }

    public Alimento[] leerAlimentos() {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(nombreArchivo));
            Alimento[] lista = gson.fromJson(reader, Alimento[].class);
            reader.close();
            return lista != null ? lista : new Alimento[0];
        } catch (Exception e) {
            e.printStackTrace();
            return new Alimento[0];
        }
    }

    public void mostrarTodos() {
        Alimento[] lista = leerAlimentos();
        System.out.println("=== Todos los alimentos ===");
        for (Alimento a : lista) a.mostrar();
    }
}
