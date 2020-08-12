package datos;

import dominio.Registro;
import java.sql.*;
import java.util.*;

public class RegistroDaoJDBC {

    private static final String SQL_SELECT = "SELECT id, tipo, operation, provincia, vendedor "
            + " FROM ventas";

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
                String tipo = rs.getString("tipo");
                String operation = rs.getString("operation");
                String provincia = rs.getString("provincia");
                String vendedor = rs.getString("vendedor");

                registro = new Registro(id, tipo, operation, provincia, vendedor);
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

}
