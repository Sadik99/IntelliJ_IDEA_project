package com.example.review;
import com.example.core.BaseEntity;
import com.example.course.Course;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Review extends BaseEntity{

    private int rating;
    private String description;
    @ManyToOne
    @JoinColumn(name = "course_ID")
    private Course course;

    public void setCourse(Course course) {
        this.course = course;
    }
    public Course getCourse() {
        return course;
    }

    public Review(int rating, String description) {
        this.rating = rating;
        this.description = description;
    }
    protected Review(){
       super();
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
