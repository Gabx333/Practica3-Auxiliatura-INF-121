package Ejercicio2;

import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Trabajador {
    public String nombre;
    private int ci;
    private double salario;

    public Trabajador(String nombre, int ci, double salario) {
        this.nombre = nombre;
        this.ci = ci;
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void mostrar() {
        System.out.println(
            "Nombre: " + nombre +
            " | CI: " + ci +
            " | Salario: " + salario
        );
    }
}

