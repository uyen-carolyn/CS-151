import java.time.LocalDate;
import java.time.Month;
import java.time.ZonedDateTime; 
import java.time.temporal.ChronoUnit;

/**
 * Computes the number of days that have 
 * elapsed since birth-date using the ZonedDateTime class. 
 */
public class DaysSinceBirth {
	public static void main(String[] args) {
		ZonedDateTime now = ZonedDateTime.now(); 
		LocalDate birthdate = LocalDate.of(1998, Month.JANUARY, 23); // since birth time is arbitrary
		
		long daysBetween = ChronoUnit.DAYS.between(birthdate, now);

		System.out.println("Its been " + daysBetween + " days.");
	}
}
