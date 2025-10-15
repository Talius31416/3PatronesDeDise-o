import java.time.Duration;
import java.time.LocalDateTime;

public class Comun extends BicicletaFactory{
    public Comun(String ID, boolean isElectric){
        super(ID, isElectric);
    }
    @Override
    public int calcularPrecio(LocalDateTime FechaDeSalida, LocalDateTime horaDeLLegada){
        long segundos = Duration.between(FechaDeSalida, horaDeLLegada).getSeconds();
        double cantidadTiempo = segundos/3600;
        if(cantidadTiempo < 1){
            return 1000;
        }else{
            return Integer.parseInt(String.valueOf(cantidadTiempo*1000));
        }
    }
}
