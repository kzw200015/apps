package cc.jktu.apps.blog.dao.entity;

import cc.jktu.apps.common.dao.entity.BaseEntity;
import cc.jktu.apps.common.dao.entity.UserEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@TableName("article")
public class ArticleEntity extends BaseEntity {

    private String title;
    private String content;
    @JsonIgnore
    private Long userId;
    @TableField(exist = false)
    private UserEntity user;
    @TableField(exist = false)
    private List<String> tags;

}
