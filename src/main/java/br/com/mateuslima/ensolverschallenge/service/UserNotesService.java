package br.com.mateuslima.ensolverschallenge.service;

import br.com.mateuslima.ensolverschallenge.entity.UserNotes;
import br.com.mateuslima.ensolverschallenge.repository.UserNotesRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserNotesService {
    private UserNotesRepository userNotesRepository;

    //injection with repository
    public UserNotesService(UserNotesRepository userNotesRepository) {
        this.userNotesRepository = userNotesRepository;
    }

    public List<UserNotes> getActiveNotes(Sort sort) {
        return userNotesRepository.findByConfirmedIsFalse(sort);
    }
    public List<UserNotes> create(UserNotes notes, Sort sort) {
        notes.setConfirmed(false);
        userNotesRepository.save(notes);
        return getActiveNotes(sort);
    }
    public List<UserNotes> list(){
      Sort sort = Sort.by("priority").descending().and(
              Sort.by("name").ascending());
      return userNotesRepository.findByConfirmedIsFalse(sort);
    }
    public List<UserNotes> update(UserNotes notes){
        userNotesRepository.save(notes);
        return list();
    }
    public List<UserNotes> delete(Long id){
        userNotesRepository.deleteById(id);
        return list();
    }
    public List<UserNotes> getArchivedNotes() {
        return userNotesRepository.findByConfirmedIsTrue();
    }
    public List<UserNotes> getArchivedNotesByCategory(String category) {
        return userNotesRepository.findByCategoryAndConfirmedIsTrue(category);
    }
    public List<UserNotes> getUnarchivedNotesByCategory(String category) {
        return userNotesRepository.findByCategoryAndConfirmedIsFalse(category);
    }

    public List<UserNotes> archiveNoteById(Long id) {
        UserNotes note = userNotesRepository.findById(id).orElse(null);
        if (note != null) {
            note.setConfirmed(true);
            userNotesRepository.save(note);
        }
        return list();
    }
    public List<UserNotes> unarchiveNoteById(Long id) {
        UserNotes note = userNotesRepository.findById(id).orElse(null);
        if (note != null && note.isConfirmed()) {
            note.setConfirmed(false);
            userNotesRepository.save(note);
        }
        return getArchivedNotes();
    }
    public List<UserNotes> addCategoryToNote(Long id, String category) {
        UserNotes note = userNotesRepository.findById(id).orElse(null);
        if (note != null) {
            note.setCategory(category);
            userNotesRepository.save(note);
        }
        return list();
    }

    public List<UserNotes> removeCategoryFromNote(Long id) {
        UserNotes note = userNotesRepository.findById(id).orElse(null);
        if (note != null) {
            note.setCategory(null);
            userNotesRepository.save(note);
        }
        return list();
    }

    public List<UserNotes> getNotesByCategory(String category) {
        return userNotesRepository.findByCategory(category);
    }

}
