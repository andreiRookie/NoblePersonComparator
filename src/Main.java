import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();
        list.add(new Person("Ivan", "Petrov-Gorshkov-Ivanov", 15));
        list.add((new Person("Petr", "Rimskiy-Korsakov", 20)));
        list.add((new Person("Denis", "Ilyin", 25)));
        list.add((new Person("Artem", "Petrov-Platonov-Korsakov-Sidorov", 30)));
        list.add((new Person("Igor", "Denisov-Sidorov", 35)));
        list.add((new Person("Alex", "Ivanov-Ilyin-Korsakov", 45)));
        list.add((new Person("Sergei", "Ivanov Gavrilov", 18)));
        list.add((new Person("Nikita", "Dobrynin", 17)));

        Predicate<Person> personPredicate = (Person p) -> p.getAge() < 18;

        list.removeIf(personPredicate);

        for (Person person :
                list) {
            System.out.println(person.toString());
        }


    }
}