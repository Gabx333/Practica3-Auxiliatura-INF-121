package Ejercicio3;

import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Producto {
    private String nombre;
    private int codigo;
    private float precio;

    public Producto(String nombre, int codigo, float precio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public float getPrecio() {
        return precio;
    }

    public void mostrar() {
        System.out.println(
            "Nombre: " + nombre +
            " | Codigo: " + codigo +
            " | Precio: " + precio
        );
    }
}