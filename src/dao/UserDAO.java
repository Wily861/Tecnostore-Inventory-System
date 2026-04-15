package dao;

import modelo.Usuario;
import ConexionBD.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para gestionar operaciones CRUD sobre la entidad Usuario.
 *
 * Autor: Wily Duvan Villamil Rey 
 * Fecha: Agosto 2025
 */
public class UsuarioDAO {

    // 🔒 Conexión inmutable con la base de datos
    private final Connection conn;

    public UsuarioDAO() {
        this.conn = ConexionBD.conectar();
    }

    // Registrar nuevo usuario
    public boolean registrarUsuario(Usuario usuario) {
        final String sql = "INSERT INTO Usuario (nombre, correo, contrasena) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getContrasena());
            stmt.executeUpdate();
            System.out.println("✅ Usuario registrado correctamente.");
            return true;
        } catch (SQLException e) {
            logError("registrarUsuario", e);
            return false;
        }
    }

    // Listar todos los usuarios
    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        final String sql = "SELECT * FROM Usuario";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario u = new Usuario(
                    rs.getInt("idUsuario"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("contrasena")
                );
                lista.add(u);
            }
        } catch (SQLException e) {
            logError("listarUsuarios", e);
        }
        return lista;
    }

    // Buscar usuario por ID
    public Usuario buscarPorId(int idUsuario) {
        final String sql = "SELECT * FROM Usuario WHERE idUsuario = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("contrasena")
                    );
                }
            }
        } catch (SQLException e) {
            logError("buscarPorId", e);
        }
        return null;
    }

    // Buscar usuario por correo
    public Usuario buscarPorCorreo(String correo) {
        final String sql = "SELECT * FROM Usuario WHERE correo = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, correo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("contrasena")
                    );
                }
            }
        } catch (SQLException e) {
            logError("buscarPorCorreo", e);
        }
        return null;
    }

    // Actualizar usuario
    public boolean actualizarUsuario(Usuario usuario) {
        final String sql = "UPDATE Usuario SET nombre = ?, correo = ?, contrasena = ? WHERE idUsuario = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getContrasena());
            stmt.setInt(4, usuario.getIdUsuario());
            stmt.executeUpdate();
            System.out.println("✅ Usuario actualizado correctamente.");
            return true;
        } catch (SQLException e) {
            logError("actualizarUsuario", e);
            return false;
        }
    }

    // Eliminar usuario
    public boolean eliminarUsuario(int idUsuario) {
        final String sql = "DELETE FROM Usuario WHERE idUsuario = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();
            System.out.println("✅ Usuario eliminado correctamente.");
            return true;
        } catch (SQLException e) {
            logError("eliminarUsuario", e);
            return false;
        }
    }

    // 🔒 Cerrar conexión manualmente
    public void cerrarConexion() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("🔒 Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            logError("cerrarConexion", e);
        }
    }

    // Método privado para trazabilidad de errores
    private void logError(String metodo, SQLException e) {
        System.err.println("❌ Error en " + metodo + ": " + e.getMessage());
    }
}
