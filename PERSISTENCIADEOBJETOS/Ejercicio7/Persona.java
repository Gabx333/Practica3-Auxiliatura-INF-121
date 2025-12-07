package Ejercicio7;

import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class Persona {
    public String nombre;
    public String apellidoPaterno;
    public String apellidoMaterno;
    public int ci;

    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, int ci) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.ci = ci;
    }

    public void mostrar() {
        System.out.println("Nombre: " + nombre + " " + apellidoPaterno + " " + apellidoMaterno + " | CI: " + ci);
    }
}
