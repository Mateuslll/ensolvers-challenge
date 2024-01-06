package br.com.mateuslima.ensolverschallenge.repository;

import br.com.mateuslima.ensolverschallenge.entity.UserNotes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserNotesRepository extends JpaRepository <UserNotes, Long>{

}
