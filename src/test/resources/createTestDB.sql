CREATE TABLE IF NOT EXISTS author
    (id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS book (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255),
                      author_id BIGINT,
                      FOREIGN KEY (author_id) REFERENCES author(id)
);