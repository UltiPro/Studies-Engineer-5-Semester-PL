import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<IPolaczenie> listOfPoloczenie = new ArrayList<IPolaczenie>();

        listOfPoloczenie.add(Baza.getPolaczenie());
        listOfPoloczenie.add(Baza.getPolaczenie());
        listOfPoloczenie.add(Baza.getPolaczenie());
        listOfPoloczenie.add(Baza.getPolaczenie());

        listOfPoloczenie.get(0).set(0, 'D');
        listOfPoloczenie.get(0).set(1, 'U');
        listOfPoloczenie.get(0).set(2, 'P');
        listOfPoloczenie.get(0).set(3, 'A');

        for (IPolaczenie iPolaczenie : listOfPoloczenie) {
            testing(iPolaczenie);
        }
        ;

        listOfPoloczenie.get(1).set(0, 'P');
        listOfPoloczenie.get(1).set(1, 'U');
        listOfPoloczenie.get(1).set(2, 'P');
        listOfPoloczenie.get(1).set(3, 'A');

        for (IPolaczenie iPolaczenie : listOfPoloczenie) {
            testing(iPolaczenie);
        }
        ;

        listOfPoloczenie.get(2).set(0, 'K');
        listOfPoloczenie.get(2).set(1, 'U');
        listOfPoloczenie.get(2).set(2, 'P');
        listOfPoloczenie.get(2).set(3, 'A');

        for (IPolaczenie iPolaczenie : listOfPoloczenie) {
            testing(iPolaczenie);
        }
        ;

        listOfPoloczenie.get(3).set(0, 'Z');
        listOfPoloczenie.get(3).set(1, 'U');
        listOfPoloczenie.get(3).set(2, 'P');
        listOfPoloczenie.get(3).set(3, 'A');

        for (IPolaczenie iPolaczenie : listOfPoloczenie) {
            testing(iPolaczenie);
        }
        ;
    }

    public static void testing(IPolaczenie object) {
        System.out.print(object.get(0));
        System.out.print(object.get(1));
        System.out.print(object.get(2));
        System.out.print(object.get(3) + "\n");
    }
}