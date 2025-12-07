package Ejercicio1;

import java.io.FileWriter;
import com.google.gson.Gson;

public class GuardarCharangos {

    public static void main(String[] args) {

        try {
            Gson gson = new Gson();

            FileWriter writer = new FileWriter("charangos.json");

            Charango[] lista = {

                new Charango("Madera", 10,
                    new boolean[]{true,true,true,true,true,true,true,true,true,true}),

                new Charango("Plastico", 8,
                    new boolean[]{false,false,false,true,true,true,true,true,true,true}),

                new Charango("Algarrobo", 7,
                    new boolean[]{false,false,false,false,false,false,false,false,true,true}),

                new Charango("Madera", 10,
                    new boolean[]{true,true,false,false,true,true,true,true,true,true})
            };

            writer.write(gson.toJson(lista));
            writer.close();

            System.out.println("Archivo guardado correctamente.");

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
