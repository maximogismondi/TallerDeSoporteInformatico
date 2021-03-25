package app.web;

public class Socio {

    private String nombre;
    private int edad;
    private String equipo;
    private String estadoCivil;
    private String nivelDeEstudios;

    public Socio(String nombre, int edad, String equipo, String estadoCivil, String nivelDeEstudios) {
        this.nombre = nombre;
        this.edad = edad;
        this.equipo = equipo;
        this.estadoCivil = estadoCivil;
        this.nivelDeEstudios = nivelDeEstudios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNivelDeEstudios() {
        return nivelDeEstudios;
    }

    public void setNivelDeEstudios(String nivelDeEstudios) {
        this.nivelDeEstudios = nivelDeEstudios;
    }
}