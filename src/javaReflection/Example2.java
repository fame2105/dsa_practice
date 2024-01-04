package javaReflection;

/**
 * Getting information on a Class
 * - superclass of a class instance
 * - interfaces implemented by a class instance etc.
 */

public class Example2 {
    String hello = "Hello";
    Class<?> helloClass = hello.getClass();

    // Getting the super class on a class instance
    Class<?> helloSuperClass = helloClass.getSuperclass();

    // Getting interfaces implemented by a class instance

    Class<?>[] helloClassInterfaces = helloClass.getInterfaces(); // will return empty array if String.class does not implement any interfaces



}
