-- ================================
-- TABLA: Entrada_Producto
-- ================================
CREATE TABLE Entrada_Producto (
    id_entrada     INT AUTO_INCREMENT PRIMARY KEY,
    fecha          DATE NOT NULL,
    cantidad       INT NOT NULL,
    detalle_entrada VARCHAR(255),
    id_proveedor   INT,
    FOREIGN KEY (id_proveedor) REFERENCES Proveedor(id_proveedor)
);
