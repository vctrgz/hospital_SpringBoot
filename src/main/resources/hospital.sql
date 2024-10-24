CREATE DATABASE hospital;
USE hospital;

CREATE TABLE nurse (
    id INT AUTO_INCREMENT PRIMARY KEY,  # ID AUTOINCREMENT PARA EVITAR MANUAL
    name VARCHAR(20) NOT NULL,
    user VARCHAR(20) NOT NULL UNIQUE,	# UNIQUE PARA EVITAR USUARIO REPETIDO
    password VARCHAR(20) NOT NULL,
    CONSTRAINT checkUser CHECK (user LIKE '%_@_%._%')	# CHECK PARA VERIFICAR FORMATOS GUARDADOS
);