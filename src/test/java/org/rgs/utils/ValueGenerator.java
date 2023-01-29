package org.rgs.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.rgs.tests.BaseTests;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ValueGenerator extends BaseTests {

    public static String randomNameGenerator() {
        StringBuilder names = new StringBuilder();
        List<String> lastName = Arrays.asList("Джонсон", "Ли", "Тернер", "Хьюстон");
        List<String> firstName = Arrays.asList("Джей", "Джордж", "Кайт", "Майк");
        List<String> middleName = Arrays.asList("Рон", "Хан", "Пратт", "Жюль");
        int random = (int) ((Math.random() * firstName.size()) - 1);
        names.append(lastName.get(random)).append(" ").append(firstName.get(random)).append(" ").append(middleName.get(random));
        return names.toString();
    }

    public static String randomAddressGenerator() {
        StringBuilder address = new StringBuilder();
        List<String> streets = Arrays.asList("ул Богайчука, д 24", "Советский проспект, д 3", "Колпинская улица, д 1", "Рыбацкий проспект, д 8");
        int random = new Random().nextInt(streets.size() + 1);
        address.append("г Санкт-Петербург, ").append(streets.get(random));
        return address.toString();
    }

    public static String randomPhoneNumberGenerator() {
        StringBuilder phoneNumber = new StringBuilder();
        phoneNumber.append("(9");
        phoneNumber.append(RandomStringUtils.randomNumeric(2));
        phoneNumber.append(")").append(RandomStringUtils.randomNumeric(3))
                .append("-").append(RandomStringUtils.randomNumeric(4));

        return phoneNumber.toString();
    }

    public static String stringGenerator() {
        return RandomStringUtils.randomAlphanumeric(8);
    }
}
