package com.salesianostriana.dam.ejercicio.dto.series;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ApplicationTests {

    @Test
    void convierteLaSerieYSeleccionaLaPrimeraImagen() {
        Creador creador = Creador.builder().nombre("Álex").apellidos("Pina").build();
        Categoria categoria = Categoria.builder().nombre("Drama").build();
        Serie serie = Serie.builder()
                .titulo("La casa de papel")
                .numeroTemporadas(5)
                .creador(creador)
                .categoria(categoria)
                .imagenes(List.of("portada.jpg", "otra.jpg"))
                .build();

        SerieDTO dto = SerieDTO.of(serie);

        assertEquals("La casa de papel", dto.titulo());
        assertEquals(5, dto.temporadas());
        assertEquals("Álex Pina", dto.creador());
        assertEquals("Drama", dto.categoria());
        assertEquals("portada.jpg", dto.imagenPrincipal());
    }

    @Test
    void admiteDatosOpcionalesAusentesYSerieNull() {
        Serie sinCategoria = Serie.builder().titulo("Sin categoría").imagenes(List.of()).build();
        Serie sinImagenes = Serie.builder().titulo("Sin imágenes").imagenes(null).build();

        assertNull(SerieDTO.of(sinCategoria).categoria());
        assertNull(SerieDTO.of(sinCategoria).imagenPrincipal());
        assertNull(SerieDTO.of(sinImagenes).imagenPrincipal());
        assertNull(SerieDTO.of(null).titulo());
        assertNull(SerieDTO.of(null).creador());
    }
}
