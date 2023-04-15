package cc.jktu.apps.blog.dao.entity;

import cc.jktu.apps.common.dao.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@TableName("tag")
public class TagEntity extends BaseEntity {

    private String name;

}
