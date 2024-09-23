CREATE DATABASE test DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

use test;


CREATE TABLE user (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(20) NOT NULL,
                      age INT NOT NULL,
                      email VARCHAR(20) NOT NULL,
                      created_at TIMESTAMP NOT NULL DEFAULT '2024-01-01 00:00:00'
);

INSERT INTO user(name, age, email, created_at) VALUES
                                                   ('Larry', 18, 'larry@larry.com', now()),
                                                   ('Jacky', 28, 'jacky@jacky.com', now()),
                                                   ('Lucy', 20, 'lucy@lucy.com', now());