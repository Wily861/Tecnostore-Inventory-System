-- ================================
-- TABLA: Detalle_Venta
-- ================================
CREATE TABLE Detalle_Venta (
    id_detalle     INT AUTO_INCREMENT PRIMARY KEY,
    cantidad       INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    id_venta       INT,
    id_producto    INT,
    FOREIGN KEY (id_venta) REFERENCES Venta(id_venta),
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
);
