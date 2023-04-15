package cc.jktu.apps.blog.service;

import cc.jktu.apps.blog.controller.req.ArticleAddReq;
import cc.jktu.apps.blog.dao.entity.ArticleEntity;
import cc.jktu.apps.blog.dao.entity.ArticleTagRelEntity;
import cc.jktu.apps.blog.dao.entity.TagEntity;
import cc.jktu.apps.blog.dao.mapper.ArticleMapper;
import cc.jktu.apps.blog.dao.mapper.ArticleTagRelMapper;
import cc.jktu.apps.blog.dao.mapper.TagMapper;
import cc.jktu.apps.blog.service.rpc.AuthUserRpcService;
import cc.jktu.apps.common.PageWrapper;
import cc.jktu.apps.common.exception.BadRequestException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleMapper articleMapper;
    private final AuthUserRpcService authUserRpcService;
    private final TagMapper tagMapper;
    private final ArticleTagRelMapper articleTagRelMapper;

    public PageWrapper<ArticleEntity> getArticlesPageInUserIds(List<Long> userIds, Long pageNum, Long pageSize) {
        if (userIds.isEmpty()) {
            throw new BadRequestException("用户ID不能为空");
        }
        final PageWrapper<ArticleEntity> pageWrapper = PageWrapper.of(articleMapper.getArticlesPageInUserIds(new Page<>(pageNum, pageSize), userIds));
        pageWrapper.items().forEach(it -> it.setUser(authUserRpcService.getById(it.getUserId()).data()));
        return pageWrapper;
    }

    public PageWrapper<ArticleEntity> getArticlesPageByUserId(Long userId, Long pageNum, Long pageSize) {
        return getArticlesPageInUserIds(List.of(userId), pageNum, pageSize);
    }

    public PageWrapper<ArticleEntity> getArticlesPage(Long pageNum, Long pageSize) {
        final PageWrapper<ArticleEntity> pageWrapper = PageWrapper.of(articleMapper.getArticlesPage(new Page<>(pageNum, pageSize)));
        pageWrapper.items().parallelStream().forEach(it -> it.setUser(authUserRpcService.getById(it.getUserId()).data()));
        return pageWrapper;
    }

    public List<ArticleEntity> getArticleInIds(List<Long> ids) {
        final List<ArticleEntity> articles = articleMapper.getArticleInIds(ids);
        articles.parallelStream().forEach(it -> it.setUser(authUserRpcService.getById(it.getUserId()).data()));
        return articles;
    }

    public ArticleEntity getArticleById(Long id) {
        final List<ArticleEntity> articles = getArticleInIds(List.of(id));
        if (articles.isEmpty()) {
            return null;
        }

        return articles.get(0);
    }

    @Transactional
    public void addOneArticle(ArticleAddReq req) {
        final ArticleEntity article = new ArticleEntity();
        article.setTitle(req.getTitle());
        article.setContent(req.getContent());
        article.setUserId(req.getUserId());
        articleMapper.insert(article);
        updateArticleTagRel(article.getId(), req.getTags());
    }

    @Transactional
    protected void updateArticleTagRel(Long articleId, List<String> tagNames) {
        articleTagRelMapper.delete(new LambdaQueryWrapper<ArticleTagRelEntity>().eq(ArticleTagRelEntity::getArticleId, articleId));
        tagNames.forEach(tagName -> {
            final TagEntity tag = tagMapper.selectOne(new LambdaQueryWrapper<TagEntity>().eq(TagEntity::getName, tagName));
            Long tagId;
            if (tag == null) {
                final TagEntity newTag = new TagEntity();
                newTag.setName(tagName);
                tagMapper.insert(newTag);
                tagId = newTag.getId();
            } else {
                tagId = tag.getId();
            }

            final ArticleTagRelEntity articleTagRel = new ArticleTagRelEntity();
            articleTagRel.setArticleId(articleId);
            articleTagRel.setTagId(tagId);
            articleTagRelMapper.insert(articleTagRel);
        });
    }

    public void removeArticleById(final String id) {
        articleMapper.deleteById(id);
    }

    public void removeArticlesByUserId(final String userId) {
        articleMapper.delete(new LambdaQueryWrapper<ArticleEntity>()
                .eq(ArticleEntity::getUserId, userId));
    }

}
