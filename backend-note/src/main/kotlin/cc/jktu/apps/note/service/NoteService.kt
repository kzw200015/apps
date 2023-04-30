package cc.jktu.apps.note.service

import cc.jktu.apps.note.dao.Note
import cc.jktu.apps.note.dao.NoteMapper
import org.springframework.stereotype.Service

@Service
class NoteService(
    private val noteMapper: NoteMapper
) {

    fun getAllNotes(): List<Note> {
        return noteMapper.selectList(null)
    }
}