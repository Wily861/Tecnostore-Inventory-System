-- ================================
-- TABLA: Cliente
-- ================================
CREATE TABLE Cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre     VARCHAR(100) NOT NULL,
    correo     VARCHAR(100) UNIQUE,
    telefono   VARCHAR(20)
);
