package org.jboss.repro.h8.orm.ts.sources.typeoverride.model;

/**
 * @author Gail Badner
 */
public class Entity {
    private long id;
    private String name;

    public Entity() {
    }

    public Entity(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

