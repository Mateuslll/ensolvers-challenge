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

    public List<UserNotes> create(UserNotes notes) {
        userNotesRepository.save(notes);
        return list();
    }
    public List<UserNotes> list(){
      Sort sort = Sort.by("priority").descending().and(
              Sort.by("name").ascending());
      return userNotesRepository.findAll(sort);
    }
    public List<UserNotes> update(UserNotes notes){
        userNotesRepository.save(notes);
        return list();
    }
    public List<UserNotes> delete(Long id){
        userNotesRepository.deleteById(id);
        return list();
    }
}
