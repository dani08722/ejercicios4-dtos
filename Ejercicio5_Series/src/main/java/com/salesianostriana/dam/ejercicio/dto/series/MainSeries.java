package com.salesianostriana.dam.ejercicio.dto.series;

import java.util.List;

public class MainSeries {

    public static void main(String[] args) {
        Creador creador = Creador.builder()
                .nombre("Álex")
                .apellidos("Pina")
                .pais("España")
                .build();
        Categoria drama = Categoria.builder()
                .nombre("Drama")
                .descripcion("Historias dramáticas")
                .build();

        Serie completa = Serie.builder()
                .titulo("La casa de papel")
                .sinopsis("Un grupo prepara un gran atraco.")
                .numeroTemporadas(5)
                .creador(creador)
                .categoria(drama)
                .imagenes(List.of("https://ejemplo.com/serie-principal.jpg", "https://ejemplo.com/serie-2.jpg"))
                .build();
        Serie sinCategoria = Serie.builder()
                .titulo("Serie sin categoría")
                .numeroTemporadas(1)
                .creador(creador)
                .imagenes(List.of("https://ejemplo.com/sin-categoria.jpg"))
                .build();
        Serie sinImagenes = Serie.builder()
                .titulo("Serie sin lista de imágenes")
                .creador(creador)
                .categoria(drama)
                .build();
        Serie listaVacia = Serie.builder()
                .titulo("Serie con lista vacía")
                .creador(creador)
                .categoria(drama)
                .imagenes(List.of())
                .build();

        System.out.println("Serie completa: " + SerieDTO.of(completa));
        System.out.println("Serie sin categoría: " + SerieDTO.of(sinCategoria));
        System.out.println("Serie sin imágenes: " + SerieDTO.of(sinImagenes));
        System.out.println("Serie con lista vacía: " + SerieDTO.of(listaVacia));
        System.out.println("Serie null: " + SerieDTO.of(null));
    }
}
