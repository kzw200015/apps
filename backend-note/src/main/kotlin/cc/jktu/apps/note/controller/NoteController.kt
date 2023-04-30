package cc.jktu.apps.note.controller

import cc.jktu.apps.common.CommonResp
import cc.jktu.apps.common.ok
import cc.jktu.apps.note.dao.Note
import cc.jktu.apps.note.service.NoteService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/notes")
class NoteController(
    private val noteService: NoteService
) {

    @GetMapping("")
    fun getAllNotes(): CommonResp<List<Note>> {
        return noteService.getAllNotes().ok()
    }
}