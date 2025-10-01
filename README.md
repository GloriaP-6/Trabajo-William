# Trabajo-William

Proyecto de Gestión de Reservas - Resumen
Descripción General
Este proyecto consiste en una aplicación desarrollada en Java que implementa un sistema de gestión de reservas mediante una lista doblemente enlazada con interfaz gráfica basada en Swing y JOptionPane. La aplicación permite realizar operaciones completas de administración de reservas a través de una interfaz visual personalizada y moderna.

Funcionalidades Principales
El sistema ofrece operaciones esenciales para la gestión de reservas:

Inserción de nuevas reservas

Búsqueda eficiente de reservas existentes

Actualización de costos y datos

Eliminación de reservas

Visualización completa de la lista

Estadísticas detalladas del sistema

Características Técnicas
Estructura de Datos
Utiliza una lista doblemente enlazada que optimiza las operaciones de inserción, eliminación y recorrido bidireccional, proporcionando un balance ideal entre eficiencia y flexibilidad.

Interfaz de Usuario
Implementada con Swing y JOptionPane

Tema visual personalizado mediante Nimbus LookAndFeel

Colores y fuentes modernas para mejor experiencia

Visualización de listas en JScrollPane con JList

Arquitectura Modular
Las operaciones principales están encapsuladas en la clase ListaDobleReservas, garantizando:

Código organizado y mantenible

Separación clara de responsabilidades

Facilidad de extensión y modificación

Complejidad Computacional
Todas las operaciones mantienen una complejidad O(n) lineal:

Inserción: Verificación de IDs únicos + inserción

Búsqueda: Recorrido secuencial hasta encontrar elemento

Eliminación: Búsqueda + eliminación del nodo

Actualización: Búsqueda + modificación

Estadísticas: Cálculo de promedio, moda, mediana, mínimo y máximo

Requisitos y Ejecución
Requisitos Mínimos
Java JDK 8 o superior

IDE opcional (NetBeans, Eclipse, IntelliJ, VS Code)

Métodos de Ejecución
Terminal: Compilación y ejecución mediante comandos javac y java

IDE: Importar proyecto y ejecutar Main.java

Compilación directa desde la carpeta del proyecto

Propts usaods:

se usaron principalmente prompts que permitieran resolver errores, crear un par de clases especificas y elegir paleta de colore y fonts para la interfaz grafica, uno de los prompts usados fue:

Como podria crear la clase nodo teniendo en cuenta la clase reserva
public class Reserva {
    String cliente;
    int idReserva;
    double costo;

    public Reserva(String cliente, int idReserva, double costo) {
        this.cliente = cliente;
        this.idReserva = idReserva;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente + ", ID: " + idReserva + ", Costo: " + costo;
    }
}
