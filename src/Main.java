import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, IntrospectionException, InvocationTargetException, NoSuchMethodException {
        Integer a = 123;
        Integer b = 123;
        System.out.println(a==b);
        String c = null;
        String[] split = c.split("//?");
/*        System.out.println("Hello World!");

        String a = "abc";
        String b = new String("abc");
        System.out.println(a == b);

        Person person = new Person("1234", "Lola", new Address("LA", "USA"));

        System.out.println(Impls.JsonConverter.convert(person));

        Set<String> set = new LinkedHashSet<>();
        set.add("a");
        set.remove("a");

        Queue q = new ArrayDeque();
        q.peek();*/

        LinkedList l = new LinkedList();
        l.add("1");
        l.add("1");

        l.remove("1");
        System.out.println(l);
   /*     set.add("a");
        set.remove("a")*/

   Set<Integer> s = new LinkedHashSet<>();
   s.add(5);
    }

}
