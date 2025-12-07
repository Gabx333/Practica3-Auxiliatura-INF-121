package Ejercicio4;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

class ArchiNota {
    private String nombreArchi;

    public ArchiNota(String nombreArchi) {
        this.nombreArchi = nombreArchi;
    }

    // a) Crear archivo vacío
    public void crearArchivo() {
        try {
            FileWriter writer = new FileWriter(nombreArchi);
            writer.write("[]"); 
            writer.close();
            System.out.println("Archivo de notas creado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // b) Agregar varios estudiantes (notas)
    public void agregarNotas(Nota[] notas) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(nombreArchi));
            Nota[] lista = gson.fromJson(reader, Nota[].class);
            reader.close();

            ArrayList<Nota> temp = new ArrayList<>();
            if (lista != null) {
                for (Nota n : lista) temp.add(n);
            }
            for (Nota n : notas) temp.add(n);

            FileWriter writer = new FileWriter(nombreArchi);
            writer.write(gson.toJson(temp));
            writer.close();
            System.out.println("Notas agregadas correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // c) Calcular promedio de todas las notas
    public float promedioNotas() {
        float suma = 0;
        int count = 0;
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(nombreArchi));
            Nota[] lista = gson.fromJson(reader, Nota[].class);
            reader.close();

            if (lista != null && lista.length > 0) {
                for (Nota n : lista) {
                    suma += n.notaFinal;
                    count++;
                }
                return suma / count;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // d) Buscar estudiante(s) con la mejor nota
    public void mejoresNotas() {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(nombreArchi));
            Nota[] lista = gson.fromJson(reader, Nota[].class);
            reader.close();

            if (lista != null && lista.length > 0) {
                float max = lista[0].notaFinal;
                for (Nota n : lista) if (n.notaFinal > max) max = n.notaFinal;

                System.out.println("=== Estudiante(s) con la mejor nota ===");
                for (Nota n : lista) {
                    if (n.notaFinal == max) n.mostrar();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // e) Eliminar estudiantes de una materia determinada
    public void eliminarMateria(String materia) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(nombreArchi));
            Nota[] lista = gson.fromJson(reader, Nota[].class);
            reader.close();

            ArrayList<Nota> temp = new ArrayList<>();
            if (lista != null) {
                for (Nota n : lista) {
                    if (!n.materia.equalsIgnoreCase(materia)) temp.add(n);
                }
            }

            FileWriter writer = new FileWriter(nombreArchi);
            writer.write(gson.toJson(temp));
            writer.close();
            System.out.println("Estudiantes de la materia '" + materia + "' eliminados.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarTodas() {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(nombreArchi));
            Nota[] lista = gson.fromJson(reader, Nota[].class);
            reader.close();

            if (lista != null && lista.length > 0) {
                System.out.println("=== Todas las notas ===");
                for (Nota n : lista) n.mostrar();
            } else {
                System.out.println("No hay notas registradas.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

