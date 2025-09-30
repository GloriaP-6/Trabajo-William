public class Nodo {
    Reserva dato;
    private Nodo anterior;
    private Nodo siguiente;

    public Nodo(Reserva dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }

    public Reserva getDato() {
        return dato;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}

