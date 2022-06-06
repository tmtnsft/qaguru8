package guru.qa8.lesson;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JUnit {

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (Method declaredMethod: SimpleTest.class.getDeclaredMethods()) {
            Test test = declaredMethod.getAnnotation(Test.class);
            if (test != null) {
                try {
                declaredMethod.invoke(SimpleTest.class.getConstructor().newInstance());
                System.out.println("passed");
            } catch(InvocationTargetException e) {
                    if (e.getCause() instanceof AssertionError) {
                        System.out.println("Test " + declaredMethod.getName() + " failed: " + e.getCause().getMessage());
                        continue;
                    } else {
                        System.out.println("Test " + declaredMethod.getName() + " broken: " + e.getCause().getMessage());
                        continue;
                    }
                }
                System.out.println("Test " + declaredMethod.getName() + " passed.");
                }
        }
    }
}
