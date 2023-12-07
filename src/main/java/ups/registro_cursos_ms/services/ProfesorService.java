package ups.registro_cursos_ms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.registro_cursos_ms.model.Profesor;
import ups.registro_cursos_ms.repository.ProfesorRepository;

import java.util.List;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    public Profesor create(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public List<Profesor> listProfesores() {
        return profesorRepository.findAll();
    }

    public void delete(Profesor profesor) {
        profesorRepository.delete(profesor);
    }
}
