package org.javawavers.studybuddy.courses;

import java.time.LocalDate;
import java.util.Scanner;

public class AssignmentTest {

    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);

        System.out.println("εργασια:");
        String title = Scanner.nextLine();
        System.out.println("προθεσμια : (yyyy - MM - DD)");
        LocalDate deadline = LocalDate.parse(Scanner.nextLine());
        System.out.println("ωρες:");
        int hours = Scanner.nextInt();


        Assignment as = new Assignment(title, deadline, hours, null);

        long remaingdays = as.getRemainingDays(deadline);
        System.out.println(as);


    }
}
