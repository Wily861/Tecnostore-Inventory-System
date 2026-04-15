package modelo;

/**
 * Clase que representa un usuario del sistema TecnoStore S.A.S.
 * Esta clase encapsula los atributos definidos en el modelo lógico relacional
 * y permite su trazabilidad dentro del sistema.
 *
 * Cumple con principios de diseño orientado a objetos, trazabilidad de datos,
 * y se alinea con los estándares de calidad ISO/IEC 25010.
 *
 * Autor: Wily Duvan Villamil Rey
 * Fecha: Agosto 2025
 */
public class Usuario {

    // Atributos según el modelo lógico relacional
    private int idUsuario;       // Clave primaria
    private String nombre;       // Nombre del usuario
    private String correo;       // Correo electrónico
    private String contrasena;   // Contraseña (idealmente encriptada)

    // Constructor vacío
    public Usuario() {}

    // Constructor completo
    public Usuario(int idUsuario, String nombre, String correo, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    // Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // Método toString
    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
