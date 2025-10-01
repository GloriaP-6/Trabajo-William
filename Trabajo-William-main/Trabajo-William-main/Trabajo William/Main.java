import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.border.Border;

public class Main {

        public static void applyCustomTheme() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

            Color backgroundColor = new Color(245, 245, 250);
            Color primaryColor = new Color(65, 105, 225);
            Color textColor = new Color(40, 40, 40);

            UIManager.put("OptionPane.background", backgroundColor);
            UIManager.put("Panel.background", backgroundColor);
            UIManager.put("OptionPane.messageForeground", textColor);
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.PLAIN, 14));

            UIManager.put("Button.background", primaryColor);
            UIManager.put("Button.foreground", Color.WHITE);
            UIManager.put("Button.font", new Font("Segoe UI", Font.BOLD, 12));
            UIManager.put("Button.border", BorderFactory.createEmptyBorder(8, 15, 8, 15));

        } catch (Exception e) {
            e.printStackTrace();
        }
        }

        public static void showListDialog(List<String> elementos, String title) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String elemento : elementos) {
            listModel.addElement("➤ " + elemento);
        }

        JList<String> list = new JList<>(listModel);
        list.setFont(new Font("Consolas", Font.PLAIN, 14));
        list.setBackground(new Color(248, 248, 255));
        list.setSelectionBackground(new Color(135, 206, 250));
        list.setForeground(new Color(40, 40, 40));

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.getViewport().setBackground(new Color(245, 245, 250));
        scrollPane.setBackground(new Color(245, 245, 250));

        JOptionPane.showMessageDialog(null, scrollPane, title,JOptionPane.INFORMATION_MESSAGE);
    }
    public static void main(String[] args) {
        applyCustomTheme();
        ListaDobleReservas lista = new ListaDobleReservas();

        // Datos iniciales (puedes comentar si no los quieres)
        lista.insertar(new Reserva("Gloria", 1, 150));
        lista.insertar(new Reserva("Minimi", 2, 200));
        lista.insertar(new Reserva("David", 3, 300));
        lista.insertar(new Reserva("Ana", 4, 200));
        lista.insertar(new Reserva("Luis", 5, 150));
        lista.insertar(new Reserva("Maria", 6, 500));
        lista.insertar(new Reserva("Carlos", 7, 100));
        lista.insertar(new Reserva("Sofia", 8, 350));
        lista.insertar(new Reserva("Pedro", 9, 200));
        lista.insertar(new Reserva("Laura", 10, 450));

        String menu = "1. Insertar reserva\n"
                    + "2. Buscar reserva\n"
                    + "3. Actualizar costo\n"
                    + "4. Eliminar reserva\n"
                    + "5. Mostrar lista\n"
                    + "6. Mostrar estadísticas\n"
                    + "7. Salir";

        int opcion;
        do {
            String input = JOptionPane.showInputDialog(null, menu, "Menú Reservas", JOptionPane.QUESTION_MESSAGE);
            if (input == null) break; // Cancelar
            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opción inválida.");
                continue;
            }

            

            switch (opcion) {
                case 1: // Insertar
                    try {
                        String nombre = JOptionPane.showInputDialog("Nombre:");
                        if (nombre == null) break;
                        int id = Integer.parseInt(JOptionPane.showInputDialog("ID:"));
                        int costo = Integer.parseInt(JOptionPane.showInputDialog("Costo:"));
                        boolean exito = lista.insertar(new Reserva(nombre, id, costo));
                        if (exito) {
                            JOptionPane.showMessageDialog(null, "Reserva insertada.");
                        } else {
                            JOptionPane.showMessageDialog(null, "ID repetido. No se insertó.");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Datos inválidos.");
                    }
                    break;
                case 2: // Buscar
                    try {
                        int idBuscar = Integer.parseInt(JOptionPane.showInputDialog("ID a buscar:"));
                        Reserva r = lista.buscar(idBuscar);
                        if (r != null) {
                            JOptionPane.showMessageDialog(null, r.toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "No encontrada.");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "ID inválido.");
                    }
                    break;
                case 3: // Actualizar costo
                    try {
                        int idAct = Integer.parseInt(JOptionPane.showInputDialog("ID a actualizar:"));
                        int nuevoCosto = Integer.parseInt(JOptionPane.showInputDialog("Nuevo costo:"));
                        boolean actualizado = lista.actualizarCosto(idAct, nuevoCosto);
                        if (actualizado) {
                            JOptionPane.showMessageDialog(null, "Costo actualizado.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Reserva no encontrada.");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Datos inválidos.");
                    }
                    break;
                case 4: // Eliminar
                    try {
                        int idElim = Integer.parseInt(JOptionPane.showInputDialog("ID a eliminar:"));
                        int confirm = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar la reserva?", "Confirmar", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            boolean eliminado = lista.eliminar(idElim);
                            if (eliminado) {
                                JOptionPane.showMessageDialog(null, "Reserva eliminada.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Reserva no encontrada.");
                            }
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "ID inválido.");
                    }
                    break;
                case 5: // Mostrar lista
                    List<String> reservasList = lista.obtenerReservasComoLista();
                    showListDialog(reservasList, "Lista de Reservas");
                    break;
                case 6: // Estadísticas
                    JOptionPane.showMessageDialog(null, lista.estadisticasComoString());
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (true);
    }
}







