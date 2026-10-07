package com.salesianostriana.dam.ejercicio.dto.reservas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ApplicationTests {

    @Test
    void convierteUnaReservaCompletaYCalculaElPrecio() {
        Cliente cliente = Cliente.builder().nombre("Lucía").apellidos("García López").build();
        Habitacion habitacion = Habitacion.builder()
                .numero("204")
                .tipo("Doble")
                .precioNoche(85.0)
                .build();
        Reserva reserva = Reserva.builder()
                .codigo("R-001")
                .numeroNoches(3)
                .cliente(cliente)
                .habitacion(habitacion)
                .build();

        ReservaDTO dto = ReservaDTO.of(reserva);

        assertEquals("R-001", dto.codigo());
        assertEquals("Lucía García López", dto.cliente());
        assertEquals("204 - Doble", dto.habitacion());
        assertEquals(Integer.valueOf(3), dto.numeroNoches());
        assertEquals(255.0, dto.precioTotal(), 0.001);
    }

    @Test
    void devuelveNullCuandoFaltanDatosParaElCalculo() {
        Reserva sinClienteNiHabitacion = Reserva.builder().numeroNoches(2).build();
        Reserva sinNoches = Reserva.builder()
                .numeroNoches(null)
                .habitacion(Habitacion.builder().precioNoche(50.0).build())
                .build();
        Reserva sinPrecio = Reserva.builder()
                .numeroNoches(2)
                .habitacion(Habitacion.builder().tipo("Individual").build())
                .build();

        assertNull(ReservaDTO.of(sinClienteNiHabitacion).cliente());
        assertNull(ReservaDTO.of(sinClienteNiHabitacion).habitacion());
        assertNull(ReservaDTO.of(sinClienteNiHabitacion).precioTotal());
        assertNull(ReservaDTO.of(sinNoches).precioTotal());
        assertNull(ReservaDTO.of(sinPrecio).precioTotal());
    }

    @Test
    void admiteUnaReservaNull() {
        assertNull(ReservaDTO.of(null).codigo());
        assertNull(ReservaDTO.of(null).precioTotal());
    }
}
