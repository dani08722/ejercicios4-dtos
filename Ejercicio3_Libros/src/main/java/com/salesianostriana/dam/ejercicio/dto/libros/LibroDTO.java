package com.salesianostriana.dam.ejercicio.dto.libros;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public record LibroDTO(
        String titulo,
        String isbn,
        String autor,
        Integer anioPublicacion
) {

    public static LibroDTO of(Libro libro) {
        if (libro == null) {
            return new LibroDTO(null, null, null, null);
        }

        return new LibroDTO(
                libro.getTitulo(),
                libro.getIsbn(),
                nombreCompleto(libro.getAutor()),
                libro.getAnioPublicacion()
        );
    }

    private static String nombreCompleto(Autor autor) {
        if (autor == null) {
            return null;
        }

        String nombre = Stream.of(autor.getNombre(), autor.getApellido1(), autor.getApellido2())
                .filter(parte -> parte != null && !parte.isBlank())
                .collect(Collectors.joining(" "));

        return nombre.isBlank() ? null : nombre;
    }
}
