package cc.jktu.apps.common;


import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

public record CommonPage<T>(Long pageNum, Long pageSize, Long count, List<T> items) {

    public static <T> CommonPage<T> of(IPage<T> page) {
        return new CommonPage<>(page.getCurrent(), page.getSize(), page.getTotal(), page.getRecords());
    }

}
