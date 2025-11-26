import com.github.javafaker.Faker;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FakerTest {
	static Faker fk = new Faker(new Locale("pt-BR"));

	public static void main() {
		Calendar cl = Calendar.getInstance(new Locale("pt-BR"));
		cl.set(2026, Calendar.DECEMBER, 31);
		System.out.println(fk.name().fullName());
		System.out.println(fk.aquaTeenHungerForce().character());
		System.out.println(fk.date().between(new Date(), cl.getTime()));
	}
}