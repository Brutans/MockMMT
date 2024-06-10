package utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import com.example.SpringTest.entity.PersonEntity;

public class GenerateUser {
    private static Random r = new Random();
    private static List<String> firstNamesMale = Arrays.asList("Александр", "Даниил", "Ярослав");
    private static List<String> lastNamesMale = Arrays.asList("Андреев", "Лермонтов", "Пушкин");
    private static List<String> patronymicMale = Arrays.asList("Александрович", "Иванович", "Ярополкович");
    private static List<String> firstNamesFemale = Arrays.asList("Алина", "Екатерина", "Ульяна");
    private static List<String> patronymicFemale = Arrays.asList("Александровна", "Ивановна", "Юрьевна");
    private static List<String> lastNamesFemale = Arrays.asList("Ёлкина", "Макарова","Орлова");
    public static String randomFirstName(boolean female) {
        return female ? firstNamesFemale.get(r.nextInt(3)) : firstNamesMale.get(r.nextInt(3));
    }

    public static String randomLastName(boolean female) {
        return female ? lastNamesFemale.get(r.nextInt(3)) : lastNamesMale.get(r.nextInt(3));
    }

    public static String randomPatronymic(boolean female) {
        return female ? patronymicFemale.get(r.nextInt(3)) : patronymicMale.get(r.nextInt(3));
    }
    public static PersonEntity generateRandomUser(PersonEntity person){
        String phone = "+7(" + (r.nextInt(899) + 100) + ")" + (r.nextInt(899)
                + 100) +
                "-" + (r.nextInt(89) + 10) + "-" + (r.nextInt(89) + 10);
        boolean female = r.nextInt(2) == 0;
        if (person.getFirstName() == null){
            person.setFirstName(randomFirstName(female));
        }
        if (person.getLastName() == null){
            person.setLastName(randomLastName(female));
        }
        if (person.getPatronymic() == null){
            person.setPatronymic(randomPatronymic(female));
        }
        if (person.getEmail() == null){
            person.setEmail(StringGenerator.generateRandomEmail(6));
        }
        if (person.getPhoneNumber() == null){
            person.setPhoneNumber(phone);
        }
        if (person.getSkype() == null){
            person.setSkype("live:"+StringGenerator.genLatin(8));
        }
        if (person.getTelegram() == null){
            person.setTelegram(StringGenerator.genLatin(8));
        }
        if (person.getMaxExplorers() == 0){
            person.setMaxExplorers(
                    person.getIsKeeper().equals(true) ? r.nextInt(4) : 0
            );
        }
        return person;
    }
}
