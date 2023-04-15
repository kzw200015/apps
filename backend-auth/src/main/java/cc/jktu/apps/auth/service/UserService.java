package cc.jktu.apps.auth.service;

import cc.jktu.apps.auth.dao.mapper.UserMapper;
import cc.jktu.apps.common.dao.entity.UserEntity;
import cc.jktu.apps.common.exception.NotFoundException;
import cc.jktu.apps.common.util.BcryptUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public UserEntity getByUsername(String username) throws NotFoundException {
        final UserEntity user = userMapper.selectOne(new LambdaQueryWrapper<UserEntity>()
                .eq(UserEntity::getUsername, username));
        if (user == null) {
            throw new NotFoundException("未找到用户");
        }
        return user;
    }

    public void addOne(String username, String password) {
        final UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(BcryptUtil.hashPassword(password));
        userMapper.insert(user);
    }

    public List<UserEntity> getAllUsers() {
        return userMapper.selectList(null);
    }

    public UserEntity getById(final Long id) {
        final UserEntity user = userMapper.selectById(id);
        if (user == null) {
            throw new NotFoundException("未找到用户");
        }
        return user;
    }

    public void updateById(final Long id, final String username, final String password) {
        final UserEntity user = new UserEntity();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        userMapper.updateById(user);
    }

}
