// Source code is decompiled from a .class file using FernFlower decompiler.

import java.util.*;

public class ListaDobleReservas {

    private Nodo cabeza = null;
    private Nodo cola = null;

   

    public void insertar(Reserva var1) {
        if (this.buscar(var1.getIdReserva()) != null) {
            System.out.println("Error: El idReserva " + var1.getIdReserva() + " ya existe.");
        } else {
            Nodo var2 = new Nodo(var1);
            if (this.cabeza == null) {
                this.cabeza = this.cola = var2;
            } else {
                this.cola.setSiguiente(var2);
                var2.setAnterior(this.cola);
                this.cola = var2;
            }

        }
    }

    public Reserva buscar(int var1) {
        for (Nodo var2 = this.cabeza; var2 != null; var2 = var2.getSiguiente()) {
            if (var2.getDato().getIdReserva() == var1) {
                return var2.getDato();
            }
        }

        return null;
    }

    public boolean eliminar(int var1) {
        for (Nodo var2 = this.cabeza; var2 != null; var2 = var2.getSiguiente()) {
            if (var2.getDato().getIdReserva() == var1) {
                if (var2.getAnterior() != null) {
                    var2.getAnterior().setSiguiente(var2.getSiguiente());
                } else {
                    this.cabeza = var2.getSiguiente();
                }

                if (var2.getSiguiente() != null) {
                    var2.getSiguiente().setAnterior(var2.getAnterior());
                } else {
                    this.cola = var2.getAnterior();
                }

                return true;
            }
        }

        return false;
    }

    public void imprimir() {
        for (Nodo var1 = this.cabeza; var1 != null; var1 = var1.getSiguiente()) {
            System.out.println(var1.getDato());
        }

    }

    public boolean actualizarCosto(int var1, double var2) {
        Reserva var4 = this.buscar(var1);
        if (var4 != null) {
            try {
                var4.setCosto(var2);
                return true;
            } catch (IllegalArgumentException var6) {
                System.out.println("\u26a0\ufe0f " + var6.getMessage());
            }
        }

        return false;
    }

    public int contarReservas() {
        int var1 = 0;

        for (Nodo var2 = this.cabeza; var2 != null; var2 = var2.getSiguiente()) {
            ++var1;
        }

        return var1;
    }

    public double calcularPromedio() {
        if (this.cabeza == null) {
            return 0.0;
        } else {
            double var1 = 0.0;
            int var3 = 0;

            for (Nodo var4 = this.cabeza; var4 != null; var4 = var4.getSiguiente()) {
                var1 += var4.getDato().getCosto();
                ++var3;
            }

            return var1 / (double) var3;
        }
    }

    public double encontrarMinimo() {
        if (this.cabeza == null) {
            return 0.0;
        } else {
            double var1 = Double.MAX_VALUE;

            for (Nodo var3 = this.cabeza; var3 != null; var3 = var3.getSiguiente()) {
                double var4 = var3.getDato().getCosto();
                if (var4 < var1) {
                    var1 = var4;
                }
            }

            return var1;
        }
    }

    public double encontrarMaximo() {
        if (this.cabeza == null) {
            return 0.0;
        } else {
            double var1 = Double.MIN_VALUE;

            for (Nodo var3 = this.cabeza; var3 != null; var3 = var3.getSiguiente()) {
                double var4 = var3.getDato().getCosto();
                if (var4 > var1) {
                    var1 = var4;
                }
            }

            return var1;
        }
    }

    public double calcularRango() {
        return this.encontrarMaximo() - this.encontrarMinimo();
    }

    public double calcularMediana() {
        if (this.cabeza == null) {
            return 0.0;
        } else {
            ArrayList var1 = new ArrayList();

            for (Nodo var2 = this.cabeza; var2 != null; var2 = var2.getSiguiente()) {
                var1.add(var2.getDato().getCosto());
            }

            Collections.sort(var1);
            int var3 = var1.size();
            if (var3 % 2 == 0) {
                int var4 = var3 / 2;
                double var5 = (Double) var1.get(var4 - 1);
                double var7 = (Double) var1.get(var4);
                return (var5 + var7) / 2.0;
            } else {
                return (Double) var1.get(var3 / 2);
            }
        }
    }

    public Map<Double, Integer> calcularModa() {
        HashMap var1 = new HashMap();

        for (Nodo var2 = this.cabeza; var2 != null; var2 = var2.getSiguiente()) {
            double var3 = var2.getDato().getCosto();
            if (var1.containsKey(var3)) {
                var1.put(var3, (Integer) var1.get(var3) + 1);
            } else {
                var1.put(var3, 1);
            }
        }

        int var7 = 0;
        Iterator var4 = var1.values().iterator();

        while (var4.hasNext()) {
            int var5 = (Integer) var4.next();
            if (var5 > var7) {
                var7 = var5;
            }
        }

        HashMap var8 = new HashMap();
        Iterator var9 = var1.entrySet().iterator();

        while (var9.hasNext()) {
            Map.Entry var6 = (Map.Entry) var9.next();
            if ((Integer) var6.getValue() == var7) {
                var8.put((Double) var6.getKey(), (Integer) var6.getValue());
            }
        }

        return var8;
    }

    public double calcularVarianza() {
        if (this.cabeza != null && this.contarReservas() >= 2) {
            double var1 = this.calcularPromedio();
            double var3 = 0.0;
            int var5 = 0;

            for (Nodo var6 = this.cabeza; var6 != null; var6 = var6.getSiguiente()) {
                double var7 = var6.getDato().getCosto() - var1;
                var3 += var7 * var7;
                ++var5;
            }

            return var3 / (double) (var5 - 1);
        } else {
            return 0.0;
        }
    }

    public double calcularDesviacionEstandar() {
        return Math.sqrt(this.calcularVarianza());
    }

    public Map<Double, Integer> generarTablaFrecuencias() {
        TreeMap var1 = new TreeMap();

        for (Nodo var2 = this.cabeza; var2 != null; var2 = var2.getSiguiente()) {
            double var3 = var2.getDato().getCosto();
            if (var1.containsKey(var3)) {
                int var5 = (Integer) var1.get(var3);
                var1.put(var3, var5 + 1);
            } else {
                var1.put(var3, 1);
            }
        }

        return var1;
    }

  public List<Reserva> obtenerTopNCostos(int n, boolean ascendente) {
    // Validar que n sea positivo y que haya reservas
    if (n <= 0 || cabeza == null) {
        return new ArrayList<>();
    }
    
    // Primero recojo todas las reservas en una lista
    List<Reserva> listaReservas = new ArrayList<>();
    Nodo temp = cabeza;
    
    while (temp != null) {
        listaReservas.add(temp.getDato());
        temp = temp.getSiguiente();
    }
    
    // Ahora las ordeno según lo que me pidieron
    if (ascendente) {
        // De menor a mayor costo
        listaReservas.sort(new Comparator<Reserva>() {
            public int compare(Reserva r1, Reserva r2) {
                return Double.compare(r1.getCosto(), r2.getCosto());
            }
        });
    } else {
        // De mayor a menor costo
        listaReservas.sort(new Comparator<Reserva>() {
            public int compare(Reserva r1, Reserva r2) {
                return Double.compare(r2.getCosto(), r1.getCosto());
            }
        });
    }
    
    // Devuelvo solo las primeras N reservas
    int cantidad = n;
    if (n > listaReservas.size()) {
        cantidad = listaReservas.size();
    }
    
    return listaReservas.subList(0, cantidad);
}

    public void mostrarTablaFrecuenciasVisual() {
        Map var1 = this.generarTablaFrecuencias();
        if (var1.isEmpty()) {
            System.out.println("No hay datos para mostrar.");
        } else {
            int var2 = (Integer) Collections.max(var1.values());
            byte var3 = 40;
            System.out.println("         TABLA DE FRECUENCIAS DE COSTOS");
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("%-13s | %-10s | %-35s\n", "COSTO", "FRECUENCIA", "DISTRIBUCION");
            System.out.println("------------------------------------------------------------------------");
            Iterator var4 = var1.entrySet().iterator();

            while (var4.hasNext()) {
                Map.Entry var5 = (Map.Entry) var4.next();
                double var6 = (Double) var5.getKey();
                int var8 = (Integer) var5.getValue();
                int var9 = (int) ((double) (var8 * var3) / (double) var2);
                String var10 = "#".repeat(var9);
                System.out.printf("$ %,10.2f | %6d     | %-35s\n", var6, var8, var10);
            }

            System.out.println("------------------------------------------------------------------------");
            System.out.printf("Total de valores unicos: %d | Total de reservas: %d\n", var1.size(), this.contarReservas());
        }
    }

    public void mostrarEstadisticasCompletas() {
        System.out.println("===================================");
        System.out.println("   ESTADISTICAS DE RESERVAS");
        System.out.println("===================================");
        System.out.println("Total de reservas: " + this.contarReservas());
        System.out.printf("Costo promedio: $%.2f\n", this.calcularPromedio());
        System.out.printf("Costo minimo: $%.2f\n", this.encontrarMinimo());
        System.out.printf("Costo maximo: $%.2f\n", this.encontrarMaximo());
        System.out.printf("Rango: $%.2f\n", this.calcularRango());
        System.out.printf("Mediana: $%.2f\n", this.calcularMediana());
        Map var1 = this.calcularModa();
        System.out.print("Moda: ");
        if (var1.isEmpty()) {
            System.out.println("No hay datos");
        } else {
            Iterator var2 = var1.entrySet().iterator();

            while (var2.hasNext()) {
                Map.Entry var3 = (Map.Entry) var2.next();
                System.out.printf("$%.2f (aparece %d veces) ", var3.getKey(), var3.getValue());
            }

            System.out.println();
        }

        System.out.printf("Varianza: %.2f\n", this.calcularVarianza());
        System.out.printf("Desviacion estandar: %.2f\n", this.calcularDesviacionEstandar());
        System.out.println("\n=== TABLA DE FRECUENCIAS ===");
        this.mostrarTablaFrecuenciasVisual();
        System.out.println("\n=== TOP 5 COSTOS MAS ALTOS ===");
        List var6 = this.obtenerTopNCostos(5, false);
        Iterator var7 = var6.iterator();

        while (var7.hasNext()) {
            Reserva var4 = (Reserva) var7.next();
            System.out.printf("$%.2f - %s\n", var4.getCosto(), var4.getCliente());
        }

        System.out.println("\n=== TOP 5 COSTOS MAS BAJOS ===");
        List var8 = this.obtenerTopNCostos(5, true);
        Iterator var9 = var8.iterator();

        while (var9.hasNext()) {
            Reserva var5 = (Reserva) var9.next();
            System.out.printf("$%.2f - %s\n", var5.getCosto(), var5.getCliente());
        }

    }
}
