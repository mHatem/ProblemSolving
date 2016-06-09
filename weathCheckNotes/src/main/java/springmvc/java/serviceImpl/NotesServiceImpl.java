package springmvc.java.serviceImpl;

import java.util.Date;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import springmvc.java.dao.NotesDAO;
import springmvc.java.domain.Notes;
import springmvc.java.service.NotesService;

@Component
public class NotesServiceImpl implements NotesService {

	
private static final Logger logger = LoggerFactory.getLogger(NotesServiceImpl.class); 
	
	@Autowired
	private NotesDAO notesDao;
	

	@Override
	public void saveNote(Notes note) {
		logger.debug("NotesServiceImpl : saveNote is Called");
		notesDao.save(note);

	}

	@Override
	public List<Notes> getNotesbyUserId(Long userId) {
		return notesDao.findNotesByUserId(userId);
		
	}

	@Override
	public void deleteNotebyId(Long id) {
		logger.debug("NotesServiceImpl : delete Note by Id is Called");
		notesDao.delete(id);
		
	}

	@Override
	public Notes getNotesByDate(Date date) {
		logger.debug("NotesServiceImpl : get Note by Date is Called");
		List<Notes> notes = notesDao.findNotesByDate(date);
		return notes.get(notes.size()-1);
	}

	@Override
	public Notes getNotesByRangFromAndRangeTo(Integer rangeFrom, Integer rangeTo) {
		logger.debug("NotesServiceImpl : get Note by ranges is Called");
		List<Notes> notes =notesDao.findNotesByRangeFromAndRangeTo(rangeFrom, rangeTo);
		return notes.get(notes.size()-1);
	}
	

}
