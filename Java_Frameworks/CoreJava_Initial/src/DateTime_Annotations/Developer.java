package DateTime_Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.METHOD})
// can use in method only.
public @interface Developer {
	public enum Functionality {
		SALES, HR, PURCHASE
	}
	String name();
	String date();
	String description() default "Default Description";
	int rank();
	Functionality functionality();
}