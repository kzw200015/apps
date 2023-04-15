package cc.jktu.apps.blog.service;

import cc.jktu.apps.blog.dao.entity.TagEntity;
import cc.jktu.apps.blog.dao.mapper.TagMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagMapper tagMapper;

    public TagEntity getTagById(Long id) {
        return tagMapper.selectById(id);
    }

    public List<TagEntity> getAllTags() {
        return tagMapper.selectList(null);
    }

    public void addOneTag(String name) {
        final TagEntity tag = new TagEntity();
        tag.setName(name);
        tagMapper.insert(tag);
    }

    public void removeTagById(Long id) {
        tagMapper.deleteById(id);
    }

    public void updateTagById(Long id, String name) {
        final TagEntity tag = new TagEntity();
        tag.setId(id);
        tag.setName(name);
        tagMapper.updateById(tag);
    }

}
