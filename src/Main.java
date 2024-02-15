import SieteYMedia.InterfaceConsola;
import SieteYMedia.SieteYMedia;

public class Main {
    public static void main(String[] args) {
        InterfaceConsola interfaceConsola = new InterfaceConsola();
        SieteYMedia sieteYMedia = new SieteYMedia();

        interfaceConsola.presentarJuego();
        sieteYMedia.jugar();
    }
}
