package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class SimpleCourseIdeaDAO implements CourseIdeaDAO{
    private List<CourseIdea> ideas;

    public SimpleCourseIdeaDAO() {
        ideas=new ArrayList<>();
    }

    @Override
    public boolean add(CourseIdea idea) {
        return ideas.add(idea);
    }

    @Override
    public List<CourseIdea> findAll() {
        return new ArrayList<>(ideas);
    }

    @Override
    public CourseIdea findBySlug(String slug) {
        try {
            return ideas.stream()
                    .filter(idea->idea.getSlug().equals(slug))
                    .findFirst()
                    .orElseThrow(NotFoundException::new);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
