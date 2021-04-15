package generators;

import person.Phone;
import utils.MyMath;

import java.util.Random;

public final class PhoneGenerator implements Generator<Phone> {

    private String number;

    private static PhoneGenerator instance;

    private PhoneGenerator() {
    }

    public static PhoneGenerator getInstance() {
        if (instance == null) {
            instance = new PhoneGenerator();
        }
        return instance;
    }

    /**
     * Номер телефона генерируется следующим образом:
     * +79[сумма цифр в коде][3 случайных числа][код].
     */
    @Override
    public void generateParams(final int code) {
        number = "+79"
                + String.format("%02d", MyMath.getDigitsSum(code))
                + String.format("%03d", new Random().nextInt(1000))
                + String.format("%04d", code);
    }

    @Override
    public Phone buildResponse() {
        return new Phone(number);
    }

    @Override
    public Phone getResult(final int code) {
        generateParams(code);
        return buildResponse();
    }
}

