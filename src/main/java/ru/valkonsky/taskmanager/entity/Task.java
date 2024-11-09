package ru.valkonsky.taskmanager.entity;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Task {

    private int id;
    private String name;
    private String description;
    private Timestamp timestamp;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Task(int id, String name, String description, Timestamp timestamp, int userId ){
        this.id = id;
        this.name = name;
        this.description = description;
        this.timestamp = timestamp;
        this.userId =userId;
    }

    public Task(String name, String description, int userId ){
        this.name = name;
        this.description = description;
        this.timestamp =new Timestamp(ZonedDateTime.now(ZoneId.systemDefault())
                .minusDays(1)
                .with(LocalTime.of(19, 0)).toInstant().toEpochMilli());
        this.userId =userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return this.name + " " + this.timestamp;
    }


}
