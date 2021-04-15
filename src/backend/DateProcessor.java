package backend;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateProcessor {
	private static SimpleDateFormat SDF_SQL = new SimpleDateFormat("yyyy-MM-dd"),
			SDF_READABLE = new SimpleDateFormat("MM/dd/yyyy"),
			SDF_TIMESTAMP_SQL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
			SDF_TIMESTAMP_READABLE = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"),
			SDF_BILLMONTH_SQL = new SimpleDateFormat("yyyyMM"),
			SDF_BILLMONTH_READABLE = new SimpleDateFormat("MMM yyyy");

	public static Calendar getCalendar() {
		return Calendar.getInstance();
	}

	public static Calendar getCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	public static String toReadableBillMonth(Date billMonth) {
		if (billMonth == null)
			return null;
		return SDF_BILLMONTH_READABLE.format(billMonth);
	}

	public static int toSQLBillMonth(Date billMonth) {
		if (billMonth == null)
			return 0;
		return Integer.parseInt(SDF_BILLMONTH_SQL.format(billMonth));
	}

	public static Date toDateObjectFromBillMonth(String sBillMonth) throws Exception {
		if (sBillMonth == null)
			return null;
		return SDF_BILLMONTH_SQL.parse(sBillMonth);
	}

	public static int getYear() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);
	}

	public static Date toDateObjectFromSQL(String sDate) throws Exception {
		if (sDate == null)
			return null;
		return SDF_SQL.parse(sDate);
	}

	public static Date toDateObjectFromReadable(String sDate) throws Exception {
		if (sDate == null)
			return null;
		return SDF_READABLE.parse(sDate);
	}

	public static Date toTimestampObjectFromSQL(String sTimestamp) throws Exception {
		if (sTimestamp == null)
			return null;
		return SDF_TIMESTAMP_SQL.parse(sTimestamp);
	}

	public static Date toTimestampObjectFromReadable(String sTimestamp) throws Exception {
		if (sTimestamp == null)
			return null;
		return SDF_TIMESTAMP_READABLE.parse(sTimestamp);
	}

	public static String toSQLDate(Date date) {
		if (date == null)
			date = new Date();
		return SDF_SQL.format(date);
	}

	public static String toSQLTimestamp(Date timestamp) {
		if (timestamp == null)
			timestamp = new Date();
		return SDF_TIMESTAMP_SQL.format(timestamp);
	}

	public static String toReadableDate(Date date) {
		if (date == null)
			date = new Date();
		return SDF_READABLE.format(date);
	}

	public static String toReadableTimestamp(Date timestamp) {
		if (timestamp == null)
			timestamp = new Date();
		return SDF_TIMESTAMP_READABLE.format(timestamp);
	}

}
