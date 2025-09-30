public class Main {
    public static void main(String[] args) {
        ListaDobleReservas lista = new ListaDobleReservas();

        lista.insertar(new Reserva("Gloria", 1, 150));
        lista.insertar(new Reserva("Minimi", 2, 200));
        lista.insertar(new Reserva("David", 3, 300));
        lista.insertar(new Reserva("Ana", 4, 200)); // costo duplicado
        lista.insertar(new Reserva("Luis", 5, 150)); // costo duplicado
        lista.insertar(new Reserva("Maria", 6, 500));
        lista.insertar(new Reserva("Carlos", 7, 100));
        lista.insertar(new Reserva("Sofia", 8, 350));
        lista.insertar(new Reserva("Pedro", 9, 200)); // costo duplicado
        lista.insertar(new Reserva("Laura", 10, 450));

        System.out.println(" Lista actual:");
        lista.imprimir();

        System.out.println("\n Buscar reserva con id 2:");
        System.out.println(lista.buscar(2));

        System.out.println("\nActualizar costo de id 3:");
        lista.actualizarCosto(3, 400);
        lista.imprimir();

        System.out.println("\n Eliminar reserva con id 1:");
        lista.eliminar(1);
        lista.imprimir();

        System.out.println("\n Intentar insertar id repetido:");
        lista.insertar(new Reserva("Luis", 2, 500));

        System.out.println("\n" + "=".repeat(50));
        
        // Mostrar todas las estadísticas
        lista.mostrarEstadisticasCompletas();


    }
}







