package Ejercicio1;

public class Charango {

    public String material;
    public int nroCuerdas;
    public boolean[] cuerdas = new boolean[10];

    public Charango(String material, int nroCuerdas, boolean[] cuerdas) {
        this.material = material;
        this.nroCuerdas = nroCuerdas;
        this.cuerdas = cuerdas;
    }

    // ---- MÉTODOS DEL EJERCICIO ----

    // b) contar cuerdas malas
    public int cuerdasMalas() {
        int malas = 0;
        for (boolean c : cuerdas) {
            if (!c) malas++;
        }
        return malas;
    }

    // Mostrar información
    public void mostrar() {
        System.out.println(
            "Material: " + material +
            " | N cuerdas: " + nroCuerdas +
            " | Cuerdas malas: " + cuerdasMalas()
        );
    }
}
