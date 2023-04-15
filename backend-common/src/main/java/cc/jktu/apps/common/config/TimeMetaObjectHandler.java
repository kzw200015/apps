package cc.jktu.apps.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.Instant;

public class TimeMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        strictInsertFill(metaObject, "createTime", () -> Instant.now().getEpochSecond(), Long.class);
        strictInsertFill(metaObject, "updateTime", () -> Instant.now().getEpochSecond(), Long.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        strictUpdateFill(metaObject, "updateTime", () -> Instant.now().getEpochSecond(), Long.class);
    }

}
