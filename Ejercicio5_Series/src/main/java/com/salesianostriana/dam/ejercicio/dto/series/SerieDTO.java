package com.salesianostriana.dam.ejercicio.dto.series;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public record SerieDTO(
        String titulo,
        Integer temporadas,
        String creador,
        String categoria,
        String imagenPrincipal
) {

    public static SerieDTO of(Serie serie) {
        if (serie == null) {
            return new SerieDTO(null, null, null, null, null);
        }

        Creador creador = serie.getCreador();
        Categoria categoria = serie.getCategoria();

        return new SerieDTO(
                serie.getTitulo(),
                serie.getNumeroTemporadas(),
                creador == null ? null : nombreCompleto(creador.getNombre(), creador.getApellidos()),
                categoria == null ? null : categoria.getNombre(),
                primeraImagen(serie)
        );
    }

    private static String nombreCompleto(String nombre, String apellidos) {
        String resultado = Stream.of(nombre, apellidos)
                .filter(parte -> parte != null && !parte.isBlank())
                .map(String::trim)
                .collect(Collectors.joining(" "));
        return resultado.isBlank() ? null : resultado;
    }

    private static String primeraImagen(Serie serie) {
        if (serie.getImagenes() == null) {
            return null;
        }
        return serie.getImagenes().stream()
                .filter(imagen -> imagen != null && !imagen.isBlank())
                .findFirst()
                .orElse(null);
    }
}
