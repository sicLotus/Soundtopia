package music.exception;

public class NoAdminException extends SoundtopiaException {
	private static final long serialVersionUID = 1L;

	public NoAdminException() {
		super("Sie haben nicht die nötigen Rechte um diese Aktion durchzuführen.");
	}

}
