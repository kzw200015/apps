package cc.jktu.apps.blog.dao.mapper;

import cc.jktu.apps.blog.dao.entity.TagEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TagMapper extends BaseMapper<TagEntity> {

}
