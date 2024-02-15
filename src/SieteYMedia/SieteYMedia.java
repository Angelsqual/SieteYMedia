package SieteYMedia;

import recursos.Baraja;
import recursos.Carta;

public class SieteYMedia {

    private Baraja baraja;
    private Carta[] cartasJugador;
    private Carta[] cartasBanca;
    private InterfaceConsola interfaceConsola;

    public SieteYMedia() {
        baraja = new Baraja();
        baraja.barajar();
        cartasJugador = new Carta[15];
        cartasBanca = new Carta[15];
        interfaceConsola = new InterfaceConsola();
    }

    public void jugar() {
        interfaceConsola.presentarJuego();
        turnoJugador();
        turnoBanca();
        interfaceConsola.despedida();
        interfaceConsola.cerrarScanner();
    }

    private void turnoJugador() {
        char opc = 'C';
        while (valorCartas(cartasJugador) < 7.5 && opc == 'C') {
            Carta c = baraja.darCartas(1)[0];
            insertarCartaEnArray(cartasJugador, c);
            interfaceConsola.mostrarCartas(cartasJugador);
            double valor = valorCartas(cartasJugador);
            if (valor < 7.5) {
                opc = interfaceConsola.solicitarAccionJugador();
            }
        }
    }

    private void turnoBanca() {
        double valorCartasJugador = valorCartas(cartasJugador);
        if (valorCartasJugador > 7.5) {
            interfaceConsola.mostrarResultado(false);
            return;
        }

        while (valorCartas(cartasBanca) < valorCartasJugador) {
            Carta c = baraja.darCartas(1)[0];
            insertarCartaEnArray(cartasBanca, c);
        }

        interfaceConsola.mostrarCartas(cartasBanca);
        if (valorCartas(cartasBanca) > 7.5) {
            interfaceConsola.mostrarResultado(true);
        } else {
            interfaceConsola.mostrarResultado(false);
        }
    }

    private double valorCartas(Carta[] cartas) {
        double total = 0.0;
        for (Carta carta : cartas) {
            if (carta != null) {
                total += (carta.getNumero() > 7) ? 0.5 : carta.getNumero();
            }
        }
        return total;
    }

    private void insertarCartaEnArray(Carta[] cartas, Carta c) {
        int i = 0;
        while (cartas[i] != null) {
            i++;
        }
        cartas[i] = c;
    }
}
