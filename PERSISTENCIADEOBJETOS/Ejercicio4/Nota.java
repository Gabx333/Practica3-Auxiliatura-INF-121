package Ejercicio4;

public class Nota {
    public String materia;
    public float notaFinal;
    public Estudiante estudiante;

    public Nota(String materia, float notaFinal, Estudiante estudiante) {
        this.materia = materia;
        this.notaFinal = notaFinal;
        this.estudiante = estudiante;
    }

    public void mostrar() {
        System.out.println(
            "Materia: " + materia +
            " | Nota Final: " + notaFinal +
            " | Estudiante: " + estudiante.nombre + " " + estudiante.paterno
        );
    }
}
