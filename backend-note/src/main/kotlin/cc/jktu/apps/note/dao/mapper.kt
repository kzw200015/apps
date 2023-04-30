package cc.jktu.apps.note.dao

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper

@Mapper
interface NoteMapper : BaseMapper<Note>