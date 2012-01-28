package music.exception;

public class NoLoginException extends SoundtopiaException {
	private static final long serialVersionUID = 1L;

	public NoLoginException() {
		super("Sie sind noch nicht eingeloggt.");
	}

}
