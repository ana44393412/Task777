package person;

import person.appearance.Appearance;

public class Person {

    private final String id;
    private final String name;
    private final Physical phys;
    private final Appearance appearance;
    private final Phone phone;

    public Person(final String id,
                  final String name,
                  final Physical phys,
                  final Appearance appearance,
                  final Phone phone) {
        this.id = id;
        this.name = name;
        this.phys = phys;
        this.appearance = appearance;
        this.phone = phone;
    }


    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder()
                .append(id).append("\n")
                .append(String.format(name)).append("\n")
//                .append(String.format("%1$s %2$s %3$s", lastName, firstName, middleName)).append("\n")
                .append(phys).append("\n")
                .append(appearance).append("\n");
        if (phone != null) {
            sb.append(phone);
        } else {
            sb.append("Телефона нет");
        }
        return sb.toString();
    }
}