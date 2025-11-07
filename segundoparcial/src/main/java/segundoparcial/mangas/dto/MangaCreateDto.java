package segundoparcial.mangas.dto;

import lombok.*;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MangaCreateDto {

    @NotBlank(message = "El campo nombre es obligatorio")
    private String nombre;

    @NotNull(message = "El campo fechaLanzamiento es obligatorio")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaLanzamiento;

    private Integer temporadas;

    // Mantener INTEGER como en la BD
    @NotNull(message = "El campo anime es obligatorio")
    private Integer anime;

    @NotNull(message = "El campo juego es obligatorio")
    private Integer juego;

    @NotNull(message = "El campo pelicula es obligatorio")
    private Integer pelicula;

    // Relación opcional según tu DDL (sin NOT NULL).
    private Long paisId;
    private Long tipoId;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaLanzamiento() {
		return fechaLanzamiento;
	}
	public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}
	public Integer getTemporadas() {
		return temporadas;
	}
	public void setTemporadas(Integer temporadas) {
		this.temporadas = temporadas;
	}
	public Integer getAnime() {
		return anime;
	}
	public void setAnime(Integer anime) {
		this.anime = anime;
	}
	public Integer getJuego() {
		return juego;
	}
	public void setJuego(Integer juego) {
		this.juego = juego;
	}
	public Integer getPelicula() {
		return pelicula;
	}
	public void setPelicula(Integer pelicula) {
		this.pelicula = pelicula;
	}
	public Long getPaisId() {
		return paisId;
	}
	public void setPaisId(Long paisId) {
		this.paisId = paisId;
	}
	public Long getTipoId() {
		return tipoId;
	}
	public void setTipoId(Long tipoId) {
		this.tipoId = tipoId;
	}
}
