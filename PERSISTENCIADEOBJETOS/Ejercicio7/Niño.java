package Ejercicio7;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

class Niño extends Persona {
    public int edad;
    public float peso; //float por que el peso lo estoy midiendo en kilogramos y no creo que sea necesario en String para luego hacer un Integer innecesario si podemos usar directamente un float, lo mismo con talla
    public float talla;

    public Niño(String nombre, String apellidoPaterno, String apellidoMaterno, int ci, int edad, float peso, float talla) {
        super(nombre, apellidoPaterno, apellidoMaterno, ci);
        this.edad = edad;
        this.peso = peso;
        this.talla = talla;
    }

    public void mostrar() {
        super.mostrar();
        System.out.println("Edad: " + edad + " | Peso: " + peso + "kg | Talla: " + talla + "cm");
    }
}
