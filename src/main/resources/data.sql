
INSERT INTO especialidad (nombre)
VALUES
    ('Cardiologia'),
    ('Pediatria'),
    ('Dermatologia'),
    ('Neurologia'),
    ('Ginecologia');



INSERT INTO ciudad (nombre)
VALUES
    ('Bogota'),
    ('Medellin'),
    ('Cali'),
    ('Barranquilla'),
    ('Cartagena');


INSERT INTO medico (id_usuario, contrasena, email, tipo_usuario, nombre, telefono, ciudad_id_ciudad, imagenUrl)
VALUES
    ('12336', 'contrasena1', 'medico1@example.com', 'MED', 'Dr. Smith', '123456789', 1, "https://res.cloudinary.com/johananube/image/upload/v1699068311/fotoPrueba_dzk3jh.jpg"),
    ('12337', 'contrasena2', 'medico2@example.com', 'MED',  'Dr. Martinez', '987654321', 2, "https://res.cloudinary.com/johananube/image/upload/v1699068311/fotoPrueba_dzk3jh.jpg");



INSERT INTO medico_especialidad (medico_id, especialidad_id)
VALUES
    ('12336', 1),
    ('12336', 2),
    ('12337', 3),
    ('12337', 1),
    ('12336', 2);



INSERT INTO eps (nombre)
VALUES
    ('Sura'),
    ('Coomeva'),
    ('Nueva EPS');
INSERT INTO alergia (nombre)
VALUES
    ('Sura'),
    ('Coomeva'),
    ('Nueva EPS');
INSERT INTO alergia (nombre) VALUES
                                 ('Alergia al polen'),
                                 ('Alergia al maní'),
                                 ('Alergia a los gatos'),
                                 ('Alergia al polvo'),
                                 ('Alergia al marisco'),
                                 ('Alergia a los lácteos');



INSERT INTO medicamento (nombre)
VALUES
    ('Dolex'),
    ('Advil'),
    ('Omeprazol'),
    ('Aspirina');