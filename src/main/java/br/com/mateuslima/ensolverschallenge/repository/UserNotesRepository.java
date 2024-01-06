package br.com.mateuslima.ensolverschallenge.repository;

import br.com.mateuslima.ensolverschallenge.entity.UserNotes;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserNotesRepository extends JpaRepository <UserNotes, Long>{
    List<UserNotes> findByCategoryAndConfirmedIsTrue(String category);
    List<UserNotes> findByCategoryAndConfirmedIsFalse(String category);
    List<UserNotes> findByConfirmedIsTrue();
    //notes non-filled
    List<UserNotes> findByConfirmedIsFalse(Sort sort);
    List<UserNotes> findByCategory(String category);
}
