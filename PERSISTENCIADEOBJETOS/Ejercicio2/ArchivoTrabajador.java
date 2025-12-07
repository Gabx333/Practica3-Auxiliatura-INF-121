package Ejercicio2;

import Ejercicio2.Trabajador;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;


public class ArchivoTrabajador {
    private String archivoTrabajador = "trabajadores.json";

    public ArchivoTrabajador() {
        
    }

    // a) Crear archivo 
    public void crearArchivo() {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Trabajador[] listaVacia = {};
            FileWriter writer = new FileWriter(archivoTrabajador);
            writer.write(gson.toJson(listaVacia));
            writer.close();
            System.out.println("Archivo de trabajadores creado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // b) Guardar trabajador 
    public void guardarTrabajador(Trabajador t) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(archivoTrabajador));
            Trabajador[] lista = gson.fromJson(reader, Trabajador[].class);
            reader.close();

            int n = (lista != null) ? lista.length : 0;
            Trabajador[] nuevaLista = new Trabajador[n + 1];
            if (n > 0) System.arraycopy(lista, 0, nuevaLista, 0, n);
            nuevaLista[n] = t;

            // Guardar de nuevo
            FileWriter writer = new FileWriter(archivoTrabajador);
            writer.write(gson.toJson(nuevaLista));
            writer.close();
            System.out.println("Trabajador guardado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // c) Aumentar salario de un trabajador t
    public void aumentaSalario(int aumento, Trabajador t) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(archivoTrabajador));
            Trabajador[] lista = gson.fromJson(reader, Trabajador[].class);
            reader.close();

            for (Trabajador tr : lista) {
                if (tr.nombre.equals(t.nombre)) {
                    tr.setSalario(tr.getSalario() + aumento);
                    break;
                }
            }

            FileWriter writer = new FileWriter(archivoTrabajador);
            writer.write(gson.toJson(lista));
            writer.close();
            System.out.println("Salario aumentado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Trabajador[] leerTrabajadores() {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(archivoTrabajador));
            Trabajador[] lista = gson.fromJson(reader, Trabajador[].class);
            reader.close();
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return new Trabajador[0];
        }
    }

    // d) Buscar trabajador con mayor salario
    public Trabajador mayorSalario() {
        Trabajador[] lista = leerTrabajadores();
        if (lista.length == 0) return null;
        Trabajador mayor = lista[0];
        for (Trabajador t : lista) {
            if (t.getSalario() > mayor.getSalario()) mayor = t;
        }
        return mayor;
    }

    // e) Ordenar trabajadores por salario 
    public void ordenarPorSalario() {
        Trabajador[] lista = leerTrabajadores();
        for (int i = 0; i < lista.length - 1; i++) {
            for (int j = 0; j < lista.length - 1 - i; j++) {
                if (lista[j].getSalario() > lista[j + 1].getSalario()) {
                    Trabajador aux = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = aux;
                }
            }
        }
        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter(archivoTrabajador);
            writer.write(gson.toJson(lista));
            writer.close();
            System.out.println("Trabajadores ordenados por salario.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
