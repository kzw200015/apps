package cc.jktu.apps.comment.dao.entity;

import cc.jktu.apps.common.dao.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@TableName("comment")
public class CommentEntity extends BaseEntity {

    private String content;
    private Long userId;
    private String username;
    private Long parentId;
    private Long sourceId;

}
