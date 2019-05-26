package easycoding.ch05;

public class Exceptions {
    private static int x = 0;
    public static void main(String[] args) {
        int age = returnBeforeFinally();
        System.out.println(age); // 1

        try {
            checkAge(age);
        } catch (IllegalAgeException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Age is fine");
    }

    private static int returnBeforeFinally() {
        try {
            throw new Exception();
        } catch (Exception e) {
            return ++x;
        } finally {
            x = 1000; // 在 return 之后执行
        }
    }

    private static void checkAge(int age) throws IllegalAgeException {
        System.out.println("check age == " + age);
        if (age < 18) {
            throw new IllegalAgeException("Age is too low: age = " + age);
        }
    }
}
