package week3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Priorities {

    //Comparator yardımı ile isterlere göre sıralamamızı yapıyoruz.
    //İlk olarak cgpa'ya göre daha sonra name'e göre en son ise id'ye göre sıralamamızı tamamladık.
    private PriorityQueue<Student> studentPriorityQueue = new PriorityQueue<>(
            Comparator.comparing(Student::getCgpa).reversed()
                    .thenComparing(Student::getName)
                    .thenComparing(Student::getId)
    );

    //Bize en sonda Student'ları verecek methodumuz.
    public List<Student> getStudentList(List<String> str) {

        //Her SERVED denildiğinde kuyruktan sıraya göre bir student çıkarıyoruz.
        //Eğer denilmezse kuyruğa öğrenci ekliyoruz.
        str.forEach(event -> {
            if (event.equals("SERVED")) {
                studentPriorityQueue.poll();
            }
            String[] elements = event.split(" ");
            studentPriorityQueue.add(new Student(Integer.valueOf(elements[1]), elements[2], Double.valueOf(elements[3])));
        });

        //Geri döndürülecek Student listemiz.
        List<Student> studentList = new ArrayList<>();
        while (!studentPriorityQueue.isEmpty()) {
            studentList.add(studentPriorityQueue.poll());
        }
        return studentList;
    }
}