package javaReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Getting Fields, Methods, Constructors and Modifiers of a Class Instance
 */
public class Example3 {
    public static void main(String[] args) {
        Person person = new Person();
        Class<?> personClass = person.getClass();

  // ---------------------------------Getting FIELDS---------------------------------------------------------------------
        try {
            Field field = person.getClass().getField("age"); // method - 1 : we need to know the name of the field we want to get the reference of.
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        Field[] declaredFields = personClass.getDeclaredFields(); // method - 2 : all fields declared in the class

        Field[] allPublicFields = personClass.getFields(); // method - 3 : public fields, including inherited

 // ---------------------------------Getting METHODS---------------------------------------------------------------------
        try {
            Method method1 = personClass.getMethod("setName", String.class); // method - 1 : we need to know the name of the method we want to get the reference of and also pass the parametersTypes that the method takes in
            Method method2 = personClass.getMethod("getName"); // method - 1 : we need to know the name of the method we want to get the reference of
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        Method[] personMethods = personClass.getDeclaredMethods(); // method - 2 : all methods declared in the class

        Method[] allPublicMehods = personClass.getMethods(); // method - 3 : public methods, including inherited

 // ---------------------------------Getting CONSTRUCTORS---------------------------------------------------------------------
        try {
            Constructor<?> constructor = personClass.getConstructor(); // method - 1 :
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors(); // method - 2 : all constructors declared in the class

        Constructor<?>[] allPubliclyDeclaredConstructors = personClass.getConstructors(); // method - 3 : unlike fields and methods, only publicly declared constructors of the class are returned

    }
}

class Person {
    int age;
    String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
