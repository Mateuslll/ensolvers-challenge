package br.com.mateuslima.ensolverschallenge.controller;

import br.com.mateuslima.ensolverschallenge.entity.UserNotes;
import br.com.mateuslima.ensolverschallenge.service.UserNotesService;
import org.apache.catalina.User;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class UserNotesController {
    private UserNotesService userNotesService;

    public UserNotesController(UserNotesService userNotesService) {
        this.userNotesService = userNotesService;
    }
    //CRUD methods
    @PostMapping("/add")
    List<UserNotes> create (@RequestBody UserNotes notes, Sort sort){
        return userNotesService.create(notes,sort);
    }
    @GetMapping("/actives")
    List<UserNotes> list (){
        return userNotesService.list();
    }
    @PutMapping("/update")
    List<UserNotes> update (@RequestBody UserNotes notes){
        return userNotesService.update(notes);
    }
    @DeleteMapping("delete/{id}")
    List<UserNotes> delete (@PathVariable("id") Long id){
        return userNotesService.delete(id);
    }

    //file manipulation
    @GetMapping("/archived")
    public List<UserNotes> getArchivedNotes() {
        return userNotesService.getArchivedNotes();
    }
    @GetMapping("/archived/{category}")
    List<UserNotes> getArchivedNotes(@PathVariable("category") String category) {
        return userNotesService.getArchivedNotesByCategory(category);
    }
    @GetMapping("/unarchived/{category}")
    public List<UserNotes> getUnarchivedNotesByCategory(@PathVariable("category") String category) {
        return userNotesService.getUnarchivedNotesByCategory(category);
    }
    @PutMapping("/archive/{id}")
    List<UserNotes> archiveNote(@PathVariable("id") Long id) {
        return userNotesService.archiveNoteById(id);
    }
    @PutMapping("/unarchive/{id}")
    public List<UserNotes> unarchiveNoteById(@PathVariable("id") Long id) {
        return userNotesService.unarchiveNoteById(id);
    }
    //add , remove categories, list notes by category
    @PutMapping("/{id}/add-category/{category}")
    List<UserNotes> addCategoryToNote(@PathVariable("id") Long id, @PathVariable("category") String category) {
        return userNotesService.addCategoryToNote(id, category);
    }
    @PutMapping("/{id}/remove-category")
    List<UserNotes> removeCategoryFromNote(@PathVariable("id") Long id) {
        return userNotesService.removeCategoryFromNote(id);
    }
    @GetMapping("/category/{category}")
    List<UserNotes> getNotesByCategory(@PathVariable("category") String category) {
        return userNotesService.getNotesByCategory(category);
    }
}
