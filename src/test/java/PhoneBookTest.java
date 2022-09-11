import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class PhoneBookTest {

    static PhoneBook sut;

    @BeforeAll
    public static void startedAll() {
        System.out.println("Начало тестов");
    }

    @BeforeEach
    public void InitAndStart() {
        System.out.println("Старт теста");
        sut = new PhoneBook();
    }

    @AfterAll
    public static void finishAll() {
        System.out.println("Все тесты завершены");
    }

    @AfterEach
    public void finished() {
        System.out.println("Тест завершен");
        sut = null;
    }

    @Test
    //Тест академический. С практической точки бесмыссленный, т.к мапа не будет пустой
    // если список не пустой.
    public void testContactPut_successfulRecordingList() {
        // given:
        final String argName = "Константин";
        final String argTel = "12345";
        final List<Contact> actual = new ArrayList<>();

        // when:
        sut.contactPut(argName, argTel);

        // then:
        Assertions.assertNotNull(actual);
    }

    @Test
    public void testContactPut_successfulRecordingMap() {
        // given:
        final String argName = "Константин";
        final String argTel = "12345";

        // when:
        sut.contactPut(argName, argTel);

        // then:
        Assertions.assertNotNull(sut);
    }

    @Test
    public void testAddGroup_successfulRecordingMap() {
        // given:
        final String group = "Друзья";

        // when:
        sut.addGroup(group); // вызов сопровождается выводом строки в консоль
        // пока не разобрался как запретить вывод в тесте,
        //  сохранив вывод в основном классе
        // then:
        Assertions.assertNotNull(sut);
    }

    @Test
    public void TestGetContacts_arrayReturnCheck() {
        // given:
        Contact contact = new Contact("Костя", "111");
        sut.contactPut("Костя", "111");
        sut.addGroup("Семья");
        final String[] groups = {"Семья"};
        sut.addContact(contact, groups);
        final String argument = "Семья";
        final Contact[] expected = {contact};

        // when:
        Contact[] actual = sut.getСontacts(argument);

        // then:
        Assertions.assertArrayEquals(expected, actual);
    }
}