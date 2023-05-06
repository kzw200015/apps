package cc.jktu.apps.note.service

import cc.jktu.apps.note.controller.CreateNoteDTO
import cc.jktu.apps.note.controller.UpdateNoteDTO
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

    fun createNote(createNoteDTO: CreateNoteDTO) {
        noteMapper.insert(
            Note(
                title = createNoteDTO.title,
                content = createNoteDTO.content,
                userId = createNoteDTO.userId
            )
        )
    }

    fun updateNote(id: Long, updateNoteDTO: UpdateNoteDTO) {
        noteMapper.updateById(
            Note(
                id = id,
                title = updateNoteDTO.title,
                content = updateNoteDTO.content
            )
        )
    }

    fun removeNote(vararg ids: Long) {
        noteMapper.deleteBatchIds(ids.toList())
    }
}