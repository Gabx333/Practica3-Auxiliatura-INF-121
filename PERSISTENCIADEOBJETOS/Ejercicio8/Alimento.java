package Ejercicio8;

import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import com.google.gson.Gson;

class Alimento {
    public String nombre;
    public String fechaDeVencimiento; //yyyy-mm-dd
    public int cantidad;

    public Alimento(String nombre, String fechaDeVencimiento, int cantidad) {
        this.nombre = nombre;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.cantidad = cantidad;
    }

    public void mostrar() {
        System.out.println("Nombre: " + nombre + " | Vence: " + fechaDeVencimiento + " | Cantidad: " + cantidad);
    }
}
