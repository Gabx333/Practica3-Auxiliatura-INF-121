package Ejercicio3;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ArchivoProducto {
    private String nomA;

    public ArchivoProducto(String n) {
        this.nomA = n;
    }

    // a) Crear archivo vacío
    public void crearArchivo() {
        try {
            FileWriter writer = new FileWriter(nomA);
            writer.write("[]"); // JSON vacío
            writer.close();
            System.out.println("Archivo de productos creado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // b) Guardar producto
    public void guardarProducto(Producto p) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(nomA));
            Producto[] lista = gson.fromJson(reader, Producto[].class);
            reader.close();

            ArrayList<Producto> temp = new ArrayList<>();
            if (lista != null) {
                for (Producto pr : lista) temp.add(pr);
            }
            temp.add(p);

            FileWriter writer = new FileWriter(nomA);
            writer.write(gson.toJson(temp));
            writer.close();
            System.out.println("Producto guardado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // c) Buscar producto por código
    public Producto buscarProducto(int c) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(nomA));
            Producto[] lista = gson.fromJson(reader, Producto[].class);
            reader.close();

            if (lista != null) {
                for (Producto pr : lista) {
                    if (pr.getCodigo() == c) return pr;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; 
    }

    // d) Calcular promedio de precios
    public float promedioPrecios() {
        float suma = 0;
        int count = 0;
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(nomA));
            Producto[] lista = gson.fromJson(reader, Producto[].class);
            reader.close();

            if (lista != null && lista.length > 0) {
                for (Producto pr : lista) {
                    suma += pr.getPrecio();
                    count++;
                }
                return suma / count;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // e) Mostrar producto más caro
    public Producto productoMasCaro() {
        Producto masCaro = null;
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(nomA));
            Producto[] lista = gson.fromJson(reader, Producto[].class);
            reader.close();

            if (lista != null && lista.length > 0) {
                masCaro = lista[0];
                for (Producto pr : lista) {
                    if (pr.getPrecio() > masCaro.getPrecio()) masCaro = pr;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return masCaro;
    }
}

