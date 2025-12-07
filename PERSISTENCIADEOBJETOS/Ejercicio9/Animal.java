package Ejercicio9;

import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.google.gson.Gson;

public class Animal {
    public String especie;
    public String nombre;
    public int cantidad;

    public Animal(String especie, String nombre, int cantidad) {
        this.especie = especie;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public void mostrar() {
        System.out.println("Especie: " + especie + " | Nombre: " + nombre + " | Cantidad: " + cantidad);
    }
}
