package tenth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String REGEX_PHONE_NUMBER = "^\\+\\d{2}\\(\\d{3}\\)\\-\\d{3}\\-\\d{4}$";
    private static final String REGEX_EMAIL = "^\\w+[\\w\\.\\-\\_]{0,20}\\@[a-zA-Z]+\\.(com|net|org|ua)$";
    private static final String REGEX_IP = "^((([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3})([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
    private static final String REGEX_DATE = "^(([012]\\d)|(3[0-1]))\\.[01]\\d\\.(19|20)\\d{2}";

    public static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(REGEX_PHONE_NUMBER);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidIP(String ip){
        Pattern pattern = Pattern.compile(REGEX_IP);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }

    public static boolean isValidDate(String date){
        Pattern pattern = Pattern.compile(REGEX_DATE);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }
}
