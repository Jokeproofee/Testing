package api.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user1;
    private User user2;
    @BeforeEach
    void setUp() {
        user1 = new User("TestLogin", "Test@Email.ru");
        user2 = new User();
    }

    @Test
    @DisplayName("When an object is created with two parameters passed to it, then true")
    void createObjectWithParameters() {
        boolean actualResult1 = user1.getLogin().equals("TestLogin");
        boolean actualResult2 = user1.getEmail().equals("Test@Email.ru");
        assertTrue(actualResult1);
        assertTrue(actualResult2);
    }

    @Test
    @DisplayName("When an object is created without the parameters passed to it, then true")
    void createObjectWithOutParameters() {
        boolean actualResult1 = user2.getLogin() == null;
        boolean actualResult2 = user2.getEmail() == null;
        assertTrue(actualResult1,"Параметры не null!");
        assertTrue(actualResult2,"Параметры не null!");
    }

    @Test
    @DisplayName("When there is no symbol ('@','.') in the email, then false")
    void checkEmail() {
        boolean actualResult1 = user1.getEmail().contains("@");
        boolean actualResult2 = user1.getEmail().contains(".");
        assertTrue(actualResult1, "Email должен содержать символ:'@'!");
        assertTrue(actualResult2, "Email должен содержать символ:'.'!");
    }

    @Test
    @DisplayName("When login and email are not equal, then true")
    void checkLoginAndEmail() {
        boolean actualResult = user1.getLogin().equals(user1.getEmail());
        assertFalse(actualResult, "Логин и email не должны быть равны!");
    }
}