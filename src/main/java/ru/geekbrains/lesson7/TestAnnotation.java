package ru.geekbrains.lesson7;

public class TestAnnotation {

    @BeforeSuite
    public static void start() {
        System.out.println("start");
    }

    @Test(priority = 1)
    public static void test1() {
        System.out.println(1);
    }

    @Test(priority = 2)
    public static void test2() {
        System.out.println(2);
    }

    @Test(priority = 3)
    public static void test3() {
        System.out.println(3);
    }

    @Test(priority = 4)
    public static void test4() {
        System.out.println(4);
    }

    @Test(priority = 5)
    public static void test5() {
        System.out.println(5);
    }

    @Test(priority = 6)
    public static void test6() {
        System.out.println(6);
    }

    @Test()
    public static void test7() {
        System.out.println(7);
    }

    @AfterSuite
    public static void stop() {
        System.out.println("stop");
    }
}
