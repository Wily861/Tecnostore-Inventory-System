# 🛒 TecnoStore S.A.S – Enterprise Inventory Engine

> **ERP Solution:** Sistema integral de gestión de recursos empresariales diseñado para la optimización de inventarios, ventas y logística, bajo estándares internacionales de calidad de software e ingeniería robusta.

---

### 🏆 Ingeniería de Calidad & Arquitectura

* **Patrón de Diseño MVC:** Implementación de arquitectura Modelo-Vista-Controlador para el desacoplamiento total entre la lógica de negocio, el modelo de datos y la interfaz de usuario.
  
* **Cumplimiento ISO/IEC 25010:** Desarrollo alineado a métricas internacionales de mantenibilidad, fiabilidad y eficiencia de desempeño.
  
* **Principios SOLID:** Código diseñado bajo principios de responsabilidad única y extensibilidad, facilitando la integración de módulos como Facturación Electrónica.
  
* **Análisis Estático de Código:** Garantía de calidad mediante el uso de **PMD 7.16.0**, asegurando un código limpio y libre de deuda técnica.

---

## 🛠️ Stack Tecnológico

| Lenguaje / IDE | Persistencia | Arquitectura | Estándares / Calidad |
| :---: | :---: | :---: | :---: |
| **Java 8+ & NetBeans** | **MySQL 5.7+** | **MVC & SOLID** | **ISO 25010 / UML** |
| <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="Java" width="50" height="50"/> | <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original.svg" alt="MySQL" width="50" height="50"/> | <img src="https://img.shields.io/badge/MVC-Architecture-orange?style=for-the-badge&logo=codeproject&logoColor=white" alt="MVC" height="40"/> | <img src="https://img.shields.io/badge/ISO-25010-green?style=for-the-badge&logo=checkmarx&logoColor=white" alt="ISO" height="40"/> |

---

## 📂 Modelado y Diseño de Sistemas
La robustez de TecnoStore se fundamenta en un diseño técnico riguroso documentado mediante **UML**:
* **Diagramas de Clase:** Estructura de entidades y relaciones lógicas.
* **Modelo Lógico-Relacional:** Esquema de base de datos optimizado para integridad referencial y alto tráfico.
* **Trazabilidad de Requisitos:** Alineación directa entre el diseño UML y la implementación final del sistema.

---

## 🚀 Funcionalidades de Alto Impacto
* 📦 **Smart Inventory:** Algoritmos de alerta de stock mínimo, control de entradas/salidas y generación de etiquetas de barras.
* 🧾 **Módulo Transaccional:** Gestión de ventas, presupuestos configurables y devoluciones con sincronización automática de inventario.
* 📊 **Business Intelligence:** Reportes de rotación de stock, análisis de productos más vendidos y proyecciones de demanda estratégica.
* 🔐 **Seguridad RBAC:** Control de acceso basado en roles (Gerente/Vendedor) con trazabilidad completa de operaciones.

---

## 📊 Especificaciones de Rendimiento (QA)
* **Eficiencia:** Tiempo de respuesta en consultas de inventario < **2 segundos**.
* **Escalabilidad:** Arquitectura preparada para gestionar hasta **50,000 productos**.
* **Mantenibilidad:** Cobertura de documentación técnica y comentarios en código > **80%**.
* **Fiabilidad:** Respaldos automáticos y trazabilidad de operaciones para auditoría interna.
---
### 👤 Autor

* **LinkedIn:** [linkedin.com/in/wily-rey-dba](https://www.linkedin.com/in/wily-rey-dba)
* **Email:** [willyvillamil861@gmail.com](mailto:willyvillamil861@gmail.com)
---



## 1. 🔌 Conexión a la Base de Datos

El sistema incluye una clase dedicada para la **conexión a MySQL** mediante JDBC.  
Esto centraliza la configuración y permite mantener el código modular y reutilizable.

### Clase `ConexionBD.java`:

```java
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
```

---
## 2. 📂 Clase Modelo – Entidad Usuario

El **modelo** representa las entidades del sistema y mantiene la trazabilidad con el modelo lógico–relacional definido en la base de datos.  
En este caso, la clase `Usuario` encapsula los atributos y comportamientos asociados a los usuarios del sistema:

```java
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
```

---
## 3. 📂  DAO – Acceso a Datos (CRUD de Usuario)

El sistema implementa el patrón **DAO (Data Access Object)** para aislar la lógica de acceso a datos de la lógica de negocio, promoviendo **modularidad, mantenibilidad** y cumpliendo con estándares de calidad **ISO/IEC 25010**.

A continuación, la clase **UsuarioDAO** encargada de la gestión CRUD:

```java
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
```

---

## 4. 📂 Clase Controlador 

El proyecto implementa la arquitectura **Modelo – Vista – Controlador (MVC)**, lo que permite **separar responsabilidades**, mejorar la **mantenibilidad** y garantizar la **escalabilidad** del sistema.

```java
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
```

---
## 5. 🖥️ Vista – Interfaz por Consola

El sistema incluye una **vista por consola** que permite interactuar con el módulo **Detalle de Usuario**.  
Se pueden registrar, listar y consultar usuarios de manera sencilla, aplicando validaciones y estándares de calidad.

### La clase `VistaDetalleUsuarioConsola.java`:

```java
package vista;

import controlador.UsuarioControlador;
import modelo.Usuario;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Vista por consola para el módulo Detalle de Usuario del sistema TecnoStore S.A.S.
 * Permite registrar, listar y consultar usuarios del sistema.
 *
 * Aplica principios SOLID, trazabilidad, validación de entrada y estándares ISO/IEC 25010.
 *
 * Autor: Wily Duvan Villamil Rey 
 * Fecha: Agosto 2025
 */
public class VistaDetalleUsuarioConsola {

    public static final Scanner scanner = new Scanner(System.in);
    public static final UsuarioControlador controlador = new UsuarioControlador();

    public static void main(String[] args) {
        mostrarMenu();
        controlador.cerrarConexion();
    }

    public static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== Módulo Detalle de Usuario ===");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Listar todos los usuarios");
            System.out.println("3. Buscar usuario por ID");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                switch (opcion) {
                    case 1 -> registrarUsuario();
                    case 2 -> listarUsuarios();
                    case 3 -> buscarPorId();
                    case 0 -> System.out.println("🔚 Saliendo del módulo...");
                    default -> System.out.println("⚠️ Opción inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Entrada no válida. Ingrese un número.");
                scanner.nextLine();
                opcion = -1;
            }
        } while (opcion != 0);
    }

    // Registro de usuario
    public static void registrarUsuario() {
        try {
            System.out.println("\n--- Registro de Usuario ---");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Correo electrónico: ");
            String correo = scanner.nextLine();

            System.out.print("Contraseña: ");
            String contrasena = scanner.nextLine();

            boolean exito = controlador.registrarUsuario(nombre, correo, contrasena);
            System.out.println(exito ? "✅ Usuario registrado exitosamente." : "❌ Error al registrar el usuario.");
        } catch (InputMismatchException e) {
            System.out.println("⚠️ Entrada inválida. Verifique los datos.");
            scanner.nextLine();
        }
    }

    // Listado de usuarios
    public static void listarUsuarios() {
        System.out.println("\n--- Listado de Usuarios ---");
        List<Usuario> lista = controlador.listarUsuarios();
        if (lista.isEmpty()) {
            System.out.println("📭 No hay usuarios registrados.");
        } else {
            for (Usuario u : lista) {
                System.out.println(u.toString());
            }
        }
    }

    // Búsqueda por ID
    public static void buscarPorId() {
        try {
            System.out.print("\nIngrese el ID del usuario a buscar: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Usuario usuario = controlador.buscarPorId(id);
            if (usuario != null) {
                System.out.println("🔍 Usuario encontrado:");
                System.out.println(usuario.toString());
            } else {
                System.out.println("❌ No se encontró ningún usuario con ese ID.");
            }
        } catch (InputMismatchException e) {
            System.out.println("⚠️ Entrada inválida.");
            scanner.nextLine();
        }
    }
}
```
---
## 6. ▶️ Clase Principal `TecnoStoreSAS`

La clase `TecnoStoreSAS` es el **punto de arranque del sistema**, encargada de:  
- Establecer la conexión con la base de datos MySQL mediante `ConexionBD`.  
- Ejecutar una consulta simple (`SELECT NOW()`) para verificar conectividad.  
- Mostrar en consola la fecha/hora actual obtenida desde MySQL como prueba de funcionamiento.  

### Ejemplo de código:

```java
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
```
---
