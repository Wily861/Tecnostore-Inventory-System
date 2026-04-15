-- ================================
-- TABLA: Devolucion
-- ================================
CREATE TABLE Devolucion (
    id_devolucion   INT AUTO_INCREMENT PRIMARY KEY,
    fecha           DATE NOT NULL,
    id_detalle_venta INT,
    cantidad        INT NOT NULL,
    motivo          VARCHAR(255),
    estado          VARCHAR(50),
    FOREIGN KEY (id_detalle_venta) REFERENCES Detalle_Venta(id_detalle)
);

-- ============================================================
-- ✅ Fin del Script 
-- ============================================================
