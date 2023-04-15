package cc.jktu.apps.blog.dao.mapper;

import cc.jktu.apps.blog.dao.entity.ArticleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper extends BaseMapper<ArticleEntity> {

    Page<ArticleEntity> getArticlesPageInUserIds(Page<ArticleEntity> page, @Param("userIds") List<Long> userIds);

    Page<ArticleEntity> getArticlesPage(Page<ArticleEntity> page);

    List<ArticleEntity> getArticleInIds(@Param("ids") List<Long> ids);

}
