package ups.registro_cursos_ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ups.registro_cursos_ms.model.Profesor;
import ups.registro_cursos_ms.services.ProfesorService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/micro2/profesor/")
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;

    @PostMapping("/guardar")
    public ResponseEntity<Profesor> save(@RequestBody Profesor profesor) {
        Profesor temp = profesorService.create(profesor);

        try {
            return ResponseEntity.created(new URI("/micro2/profesor/guardar" +temp.getCedula())).body(temp);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Profesor>> listAll() {
        return ResponseEntity.ok(profesorService.listProfesores());
    }

}
