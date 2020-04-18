package com.haiming.dao;

public class StudentCourseScoreFull extends StudentCourseScore{

    private String courseName;

    private String teacherName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    private String studentName;

    public String toString(){
        return "id: " + super.getId() + ", student_id: " + super.getStudentId() + ", course_id: " + super.getCourseId()
                + ", studentName: " + studentName + ", courseName: " + courseName;
    }
}
