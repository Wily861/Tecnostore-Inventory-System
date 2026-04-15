-- ================================
-- TABLA: Producto
-- ================================
CREATE TABLE Producto (
    id_producto    INT AUTO_INCREMENT PRIMARY KEY,
    codigo_interno VARCHAR(50) UNIQUE NOT NULL,
    descripcion    VARCHAR(200),
    marca          VARCHAR(100),
    modelo         VARCHAR(100),
    precio         DECIMAL(10,2) NOT NULL,
    stock          INT DEFAULT 0
);
