-- ================================
-- TABLA: Proveedor
-- ================================
CREATE TABLE Proveedor (
    id_proveedor INT AUTO_INCREMENT PRIMARY KEY,
    nombre       VARCHAR(100) NOT NULL,
    contacto     VARCHAR(100),
    direccion    VARCHAR(150)
);
