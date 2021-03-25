package app.web;

public class Testeo {
    private String fecha_muestra;
    private String tipo;
    private String dispositivo;
    private String genero;
    private String grupo_etario;
    private String n;

    public Testeo(String fecha_muestra, String tipo, String dispositivo, String genero, String grupo_etario, String n) {
        this.fecha_muestra = fecha_muestra;
        this.tipo = tipo;
        this.dispositivo = dispositivo;
        this.genero = genero;
        this.grupo_etario = grupo_etario;
        this.n = n;
    }

    public String getFecha_muestra() {
        return fecha_muestra;
    }

    public void setFecha_muestra(String fecha_muestra) {
        this.fecha_muestra = fecha_muestra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGrupo_etario() {
        return grupo_etario;
    }

    public void setGrupo_etario(String grupo_etario) {
        this.grupo_etario = grupo_etario;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }
}
