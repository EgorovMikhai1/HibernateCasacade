CREATE TABLE IF NOT EXISTS author (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS book (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    author_id INT,
    FOREIGN KEY (author_id) REFERENCES author(id)
);

INSERT INTO author (id, name) VALUES (1, 'Лев Толстой');
INSERT INTO author (id, name) VALUES(2, 'Федор Достоевский');

INSERT INTO book (id, title, author_id) VALUES (1, 'Война и мир', 1);
INSERT INTO book (id, title, author_id) VALUES(2, 'Преступление и наказание', 2);