import java.time.LocalDate;

public class Usuario {
    private String nombre;
    private String apellido;
    private String correo;
    private String ID;
    private LocalDate fechaNacimiento;
    private Usuario(Builder builder){
        this.nombre = builder.nombre;
        this.apellido = builder.apellido;
        this.correo = builder.correo;
        this.ID = builder.ID;
        this.fechaNacimiento = builder.fechaNacimiento;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public static class Builder{
        private String nombre;
        private String apellido;
        private String correo;
        private String ID;
        private LocalDate fechaNacimiento;

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }
        public Builder apellido(String apellido) {
            this.apellido = apellido;
            return this;
        }
        public Builder correo(String correo) {
            this.correo = correo;
            return this;
        }
        public Builder ID(String ID) {
            this.ID = ID;
            return this;
        }
        public Builder fechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
            return this;
        }
        public Usuario build() {
            return new Usuario(this);
        }
        }
    }

