package springmvc.java.service;

import java.util.*;
import springmvc.java.domain.Notes;

public interface NotesService {

	public void saveNote(Notes note);
	public List<Notes> getNotesbyUserId(Long userId);
	public Notes getNotesByDate(Date date);
	public Notes getNotesByRangFromAndRangeTo(Integer rangeFrom, Integer rangeTo);
	public void deleteNotebyId(Long id);
}
