package org.eclipse.epsilon.eol.execute.operations.contributors;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return target instanceof Date;
	}
	
	public int getDayOfTheWeek() {
		Date date = (Date) target;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	
	public long getDifferenceInDays(Date other) {
		Date date = (Date) target;
		long diff = date.getTime() - other.getTime();
	    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
}
