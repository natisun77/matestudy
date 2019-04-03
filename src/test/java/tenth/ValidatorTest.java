package tenth;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class ValidatorTest {
    @Test
    public void phoneCheck() {
        assertTrue(Validator.isValidPhoneNumber("+38(050)-341-6093"));
        assertTrue(Validator.isValidPhoneNumber("+38(093)-341-6093"));
        assertFalse(Validator.isValidPhoneNumber("38(093)-341-6093"));
        assertFalse(Validator.isValidPhoneNumber("+38(93)-341-6093"));
        assertFalse(Validator.isValidPhoneNumber("+38(093)341-6093"));
        assertFalse(Validator.isValidPhoneNumber("+38(093)-341-60093"));
        assertFalse(Validator.isValidPhoneNumber("+38(093)-341-6n93"));
    }

    @Test
    public void emailCheck() {
        assertTrue(Validator.isValidEmail("kh.ng@kyiv.ua"));
        assertTrue(Validator.isValidEmail("khmelovska.ng@gmail.com"));
        assertTrue(Validator.isValidEmail("khmelovska11.ng@ukr.net"));
        assertFalse(Validator.isValidEmail("khmelovska?ng@gmail.com"));
        assertFalse(Validator.isValidEmail("khmelovska.ng%@gmail.com"));
        assertFalse(Validator.isValidEmail("khmelovska.ng@gmail.ru"));
        assertFalse(Validator.isValidEmail("khmelovska.ng_mail.com"));
        assertFalse(Validator.isValidEmail("khmelovska.ng@gmail_com"));
        assertFalse(Validator.isValidEmail("khmelovska.ng@gmail.com1"));
    }

    @Test
    public void ipCheck() {
        assertFalse(Validator.isValidIP(""));
        assertFalse(Validator.isValidIP("11111.111.111.111"));
        assertFalse(Validator.isValidIP("1.13.1n1.111"));
        assertFalse(Validator.isValidIP("7.258.21.21"));
        assertFalse(Validator.isValidIP(".111.111.111"));
        assertTrue(Validator.isValidIP("133.226.224.251"));
        assertTrue(Validator.isValidIP("1.219.251.05"));
        assertTrue(Validator.isValidIP("1.1.1.1"));
        assertTrue(Validator.isValidIP("251.1.229.229"));
        assertTrue(Validator.isValidIP("01.201.244.111"));
    }

    @Test
    public void dateCheck() {
        assertFalse(Validator.isValidDate("25/02/1966"));
        assertFalse(Validator.isValidDate("25.02.1866"));
        assertFalse(Validator.isValidDate("32.02.2066"));
        assertFalse(Validator.isValidDate("2.2.1966"));
        assertFalse(Validator.isValidDate("02.20.1946"));
        assertTrue(Validator.isValidDate("25.12.2019"));
        assertTrue(Validator.isValidDate("01.08.1999"));
        assertTrue(Validator.isValidDate("05.09.2010"));
        assertTrue(Validator.isValidDate("19.09.2005"));
        assertTrue(Validator.isValidDate("25.07.1986"));
    }
}
