package uk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Calendar;
import	java.util.Date;

public final class SmartCardNumber {

	private final String initials;
	private final int year;
	private final int serialNumber;
	private static final Map<String, SmartCardNumber> NAMES = new HashMap<String, SmartCardNumber>();
	private static final List <String> INITIALSLIST = new ArrayList <String>();


	private SmartCardNumber(String initials, int year , int serialNumber) {
		this.initials = initials;
		this.year = year;
		this.serialNumber = serialNumber;
	}

	public static SmartCardNumber getInstance(StudentName name, Date dateIssue) {
		String initials = name.getInitials();

		Calendar calendarIssue = Calendar.getInstance();
		calendarIssue.setTime(dateIssue);


		int year = calendarIssue.get(Calendar.YEAR);

		int serialNumber = 0;
		while(INITIALSLIST.contains(initials + year + serialNumber)){
			serialNumber ++;}
		INITIALSLIST.add(initials + year + serialNumber);


		final String k = initials + year + serialNumber;
		if (!NAMES.containsKey(k))
			NAMES.put(k, new SmartCardNumber (initials, year, serialNumber));
		return NAMES.get(k);
	}


	public String getInitials() {
		return initials;
	}
	public int getYear() {
		return year;
	}
	public int getSerialNumber() {
		return serialNumber;
	}


	@Override
	public String toString(){
		return String.format("%s%s%d%s%d", getInitials(), "-", getYear(), "-", getSerialNumber());

	}

}