public class ListaDobleReservas {
    private Nodo cabeza;
    private Nodo cola;

    public ListaDobleReservas() {
        cabeza = null;
        cola = null;
    }

    // Insertar verificando unicidad
    public void insertar(Reserva r) {
        if (buscar(r.getIdReserva()) != null) {
            System.out.println("Error: El idReserva " + r.getIdReserva() + " ya existe.");
            return;
        }

        Nodo nuevo = new Nodo(r);

        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            cola = nuevo;
        }
    }

    // Buscar por idReserva
    public Reserva buscar(int idReserva) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getDato().getIdReserva() == idReserva) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    // Eliminar por idReserva
    public boolean eliminar(int idReserva) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getDato().getIdReserva() == idReserva) {
                if (actual.getAnterior() != null) {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                } else {
                    cabeza = actual.getSiguiente(); // era el primero
                }

                if (actual.getSiguiente() != null) {
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                } else {
                    cola = actual.getAnterior(); // era el último
                }
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    // Imprimir lista de inicio a fin
    public void imprimir() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }

    // Actualizar costo
    public boolean actualizarCosto(int idReserva, double nuevoCosto) {
        Reserva r = buscar(idReserva);
        if (r != null) {
            try {
                r.setCosto(nuevoCosto);
                return true;
            } catch (IllegalArgumentException e) {
                System.out.println("⚠️ " + e.getMessage());
            }
        }
        return false;
    }




}







