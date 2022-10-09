package com.example.activity2;

public class course {
   private String course_name;
   private int course_hours;
   private int course_semester;

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getCourse_hours() {
        return course_hours;
    }

    public void setCourse_hours(int course_hours) {
        this.course_hours = course_hours;
    }

    public int getCourse_semester() {
        return course_semester;
    }

    public void setCourse_semester(int course_semester) {
        this.course_semester = course_semester;
    }

    public course(String course_name, int course_hours, int course_semester) {
        this.course_name = course_name;
        this.course_hours = course_hours;
        this.course_semester = course_semester;
    }
}
