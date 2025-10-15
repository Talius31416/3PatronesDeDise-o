import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AlquilerBicicletas {
    private String nombre;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Estacion> estaciones;
    private ArrayList<BicicletaFactory> bicicletasDeLaEmpresa;
    private static AlquilerBicicletas instance;
    private AlquilerBicicletas(String nombre) {
        this.nombre = nombre;
        estaciones = new ArrayList<>();
        usuarios = new ArrayList<>();
        bicicletasDeLaEmpresa = new ArrayList<>();
    }
    public static AlquilerBicicletas getInstance() {
        if (instance == null) {
            return new AlquilerBicicletas("BikeGo");
        }
        return instance;
    }
    public String registrarEstacion(String ubicacion){
        estaciones.add(new Estacion.Builder().ubicacion(ubicacion).listaBicicletas().build());
        return "Estacion Registrada correctamente";
    }
    public String registrarBicicleta(String ID, boolean isElectric){
        bicicletasDeLaEmpresa.add(BicicletaFactory.CrearBicicleta(ID, isElectric));
        return "Bicicleta Registrada correctamente";
    }
    public String sortearBicicletas() {
        for (Estacion estacion : estaciones) {
            for (BicicletaFactory bicicleta : bicicletasDeLaEmpresa) {
                if (!estacion.setListaBicicletas(bicicleta).equals("capacidad maxima alcanzada")) {
                    String aux = "Nice";
                }
            }
        }
        return "Bicicleta Sorteada correctamente";
    }
    public String registrarUsuario(String nombre, String apellido, String ID, String correo, LocalDate FechaDeNacimiento){
        usuarios.add(new Usuario.Builder().nombre(nombre).apellido(apellido).ID(ID).correo(correo).fechaNacimiento(FechaDeNacimiento).build());
        return "Usuario Registrado correctamente";
    }
    public String SacarBicicleta(String ID){
        BicicletaFactory bicicletaFactory = getBicicleta(ID);
        if(bicicletaFactory == null){
            return "Bicicleta no encontrada";
        }else{
            bicicletaFactory.setDate(LocalDateTime.now());
            return "Bicicleta Sacada correctamente";
        }
    }

    public String entregarBicicleta(String ID){
        BicicletaFactory bicicletaFactory = buscarBicicleta(ID);
        if(bicicletaFactory == null){
            return "Bicicleta no encontrada";
        }else{
            return "El precio de la bicicleta es de "+ bicicletaFactory.calcularPrecio(bicicletaFactory.getFecha(), LocalDateTime.now());
        }
    }

    private BicicletaFactory getBicicleta(String ID){
        for(Estacion estacion : estaciones){
            for(BicicletaFactory bicicleta : bicicletasDeLaEmpresa){
                if(bicicleta.getID().equals(ID)){
                    return bicicleta;
                }
            }
        }
        return null;
    }
    private BicicletaFactory buscarBicicleta(String ID){
        for(BicicletaFactory bicicleta : bicicletasDeLaEmpresa){
            if(bicicleta.getID().equals(ID)){
                return bicicleta;
            }
        }
        return null;
    }


}
