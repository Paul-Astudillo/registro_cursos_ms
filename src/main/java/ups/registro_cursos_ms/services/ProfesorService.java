package ups.registro_cursos_ms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.registro_cursos_ms.model.Profesor;
import ups.registro_cursos_ms.repository.ProfesorRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public Optional<Profesor> buscarProfesor(String cedula) {
        try {
            List<Profesor> profesoresEncontrados = profesorRepository.findByCedulaIgnoreCase(cedula);
            return profesoresEncontrados.isEmpty() ? Optional.empty() : Optional.of(profesoresEncontrados.get(0));
        } catch (Exception e) {
            System.err.println("Error al buscar profesor por cédula: " + cedula + ", " + e.getMessage());
            return Optional.empty();
        }
    }


}
