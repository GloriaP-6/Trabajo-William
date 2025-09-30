public class Reserva {
private String cliente;
int idReserva;
private double costo; 


public Reserva(String cliente,int idReserva,double costo){
        this.cliente = cliente;
        this.idReserva = idReserva;
        this.costo = costo;
}
 //Getters
 public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public double getCosto() {
        return costo;
    }

 //Setters
    public void setCosto(double costo) {
        if (costo < 0) {
            throw new IllegalArgumentException("El costo no puede ser negativo");
        }
        this.costo = costo;
    }

    @Override //Para darle el estilo de como quiero que se imprima finalmente
    public String toString() {
    return "Reserva [cliente=" + cliente + ", id=" + idReserva + ", costo=" + costo + "]";
    }

}

