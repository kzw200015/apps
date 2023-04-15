package cc.jktu.apps.blog.dao.entity;

import cc.jktu.apps.common.dao.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@TableName("article_tag_rel")
public class ArticleTagRelEntity extends BaseEntity {

    private Long articleId;
    private Long tagId;

}
