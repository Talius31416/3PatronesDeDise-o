import java.time.LocalDateTime;

public abstract class BicicletaFactory {
    private String ID;
    private boolean isElectric;
    private LocalDateTime fecha;

    public BicicletaFactory(String ID, boolean isElectric) {
        this.ID = ID;
        this.isElectric = isElectric;
    }

    public static BicicletaFactory CrearBicicleta(String ID, boolean isElectric) {
        if (isElectric) {
            return new Electrica(ID, isElectric);
        } else {
            return new Comun(ID, isElectric);
        }
    }

    public String getID() {
        return ID;
    }
    public void setDate(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public abstract int calcularPrecio(LocalDateTime FechaDeSalida, LocalDateTime horaDeLLegada);


}
