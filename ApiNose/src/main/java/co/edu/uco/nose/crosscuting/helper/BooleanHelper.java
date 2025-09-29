package co.edu.uco.nose.crosscuting.helper;

public class BooleanHelper {
	
	private static final boolean IS_CONFIRMED = false;
	
	private BooleanHelper () {
		
	}
	
	public static boolean getDefault() {
		return IS_CONFIRMED;
	}
	
	public static boolean getDeafult(final boolean value) {
		return ObjectHelper.getDefault(value, getDefault());
	}

}
