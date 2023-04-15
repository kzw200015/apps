package cc.jktu.apps.blog.controller.req;

import cc.jktu.apps.blog.dao.entity.TagEntity;
import lombok.Data;

import java.util.List;

@Data
public class ArticleAddReq {

    private String title;
    private String content;
    private Long userId;
    private List<String> tags;

}
