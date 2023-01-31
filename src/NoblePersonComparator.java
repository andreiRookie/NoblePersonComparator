import java.util.Comparator;

public class NoblePersonComparator implements Comparator<Person> {

    private int maxWordsInSurname;
    public NoblePersonComparator(int maxWordsInSurname) {
        this.maxWordsInSurname = maxWordsInSurname;
    }
    @Override
    public int compare(Person o1, Person o2) {
        String[] o1SurnameWords = o1.getSurname().split("-");
        String[] o2SurnameWords = o2.getSurname().split("-");

        int o1Count = o1SurnameWords.length;
        int o2Count = o2SurnameWords.length;

        if (o1Count >= maxWordsInSurname && o2Count >= maxWordsInSurname) {
            return Integer.compare(o1.getAge(), o2.getAge());
        } else if (o1Count != o2Count) {
            return o1Count - o2Count;
        } else {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }
}
