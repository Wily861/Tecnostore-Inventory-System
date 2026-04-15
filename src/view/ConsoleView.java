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
