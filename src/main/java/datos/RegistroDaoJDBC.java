package datos;

import dominio.Registro;
import java.sql.*;
import java.util.*;

public class RegistroDaoJDBC {

    private static final String SQL_SELECT = "SELECT id, fechaAlta, tipo, operación, provincia, superficie, precio_venta, fecha_venta, vendedor "
            + " FROM ventas";

    private static final String SQL_SELECT_BY_ID = "SELECT id, fechaAlta, tipo, operacion, provincia, superficie, precio_venta, fecha_venta, vendedor "
            + " FROM cliente WHERE id_cliente = ?";

    private static final String SQL_INSERT = "INSERT INTO registro(id, fechaAlta, tipo, operación, provincia, superficie, precio_venta, fecha_venta, vendedor) "
            + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE registros "
            + " SET id=?, fechaAlta=?, tipo=?, operación=?, provincia=?, superficie=?, precio_venta=?, fecha_venta=?, vendedor=? WHERE id=?";

    private static final String SQL_DELETE = "DELETE FROM ventas WHERE id = ?";

    public List<Registro> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Registro registro = null;
        List<Registro> registros = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String fechaAlta = rs.getString("fecha_alta");
                String tipo = rs.getString("tipo");
                String operacion = rs.getString("operacion");
                String provincia = rs.getString("provincia");
                int superficie = rs.getInt("superficie");
                int precioVenta = rs.getInt("precio_venta");
                String fechaVenta = rs.getString("fecha_venta");
                String vendedor = rs.getString("vendedor");

                registro = new Registro(id, fechaAlta, tipo,
                        operacion, provincia, superficie, precioVenta, fechaVenta, vendedor);
                registros.add(registro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return registros;
    }

    public Registro encontrar(Registro registro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, registro.getId());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            String fechaAlta = rs.getString("fecha_alta");
            String tipo = rs.getString("tipo");
            String operacion = rs.getString("operacion");
            String provincia = rs.getString("provincia");
            int superficie = rs.getInt("superficie");
            int precioVenta = rs.getInt("precio_venta");
            String fechaVenta = rs.getString("fecha_venta");
            String vendedor = rs.getString("vendedor");

            registro.setFechaAlta(fechaAlta);
            registro.setTipo(tipo);
            registro.setOperacion(operacion);
            registro.setProvincia(provincia);
            registro.setSuperficie(superficie);
            registro.setPercioVenta(precioVenta);
            registro.setFechaVenta(fechaVenta);
            registro.setVendedor(vendedor);
            
            

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return registro;
    }

    public int insertar(Registro registro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, registro.getFechaAlta());
            stmt.setString(2, registro.getTipo());
            stmt.setString(3, registro.getOperacion());
            stmt.setString(4, registro.getProvincia());
            stmt.setInt(5, registro.getSuperficie());
            stmt.setInt(6, registro.getPercioVenta());
            stmt.setString(7, registro.getFechaVenta());
            stmt.setString(8, registro.getVendedor());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Registro registro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, registro.getFechaAlta());
            stmt.setString(2, registro.getTipo());
            stmt.setString(3, registro.getOperacion());
            stmt.setString(4, registro.getProvincia());
            stmt.setInt(5, registro.getSuperficie());
            stmt.setInt(6, registro.getPercioVenta());
            stmt.setString(7, registro.getFechaVenta());
            stmt.setString(8, registro.getVendedor());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Registro registro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, registro.getId());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

}
