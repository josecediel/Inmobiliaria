package dominio;

public class Registro {
    
    private int id;
    private String tipo;
    private String operation;
    private String provincia;
    private String vendedor;

    public Registro() {
    }

    public Registro(int id) {
        this.id = id;
    }

    public Registro(int id, String tipo, String operation, String provincia, String vendedor) {
        this.id = id;
        this.tipo = tipo;
        this.operation = operation;
        this.provincia = provincia;
        this.vendedor = vendedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public String toString() {
        return "Registro{" + "id=" + id + ", tipo=" + tipo + ", operation=" + operation + ", provincia=" + provincia + ", vendedor=" + vendedor + '}';
    }
    
    
    
}
