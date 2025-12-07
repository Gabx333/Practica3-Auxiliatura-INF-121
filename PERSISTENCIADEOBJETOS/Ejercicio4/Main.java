package Ejercicio4;

public class Main {
    public static void main(String[] args) {
        ArchiNota archivo = new ArchiNota("notas.json");

        archivo.crearArchivo();

        Estudiante e1 = new Estudiante(101, "Ana", "Perez", "Lopez", 20);
        Estudiante e2 = new Estudiante(102, "Luis", "Gomez", "Diaz", 21);
        Estudiante e3 = new Estudiante(103, "Marta", "Ramirez", "Suarez", 19);

        Nota[] notas = {
            new Nota("Matematica", 18.5f, e1),
            new Nota("Fisica", 15.0f, e2),
            new Nota("Matematica", 19.0f, e3),
            new Nota("Quimica", 17.0f, e1)
        };

        archivo.agregarNotas(notas);

        archivo.mostrarTodas();

        System.out.println("\n=== Promedio de notas ===");
        System.out.println(archivo.promedioNotas());

        archivo.mejoresNotas();

        archivo.eliminarMateria("Matematica");

        System.out.println("\n=== Notas despues de eliminar Matematica ===");
        archivo.mostrarTodas();
    }
}