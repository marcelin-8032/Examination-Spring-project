INSERT INTO invigilators
VALUES (1000, 'Adrian', 524475, 'BERNARD');
INSERT INTO invigilators
VALUES (1001, 'Maria', 359583, 'PETIT');
INSERT INTO invigilators
VALUES (1002, 'Arthur', 554840, 'THOMAS');

INSERT INTO rooms
VALUES (1180, 1254, 'Science', 4, 442220);
INSERT INTO rooms
VALUES (1181, 1255, 'Literature', 2, 563701);
INSERT INTO rooms
VALUES (1182, 1256, 'Engineering', 10, 607374);

INSERT INTO subjects
VALUES (2200, 164, '2024-04-25T13:22:09.389365700Z', null, '2024-04-25T13:22:09.389365700Z', null, 'MODULE_2',
        'Physics');
INSERT INTO subjects
VALUES (2201, 165, null, null, null, null, 'MODULE_2', 'Chemistry');
INSERT INTO subjects
VALUES (2202, 175, null, null, null, null, 'MODULE_2', 'Computer-Science');
INSERT INTO subjects
VALUES (2203, 190, null, null, null, null, 'MODULE_3', 'Literature');
INSERT INTO subjects
VALUES (2204, 155, null, null, null, null, 'MODULE_3', 'Philosophy');
INSERT INTO subjects
VALUES (2205, 180, null, null, null, null, 'MODULE_1', 'Music');

INSERT INTO students
VALUES (800, '2002-04-25T13:22:09.389365700Z', 'classeA', 'Alex', 45654654, 'BERNARD', 3);
INSERT INTO students
VALUES (801, '2002-05-25T13:22:09.389365700Z', 'classeB', 'Albert', 45654654, 'COHEN', 3);
INSERT INTO students
VALUES (802, '2002-01-25T13:22:09.389365700Z', 'classeC', 'Robert', 536881, 'AUCLAIR', 4);
INSERT INTO students
VALUES (803, '2003-04-25T13:22:09.389365700Z', 'classeB', 'Mickael', 779766, 'BOUCHER', 5);
INSERT INTO students
VALUES (804, '2001-04-25T13:22:09.389365700Z', 'classeA', 'Marcel', 282615, 'BLANCHET', 4);
INSERT INTO students
VALUES (805, '2004-04-25T13:22:09.389365700Z', 'classeC', 'Betty', 947795, 'DUPONT', 5);
INSERT INTO students
VALUES (806, '2003-04-25T13:22:09.389365700Z', 'classeA', 'Maria', 763243, 'LEROY', 5);
INSERT INTO students
VALUES (807, '2002-06-25T13:22:09.389365700Z', 'classeC', 'Natalia', 249093, 'CARTIER', 5);
INSERT INTO students
VALUES (808, '2001-12-25T13:22:09.389365700Z', 'classeC', 'Alexandra', 59464, 'AUBERT', 5);

INSERT INTO exams
VALUES (300, null, null, '2022-01-31 09:00:00', 'Physics Exam', null, null, 1000, 1180, 2200);
INSERT INTO exams
VALUES (301, null, null, '2023-11-13T12:31:50.737847400', 'Chemistry Exam', null, null, 1001, 1180, 2201);
INSERT INTO exams
VALUES (302, null, null, '2023-11-14T12:31:50.737847400', 'Computer-Science', null, null, 1002, 1181, 2202);
INSERT INTO exams
VALUES (303, null, null, '2022-04-15 12:16:44', 'Literature', null, null, 1001, 1181, 2203);
INSERT INTO exams
VALUES (304, null, null, '2022-04-20 12:16:44', 'Philosophy', null, null, 1002, 1182, 2204);
INSERT INTO exams
VALUES (305, null, null, '2022-06-21 12:16:44', 'Music', null, null, 1000, 1182, 2205);

INSERT INTO students_exams
VALUES (800, 300);
INSERT INTO students_exams
VALUES (801, 300);
INSERT INTO students_exams
VALUES (802, 300);
INSERT INTO students_exams
VALUES (803, 300);

INSERT INTO students_exams
VALUES (801, 301);
INSERT INTO students_exams
VALUES (802, 301);
INSERT INTO students_exams
VALUES (803, 301);
INSERT INTO students_exams
VALUES (804, 301);

INSERT INTO students_exams
VALUES (805, 300);
INSERT INTO students_exams
VALUES (805, 301);
INSERT INTO students_exams
VALUES (805, 302);

INSERT INTO students_exams
VALUES (806, 303);
INSERT INTO students_exams
VALUES (807, 303);
INSERT INTO students_exams
VALUES (808, 303);

INSERT INTO students_exams
VALUES (806, 304);
INSERT INTO students_exams
VALUES (807, 304);
INSERT INTO students_exams
VALUES (808, 304);

INSERT INTO students_exams
VALUES (806, 305);
INSERT INTO students_exams
VALUES (807, 305);
INSERT INTO students_exams
VALUES (808, 305);

