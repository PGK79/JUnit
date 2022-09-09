import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<Contact>> map;
    List<Contact> nonSorted = new ArrayList<>();

    public PhoneBook() {
        this.map = new HashMap<>();
    }

    public void contactPut(String contactName, String numTel) {
        nonSorted.add(new Contact(contactName, numTel));
        map.put("Не сортированные", nonSorted);
    }

    public void addGroup(String group) {
        map.put(group, new ArrayList<>());
    }

    public void viewingContactGroups() {
        System.out.println("В телефонной книге следующие группы: ");
        for (Map.Entry<String, List<Contact>> result : map.entrySet()) {
            System.out.println("  Группа " + result.getKey() + ": ");
            for (Contact contact : result.getValue()) {
                System.out.println("Контакт: " + contact.getName() + ", Номер телефона: " + contact.getPhoneNumber());
            }
        }
        System.out.println("");
    }

    public void addContact(Contact contact, String[] groups) {
        for (String s : groups) {
            List<Contact> valueGroup;
            String n = contact.getName();

            if (map.containsKey(s) && nonSorted.contains(contact)) {
                valueGroup = map.get(s);
                Contact nameContact;

                for (int i = 0; i < nonSorted.size(); i++) {
                    Contact res = nonSorted.get(i);

                    if (res.getName().equals(n)) {
                        nameContact = res;
                        valueGroup.add(nameContact);
                    }
                }
            } else System.out.println("Введены не корректные значения");
        }
        System.out.println("\nКонтакт успешно перенесен\n");
    }

    public Contact[] getСontacts(String group) {
        List<Contact> valueGroup;
        if (map.containsKey(group)) {
            valueGroup = map.get(group);
            for (int i = 0; i < valueGroup.size(); i++) {
                Contact s = valueGroup.get(i);
                Contact[] contacts = valueGroup.toArray(new Contact[valueGroup.size()]);
                for (Contact output : contacts) {
                    //System.out.println("Контакт" + output.getName() + ", Номер: " + output.getPhoneNumber());
                }
                return contacts;
            }
        }
        return null;
    }

    public Contact getСontactByPhone(String phone) {
        for (Map.Entry<String, List<Contact>> result : map.entrySet()) {
            for (Contact contact : result.getValue()) {
                String telefone = contact.getPhoneNumber();
                if (telefone.equals(phone)) {
                    String byNam = contact.getName();
                    System.out.println("Данный номер телефона принадлежит контакту: " + byNam);
                    return contact;
                }
            }
        }
        return null;
    }

    public Contact getСontactByName(String name) {
        for (Map.Entry<String, List<Contact>> result : map.entrySet()) {
            for (Contact contact : result.getValue()) {
                String namTarget = contact.getName();
                if (namTarget.equals(name)) {
                    return contact;
                }
            }
        }
        return null;
    }
}