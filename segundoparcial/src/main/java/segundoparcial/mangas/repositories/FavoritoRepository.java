package segundoparcial.mangas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import segundoparcial.mangas.models.Favorito;
import segundoparcial.mangas.models.FavoritoId;
import segundoparcial.mangas.models.Usuario;
import segundoparcial.mangas.models.Manga;
import java.util.List;
import java.util.Optional;

public interface FavoritoRepository extends JpaRepository<Favorito, FavoritoId> {

    Optional<Favorito> findByUsuarioAndManga(Usuario usuario, Manga manga);
    boolean existsByManga(Manga manga);
    List<Favorito> findAllByUsuario(Usuario usuario);
}
