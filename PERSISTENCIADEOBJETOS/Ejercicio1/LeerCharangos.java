package Ejercicio1;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.google.gson.Gson;

public class LeerCharangos {

    public static void main(String[] args) {

        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("charangos.json"));

            Charango[] lista = gson.fromJson(reader, Charango[].class);
            reader.close();

            System.out.println("=== LISTA ORIGINAL ===");
            for (Charango c : lista)
                c.mostrar();

            // b) Eliminar charangos con más de 6 cuerdas malas
            Charango[] filtrados = new Charango[lista.length];
            int cont = 0;

            for (int i = 0; i < lista.length; i++) {
                if (lista[i].cuerdasMalas() <= 6) {
                    filtrados[cont] = lista[i];
                    cont++;
                }
            }

            System.out.println("\n=== b) Después de eliminar (>6 malas) ===");
            for (int i = 0; i < cont; i++)
                filtrados[i].mostrar();
            
            // c) Listar charangos de material "x"
            String materialBuscado = "Madera";

            System.out.println("\n=== c) De material: " + materialBuscado + " ===");
            for (int i = 0; i < cont; i++) {
                if (filtrados[i].material.equalsIgnoreCase(materialBuscado)) {
                    filtrados[i].mostrar();
                }
            }

            // d) Buscar charangos con 10 cuerdas
            System.out.println("\n=== d) Charangos con 10 cuerdas ===");
            for (int i = 0; i < cont; i++) {
                if (filtrados[i].nroCuerdas == 10) {
                    filtrados[i].mostrar();
                }
            }

            // e) Ordenar por material alfabéticamente
            for (int i = 0; i < cont - 1; i++) {
                for (int j = 0; j < cont - 1 - i; j++) {
                    if (filtrados[j].material.compareToIgnoreCase(filtrados[j + 1].material) > 0) {
                        Charango aux = filtrados[j];
                        filtrados[j] = filtrados[j + 1];
                        filtrados[j + 1] = aux;
                    }
                }
            }

            System.out.println("\n=== e) Ordenados por material ===");
            for (int i = 0; i < cont; i++)
                filtrados[i].mostrar();

        } catch (Exception e) {
            System.out.println("ERROR LEER"+e);
        }
    }
}
