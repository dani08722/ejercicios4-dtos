package com.salesianostriana.dam.ejercicio.dto.libros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ApplicationTests {

    @Test
    void convierteUnLibroConAutor() {
        Autor autor = Autor.builder()
                .nombre("Gabriel")
                .apellido1("García")
                .apellido2("Márquez")
                .build();
        Libro libro = Libro.builder()
                .titulo("Cien años de soledad")
                .isbn("978-0307474728")
                .anioPublicacion(1967)
                .autor(autor)
                .build();

        LibroDTO dto = LibroDTO.of(libro);

        assertEquals("Cien años de soledad", dto.titulo());
        assertEquals("Gabriel García Márquez", dto.autor());
        assertEquals(Integer.valueOf(1967), dto.anioPublicacion());
    }

    @Test
    void aceptaLibroSinAutorYLibroNull() {
        LibroDTO sinAutor = LibroDTO.of(Libro.builder().titulo("Anónimo").build());
        LibroDTO nullLibro = LibroDTO.of(null);

        assertNull(sinAutor.autor());
        assertNull(nullLibro.titulo());
        assertNull(nullLibro.autor());
    }

    @Test
    void omiteElSegundoApellidoCuandoNoExiste() {
        Autor autor = Autor.builder().nombre("Miguel").apellido1("Delibes").build();

        assertEquals("Miguel Delibes", LibroDTO.of(Libro.builder().autor(autor).build()).autor());
    }
}
