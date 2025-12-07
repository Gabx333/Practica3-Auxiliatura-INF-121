package Ejercicio9;

class Zoologico {
    public int id;
    public String nombre;
    public int nroAnimales;
    public Animal[] animales = new Animal[30];

    public Zoologico(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.nroAnimales = 0;
    }

    public void agregarAnimal(Animal a) {
        if (nroAnimales < 30) {
            animales[nroAnimales] = a;
            nroAnimales++;
        } else {
            System.out.println("Capacidad máxima de animales alcanzada.");
        }
    }

    public void mostrar() {
        System.out.println("=== Zoologico: " + nombre + " (ID: " + id + ") ===");
        System.out.println("Numero de animales: " + nroAnimales);
        for (int i = 0; i < nroAnimales; i++) animales[i].mostrar();
    }
}
