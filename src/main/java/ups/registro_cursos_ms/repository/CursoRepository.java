package ups.registro_cursos_ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ups.registro_cursos_ms.model.Curso;


public interface CursoRepository  extends JpaRepository<Curso, Long> {
}
