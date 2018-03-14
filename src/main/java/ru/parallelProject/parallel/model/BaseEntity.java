package ru.parallelProject.parallel.model;

public abstract class BaseEntity {

    protected Integer id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return this.id == null;
    }
}
