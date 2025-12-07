package Ejercicio7;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

class ArchNiño {
    private String na;

    public ArchNiño(String na) {
        this.na = na;
    }

    // a) Crear archivo vacío
    public void crearArchivo() {
        try {
            FileWriter writer = new FileWriter(na);
            writer.write("[]");
            writer.close();
            System.out.println("Archivo de ninios creado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guardarNiño(Niño n) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(na));
            Niño[] lista = gson.fromJson(reader, Niño[].class);
            reader.close();

            ArrayList<Niño> temp = new ArrayList<>();
            if (lista != null) for (Niño ni : lista) temp.add(ni);
            temp.add(n);

            FileWriter writer = new FileWriter(na);
            writer.write(gson.toJson(temp));
            writer.close();
            System.out.println("Ninio guardado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Niño[] leerNiños() {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(na));
            Niño[] lista = gson.fromJson(reader, Niño[].class);
            reader.close();
            return lista != null ? lista : new Niño[0];
        } catch (Exception e) {
            e.printStackTrace();
            return new Niño[0];
        }
    }

    // b) Cuántos tienen peso adecuado según talla y edad
    public void contarPesoAdecuado() {
        Niño[] lista = leerNiños();
        int cont = 0;
        for (Niño n : lista) {
            // Peso adecuado = edad*3 + 10 ± 2 kg
            float pesoIdeal = n.edad * 3 + 10;
            if (n.peso >= pesoIdeal - 2 && n.peso <= pesoIdeal + 2) cont++;
        }
        System.out.println("Cantidad de ninios con peso adecuado: " + cont);
    }

    // c) Mostrar niños con peso o talla inadecuada
    public void mostrarPesoTallaInadecuada() {
        Niño[] lista = leerNiños();
        System.out.println("=== Ninios con peso o talla inadecuada ===");
        for (Niño n : lista) {
            float pesoIdeal = n.edad * 3 + 10; 
            float tallaIdeal = n.edad * 6 + 60; 
            if (n.peso < pesoIdeal - 2 || n.peso > pesoIdeal + 2 || n.talla < tallaIdeal - 5 || n.talla > tallaIdeal + 5) {
                n.mostrar();
            }
        }
    }

    // d) Promedio de edad
    public void promedioEdad() {
        Niño[] lista = leerNiños();
        if (lista.length == 0) {
            System.out.println("No hay ninios registrados.");
            return;
        }
        int suma = 0;
        for (Niño n : lista) suma += n.edad;
        System.out.println("Promedio de edad: " + (float)suma / lista.length);
    }

    // e) Buscar niño por carnet (CI)
    public void buscarPorCI(int ci) {
        Niño[] lista = leerNiños();
        for (Niño n : lista) {
            if (n.ci == ci) {
                System.out.println("Ninio encontrado:");
                n.mostrar();
                return;
            }
        }
        System.out.println("No se encontró ninio con CI: " + ci);
    }

    // f) Mostrar niños con la talla más alta
    public void mostrarMasAlta() {
        Niño[] lista = leerNiños();
        if (lista.length == 0) return;
        float maxTalla = lista[0].talla;
        for (Niño n : lista) if (n.talla > maxTalla) maxTalla = n.talla;

        System.out.println("=== Ninios con la talla mas alta ===");
        for (Niño n : lista) if (n.talla == maxTalla) n.mostrar();
    }

    public void mostrarTodos() {
        Niño[] lista = leerNiños();
        System.out.println("=== Lista de todos los ninios ===");
        for (Niño n : lista) n.mostrar();
    }
}
