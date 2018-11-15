package com.example.myspringboot.lambda;

import io.swagger.models.auth.In;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 类名称：lambdaTest<br>
 * 类描述：<br>
 * 创建时间：2018年11月13日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
public class lambdaTest {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("张三", 12),
                new Person("李四", 22),
                new Person("王五", 22),
                new Person("赵六", 18)
        );

        /*List<Person> result = persons.stream()
                .filter(person -> person.getAge()>=15)
                .sorted(Comparator.comparing(p -> p.getAge()))
                .collect(Collectors.toList());
        System.out.println(result);*/

        /*persons.forEach(person -> {person.getAge().equals(16);
            System.out.println(person);
        });*/

        List<Integer> result = persons.stream()
                .map(Person::getAge)
                .distinct()
                .collect(Collectors.toList());

        Map<Integer, List<Person>> personByAge = persons.stream()
                .collect(Collectors.groupingBy(Person::getAge));
        System.out.println(result);
        System.out.println(personByAge);
    }
}
