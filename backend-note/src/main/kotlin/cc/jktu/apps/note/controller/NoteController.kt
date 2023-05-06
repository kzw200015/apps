package cc.jktu.apps.note.controller

import cc.jktu.apps.common.exception.ForbiddenException
import cc.jktu.apps.common.util.*
import cc.jktu.apps.note.dao.Note
import cc.jktu.apps.note.service.NoteService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/notes")
@Tag(name = "笔记接口")
class NoteController(
    private val noteService: NoteService
) {

    @GetMapping("")
    @Operation(summary = "获取所有笔记")
    fun getAllNotes(): CommonResp<List<Note>> {
        return noteService.getAllNotes().ok()
    }

    @PostMapping("")
    @Operation(summary = "创建新笔记")
    fun createNote(@RequestBody createNoteDTO: CreateNoteDTO): CommonResp<Nothing?> {
        val userId = getCurrentUserId()
        if (userId != createNoteDTO.userId) {
            throw ForbiddenException()
        }

        noteService.createNote(createNoteDTO)
        return emptyResp()
    }

    @PatchMapping("/{id}")
    @Operation(summary = "更新笔记")
    fun updateNote(@PathVariable id: Long, @RequestBody updateNoteDTO: UpdateNoteDTO): CommonResp<Nothing?> {
        noteService.updateNote(id, updateNoteDTO)
        return emptyResp()
    }

    @DeleteMapping("/{ids}")
    fun removeNote(@PathVariable ids: List<Long>) {
        noteService.removeNote(*ids.toLongArray())
    }
}

data class CreateNoteDTO(
    val title: String,
    val content: String,
    val userId: Long
)

data class UpdateNoteDTO(
    val title: String?,
    val content: String?,
)