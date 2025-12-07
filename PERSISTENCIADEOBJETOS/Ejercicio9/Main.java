package Ejercicio9;

public class Main {
    public static void main(String[] args) {
        ArchZoo archivo = new ArchZoo("zoologicos.json");

        archivo.crearArchivo();

        Zoologico zoo1 = new Zoologico(1, "Safari");
        zoo1.agregarAnimal(new Animal("Leon", "Simba", 2));
        zoo1.agregarAnimal(new Animal("Elefante", "Dumbo", 1));

        Zoologico zoo2 = new Zoologico(2, "Jungla");
        zoo2.agregarAnimal(new Animal("Tigre", "Shere Khan", 1));

        Zoologico zoo3 = new Zoologico(3, "Bosque"); 

        archivo.guardarZoologico(zoo1);
        archivo.guardarZoologico(zoo2);
        archivo.guardarZoologico(zoo3);

        archivo.mostrarTodos();

        archivo.zoologicosMayorVariedad();

        archivo.eliminarZoologicosVacios();

        archivo.mostrarEspecie("Tigre");

        archivo.moverAnimales("Safari", "Jungla");

        archivo.mostrarTodos();
    }
}
