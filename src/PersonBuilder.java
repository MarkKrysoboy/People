public class PersonBuilder {

    private String name;
    private String surname;
    private int age = -1;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть меньше нуля!");
        } else {
            this.age = age;
            return this;
        }
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (this.name == null | this.surname == null) {
            throw new IllegalStateException("Не достаточно данных для создания объекта!");
        } else
            return new Person(this.name, this.surname, this.age, this.address);
    }
}
