package Ejercicio9;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ArchZoo {
    private String nombreArchivo;

    public ArchZoo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    // a) Crear archivo vacío
    public void crearArchivo() {
        try {
            FileWriter writer = new FileWriter(nombreArchivo);
            writer.write("[]");
            writer.close();
            System.out.println("Archivo de zoologicos creado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // a) Guardar zoológico
    public void guardarZoologico(Zoologico z) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(nombreArchivo));
            Zoologico[] lista = gson.fromJson(reader, Zoologico[].class);
            reader.close();

            Zoologico[] nuevaLista;
            int n = (lista != null) ? lista.length : 0;
            nuevaLista = new Zoologico[n + 1];
            if (n > 0) System.arraycopy(lista, 0, nuevaLista, 0, n);
            nuevaLista[n] = z;

            FileWriter writer = new FileWriter(nombreArchivo);
            writer.write(gson.toJson(nuevaLista));
            writer.close();
            System.out.println("Zoologico guardado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // a) Modificar zoologico por nombre
    public void modificarZoologico(String nombre, Zoologico nuevo) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(nombreArchivo));
            Zoologico[] lista = gson.fromJson(reader, Zoologico[].class);
            reader.close();

            if (lista == null) return;
            for (int i = 0; i < lista.length; i++) {
                if (lista[i].nombre.equalsIgnoreCase(nombre)) lista[i] = nuevo;
            }

            FileWriter writer = new FileWriter(nombreArchivo);
            writer.write(gson.toJson(lista));
            writer.close();
            System.out.println("Zoologico modificado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // a) Eliminar zoológico por nombre
    public void eliminarZoologico(String nombre) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(nombreArchivo));
            Zoologico[] lista = gson.fromJson(reader, Zoologico[].class);
            reader.close();

            if (lista == null) return;
            int count = 0;
            for (Zoologico z : lista) if (!z.nombre.equalsIgnoreCase(nombre)) count++;

            Zoologico[] nuevaLista = new Zoologico[count];
            int j = 0;
            for (Zoologico z : lista) {
                if (!z.nombre.equalsIgnoreCase(nombre)) {
                    nuevaLista[j] = z;
                    j++;
                }
            }

            FileWriter writer = new FileWriter(nombreArchivo);
            writer.write(gson.toJson(nuevaLista));
            writer.close();
            System.out.println("Zoologico eliminado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Zoologico[] leerZoologicos() {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(nombreArchivo));
            Zoologico[] lista = gson.fromJson(reader, Zoologico[].class);
            reader.close();
            return (lista != null) ? lista : new Zoologico[0];
        } catch (Exception e) {
            e.printStackTrace();
            return new Zoologico[0];
        }
    }

    // b) Listar zoológicos con mayor cantidad de animales
    public void zoologicosMayorVariedad() {
        Zoologico[] lista = leerZoologicos();
        if (lista.length == 0) return;

        int max = lista[0].nroAnimales;
        for (Zoologico z : lista) if (z.nroAnimales > max) max = z.nroAnimales;

        System.out.println("=== Zoologicos con mayor cantidad de animales ===");
        for (Zoologico z : lista) if (z.nroAnimales == max) z.mostrar();
    }

    // c) Listar zoológicos vacíos y eliminarlos
    public void eliminarZoologicosVacios() {
        Zoologico[] lista = leerZoologicos();
        ArrayList<Zoologico> temp = new ArrayList<>();
        System.out.println("=== Zoologicos vacios ===");
        for (Zoologico z : lista) {
            if (z.nroAnimales == 0) z.mostrar();
            else temp.add(z);
        }

        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter(nombreArchivo);
            writer.write(gson.toJson(temp));
            writer.close();
            System.out.println("Zoologicos vacios eliminados.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // d) Mostrar animales de especie x
    public void mostrarEspecie(String especie) {
        Zoologico[] lista = leerZoologicos();
        System.out.println("=== Animales de especie " + especie + " ===");
        for (Zoologico z : lista) {
            for (int i = 0; i < z.nroAnimales; i++) {
                if (z.animales[i].especie.equalsIgnoreCase(especie)) z.animales[i].mostrar();
            }
        }
    }

    // e) Mover animales de un zoológico x a un zoológico y
    public void moverAnimales(String zooOrigen, String zooDestino) {
        Zoologico[] lista = leerZoologicos();
        Zoologico origen = null, destino = null;
        for (Zoologico z : lista) {
            if (z.nombre.equalsIgnoreCase(zooOrigen)) origen = z;
            if (z.nombre.equalsIgnoreCase(zooDestino)) destino = z;
        }
        if (origen == null || destino == null) {
            System.out.println("Zoológico origen o destino no encontrado.");
            return;
        }

        for (int i = 0; i < origen.nroAnimales; i++) {
            destino.agregarAnimal(origen.animales[i]);
        }
        origen.nroAnimales = 0;

        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter(nombreArchivo);
            writer.write(gson.toJson(lista));
            writer.close();
            System.out.println("Animales movidos de " + zooOrigen + " a " + zooDestino);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarTodos() {
        Zoologico[] lista = leerZoologicos();
        System.out.println("=== Todos los Zoologicos ===");
        for (Zoologico z : lista) z.mostrar();
    }
}
