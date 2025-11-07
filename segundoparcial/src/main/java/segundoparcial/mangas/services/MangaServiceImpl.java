package segundoparcial.mangas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import segundoparcial.mangas.services.MangaService;
import segundoparcial.mangas.repositories.*;
import segundoparcial.mangas.dto.*;
import segundoparcial.mangas.models.*;
import segundoparcial.mangas.exceptions.BadRequestException;
import segundoparcial.mangas.exceptions.NotFoundException;

import java.util.List;

@Service
public class MangaServiceImpl implements MangaService {

    @Autowired private MangaRepository mangaRepository;
    @Autowired private PaisRepository paisRepository;
    @Autowired private TipoRepository tipoRepository;
    @Autowired private FavoritoRepository favoritoRepository;

    @Override
    public List<MangaDto> getAll() {
        return mangaRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public MangaDto getById(Long id) {
        Manga manga = mangaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Objeto no encontrado"));

        return toDto(manga);
    }

    @Transactional
    @Override
    public MangaDto create(MangaCreateDto dto) {

        Pais pais = paisRepository.findById(dto.getPaisId())
                .orElseThrow(() -> new BadRequestException("Pais no existe"));

        Tipo tipo = tipoRepository.findById(dto.getTipoId())
                .orElseThrow(() -> new BadRequestException("Tipo no existe"));

        Manga manga = Manga.builder()
                .nombre(dto.getNombre())
                .fechaLanzamiento(dto.getFechaLanzamiento())
                .temporadas(dto.getTemporadas())
                .anime(dto.getAnime())
                .juego(dto.getJuego())
                .pelicula(dto.getPelicula())
                .pais(pais)
                .tipo(tipo)
                .build();

        mangaRepository.save(manga);

        return toDto(manga);
    }

    @Transactional
    @Override
    public MangaDto update(Long id, MangaCreateDto dto) {

        Manga manga = mangaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Objeto no encontrado"));

        Pais pais = paisRepository.findById(dto.getPaisId())
                .orElseThrow(() -> new BadRequestException("Pais no existe"));

        Tipo tipo = tipoRepository.findById(dto.getTipoId())
                .orElseThrow(() -> new BadRequestException("Tipo no existe"));

        manga.setNombre(dto.getNombre());
        manga.setFechaLanzamiento(dto.getFechaLanzamiento());
        manga.setTemporadas(dto.getTemporadas());
        manga.setAnime(dto.getAnime());
        manga.setJuego(dto.getJuego());
        manga.setPelicula(dto.getPelicula());
        manga.setPais(pais);
        manga.setTipo(tipo);

        mangaRepository.save(manga);

        return toDto(manga);
    }

    @Transactional
    @Override
    public MangaDto delete(Long id) {
        Manga manga = mangaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Objeto no encontrado"));

        if (favoritoRepository.existsByManga(manga)) {
            throw new BadRequestException("Manga tiene usuarios asociados");
        }

        mangaRepository.delete(manga);
        return toDto(manga);
    }


    /* ----------------------------------------------------- */
    /*                   MÉTODO AUXILIAR                     */
    /* ----------------------------------------------------- */

    private MangaDto toDto(Manga manga) {
        return MangaDto.builder()
                .id(manga.getId())
                .nombre(manga.getNombre())
                .fechaLanzamiento(manga.getFechaLanzamiento())
                .temporadas(manga.getTemporadas())
                .anime(manga.getAnime())
                .juego(manga.getJuego())
                .pelicula(manga.getPelicula())
                .pais(manga.getPais().getNombre())
                .tipo(manga.getTipo().getNombre())
                .build();
    }
}
