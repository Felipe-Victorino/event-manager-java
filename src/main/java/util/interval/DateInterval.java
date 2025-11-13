package util.interval;

import java.util.Date;

public class DateInterval extends Interval<Date> {
	DateInterval(Date low, Date high) {
		super(low, high);
	}
}