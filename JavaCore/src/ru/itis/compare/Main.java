package ru.itis.compare;

import ru.itis.compare.comparators.HumanIdComparator;
import ru.itis.compare.models.Human;
import ru.itis.compare.models.Student;
import ru.itis.compare.models.Triangle;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Human marsel = new Human(1, 23, "Marsel");
        Human robert = new Human(2, 30, "Robert");
        Human kirill = new Human(3, 25, "Kirill");
        Human denis = new Human(4, 22, "Denis");
        Human artur = new Human(5, 23, "Artur");
        Human arturRianov = new Human(6, 23, "ArturRianov");
        Human andrey = new Human(7, 25, "Andrey");
        Human ayaz = new Human(8,25,"Ayaz");

        Human humans[] = {marsel,
                robert, kirill, denis, artur,
                arturRianov, andrey, ayaz};


        Human min = humans[0];
        for (int i = 1; i < humans.length; i++) {
            if (min.compareTo(humans[i]) > 0) {
                min = humans[i];
            }
        }
        System.out.println(min);


        Triangle triangles[] = new Triangle[] {
                new Triangle(2, 3, 4),
                new Triangle(5, 6,8),
                new Triangle(1, 1,1),
                new Triangle(2, 4,5),
                new Triangle(1, 2,1),
        };


        Triangle minTriangle = triangles[0];
        for (int i = 1; i < triangles.length; i++) {
            if (minTriangle.compareTo(triangles[i]) > 0) {
                minTriangle = triangles[i];
            }
        }


        System.out.println(minTriangle);
        Human newMin = Collections.findMin(humans);
        System.out.println(newMin);
        Triangle newMinTriangle = Collections.findMin(triangles);
        System.out.println(newMinTriangle);

        Triangle triangle = new Triangle(2, 3, 4);
        Human human = new Human(1, 23, "Marsel");

        Human minIdHuman = Collections.findMin(humans, new HumanIdComparator());
        System.out.println(minIdHuman.getName());

        // Human someHuman = findMin(humans, new TriangleAreaComparator());

        Student students[] = {
                new Student("Marsel", 515),
                new Student("Igor", 512),
                new Student("Dima", 515),
                new Student("Gosha", 519),
                new Student("Denis", 519),
                new Student("Kirill", 520)
        };

        Student student = Collections.findMin(students, null);

    }
}
