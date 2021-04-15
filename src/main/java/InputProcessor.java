import generators.Generator;
import generators.FioGenerator;
import generators.PhysGenerator;
import generators.PhoneGenerator;
import generators.AppearanceGenerator;
import person.Person;
import person.Phone;
import person.Physical;
import person.appearance.Appearance;

public class InputProcessor {

    public final String processInput(final String input) {
        String result;

        if (input.trim().matches("\\d{4}")) {
            // Создаём Person
            final int intCode = Integer.parseInt(input);

            final Generator<String> fioGenerator = FioGenerator.getInstance();
            final String name = fioGenerator.getResult(intCode);

            final Generator<Physical> physGenerator = PhysGenerator.getInstance();
            final Physical physical = physGenerator.getResult(intCode);

            final Generator<Appearance> appearanceGenerator = AppearanceGenerator.getInstance();
            final Appearance appearance = appearanceGenerator.getResult(intCode);

            Phone phone = null;
            // добавляем телефон, только если введённый код не палиндром
            if (!input.equals(new StringBuilder(input).reverse().toString())) {
                final Generator<Phone> phoneGenerator = PhoneGenerator.getInstance();
                phone = phoneGenerator.getResult(intCode);
            }

            result = new Person(input,
                    name,
                    physical,
                    appearance,
                    phone).toString();
        } else {
            result = "Неверный ввод.";
        }
        return result;
    }
}
