-- Insertando datos de ejemplo en la tabla especialidad
INSERT INTO especialidad (nombre)
VALUES
    ('Cardiologia'),
    ('Pediatria'),
    ('Dermatologia'),
    ('Neurologia'),
    ('Ginecologia');


-- Insertando datos de ejemplo en la tabla ciudad
INSERT INTO ciudad (nombre)
VALUES
    ('Bogota'),
    ('Medellin'),
    ('Cali'),
    ('Barranquilla'),
    ('Cartagena');

-- Insertando datos de ejemplo en la tabla medico
INSERT INTO medico (id_usuario, contrasenia, email, tipo_usuario, image_byte, nombre, telefono, ciudad_id_ciudad)
VALUES
    ('medico1', 'contrasena1', 'medico1@example.com', 'MED', NULL, 'Dr. Smith', '123456789', 1),
    ('medico2', 'contrasena2', 'medico2@example.com', 'MED', NULL, 'Dr. Martinez', '987654321', 2);


-- Insertando datos de ejemplo en la tabla medico_especialidad
INSERT INTO medico_especialidad (medico_id, especialidad_id)
VALUES
    ('medico1', 1),
    ('medico1', 2),
    ('medico2', 3),
    ('medico2', 1),
    ('medico1', 2);


-- Insertando datos de ejemplo en la tabla especialidad
INSERT INTO eps (nombre)
VALUES
    ('Sura'),
    ('Coomeva'),
    ('Nueva EPS');


-- Insertando datos de ejemplo en la tabla especialidad
INSERT INTO medicamento (nombre)
VALUES
    ('Dolex'),
    ('Advil'),
    ('Omeprazol'),
    ('Aspirina');