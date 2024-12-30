package org.javawavers.studybuddy.courses;



import java.util.List;
import java.time.LocalDate;
import java.time.DayOfWeek;

public class Day {
    int availability;
    List<Task> dayTasks;

    public Day (int availability, List<Task> dayTasks) {
        this.availability = availability;
        this.dayTasks = dayTasks;
    }
}

