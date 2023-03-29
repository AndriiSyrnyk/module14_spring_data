package goit.javadeveloper.note;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    public Note getById(long id) {
        return noteRepository.findById(id).get();
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void update(Note note) {
        long id = note.getId();
        if (noteRepository.existsById(id)) {
            noteRepository.save(note);
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void deleteById(long id) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }
}