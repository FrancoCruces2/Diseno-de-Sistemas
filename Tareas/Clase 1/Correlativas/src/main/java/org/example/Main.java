package org.example;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

class Materia {
    private String nombre;
    private List<Materia> correlativas;

    public Materia(String nombre, List<Materia> correlativas) {
        this.nombre = nombre;
        this.correlativas = correlativas;
    }
}

@Getter
@Setter
class Alumno {
    private String nombre;
    private List<Materia> materiasAprobadas;

    public Alumno(String nombre, List<Materia> materiasAprobadas) {
        this.nombre = nombre;
        this.materiasAprobadas = materiasAprobadas;
    }

    public boolean aproboMateria(Materia materia) {
        return materiasAprobadas.contains(materia);
    }
}

@Getter
@Setter
class Inscripcion {
    private Alumno alumno;
    private List<Materia> materiasAInscribirse;

    public Inscripcion(Alumno alumno, List<Materia> materiasAInscribirse) {
        this.alumno = alumno;
        this.materiasAInscribirse = materiasAInscribirse;
    }

    public boolean aprobada() {
        for (Materia materia : materiasAInscribirse) {
            if (!cumpleCorrelativas(materia)) {
                return false;
            }
        }
        return true;
    }

    private boolean cumpleCorrelativas(Materia materia) {
        for (Materia correlativa : materia.getCorrelativas()) {
            if (!alumno.aproboMateria(correlativa)) {
                return false;
            }
        }
        return true;
    }
}