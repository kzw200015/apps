package cc.jktu.apps.common;


import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

public record PageWrapper<T>(Long pageNum, Long pageSize, Long count, List<T> items) {

    public static <T> PageWrapper<T> of(IPage<T> page) {
        return new PageWrapper<>(page.getCurrent(), page.getSize(), page.getTotal(), page.getRecords());
    }

}
