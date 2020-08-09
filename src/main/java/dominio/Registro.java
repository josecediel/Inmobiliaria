package dominio;

public class Registro {

    private int id;
    private String FechaAlta;
    private String tipo;
    private String operacion;
    private String provincia;
    private int superficie;
    private int percioVenta;
    private String fechaVenta;
    private String vendedor;

    public Registro() {
    }

    public Registro(int id) {
        this.id = id;
    }

    public Registro(String FechaAlta, String tipo, String operacion, String provincia, int superficie, int percioVenta, String fechaVenta, String vendedor) {
        this.FechaAlta = FechaAlta;
        this.tipo = tipo;
        this.operacion = operacion;
        this.provincia = provincia;
        this.superficie = superficie;
        this.percioVenta = percioVenta;
        this.fechaVenta = fechaVenta;
        this.vendedor = vendedor;
    }

    public Registro(int id, String FechaAlta, String tipo, String operacion, String provincia, int superficie, int percioVenta, String fechaVenta, String vendedor) {
        this.id = id;
        this.FechaAlta = FechaAlta;
        this.tipo = tipo;
        this.operacion = operacion;
        this.provincia = provincia;
        this.superficie = superficie;
        this.percioVenta = percioVenta;
        this.fechaVenta = fechaVenta;
        this.vendedor = vendedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaAlta() {
        return FechaAlta;
    }

    public void setFechaAlta(String FechaAlta) {
        this.FechaAlta = FechaAlta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public int getPercioVenta() {
        return percioVenta;
    }

    public void setPercioVenta(int percioVenta) {
        this.percioVenta = percioVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public String toString() {
        return "Registro{" + "id=" + id + ", FechaAlta=" + FechaAlta + ", tipo=" + tipo + ", operacion=" + operacion + ", provincia=" + provincia + ", superficie=" + superficie + ", percioVenta=" + percioVenta + ", fechaVenta=" + fechaVenta + ", vendedor=" + vendedor + '}';
    }

}
