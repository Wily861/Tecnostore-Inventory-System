-- ================================
-- TABLA: Venta
-- ================================
CREATE TABLE Venta (
    id_venta   INT AUTO_INCREMENT PRIMARY KEY,
    estado     VARCHAR(50) NOT NULL,
    fecha      DATE NOT NULL,
    id_cliente INT,
    id_usuario INT,
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);
