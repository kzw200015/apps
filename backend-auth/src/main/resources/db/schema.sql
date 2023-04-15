CREATE TABLE user
(
    id          BIGINT       NOT NULL PRIMARY KEY,
    create_time BIGINT       NOT NULL,
    update_time BIGINT       NOT NULL,
    username    VARCHAR(50)  NOT NULL UNIQUE,
    password    VARCHAR(200) NOT NULL
)