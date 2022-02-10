import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();

        System.out.println("У " + mom + ", есть сын " + son);
        System.out.println();

        Person man = new PersonBuilder()
                .setName("Иван")
                .setSurname("Иванов")
                .build();
        System.out.println(man);
        System.out.println(man.hasAge());
        System.out.println(man.hasAddress());
        man.setAge(29);
        man.setAddress("Москва");
        System.out.println(man.hasAge());
        System.out.println(man.hasAddress());
        System.out.println(man);
        man.setAge(48);
        man.setAddress("Минск");
        System.out.println(man);


        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
