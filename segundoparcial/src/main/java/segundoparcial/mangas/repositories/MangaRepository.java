package segundoparcial.mangas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import segundoparcial.mangas.models.Manga;

public interface MangaRepository extends JpaRepository<Manga, Long> {

}
