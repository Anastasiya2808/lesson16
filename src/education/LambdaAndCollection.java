package education;

import education.University;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaAndCollection {
    public static void main(String[] args) {
        University university = new University();
        university.addCourses(Course.getInstances(15));

        // void accept (T t);
        // перебор коллекции - метод foreach
        Consumer <Course> soutCourse = course -> System.out.println(course);
        university.getCourses().forEach(soutCourse);
        university.getCourses().forEach(course -> System.out.println(course));
        // :: ссылка на метод
        university.getCourses().forEach(System.out::println);

        // TODO:: увеличить стоимость каждого курса на 10%
        university.getCourses().forEach(course -> course.setPrice(course.getPrice() * 1.1));

        // TODO:: вывести названия каждого курса
        university.getCourses().forEach(course -> System.out.println(course.getName()));

        // TODO:: удалить из коллекции курсы, если их строго стоимость меньше 15000
        university.getCourses().removeIf(course -> course.getPrice() < 15000 );

        // TODO:: написать реализацию метода getFilteredCourses, который принимает на вход Predicate<education.Course>
        //  и возвращает список отфильтрованных данным предикатом курсов университета

        // TODO::написать предикаты, которые возвращают true, если:
        //  1) курс дешевле 20000
        Predicate<Course> lessPrice = course -> course.getPrice() < 20000;

        //  2) продолжительность курса 3 месяца или меньше
        Predicate<Course> lessDuration = course -> course.getDuration() <= 3;

        //  3) название курса JJD
        Predicate<Course> jjd = course -> course.getName().equalsIgnoreCase("jjd");


        // TODO:: Отфильтровать:
        // 1. дешевле 20000
        List<Course> filtered = university.getFilteredCourses(lessPrice);
        filtered.forEach(System.out::println);

        // 2. дешевле 20000 и меньше 3-х месяцев
        filtered = university.getFilteredCourses(lessPrice.and(lessDuration));
        filtered.forEach(System.out::println);

        // 3. JJD  или дешевле 20000
        filtered = university.getFilteredCourses(jjd.or(lessPrice));
        filtered.forEach(System.out::println);

        System.out.println("----- Comparator ------");
        // int compare (T o1, T o2)
        // compare - сравнивать
        Comparator <Course> byName = (course1, course2) -> course2.getName().compareTo(course1.getName());

        // "JJD", "Node js", "Python", "C++"
        university.getCourses().sort(byName);
        university.getCourses().forEach(System.out::println);

        Comparator<Course> byDuration = (course1, course2) -> course1.getDuration() - course2.getDuration();
       // Comparator<education.Course> byDuration =
       //          (course1, course2) -> {
       //     if (course1.getDuration() < course2.getDuration()) return -1;
       //     if (course1.getDuration() > course2.getDuration()) return 1;
       // };

        university.getCourses().sort(byName.thenComparing(byDuration));


    }
}
