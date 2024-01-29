CREATE TABLE IF NOT EXISTS author (id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS book (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255),
                      author_id BIGINT,
                      FOREIGN KEY (author_id) REFERENCES author(id)
);

INSERT INTO author (name) VALUES ('Лев Толстой');
INSERT INTO author (name) VALUES ('Фёдор Достоевский');

INSERT INTO book (title, author_id) VALUES ('Война и мир', 1);
INSERT INTO book (title, author_id) VALUES ('Анна Каренина', 1);
INSERT INTO book (title, author_id) VALUES ('Преступление и наказание', 2);
INSERT INTO book (title, author_id) VALUES ('Идиот', 2);
