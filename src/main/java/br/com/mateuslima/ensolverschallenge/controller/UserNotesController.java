package br.com.mateuslima.ensolverschallenge.controller;

import br.com.mateuslima.ensolverschallenge.entity.UserNotes;
import br.com.mateuslima.ensolverschallenge.service.UserNotesService;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class UserNotesController {
    private UserNotesService userNotesService;

    public UserNotesController(UserNotesService userNotesService) {
        this.userNotesService = userNotesService;
    }
    @PostMapping
    List<UserNotes> create (@RequestBody UserNotes notes){
        return userNotesService.create(notes);
    }

    @GetMapping
    List<UserNotes> list (){
        return userNotesService.list();
    }
    @PutMapping
    List<UserNotes> update (@RequestBody UserNotes notes){
        return userNotesService.update(notes);
    }
    @DeleteMapping("{id}")
    List<UserNotes> delete (@PathVariable("id") Long id){
        return userNotesService.delete(id);
    }

}
