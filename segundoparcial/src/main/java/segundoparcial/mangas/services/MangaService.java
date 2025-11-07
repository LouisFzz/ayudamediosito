package segundoparcial.mangas.services;

import segundoparcial.mangas.dto.MangaDto;
import segundoparcial.mangas.dto.MangaCreateDto;
import java.util.List;

public interface MangaService {

    List<MangaDto> getAll();

    MangaDto getById(Long id);

    MangaDto create(MangaCreateDto dto);

    MangaDto update(Long id, MangaCreateDto dto);

    MangaDto delete(Long id);
}
