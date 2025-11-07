package segundoparcial.mangas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import segundoparcial.mangas.models.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);
}
