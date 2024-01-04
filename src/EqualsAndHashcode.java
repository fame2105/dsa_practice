import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EqualsAndHashcode {

    private static class Person {
        int id;
        String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return id == person.id && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        Person p1 = new Person(1, "Erin");
        Person p2 = new Person(2, "Mikasa");
        Person p3 = new Person(3, "Levy");
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println(set);
        int[] minus = new int[]{-1};
        System.out.println(minus);
    }
}
