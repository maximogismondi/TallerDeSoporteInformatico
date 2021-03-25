package app.web;

public class OrdenDeCompra {
    private String fecha;
    private String numero_oc;
    private String provedor;
    private String importenEnArs;
    private String objeto;
    private String tipoDeProcedimiento;

    public OrdenDeCompra(String fecha, String numero_oc, String provedor, String importenEnArs, String objeto, String tipoDeProcedimiento) {
        this.fecha = fecha;
        this.numero_oc = numero_oc;
        this.provedor = provedor;
        this.importenEnArs = importenEnArs;
        this.objeto = objeto;
        this.tipoDeProcedimiento = tipoDeProcedimiento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNumero_oc() {
        return numero_oc;
    }

    public void setNumero_oc(String numero_oc) {
        this.numero_oc = numero_oc;
    }

    public String getProvedor() {
        return provedor;
    }

    public void setProvedor(String provedor) {
        this.provedor = provedor;
    }

    public String getImportenEnArs() {
        return importenEnArs;
    }

    public void setImportenEnArs(String importenEnArs) {
        this.importenEnArs = importenEnArs;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getTipoDeProcedimiento() {
        return tipoDeProcedimiento;
    }

    public void setTipoDeProcedimiento(String tipoDeProcedimiento) {
        this.tipoDeProcedimiento = tipoDeProcedimiento;
    }
}
