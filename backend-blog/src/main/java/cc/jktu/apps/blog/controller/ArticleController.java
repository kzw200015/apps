package cc.jktu.apps.blog.controller;

import cc.jktu.apps.blog.controller.req.ArticleAddReq;
import cc.jktu.apps.blog.dao.entity.ArticleEntity;
import cc.jktu.apps.blog.service.ArticleService;
import cc.jktu.apps.common.CommonResp;
import cc.jktu.apps.common.CommonPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
@Api(tags = "文章接口")
public class ArticleController {

    private final ArticleService articleService;

    @ApiOperation("分页获取文章")
    @GetMapping("")
    public CommonResp<CommonPage<ArticleEntity>> getArticlesPage(@RequestParam(required = false) List<Long> userIds,
                                                                 @RequestParam Long pageNum,
                                                                 @RequestParam Long pageSize) {
        if (userIds != null && !userIds.isEmpty()) {
            return CommonResp.ok(articleService.getArticlesPageInUserIds(userIds, pageNum, pageSize));
        }

        return CommonResp.ok(articleService.getArticlesPage(pageNum, pageSize));
    }

    @ApiOperation("根据ID获取文章")
    @GetMapping("/{id}")
    public CommonResp<ArticleEntity> getArticleById(@PathVariable Long id) {
        return CommonResp.ok(articleService.getArticleById(id));
    }

    @ApiOperation("添加文章")
    @PostMapping("")
    public CommonResp<Void> addOneArticle(@RequestBody ArticleAddReq req) {
        articleService.addOneArticle(req);
        return CommonResp.emptyWithMsg("添加成功");
    }

    @ApiOperation("通过ID删除文章")
    @DeleteMapping("/{id}")
    public CommonResp<Void> removeArticleById(@PathVariable String id) {
        articleService.removeArticleById(id);
        return CommonResp.emptyWithMsg("删除成功");
    }

    @ApiOperation("通过用户ID删除文章")
    @DeleteMapping("")
    public CommonResp<Void> removeArticlesByUserId(@RequestParam String userId) {
        articleService.removeArticlesByUserId(userId);
        return CommonResp.emptyWithMsg("删除成功");
    }

}
