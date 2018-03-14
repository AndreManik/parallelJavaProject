package ru.parallelProject.parallel.model;

public abstract class NamedEntity extends BaseEntity{
    protected String name;

    public NamedEntity() {
    //NAN
    }

    protected NamedEntity(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
