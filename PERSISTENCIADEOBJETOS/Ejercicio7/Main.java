package Ejercicio7;

public class Main {
    public static void main(String[] args) {
        ArchNiño archivo = new ArchNiño("ninos.json");

        archivo.crearArchivo();

        archivo.guardarNiño(new Niño("Ana", "Perez", "Lopez", 101, 5, 25.0f, 90.0f));
        archivo.guardarNiño(new Niño("Luis", "Gomez", "Diaz", 102, 6, 28.0f, 100.0f));
        archivo.guardarNiño(new Niño("Marta", "Ramirez", "Suarez", 103, 5, 18.0f, 85.0f));
        archivo.guardarNiño(new Niño("Jorge", "Diaz", "Torres", 104, 7, 30.0f, 110.0f));

        archivo.mostrarTodos();

        archivo.contarPesoAdecuado();

        archivo.mostrarPesoTallaInadecuada();

        archivo.promedioEdad();

        archivo.buscarPorCI(102);

        archivo.mostrarMasAlta();
    }
}