DROP TABLE IF EXISTS comment;

CREATE TABLE comment
(
    id          BIGINT      NOT NULL PRIMARY KEY,
    create_time BIGINT      NOT NULL,
    update_time BIGINT      NOT NULL,
    content     TEXT        NOT NULL,
    user_id     BIGINT      NULL,
    username    VARCHAR(50) NULL,
    parent_id   BIGINT      NULL,
    source_id   BIGINT      NOT NULL,
    INDEX idx_user_id (user_id),
    INDEX idx_parent_id (parent_id),
    INDEX idx_source_id (source_id)
)