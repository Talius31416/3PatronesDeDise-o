import java.util.ArrayList;

public class Estacion {
    private ArrayList<BicicletaFactory> listaBicicletas;
    private String ubicacion;
    public Estacion(Builder builder) {
        this.listaBicicletas = builder.listaBicicletas;
        this.ubicacion = builder.ubicacion;
    }

    public String setListaBicicletas(BicicletaFactory Bicicleta) {
        if(listaBicicletas.size() < 10) {
            listaBicicletas.add(Bicicleta);
            return "bicicleta guardada con exito";
        }else{
            return "capacidad maxima alcanzada";
        }
    }
    public static class Builder {
        private ArrayList<BicicletaFactory> listaBicicletas;
        private String ubicacion;
        public Builder ubicacion(String ubicacion) {
            this.ubicacion = ubicacion;
            return this;
        }
        public Builder listaBicicletas() {
            this.listaBicicletas = new ArrayList();
            return this;
        }
        public Estacion build() {
            return new Estacion(this);
        }
    }
}
