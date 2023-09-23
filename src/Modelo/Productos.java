
package Modelo;

public class Productos {

private int id;
private String CodigoProducto;
private String NombreProducto;
private String proveedor;
private double PrecioUnitario;
private int CantidadProducto;
private String FechaVencimiento;

public Productos(){
}

    public Productos(int id, String CodigoProducto, String NombreProducto, String proveedor, double PrecioUnitario, int CantidadProducto, String FechaVencimiento) {
        this.id = id;
        this.CodigoProducto = CodigoProducto;
        this.NombreProducto = NombreProducto;
        this.proveedor = proveedor;
        this.PrecioUnitario = PrecioUnitario;
        this.CantidadProducto = CantidadProducto;
        this.FechaVencimiento = FechaVencimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoProducto() {
        return CodigoProducto;
    }

    public void setCodigoProducto(String CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public double getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(double PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public int getCantidadProducto() {
        return CantidadProducto;
    }

    public void setCantidadProducto(int CantidadProducto) {
        this.CantidadProducto = CantidadProducto;
    }

    public String getFechaVencimiento() {
        return FechaVencimiento;
    }

    public void setFechaVencimiento(String FechaVencimiento) {
        this.FechaVencimiento = FechaVencimiento;
    }
    

}
