package segundoparcial.mangas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import segundoparcial.mangas.services.MangaService;
import segundoparcial.mangas.dto.MangaCreateDto;
import segundoparcial.mangas.dto.MangaDto;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mangas")
@Validated
public class MangaController {

	@Autowired private MangaService mangaService;

    @GetMapping
    public ResponseEntity<List<MangaDto>> getAll() {
        return ResponseEntity.ok(mangaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MangaDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(mangaService.getById(id));
    }

    @PostMapping
    public ResponseEntity<MangaDto> create(@Valid @RequestBody MangaCreateDto dto) {
        MangaDto created = mangaService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MangaDto> update(@PathVariable Long id,
                                           @Valid @RequestBody MangaCreateDto dto) {
        return ResponseEntity.ok(mangaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MangaDto> delete(@PathVariable Long id) {
        return ResponseEntity.ok(mangaService.delete(id));
    }
}
