DROP TABLE IF EXISTS note;

CREATE TABLE note
(
    id          BIGINT       NOT NULL PRIMARY KEY,
    create_time BIGINT       NOT NULL,
    update_time BIGINT       NOT NULL,
    title       VARCHAR(100) NOT NULL,
    content     TEXT         NOT NULL,
    user_id     BIGINT       NULL,
    INDEX idx_user_id (user_id)
)