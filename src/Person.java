import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;

public class Person {

    private final String name;
    private final String surname;
    private int age = -1;
    private String address;

    public Person(String name, String surname, int age, String location) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = location;
    }

    public boolean hasAge() {
        return !(age < 0);
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void happyBirthday() {
        age++;
    }

    public void setAge(int age) {
        if (hasAge()) {
            System.out.println("Возраст может быть увеличен только на 1 единицу.");
            happyBirthday();
        } else {
            this.age = age;
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAge(0)
                .setAddress(this.address);
    }

    @Override
    public String toString() {
        return name + " " + surname + (age != -1 ? ", возраст - " + age : ", возраст отсутствует, ") + (address != null ? ", адрес - " + address : "адрес отсутствует");
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getAge(), getAddress());
    }
}
