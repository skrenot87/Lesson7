package ru.geekbrains.lesson7;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) throws Exception {

        Class<TestAnnotation> cl = TestAnnotation.class;
        Object testObj = cl.getDeclaredMethods();
        Method[] methods = cl.getDeclaredMethods();
        ArrayList<Method> methodArrayList = new ArrayList<>();
        Method beforeSuite = null;
        Method afterSuite = null;
        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)) {
                methodArrayList.add(m);
            }
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeSuite == null) {
                    beforeSuite = m;
                } else {
                    throw new RuntimeException("Больше одного метода");
                }

            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                if (afterSuite == null) {
                    afterSuite = m;
                } else {
                    throw new RuntimeException("Больше одного метода");
                }
            }
            methodArrayList.sort((m1, m2) -> m2.getAnnotation(Test.class).priority() - m1.getAnnotation(Test.class).priority());
        }
        if (beforeSuite != null) {
            beforeSuite.invoke(testObj, null);
        }
        for (Method m : methodArrayList) {
            m.invoke(testObj, null);
        }
        if (afterSuite != null) {
            afterSuite.invoke(testObj,null);
        }
    }

}
