package it.aulab.learningplatform.dto;

import java.util.List;

public class UpdateCourseDTO {
    private String description;
    private String date;
    private List<Long> addedStudentsIds;
    private List<Long> removedStudentsIds;

    public UpdateCourseDTO() {
    }
    public List<Long> getAddedStudentsIds() {
        return addedStudentsIds;
    }
    public void setAddedStudentsIds(List<Long> addedStudentsIds) {
        this.addedStudentsIds = addedStudentsIds;
    }

    public List<Long> getRemovedStudentsIds() {
        return removedStudentsIds;
    }
    public void setRemovedStudentsIds(List<Long> removedStudentsIds) {
        this.removedStudentsIds = removedStudentsIds;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
