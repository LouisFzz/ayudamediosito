package segundoparcial.mangas.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Objeto no encontrado");
    }
    public NotFoundException(String message) {
        super(message);
    }
}
