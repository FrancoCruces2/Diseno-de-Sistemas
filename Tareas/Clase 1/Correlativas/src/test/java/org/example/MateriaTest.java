package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;

class InscripcionTest {

    @Test
    @DisplayName("Rodolfo se quiere anotar a materias, y cumple con las correlativas neceserias, se espera que de True")
    void testInscripcionAprobada() {

        Materia algebra = new Materia("Álgebra y Geometría Analítica", Collections.emptyList());
        Materia ingSociedad = new Materia("Ingeniería y Sociedad", Collections.emptyList());
        Materia algoritmos = new Materia("Algoritmos y Estructuras de Datos", Collections.emptyList());
        Materia legislacion = new Materia("Legislación", Arrays.asList(ingSociedad));

        Alumno rodolfo = new Alumno("Rodolfo", Arrays.asList(algebra, ingSociedad));

        Inscripcion inscripcion = new Inscripcion(rodolfo, Arrays.asList(algoritmos, legislacion));

        Assertions.assertTrue(inscripcion.aprobada(), "La inscripción debería estar aprobada.");

    }
    @Test
    @DisplayName("Carlos se quiere anotar a materias, pero no cumple con las correlativas necesarias se espera que de False")
    void testInscripcionRechazada() {
        Materia sistemasOrganizaciones = new Materia("Sistemas y Organizaciones", Collections.emptyList());
        Materia analisisSistemas = new Materia("Análisis de Sistemas", Collections.emptyList());
        Materia paradigmas = new Materia("Paradigmas de Programación", Collections.emptyList());
        Materia algoritmos = new Materia("Algoritmos y Estructuras de Datos", Collections.emptyList());
        Materia ingles1 = new Materia("Inglés 1", Collections.emptyList());
        Materia ingles2 = new Materia("Inglés 2", Collections.emptyList());
        Materia matematicaDiscreta = new Materia("Matemática Discreta", Collections.emptyList());

        Materia diseñoSistemas = new Materia("Diseño de Sistemas", Arrays.asList(analisisSistemas, ingles1));
        Materia baseDatos = new Materia("Base de Datos", Arrays.asList(algoritmos, matematicaDiscreta));

        Alumno carlos = new Alumno("Carlos", Arrays.asList(sistemasOrganizaciones, analisisSistemas, paradigmas, algoritmos, ingles1, ingles2));

        Inscripcion inscripcion = new Inscripcion(carlos, Arrays.asList(diseñoSistemas, baseDatos));

        Assertions.assertFalse(inscripcion.aprobada(), "La inscripción debería estar rechazada.");
    }
}

