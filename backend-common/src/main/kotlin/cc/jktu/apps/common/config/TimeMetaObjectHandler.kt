package cc.jktu.apps.common.config

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler
import org.apache.ibatis.reflection.MetaObject
import java.time.Instant

class TimeMetaObjectHandler : MetaObjectHandler {

    override fun insertFill(metaObject: MetaObject) {
        strictInsertFill(metaObject, "createTime", { Instant.now().epochSecond }, Long::class.java)
        strictInsertFill(metaObject, "updateTime", { Instant.now().epochSecond }, Long::class.java)
    }

    override fun updateFill(metaObject: MetaObject) {
        strictUpdateFill(metaObject, "updateTime", { Instant.now().epochSecond }, Long::class.java)
    }
}
