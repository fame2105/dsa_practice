package prepworkAndLearn.Generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsIsNotARuntimeCheck {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        addToNames_correct(names, "Name 1");
        addToNames_correct(names, "Name 2");
        System.out.println(names);

        addToNames_incorrect(names, 2);
        System.out.println("Size of names = "+ names.size() + " Contents of names: "+ names);

        /*
        * This is where the facade of Generics falls apart... Generics is a compile time check, so at runtime this piece of code will fail due to ClassCastException.
        * TypeErasures is a compile time construct which removes all the Parameterized Types during compilation.
         */
        String name = names.get(2);
    }

    private static void addToNames_correct(List<String> names, String s) {
        names.add(s);
    }

    private static void addToNames_incorrect(List names, Object o) {
        names.add(o);
    }
}
