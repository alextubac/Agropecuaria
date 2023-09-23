
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class ProductosDao {
Connection con;
Conexion cn = new Conexion();
PreparedStatement ps;
ResultSet rs;
public boolean RegistrarProductos(Productos pro){
    String sql = "INSERT INTO productos (CodigoProducto, NombreProducto,proveedor, PrecioUnitario, CantidadProducto, FechaVencimiento) VALUES (?,?,?,?,?,?)";
    try{
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, pro.getCodigoProducto());
        ps.setString(2, pro.getNombreProducto());
        ps.setString(3, pro.getProveedor());
        ps.setDouble(4, pro.getPrecioUnitario());
        ps.setInt(5, pro.getCantidadProducto());
        ps.setString(6, pro.getFechaVencimiento());
        ps.execute();
        return true;
    }catch (SQLException e){
        System.out.println(e.toString());
        return false;
    }
}

public void ConsultarProveedor(JComboBox proveedor){
    String sql = "SELECT nombre FROM proveedor";
    try{
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()){
            proveedor.addItem(rs.getString("nombre"));
        }
    }catch (SQLException e){
        System.out.println(e.toString());
    }
}

public List ListarProductos() {
        List<Productos> Listapro = new ArrayList();
        String sql = "SELECT * FROM productos";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Productos pro = new Productos();
                pro.setId(rs.getInt("id"));
                pro.setCodigoProducto(rs.getString("CodigoProducto"));
                pro.setNombreProducto(rs.getString("NombreProducto"));
                pro.setProveedor(rs.getString("proveedor"));
                pro.setPrecioUnitario(rs.getDouble("PrecioUnitario"));
                pro.setCantidadProducto(rs.getInt("CantidadProducto"));
                pro.setFechaVencimiento(rs.getString("FechaVencimiento"));
                Listapro.add(pro);
            }
        }catch (SQLException e){
            System.out.println(e.toString());
        }
        return Listapro;
    }

public boolean EliminarProductos(int id){
        String sql = "DELETE FROM productos WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        }catch (SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            }catch (SQLException ex){
                System.out.println(ex.toString());
            }
        }
    }

public boolean ModificarProductos(Productos pro){
        String sql = "UPDATE productos SET CodigoProducto=?, NombreProducto=?, proveedor=?, PrecioUnitario=?, CantidadProducto=?, FechaVencimiento=? WHERE id=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigoProducto());
            ps.setString(2, pro.getNombreProducto());
            ps.setString(3, pro.getProveedor());
            ps.setDouble(4, pro.getPrecioUnitario());
            ps.setInt(5, pro.getCantidadProducto());
            ps.setString(6, pro.getFechaVencimiento());
            ps.setInt(7, pro.getId());
            ps.execute();
            return true;
        }catch (SQLException e){
            System.out.println(e.toString());
            return false;            
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    }

public Productos BuscarPro(String cod){
    Productos producto = new Productos();
    String sql = "SELECT * FROM productos WHERE CodigoProducto = ?";
    try{
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, cod);
        rs = ps.executeQuery();
        if (rs.next()){
            producto.setNombreProducto(rs.getString("NombreProducto"));
            producto.setPrecioUnitario(rs.getDouble("PrecioUnitario"));
            producto.setCantidadProducto(rs.getInt("CantidadProducto"));
        }
        }catch (SQLException e){
                System.out.println(e.toString());
                }
        return producto;
    }    

public Config BuscarDatos(){
    Config conf = new Config();
    String sql = "SELECT * FROM config";
    try{
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        if (rs.next()){
            conf.setId(rs.getInt("id"));
            conf.setRuc(rs.getInt("ruc"));
            conf.setNombre(rs.getString("nombre"));
            conf.setTelefono(rs.getInt("telefono"));
            conf.setDireccion(rs.getString("direccion"));
            conf.setRazon(rs.getString("razon"));
        }
        }catch (SQLException e){
                System.out.println(e.toString());
                }
        return conf;
    }   

public boolean ModificarDatos(Config conf){
        String sql = "UPDATE config SET ruc=?, nombre=?, telefono=?, direccion=?, razon=?  WHERE id=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, conf.getRuc());
            ps.setString(2, conf.getNombre());
            ps.setInt(3, conf.getTelefono());
            ps.setString(4, conf.getDireccion());
            ps.setString(5, conf.getRazon());
            ps.setInt(6, conf.getId());
            ps.execute();
            return true;
        }catch (SQLException e){
            System.out.println(e.toString());
            return false;            
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    }
}



