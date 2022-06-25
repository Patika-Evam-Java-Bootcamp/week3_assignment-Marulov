package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Priorties sınıfının instance'sini oluşturduk
        Priorities priorities = new Priorities();

        //Toplam eventi scanner ile alarak for'da girilen sayı kadar döndürülmesini sağladık.
        Integer totalEvents;
        List<String> events = new ArrayList<>();
        List<Student> studentsList;

        Scanner scanner = new Scanner(System.in);
        totalEvents = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < totalEvents; i++) {
            String event;
            event = scanner.nextLine();
            events.add(event);
        }
        scanner.close();
        //Priortieste tanımladığımız methoda verilerimizi gönderdik.
        studentsList = priorities.getStudentList(events);
        if (studentsList.isEmpty()) {
            System.out.println("EMPTY");
        }

        //Studentları yazdırdık.
        studentsList.forEach(System.out::println);
    }
}