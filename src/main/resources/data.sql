

INSERT INTO especialidad (nombre)
VALUES
    ('Cirugía'),
    ('Pediatría'),
    ('Medicina Interna'),
    ('Ginecología'),
    ('Cardiología'),
    ('Dermatología'),
    ('Oftalmología'),
    ('Ortopedia');



INSERT INTO ciudad (nombre)
VALUES
    ('Bogotá'),
    ('Medellín'),
    ('Cali'),
    ('Barranquilla'),
    ('Cartagena'),
    ('Cúcuta'),
    ('Bucaramanga'),
    ('Pereira'),
    ('Santa Marta'),
    ('Ibagué'),
    ('Pasto'),
    ('Villavicencio'),
    ('Manizales'),
    ('Neiva'),
    ('Armenia'),
    ('Valledupar'),
    ('Montería'),
    ('Sincelejo'),
    ('Popayán'),
    ('Tunja'),
    ('Riohacha'),
    ('Quibdó'),
    ('Arauca'),
    ('Yopal'),
    ('Mocoa'),
    ('San José del Guaviare'),
    ('Puerto Carreño'),
    ('Mitú'),
    ('Leticia');

INSERT INTO medico (id_usuario, contrasena, email, tipo_usuario, nombre, telefono, ciudad_id_ciudad, imagen_url)
VALUES
    (1221, 'contrasena1', 'medico1@example.com', 'MED', 'Médico 1', '123-456-7891', 1, 'https://res.cloudinary.com/johananube/image/upload/v1699411105/3e435f79e723b003a2b3c042fed9498f_ccoyec.jpg'),
    (1222, 'contrasena2', 'medico2@example.com', 'MED', 'Médico 2', '123-456-7892', 2, 'https://res.cloudinary.com/johananube/image/upload/v1699411105/53bd748671518d88dc35fdbc76dd501c_jla3qw.jpg'),
    (1223, 'contrasena3', 'medico3@example.com', 'MED', 'Médico 3', '123-456-7893', 3, 'https://res.cloudinary.com/johananube/image/upload/v1699411106/fotoPrueba_zreobo.jpg'),
    (1224, 'contrasena4', 'medico4@example.com', 'MED', 'Médico 4', '123-456-7894', 4, 'https://res.cloudinary.com/johananube/image/upload/v1699411230/images_nr0tg1.jpg'),
    (1225, 'contrasena5', 'medico5@example.com', 'MED', 'Médico 5', '123-456-7895', 5, 'https://res.cloudinary.com/johananube/image/upload/v1699411247/istockphoto-166373407-170667a_wq3jxp.jpg'),
    (1226, 'contrasena6', 'medico6@example.com', 'MED', 'Médico 6', '123-456-7896', 1, 'https://res.cloudinary.com/johananube/image/upload/v1699411106/d30a720a-31e6-4cb8-97e3-60fd21c18a61_ue1lpy.jpg');


INSERT INTO medico_especialidad (medico_id, especialidad_id)
VALUES
    (1221, 1),
    (1221, 2),
    (1222, 3),
    (1222, 1),
    (1223, 2),
    (1224, 6),
    (1224, 2),
    (1225, 4),
    (1225, 5),
    (1226, 8),
    (1226, 7);

INSERT INTO eps (nombre)
VALUES
    ('Sura'),
    ('Coomeva'),
    ('Nueva EPS');
;
INSERT INTO alergia (nombre) VALUES
                                 ('Alergia al polen'),
                                 ('Alergia al maní'),
                                 ('Alergia a los gatos'),
                                 ('Alergia al polvo'),
                                 ('Alergia al marisco'),
                                 ('Alergia a los lácteos');

INSERT INTO disponibilidad (fecha, hora, medico_id_usuario)
VALUES
    ('2023-11-07', '08:00 AM', 1221),
    ('2023-11-07', '09:00 AM', 1221),
    ('2023-11-08', '10:00 AM', 1221),
    ('2023-11-08', '11:00 AM', 1221),
    ('2023-11-09', '02:00 PM', 1221),
    ('2023-11-09', '03:00 PM', 1221);


INSERT INTO disponibilidad (fecha, hora, medico_id_usuario)
VALUES
    ('2023-11-07', '08:00 AM', 1222),
    ('2023-11-07', '09:00 AM', 1222),
    ('2023-11-08', '10:00 AM', 1222),
    ('2023-11-08', '11:00 AM', 1222),
    ('2023-11-09', '02:00 PM', 1222),
    ('2023-11-09', '03:00 PM', 1222);


INSERT INTO disponibilidad (fecha, hora, medico_id_usuario)
VALUES
    ('2023-11-07', '08:00 AM', 1223),
    ('2023-11-07', '09:00 AM', 1223),
    ('2023-11-08', '10:00 AM', 1223),
    ('2023-11-08', '11:00 AM', 1223),
    ('2023-11-09', '02:00 PM', 1223),
    ('2023-11-09', '03:00 PM', 1223);

-- Médico 4
INSERT INTO disponibilidad (fecha, hora, medico_id_usuario)
VALUES
    ('2023-11-07', '08:00 AM', 1224),
    ('2023-11-07', '09:00 AM', 1224),
    ('2023-11-08', '10:00 AM', 1224),
    ('2023-11-08', '11:00 AM', 1224),
    ('2023-11-09', '02:00 PM', 1224),
    ('2023-11-09', '03:00 PM', 1224);

INSERT INTO disponibilidad (fecha, hora, medico_id_usuario)
VALUES
    ('2023-11-07', '08:00 AM', 1225),
    ('2023-11-07', '09:00 AM', 1225),
    ('2023-11-08', '10:00 AM', 1225),
    ('2023-11-08', '11:00 AM', 1225),
    ('2023-11-09', '02:00 PM', 1225),
    ('2023-11-09', '03:00 PM', 1225);

INSERT INTO disponibilidad (fecha, hora, medico_id_usuario)
VALUES
    ('2023-11-07', '08:00 AM', 1226),
    ('2023-11-07', '09:00 AM', 1226),
    ('2023-11-08', '10:00 AM', 1226),
    ('2023-11-08', '11:00 AM', 1226),
    ('2023-11-09', '02:00 PM', 1226),
    ('2023-11-09', '03:00 PM', 1226);



INSERT INTO medicamento (nombre)
VALUES
    ('Dolex'),
    ('Advil'),
    ('Omeprazol'),
    ('Aspirina');