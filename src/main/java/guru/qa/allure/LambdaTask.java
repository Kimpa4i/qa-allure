package guru.qa.allure;

interface StringProcessor {
    String process(String s);
}

public class LambdaTask {
    public static void main(String[] args) {
        String input = "Hello Lambda Expressions";

        // Лямбда-выражения
        StringProcessor toUpperCase = s -> s.toUpperCase();
        StringProcessor removeSpaces = s -> s.replaceAll(" ", "");
        StringProcessor replaceVowels = s -> s.replaceAll("[aeiouAEIOU]", "*");

        // Тестирование
        System.out.println(processString(input, toUpperCase));
        System.out.println(processString(input, removeSpaces));
        System.out.println(processString(input, replaceVowels));
    }

    public static String processString(String input, StringProcessor processor) {
        return processor.process(input);
    }
}