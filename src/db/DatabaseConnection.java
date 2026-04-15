/**
*El sistema incluye una clase dedicada a la conexión a MySQL mediante JDBC.
*Esto centraliza la configuración y permite mantener el código modular y reutilizable.
*/

package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de establecer la conexión con la base de datos MySQL
 * para el sistema TecnoStore S.A.S.
 *
 * Esta implementación sigue principios de modularidad y reutilización,
 * permitiendo centralizar la lógica de conexión y facilitar el mantenimiento.
 *
 * Autor: Wily Duvan Villamil Rey 
 * Fecha: Agosto 2025
 */

public class ConexionBD {

    // ================================
    // 🔧 Parámetros de configuración
    // ================================
    private static final String URL = "jdbc:mysql://localhost:3306/tecnostore"
                                    + "?useSSL=false"
                                    + "&allowPublicKeyRetrieval=true"
                                    + "&serverTimezone=UTC";
    private static final String USER = "Usuario de Conexion Base de Datos";
    private static final String PASSWORD = "Contraseña de Acceso";

    // ============================================
    // 🔌 Método para establecer la conexión JDBC
    // ============================================
    public static Connection conectar() {
        Connection conexion = null;

        try {
            // Cargar el driver JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Intentar establecer la conexión
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión exitosa a la base de datos.");

        } catch (ClassNotFoundException e) {
            System.out.println("❌ Error: No se encontró el driver JDBC de MySQL.");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("❌ Error al conectar a la base de datos.");
            System.out.println("📌 Verifica que el servidor esté activo y que las credenciales sean correctas.");
            e.printStackTrace();
        }

        return conexion;
    }
}
