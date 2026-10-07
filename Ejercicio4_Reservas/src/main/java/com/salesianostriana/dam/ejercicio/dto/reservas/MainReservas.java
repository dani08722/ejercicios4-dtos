package com.salesianostriana.dam.ejercicio.dto.reservas;

public class MainReservas {

    public static void main(String[] args) {
        Cliente cliente = Cliente.builder()
                .nombre("Lucía")
                .apellidos("García López")
                .email("lucia@example.com")
                .telefono("600123123")
                .build();
        Habitacion habitacion = Habitacion.builder()
                .numero("204")
                .tipo("Doble")
                .precioNoche(85.0)
                .planta(2)
                .build();

        Reserva completa = Reserva.builder()
                .codigo("R-001")
                .numeroNoches(3)
                .cliente(cliente)
                .habitacion(habitacion)
                .build();
        Reserva sinCliente = Reserva.builder()
                .codigo("R-002")
                .numeroNoches(2)
                .habitacion(habitacion)
                .build();
        Reserva sinHabitacion = Reserva.builder()
                .codigo("R-003")
                .numeroNoches(1)
                .cliente(cliente)
                .build();
        Reserva sinNoches = Reserva.builder()
                .codigo("R-004")
                .cliente(cliente)
                .habitacion(habitacion)
                .build();
        Habitacion sinPrecio = Habitacion.builder().numero("105").tipo("Individual").build();
        Reserva sinPrecioNoche = Reserva.builder()
                .codigo("R-005")
                .numeroNoches(2)
                .cliente(cliente)
                .habitacion(sinPrecio)
                .build();

        System.out.println("Reserva completa: " + ReservaDTO.of(completa));
        System.out.println("Reserva sin cliente: " + ReservaDTO.of(sinCliente));
        System.out.println("Reserva sin habitación: " + ReservaDTO.of(sinHabitacion));
        System.out.println("Reserva sin número de noches: " + ReservaDTO.of(sinNoches));
        System.out.println("Reserva sin precio por noche: " + ReservaDTO.of(sinPrecioNoche));
        System.out.println("Reserva null: " + ReservaDTO.of(null));
    }
}
