package com.api.booker.models.in;

public class SolicitudeModel {

    private String description;

    private Long value;

    private int id_user;

    private int id_book;

    public SolicitudeModel(String description, Long value, int id_user, int id_book) {
        this.description = description;
        this.value = value;
        this.id_user = id_user;
        this.id_book = id_book;
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SolicitudeModel{" +
                "description='" + description + '\'' +
                ", value=" + value +
                ", id_user=" + id_user +
                ", id_book=" + id_book +
                '}';
    }
}
