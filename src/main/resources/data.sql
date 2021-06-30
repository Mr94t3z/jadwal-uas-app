CREATE TABLE IF NOT EXISTS Jadwal(id IDENTITY PRIMARY KEY, done BOOLEAN, text VARCHAR(255));
DELETE FROM Jadwal;
INSERT INTO Jadwal VALUES(1, true, 'Praktikum Pemrograman Berorientasi Objek');
INSERT INTO Jadwal VALUES(2, true, 'Rekayasa Perangkat Lunak');
INSERT INTO Jadwal VALUES(3, false, 'Basis Data');
