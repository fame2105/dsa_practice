package javaReflection;

/**
 * How to get the Class instance ...
 * Method 1 :   Class<?> clss = hello.getClass();
 * Method 2 :   Class<?> clss = String.class;
 * Method 1 :   Class<?> clss = Class.forName("java.lang.String);
 */
public class Example1 {
    public static void main(String[] args) {
        String hello = "Hello";

        // 1st Way
        Class<?> helloClass1 = hello.getClass();
        print(helloClass1.getName());

        // 2nd Way
        Class<? extends String> helloClass2 = hello.getClass();
        print(helloClass2.getName());

        // 3rd Way
        Class<? extends Object> helloClass3 = hello.getClass();
        print(helloClass3.getName());

        // 4th Way
        Class<?> stringClass1 = String.class;
        print(helloClass1.getName());

        String className = "java.lang.String";
        try {
            // 5th Way
            Class<?> stringClass2 = Class.forName(className);
            print(stringClass2.getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    static void print(String message) {
        System.out.println(message);
    }
}
