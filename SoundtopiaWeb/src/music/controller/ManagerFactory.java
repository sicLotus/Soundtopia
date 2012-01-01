package music.controller;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ManagerFactory {
	public static enum Mode{Remote, Local};

	/**
	 * Liefert jeden Manager aus dem EJB Projekt
	 * @param manager - Name der Klasse des Managers z.B. SongManagerLocal
	 * @return Object, welches noch gecastet werden muss
	 */
	public static Object getManager(String manager, Mode mode) {
		Context ctx;
		try {
			ctx = new InitialContext();
			Object obj = ctx.lookup("java:global/Soundtopia/SoundtopiaEJB/"+manager+"!music.manager."+manager+mode.toString());
			return obj;
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
