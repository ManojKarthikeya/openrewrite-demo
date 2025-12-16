package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", 25, "Developer"),
            new Person("Bob", 30, "Manager"),
            new Person("Charlie", 22, "Intern")
        );

        // 1. Traditional Switch Statement (can be enhanced switch)
        for (Person p : people) {
            String message;
            switch (p.getRole()) {
                case "Developer":
                    message = "Writes code";
                    break;
                case "Manager":
                    message = "Manages team";
                    break;
                case "Intern":
                    message = "Learning";
                    break;
                default:
                    message = "Unknown role";
            }
            System.out.println(p.getName() + ": " + message);
        }

        // 2. instanceof with casting (can be pattern matching for instanceof)
        Object obj = new Person("Dave", 40, "Director");
        if (obj instanceof Person) {
            Person p = (Person) obj;
            System.out.println("Found a person: " + p.getName());
        }

        // 3. Multi-line string concatenation (can be Text Blocks)
        String html = "<html>\n" +
                      "    <body>\n" +
                      "        <h1>Hello World</h1>\n" +
                      "    </body>\n" +
                      "</html>";
        System.out.println(html);

        // 4. Stream collection (can be .toList())
        List<String> names = people.stream()
                                   .map(Person::getName)
                                   .collect(Collectors.toList());
        System.out.println("Names: " + names);
    }
}
