package controlador;

import dao.UsuarioDAO;
import modelo.Usuario;
import java.util.List;

/**
 * Controlador para gestionar la lógica de negocio relacionada con la entidad Usuario.
 * Actúa como intermediario entre la capa de presentación y la capa de acceso a datos.
 *
 * Cumple con principios SOLID, trazabilidad de datos, modularidad,
 * y estándares de calidad ISO/IEC 25010.
 *
 * Autor: Wily Duvan Villamil Rey 
 * Fecha: Agosto 2025
 */
public class UsuarioControlador {

    // 🔒 Dependencia inmutable al DAO
    private final UsuarioDAO usuarioDAO;

    public UsuarioControlador() {
        this.usuarioDAO = new UsuarioDAO();
    }

    // Registro de nuevo usuario
    public boolean registrarUsuario(String nombre, String correo, String contrasena) {
        Usuario usuario = new Usuario(0, nombre, correo, contrasena);
        return usuarioDAO.registrarUsuario(usuario);
    }

    // Búsqueda por ID
    public Usuario buscarPorId(int idUsuario) {
        return usuarioDAO.buscarPorId(idUsuario);
    }

    // Listado de usuarios
    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listarUsuarios();
    }

    // Actualización de usuario
    public boolean actualizarUsuario(int idUsuario, String nombre, String correo, String contrasena) {
        Usuario usuario = new Usuario(idUsuario, nombre, correo, contrasena);
        return usuarioDAO.actualizarUsuario(usuario);
    }

    // Eliminación de usuario
    public boolean eliminarUsuario(int idUsuario) {
        return usuarioDAO.eliminarUsuario(idUsuario);
    }

    // Cierre de conexión
    public void cerrarConexion() {
        usuarioDAO.cerrarConexion();
    }
}
