package Ejercicio4;

import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Estudiante {
    public int ru;
    public String nombre;
    public String paterno;
    public String materno;
    public int edad;

    public Estudiante(int ru, String nombre, String paterno, String materno, int edad) {
        this.ru = ru;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.edad = edad;
    }

    public void mostrar() {
        System.out.println(
            "RU: " + ru + " | Nombre: " + nombre + " " + paterno + " " + materno + " | Edad: " + edad);
    }
}

