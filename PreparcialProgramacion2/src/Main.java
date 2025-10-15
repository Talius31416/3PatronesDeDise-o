import javax.swing.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        AlquilerBicicletas aux = AlquilerBicicletas.getInstance();
        String menu[] = {"salida", "Registrar bicicleta", "registrar Usuario", "registrar Estacion", "sacar bicicleta", "entregar bicicleta"};
        boolean salida = false;
        while (!salida) {
            int opcion = JOptionPane.showOptionDialog(null,
                    "",
                    "que quieres hacer",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    menu,
                    menu[0]);
            switch (opcion) {
                case 0:
                    salida = true;
                    break;
                case 1:
                    aux.registrarBicicleta(input("Ingrese el ID de la bicicleta"), booleanInput("La bicicleta es electrica?"));
                    break;
                case 2:
                    aux.registrarUsuario(input("Ingrese el nombre de la persona"), input("Ingrese el apellido"), input("ingrese el ID"), input("Ingrese el correo"), LocalDate.parse(input("Ingrese la fecha de nacimiento (YYYY-MM-DD)")));
                    break;
                case 3:
                    aux.registrarEstacion(input("Ingrese la ubicacion de la estacion"));
                    break;
                case 4:
                    aux.SacarBicicleta(input("Ingrese el ID de la bicicleta"));
                    break;
                case 5:
                    aux.entregarBicicleta(input("Ingrese el ID de la bicicleta"));
                    break;
            }
        }
    }

    public static void print(String text){
        JOptionPane.showMessageDialog(null, text);
    }
    public static String input(String text){
        String texto = JOptionPane.showInputDialog(null, text);
        return texto;
    }
    public static boolean booleanInput(String text){
        boolean result = JOptionPane.YES_NO_OPTION == JOptionPane.showConfirmDialog(null, text);
        return result;
    }
}