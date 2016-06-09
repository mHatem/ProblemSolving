package springmvc.java.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import springmvc.java.domain.Notes;


public interface NotesDAO extends CrudRepository<Notes, Long> {
	
	List<Notes> findNotesByUserId(Long UserId);
	List<Notes> findNotesByDate(Date date);
	List<Notes> findNotesByRangeFromAndRangeTo(Integer rangeFrom , Integer rangeTo);
}
