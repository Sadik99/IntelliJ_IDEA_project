package org.example.model;

import com.github.slugify.Slugify;

import java.io.IOException;
import java.util.*;

public class CourseIdea {
    private String slug;
    private String title;
    private String creator;
    private Set<String> voters;

    public CourseIdea(String title, String creator) {
        voters=new HashSet<>();
        this.title = title;
        this.creator = creator;
        Slugify slugify= Slugify.builder().underscoreSeparator(true).build();
        slug = slugify.slugify(title);
    }

    public String getTitle() {
        return title;
    }

    public String getCreator() {
        return creator;
    }

    public String getSlug() { return slug; }
    public List<String> getVoters(){
        return new ArrayList<>(voters);
    }
    public boolean addVoter(String voterUserName){
        return voters.add(voterUserName);
    }
    public int getVoteCount(){
        return voters.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseIdea that = (CourseIdea) o;
        if (!Objects.equals(title, that.title)) return false;
        return Objects.equals(creator, that.creator);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        return result;
    }
}
