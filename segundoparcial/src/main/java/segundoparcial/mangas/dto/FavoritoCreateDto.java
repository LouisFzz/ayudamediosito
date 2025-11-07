package segundoparcial.mangas.dto;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FavoritoCreateDto {

    @NotNull(message = "El campo mangaId es obligatorio")
    private Long mangaId;

	public Long getMangaId() {
		return mangaId;
	}

	public void setMangaId(Long mangaId) {
		this.mangaId = mangaId;
	}
}
