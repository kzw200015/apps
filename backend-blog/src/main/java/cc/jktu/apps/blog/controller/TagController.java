package cc.jktu.apps.blog.controller;

import cc.jktu.apps.blog.controller.req.TagAddOrUpdateReq;
import cc.jktu.apps.blog.dao.entity.TagEntity;
import cc.jktu.apps.blog.service.TagService;
import cc.jktu.apps.common.CommonResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tags")
@Api(tags = "标签接口")
public class TagController {

    private final TagService tagService;

    @ApiOperation("根据ID获取标签")
    @GetMapping("/{id}")
    public CommonResp<TagEntity> getTagById(@PathVariable Long id) {
        return CommonResp.ok(tagService.getTagById(id));
    }

    @ApiOperation("获取所有标签")
    @GetMapping("")
    public CommonResp<List<TagEntity>> getAllTags() {
        return CommonResp.ok(tagService.getAllTags());
    }

    @ApiOperation("添加标签")
    @PostMapping("")
    public CommonResp<Void> addOneTag(@RequestBody TagAddOrUpdateReq req) {
        tagService.addOneTag(req.getName());
        return CommonResp.emptyWithMsg("添加成功");
    }

    @ApiOperation("根据ID更新标签")
    @PatchMapping("/{id}")
    public CommonResp<Void> updateTagById(@PathVariable Long id, @RequestBody TagAddOrUpdateReq req) {
        tagService.updateTagById(id, req.getName());
        return CommonResp.emptyWithMsg("更新成功");
    }

    @ApiOperation("根据ID删除标签")
    @DeleteMapping("/{id}")
    public CommonResp<Void> removeTagById(@PathVariable Long id) {
        tagService.removeTagById(id);
        return CommonResp.emptyWithMsg("删除成功");
    }

}
