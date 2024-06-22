package parcial2;

import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Partido {
    private int fase;
    private Equipo equipo1;
    private Equipo equipo2;
    private int victoriasEquipo1;
    private int victoriasEquipo2;

    public Partido() {
        this.fase = 0;
        this.equipo1 = null;
        this.equipo2 = null;
        this.victoriasEquipo1 = 0;
        this.victoriasEquipo2 = 0;
    }

    public Partido(int fase) {
        this.fase = fase;
        this.equipo1 = null;
        this.equipo2 = null;
        this.victoriasEquipo1 = 0;
        this.victoriasEquipo2 = 0;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    public void jugarPartida(LinkedList<Equipo> listaEquipos, LinkedList<Jugador> listaJugadores) {
        // Verificar que existan equipos
        if (listaEquipos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay equipos en la lista", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar que haya al menos 8 equipos para jugar cuartos de final
        if (listaEquipos.size() < 8) {
            JOptionPane.showMessageDialog(null, "Debe haber al menos 8 equipos para jugar una partida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar que haya al menos 40 jugadores (8 equipos * 5 jugadores por equipo) para jugar
        if (listaJugadores.isEmpty() || listaJugadores.size() < 40) {
            JOptionPane.showMessageDialog(null, "Debe haber al menos 40 jugadores (5 por equipo) para jugar una partida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        simularPartida(listaEquipos);
    }

    public void simularPartida(LinkedList<Equipo> listaEquipos) {
        LinkedList<Equipo> EquiposSemi = new LinkedList<>();
        LinkedList<Equipo> EquiposFinal = new LinkedList<>();

        // Mensaje inicial
        JOptionPane.showMessageDialog(null, "¡Comienza el torneo!", "Inicio", JOptionPane.INFORMATION_MESSAGE);

        // Bucle principal para cuartos de final
        for (int j = 0; j < listaEquipos.size(); j += 2) {
            equipo1 = listaEquipos.get(j);
            equipo2 = listaEquipos.get(j + 1);
            victoriasEquipo1 = 0;
            victoriasEquipo2 = 0;

            // Simular la serie MJ entre equipo1 y equipo2
            while (victoriasEquipo1 < 3 && victoriasEquipo2 < 3) {
                int ganador = (int) (Math.random() * 2) + 1;

                if (ganador == 1) {
                    victoriasEquipo1++;
                    JOptionPane.showMessageDialog(null, "Victoria para " + equipo1.getNombreEquipo() + " en cuartos de final. Marcador: " + victoriasEquipo1 + "-" + victoriasEquipo2, "Resultado", JOptionPane.PLAIN_MESSAGE);
                } else {
                    victoriasEquipo2++;
                    JOptionPane.showMessageDialog(null, "Victoria para " + equipo2.getNombreEquipo() + " en cuartos de final. Marcador: " + victoriasEquipo1 + "-" + victoriasEquipo2, "Resultado", JOptionPane.PLAIN_MESSAGE);
                }
            }

            // Determinar que equipo pasa a las semifinales
            if (victoriasEquipo1 > victoriasEquipo2) {
                JOptionPane.showMessageDialog(null, "¡" + equipo1.getNombreEquipo() + " avanza a semifinales!", "Avance", JOptionPane.INFORMATION_MESSAGE);
                EquiposSemi.add(equipo1);
            } else {
                JOptionPane.showMessageDialog(null, "¡" + equipo2.getNombreEquipo() + " avanza a semifinales!", "Avance", JOptionPane.INFORMATION_MESSAGE);
                EquiposSemi.add(equipo2);
            }
        }

        // Semifinales
        for (int j = 0; j < EquiposSemi.size(); j += 2) {
            equipo1 = EquiposSemi.get(j);
            equipo2 = EquiposSemi.get(j + 1);
            victoriasEquipo1 = 0;
            victoriasEquipo2 = 0;

            // Simular la serie MJ3 entre equipo1 y equipo2
            while (victoriasEquipo1 < 3 && victoriasEquipo2 < 3) {
                int ganador = (int) (Math.random() * 2) + 1;

                if (ganador == 1) {
                    victoriasEquipo1++;
                    JOptionPane.showMessageDialog(null, "Victoria para " + equipo1.getNombreEquipo() + " en semifinales. Marcador: " + victoriasEquipo1 + "-" + victoriasEquipo2, "Resultado", JOptionPane.PLAIN_MESSAGE);
                } else {
                    victoriasEquipo2++;
                    JOptionPane.showMessageDialog(null, "Victoria para " + equipo2.getNombreEquipo() + " en semifinales. Marcador: " + victoriasEquipo1 + "-" + victoriasEquipo2, "Resultado", JOptionPane.PLAIN_MESSAGE);
                }
            }

            // Determinar que equipo pasa a la final
            if (victoriasEquipo1 > victoriasEquipo2) {
                JOptionPane.showMessageDialog(null, "¡" + equipo1.getNombreEquipo() + " avanza a la final!", "Avance", JOptionPane.INFORMATION_MESSAGE);
                EquiposFinal.add(equipo1);
            } else {
                JOptionPane.showMessageDialog(null, "¡" + equipo2.getNombreEquipo() + " avanza a la final!", "Avance", JOptionPane.INFORMATION_MESSAGE);
                EquiposFinal.add(equipo2);
            }
        }

        // Final
        equipo1 = EquiposFinal.get(0);
        equipo2 = EquiposFinal.get(1);
        victoriasEquipo1 = 0;
        victoriasEquipo2 = 0;

        // Simular la serie MJ3 entre equipo1 y equipo2
        while (victoriasEquipo1 < 3 && victoriasEquipo2 < 3) {
            int ganador = (int) (Math.random() * 2) + 1;

            if (ganador == 1) {
                victoriasEquipo1++;
                JOptionPane.showMessageDialog(null, "Victoria para " + equipo1.getNombreEquipo() + " en la final. Marcador: " + victoriasEquipo1 + "-" + victoriasEquipo2, "Resultado", JOptionPane.PLAIN_MESSAGE);
            } else {
                victoriasEquipo2++;
                JOptionPane.showMessageDialog(null, "Victoria para " + equipo2.getNombreEquipo() + " en la final. Marcador: " + victoriasEquipo1 + "-" + victoriasEquipo2, "Resultado", JOptionPane.PLAIN_MESSAGE);
            }
        }

        // Determinar ganador de la final
        Equipo ganadorFinal;
        if (victoriasEquipo1 > victoriasEquipo2) {
            ganadorFinal = equipo1;
        } else {
            ganadorFinal = equipo2;
        }

        JOptionPane.showMessageDialog(null, "¡El ganador del torneo es: " + ganadorFinal.getNombreEquipo() + "!", "¡Felicidades!", JOptionPane.INFORMATION_MESSAGE);
    }
}
