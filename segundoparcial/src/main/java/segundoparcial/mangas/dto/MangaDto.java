package segundoparcial.mangas.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MangaDto {
    private Long id;
    private String nombre;
    private LocalDate fechaLanzamiento;   // formato yyyy-MM-dd
    private Integer temporadas;

    // En DB son INTEGER -> aquí también:
    private Integer anime;     // 0 o 1
    private Integer juego;     // 0 o 1
    private Integer pelicula;  // 0 o 1

    // Nombres descriptivos para respuesta
    private String pais;       // nombre del país
    private String tipo;       // nombre del tipo
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
