package music.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Formatter {
	private static DecimalFormat df;
	static {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.GERMAN);
		otherSymbols.setDecimalSeparator('.');
		otherSymbols.setGroupingSeparator(',');
		df = new DecimalFormat("0.00", otherSymbols);
	}

	private Formatter() {

	}

	public static String formatTime(int sec) {
		String result;
		int minutes = sec / 60;
		int seconds = sec % 60;
		if (seconds < 10)
			result = minutes + ":0" + seconds;
		else
			result = minutes + ":" + seconds;
		return result;
	}

	public static DecimalFormat getNumberFormat() {
		return df;
	}
}
