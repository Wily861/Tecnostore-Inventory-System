package tecnostore.s.a.s;

import ConexionBD.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TecnoStoreSAS {
    public static void main(String[] args) {
        Connection conn = ConexionBD.conectar();
        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT NOW() as fecha;");
                if (rs.next()) {
                    System.out.println("✅ Conexión OK - Fecha desde MySQL: " + rs.getString("fecha"));
                }
                conn.close();
            } catch (Exception e) {
                System.out.println("❌ Error al ejecutar la consulta.");
                e.printStackTrace();
            }
        } else {
            System.out.println("❌ No se pudo conectar a la base de datos.");
        }
    }
}
