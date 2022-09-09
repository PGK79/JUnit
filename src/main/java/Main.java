import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();

        while (true) {
            try {
                System.out.println("Выберите действие"); // по условию общение с пользователем не обязательно,
                System.out.println("1. Создание группы контактов");//но не запрещено
                System.out.println("2. Создание контакта");
                System.out.println("3. Добавление контакта в разные группы");
                System.out.println("4. Поиск контактов по группе");
                System.out.println("5. Поиск контакта по номеру телефона");
                System.out.println("6. Перечень групп с контактами");
                System.out.println("0. Выход");

                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                int inputNum;
                if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5")
                        || input.equals("6") || input.equals("0")) {
                    inputNum = Integer.parseInt(input);
                    if (inputNum == 0) {
                        System.out.println("Работа со телефонной книгой завершена.");
                        break;
                    }
                } else {
                    System.out.println("Ошибочный ввод\n");
                    continue;
                }
                switch (inputNum) {
                    case 1:
                        System.out.println("Введите имя группы контактов: ");
                        String group = scanner.nextLine();
                        book.addGroup(group);
                        System.out.println("\nГруппа успешно создана\n");
                        break;

                    case 2:
                        System.out.println("Введите имя контакта: ");
                        String contactName = scanner.nextLine();
                        System.out.println("Введите номер телефона контакта: ");
                        String numTel = scanner.nextLine();
                        book.contactPut(contactName, numTel);
                        System.out.println("\nКонтакт " + contactName + " успешно создан\n");
                        break;

                    case 3:
                        System.out.println("Введите имя группы или нескольких групп( через :) ");
                        String inputGroup = scanner.nextLine();
                        String[] groups = inputGroup.split(":");
                        System.out.println("Введите имя контакта: ");
                        String name = scanner.nextLine();
                        Contact contact = book.getСontactByName(name);
                        book.addContact(contact, groups);
                        break;

                    case 4:
                        System.out.println("Введите имя группы: ");
                        String nameGroup = scanner.nextLine();
                        book.getСontacts(nameGroup);
                        break;

                    case 5:
                        System.out.println("Введите номер телефона контакта: ");
                        String numeroTel = scanner.nextLine();
                        book.getСontactByPhone(numeroTel);
                        break;

                    case 6:
                        book.viewingContactGroups();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ошибка\n");
            }
        }
    }
}