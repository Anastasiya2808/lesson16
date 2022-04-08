import java.util.function.Function;
import java.util.function.Predicate;

public class Lambda {
    private  static void run (Operation some, double x, double y){
        double res = some.execute(x, y);
        System.out.println("Результат: " + res);
    }


    public static void main(String[] args) {
        // TODO:: объявить интерфейс Operation с одним абстрактным методом,
        // который принимает на вход два числа с плавающей точкой и возвращает число с плавающей точкой

        // TODO:: написать несколько реализаций абстрактного метода
        // если метод принимает один элемент, круглые скобки можно не ставить
        // тип данных можно не указывать , они берутся из контекста
        // тип возвращвемого , берет из интерфейса
        // если тело метода состоит из одной инструкции, {} можно не ставить
        //  если в теле метода несколько инструкций , то return ставится
        Operation plus = (first, second) -> /* return*/ first + second;
        Operation div = (first, second) -> {
            if (second == 0) return 0;
            return first / second;
        };
        System.out.println(plus);
        System.out.println(plus.execute(34,78));
        System.out.println(div.execute(45,0));
        System.out.println(div.execute(45,1));

        run(plus, 5.7, 5.2);
        run(div, 5.7, 5.2);


        // Predicate
        // TODO:: написать реализации метода test:
        // - проверка на положительное число
        // - проверка на отрицательное число
        // - проверка на четное число
        // boolean test (T t)
        Predicate<Integer> isPos = x -> x > 0;
        Predicate <Integer> isNeg = x -> x < 0;
        Predicate <Integer> isEven = x -> x % 2 == 0;

        System.out.println(isPos.test(-67)); // false
        System.out.println(isEven.test(34)); // true

        System.out.println(isPos.and(isEven).test(68)); // &&
        System.out.println(isNeg.or(isPos).test(68)); // ||

        // Function
        // Function <T, R> - примимает Integer (Е)
        // R apply (T t)
        // TODO:: написать реализации метода apply:
        // - уменьшение целого числа на 20%
        // - увеличение числа в два раза
        // - добавление к положительному числу символов " p."
        Function <Integer, Double> minus20 = x -> x * 0.8;
        Function <Integer, Integer> doubled = x -> x * 2;
        Function <Integer, String> str = x -> x + "p. ";

        // andThen - а затем ...(Например: переводим в строку...)
        System.out.println(doubled.andThen(str).apply(45));

        // TODO:: написать generic метод, который
        // принимает Predicate condition и 2 Function: trueFn и falseFn
        // и возвращает Function, в зависимости от результата предиката
    }
}

