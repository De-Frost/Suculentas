-- CREADO POR ERICK FLORES MUÑOZ

DROP DATABASE IF EXISTS practica;
CREATE DATABASE practica CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE practica;

-- TABLA SUCULUENTA
CREATE TABLE suculenta (
id_suculenta INT AUTO_INCREMENT PRIMARY KEY,
nombre_comun VARCHAR(50) NOT NULL,
nombre_cientifico VARCHAR(80)    NOT NULL,
familia VARCHAR(50) NOT NULL,
color_principal VARCHAR(30) NOT NULL,
altura_cm DECIMAL(5,2) NOT NULL,
precio_estimado DECIMAL(8,2) NOT NULL,
nivel_riego VARCHAR(20) NOT NULL,
ruta_imagen VARCHAR(500)
);

-- CREACION DE USUARIO Y CONTRASEÑA
CREATE USER IF NOT EXISTS "usuario_practica"@"%" IDENTIFIED BY "la_Clave";
GRANT ALL PRIVILEGES ON practica.* TO "usuario_practica"@"%";
FLUSH PRIVILEGES;

-- DATOS
INSERT INTO suculenta (nombre_comun, nombre_cientifico, familia, color_principal, altura_cm, precio_estimado, nivel_riego, ruta_imagen) VALUES
("Rosa de alabastro", "Echeveria elegans", "Crassulaceae", "Verde azulado", 15.00, 2500.00, "Bajo", "https://estaticos-cdn.prensaiberica.es/clip/d917aa50-e697-4a33-9fee-bbb96bb58968_16-9-aspect-ratio_default_0.webp"),
("Cola de burro", "Sedum morganianum", "Crassulaceae", "Verde azulado", 30.00,	3500.00,	"Bajo", "https://macetitas.es/wp-content/uploads/2025/10/sedum-burrito-maceta-3d.webp"),
("Planta fantasma",	"Graptopetalum paraguayense ", "Crassulaceae", "Gris azulado", 20.00, 2500.00, "Bajo", "https://upload.wikimedia.org/wikipedia/commons/5/59/%28MHNT%29_Graptopetalum_paraguayense_-_leaves.jpg"),
("Planta panda", "Kalanchoe tomentosa", "Crassulaceae",	"Verde grisaceo", 30.00, 3000.00, "Bajo", "https://cdn.monstera-app.com/p/96a730ed70e092115e19900116256eaf5cad78f259809128fbafab3488d96955.jpg/planta-panda-de-plumon-blanco.webp"),
("Aloe vera", "Aloe vera", "Asphodelaceae", "Verde grisaceo", 50.00, 3000.00, "Bajo", "https://www.healthyhouseplants.com/wp-content/uploads/2024/08/Aloe_Vera.jpg");

-- VERIFICAR
SELECT * FROM suculenta;