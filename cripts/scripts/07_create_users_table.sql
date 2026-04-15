-- ================================
-- TABLA: Usuario
-- ================================
CREATE TABLE Usuario (
    id_usuario  INT AUTO_INCREMENT PRIMARY KEY,
    nombre      VARCHAR(100) NOT NULL,
    correo      VARCHAR(100) UNIQUE NOT NULL,
    contrasena  VARCHAR(255) NOT NULL
);
