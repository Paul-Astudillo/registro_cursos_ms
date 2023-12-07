package ups.registro_cursos_ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ups.registro_cursos_ms.model.Profesor;

import java.util.List;
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    List<Profesor> findByCedulaIgnoreCase(String cedula);
}
