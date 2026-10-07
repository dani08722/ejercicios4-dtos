package com.salesianostriana.dam.ejercicio.dto.libros;

public class MainLibros {

    public static void main(String[] args) {
        Autor autora = Autor.builder()
                .id(1L)
                .nombre("Isabel")
                .apellido1("Allende")
                .nacionalidad("Chilena")
                .build();

        Libro libroConAutora = Libro.builder()
                .id(1L)
                .titulo("La casa de los espíritus")
                .isbn("978-84-663-5172-1")
                .anioPublicacion(1982)
                .numeroPaginas(496)
                .autor(autora)
                .build();

        Libro libroSinAutor = Libro.builder()
                .id(2L)
                .titulo("Libro anónimo")
                .isbn("978-00-000-0000-0")
                .anioPublicacion(2024)
                .build();

        Autor autorSinSegundoApellido = Autor.builder()
                .nombre("Miguel")
                .apellido1("Delibes")
                .build();
        Libro libroConApellidoOpcional = Libro.builder()
                .titulo("El camino")
                .autor(autorSinSegundoApellido)
                .build();

        System.out.println("Libro con autora: " + LibroDTO.of(libroConAutora));
        System.out.println("Libro sin autor: " + LibroDTO.of(libroSinAutor));
        System.out.println("Autor sin segundo apellido: " + LibroDTO.of(libroConApellidoOpcional));
        System.out.println("Libro null: " + LibroDTO.of(null));
    }
}
