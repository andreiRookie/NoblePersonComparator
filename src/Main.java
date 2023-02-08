import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();
        list.add(new Person("Ivan", "Petrov-Gorshkov-Ivanov", 15));
        list.add((new Person("Petr", "Rimskiy~Korsakov", 20)));
        list.add((new Person("Denis", "Ilyin", 25)));
        list.add((new Person("Artem", "Petrov-Platonov-Korsakov-Sidorov", 30)));
        list.add((new Person("Igor", "Denisov/Sidorov", 35)));
        list.add((new Person("Alex", "Ivanov-Ilyin-Korsakov", 45)));
        list.add((new Person("Sergei", "Ivanov Gavrilov", 18)));
        list.add((new Person("Nikita", "Dobrynin", 17)));

        int maxWordsInSurname = 3;
        Comparator<Person> personComparator =
                (Person p1, Person p2) -> {
//                    (?U)\W:
//                    (?U..) switches to Unicode matching
//                    \W	Matches any character which is not a word character.
                    String[] p1SurnameWords = p1.getSurname().split("(?U)\\W");
                    String[] p2SurnameWords = p2.getSurname().split("(?U)\\W");

                    int p1SurnameWordsCount = p1SurnameWords.length;
                    int p2SurnameWordsCount = p2SurnameWords.length;

                    if (p1SurnameWordsCount >= maxWordsInSurname
                            && p2SurnameWordsCount >= maxWordsInSurname) {
                        return Integer.compare(p1.getAge(), p2.getAge());
                    } else if (p1SurnameWordsCount != p2SurnameWordsCount) {
                        return p1SurnameWordsCount - p2SurnameWordsCount;
                    } else {
                        return Integer.compare(p1.getAge(), p2.getAge());
                    }
                };

        list.sort(personComparator);

        for (Person person :
                list) {
            System.out.println(person.toString());
        }
    }
}