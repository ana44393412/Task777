package generators;

import static utils.FileReader.getLinesFromFile;
import static utils.MyMath.getDigitsSum;

public final class FioGenerator implements Generator<String> {

    private String lastName;
    private String firstName;
    private String middleName;

    private static FioGenerator instance;

    private FioGenerator() {
    }

    public static FioGenerator getInstance() {
        if (instance == null) {
            instance = new FioGenerator();
        }
        return instance;
    }

    /**
     * ФИО берутся из соответствующих файлов по индексу в листе:
     * Фамилия - сумма цифр в коде
     * Имя - сумма первых двух цифр
     * Отчество - сумма последних двух цифр.
     *
     * @param code код для генерации
     */
    @Override
    public void generateParams(final int code) {
        final int lastNameIndex = getDigitsSum(code);
        final String sex = (lastNameIndex % 2 == 0) ? "f" : "m";
        setLastNameFromFile(lastNameIndex, sex);
        setFirstNameFromFile(getDigitsSum(code / 100), sex);
        setMiddleNameFromFile(getDigitsSum(code % 100), sex);
    }

    private void setLastNameFromFile(final int i, final String sex) {
        lastName = getLinesFromFile("lastNames_" + sex).get(i);
    }

    private void setFirstNameFromFile(final int i, final String sex) {
        firstName = getLinesFromFile("names_" + sex).get(i);
    }

    private void setMiddleNameFromFile(final int i, final String sex) {
        middleName = getLinesFromFile("middleNames_" + sex).get(i);
    }

    @Override
    public String buildResponse() {
        final StringBuilder sb = new StringBuilder()
                .append(String.format("%1$s %2$s %3$s", lastName, firstName, middleName));
        return sb.toString();
    }

    @Override
    public String getResult(final int code) {
        generateParams(code);
        return buildResponse();
    }
}

