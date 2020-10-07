CREATE TABLE alumno(
	dni char(9),
    nombre varchar(30),
    apellido varchar(30),
    PRIMARY KEY (dni)
);

CREATE TABLE asignatura(
	cod_asig char(3),
    nom_asig varchar(30),
    PRIMARY KEY (cod_asig)
);

CREATE TABLE matricula(
	dni char(9),
    cod_asig char(3),
    FOREIGN KEY (dni) REFERENCES alumn(dni),
    FOREIGN KEY (cod_asig) REFERENCES asig(cod_asig),
    PRIMARY KEY (dni, cod_asig)
);

INSERT INTO alumno VALUES ("14896785f", "Pablo", "Moreno");
INSERT INTO alumno VALUES ("18950068g", "Jesus", "Ventana");
INSERT INTO alumno VALUES ("25615414s", "Arturo", "Lopez");

INSERT INTO asignatura VALUES ("BDI" , "Base de datos");
INSERT INTO asignatura VALUES ("PRO", "Programacion");
INSERT INTO asignatura VALUES ("ENT", "Entornos de desarrollo");

INSERT INTO matricula VALUES ("14896785f", "BDI");
INSERT INTO matricula VALUES ("25615414s", "BDI");
INSERT INTO matricula VALUES ("14896785f", "ENT");
INSERT INTO matricula VALUES ("14896785f", "PRO");
