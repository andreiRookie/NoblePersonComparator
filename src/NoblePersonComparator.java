import java.util.Comparator;

public class NoblePersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        String[] o1SurnameWords = o1.getSurname().split(" ");
        String[] o2SurnameWords = o2.getSurname().split(" ");

        if (o1SurnameWords.length != o2SurnameWords.length) {
            return o1SurnameWords.length - o2SurnameWords.length;
        } else {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }
}
