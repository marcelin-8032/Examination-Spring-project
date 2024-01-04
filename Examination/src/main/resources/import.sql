INSERT INTO invigilators  VALUES(1000, 'Adrian');
INSERT INTO invigilators  VALUES(1001, 'Maria');
INSERT INTO invigilators  VALUES(1002, 'Arthur');

INSERT INTO rooms VALUES(1180,1254);
INSERT INTO rooms VALUES(1181,1255);
INSERT INTO rooms VALUES(1182,1256);

INSERT INTO subjects VALUES(2200, 164, 'MODULE_2','Physics');
INSERT INTO subjects VALUES(2201, 165, 'MODULE_2','Chemistry');
INSERT INTO subjects VALUES(2202, 175, 'MODULE_2','Computer-Science');
INSERT INTO subjects VALUES(2203, 190, 'MODULE_3','Literature');
INSERT INTO subjects VALUES(2204, 155, 'MODULE_3','Philosophy');
INSERT INTO subjects VALUES(2205, 180, 'MODULE_1','Music');

INSERT INTO students VALUES(800,'classeA','Alex');
INSERT INTO students VALUES(801,'classeB','Albert');
INSERT INTO students VALUES(802,'classeC','Robert');
INSERT INTO students VALUES(803,'classeB','Mickael');
INSERT INTO students VALUES(804,'classeA','Marcel');
INSERT INTO students VALUES(805,'classeC','Betty');
INSERT INTO students VALUES(806,'classeA','Maria');
INSERT INTO students VALUES(807,'classeC','Natalia');
INSERT INTO students VALUES(808,'classeC','Alexandra');

INSERT INTO exams VALUES(300, '2022-01-31 09:00:00', 'Physics Exam',1000,1180,2200);
INSERT INTO exams VALUES(301,'2023-11-13T12:31:50.737847400','Chemistry Exam',1001,1180,2201);
INSERT INTO exams VALUES(302,'2023-11-14T12:31:50.737847400','Computer-Science',1002,1181,2202);
INSERT INTO exams VALUES(303,'2022-04-15 12:16:44','Literature',1001,1181,2203);
INSERT INTO exams VALUES(304,'2022-04-20 12:16:44','Philosophy',1002,1182,2204);
INSERT INTO exams VALUES(305,'2022-06-21 12:16:44','Music',1000,1182,2205);

INSERT INTO students_exams VALUES (800, 300);
INSERT INTO students_exams VALUES (801, 300);
INSERT INTO students_exams VALUES (802, 300);
INSERT INTO students_exams VALUES (803, 300);

INSERT INTO students_exams VALUES (801, 301);
INSERT INTO students_exams VALUES (802, 301);
INSERT INTO students_exams VALUES (803, 301);
INSERT INTO students_exams VALUES (804, 301);

INSERT INTO students_exams VALUES (805, 300);
INSERT INTO students_exams VALUES (805, 301);
INSERT INTO students_exams VALUES (805, 302);

INSERT INTO students_exams VALUES (806, 303);
INSERT INTO students_exams VALUES (807, 303);
INSERT INTO students_exams VALUES (808, 303);

INSERT INTO students_exams VALUES (806, 304);
INSERT INTO students_exams VALUES (807, 304);
INSERT INTO students_exams VALUES (808, 304);

INSERT INTO students_exams VALUES (806, 305);
INSERT INTO students_exams VALUES (807, 305);
INSERT INTO students_exams VALUES (808, 305);

