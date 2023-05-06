package cc.jktu.apps.common.config

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler
import org.apache.ibatis.reflection.MetaObject
import java.time.Instant

class TimeMetaObjectHandler : MetaObjectHandler {

    override fun insertFill(metaObject: MetaObject) {
        fillStrategy(metaObject, "createTime", Instant.now().epochSecond)
        fillStrategy(metaObject, "updateTime", Instant.now().epochSecond)
    }

    override fun updateFill(metaObject: MetaObject) {
        fillStrategy(metaObject, "updateTime", Instant.now().epochSecond)
    }
}
