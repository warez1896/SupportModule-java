package backend;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateProcessor {
	private static SimpleDateFormat SDF_SQL = new SimpleDateFormat("yyyy-MM-dd"),
			SDF_READABLE = new SimpleDateFormat("MM/dd/yyyy"),
			SDF_TIMESTAMP_SQL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
			SDF_TIMESTAMP_READABLE = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	public static Calendar getCalendar() {
		return Calendar.getInstance();
	}

	public static Calendar getCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	public static int getYear() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);
	}

	public static Date toDateObjectFromSQL(String sDate) throws Exception {
		return SDF_SQL.parse(sDate);
	}

	public static Date toDateObjectFromReadable(String sDate) throws Exception {
		return SDF_READABLE.parse(sDate);
	}

	public static Date toTimestampObjectFromSQL(String sTimestamp) throws Exception {
		return SDF_TIMESTAMP_SQL.parse(sTimestamp);
	}

	public static Date toTimestampObjectFromReadable(String sTimestamp) throws Exception {
		return SDF_TIMESTAMP_READABLE.parse(sTimestamp);
	}

	public static String toSQLDate(Date date) {
		return SDF_SQL.format(date);
	}

	public static String toSQLTimestamp(Date timestamp) {
		return SDF_TIMESTAMP_SQL.format(timestamp);
	}

	public static String toReadableDate(Date date) {
		return SDF_READABLE.format(date);
	}

	public static String toReadableTimestamp(Date timestamp) {
		return SDF_TIMESTAMP_READABLE.format(timestamp);
	}

}
