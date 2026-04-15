-- ================================
-- TABLA: Presupuesto
-- ================================
CREATE TABLE Presupuesto (
    id_presupuesto INT AUTO_INCREMENT PRIMARY KEY,
    fecha          DATE NOT NULL,
    validez        DATE,
    total_estimado DECIMAL(12,2),
    id_cliente     INT,
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);
