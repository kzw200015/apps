DROP TABLE IF EXISTS article_tag_rel;
DROP TABLE IF EXISTS article;
DROP TABLE IF EXISTS tag;

CREATE TABLE article
(
    id          BIGINT       NOT NULL PRIMARY KEY,
    create_time BIGINT       NOT NULL,
    update_time BIGINT       NOT NULL,
    title       VARCHAR(200) NULL,
    content     TEXT         NULL,
    user_id     BIGINT       NOT NULL,
    INDEX idx_user_id (user_id)
);

CREATE TABLE tag
(
    id          BIGINT      NOT NULL PRIMARY KEY,
    create_time BIGINT      NOT NULL,
    update_time BIGINT      NOT NULL,
    name        VARCHAR(50) NOT NULL,
    UNIQUE idx_name (name)
);

CREATE TABLE article_tag_rel
(
    id          BIGINT NOT NULL PRIMARY KEY,
    create_time BIGINT NOT NULL,
    update_time BIGINT NOT NULL,
    article_id  BIGINT NOT NULL,
    tag_id      BIGINT NOT NULL,
    INDEX idx_article_id (article_id),
    INDEX idx_tag_id (tag_id)
);