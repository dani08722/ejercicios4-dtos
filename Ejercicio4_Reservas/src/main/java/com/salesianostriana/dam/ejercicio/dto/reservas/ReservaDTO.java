package com.salesianostriana.dam.ejercicio.dto.reservas;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public record ReservaDTO(
        String codigo,
        String cliente,
        String habitacion,
        Integer numeroNoches,
        Double precioTotal
) {

    public static ReservaDTO of(Reserva reserva) {
        if (reserva == null) {
            return new ReservaDTO(null, null, null, null, null);
        }

        Cliente cliente = reserva.getCliente();
        Habitacion habitacion = reserva.getHabitacion();
        Integer noches = reserva.getNumeroNoches();

        return new ReservaDTO(
                reserva.getCodigo(),
                cliente == null ? null : nombreCliente(cliente),
                descripcionHabitacion(habitacion),
                noches,
                calcularPrecioTotal(noches, habitacion)
        );
    }

    private static String descripcionHabitacion(Habitacion habitacion) {
        if (habitacion == null) {
            return null;
        }

        String numero = textoValido(habitacion.getNumero());
        String tipo = textoValido(habitacion.getTipo());
        if (numero != null && tipo != null) {
            return numero + " - " + tipo;
        }
        return numero != null ? numero : tipo;
    }

    private static Double calcularPrecioTotal(Integer noches, Habitacion habitacion) {
        if (noches == null || habitacion == null || habitacion.getPrecioNoche() == null) {
            return null;
        }
        return noches * habitacion.getPrecioNoche();
    }

    private static String unir(String primero, String segundo) {
        return Stream.of(primero, segundo)
                .map(ReservaDTO::textoValido)
                .filter(parte -> parte != null)
                .collect(Collectors.joining(" "));
    }

    private static String nombreCliente(Cliente cliente) {
        String nombre = unir(cliente.getNombre(), cliente.getApellidos());
        return nombre.isBlank() ? null : nombre;
    }

    private static String textoValido(String texto) {
        return texto == null || texto.isBlank() ? null : texto.trim();
    }
}
