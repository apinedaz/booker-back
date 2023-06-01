package com.api.booker.models.entity;


import javax.persistence.*;

@Entity
@Table(name = "solicitude")
public class SolicitudeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer solicitude_id;

    private String date_solicitude;

    private String state;

    private String description;

    private Long value;

    @Column(name="id_user")
    private int idUser;

    @Column(name="id_book")
    private int idBook;

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int id_book) {
        this.idBook = id_book;
    }

    public Integer getSolicitude_id() {
        return solicitude_id;
    }

    public void setSolicitude_id(Integer solicitude_id) {
        this.solicitude_id = solicitude_id;
    }

    public String getDate_solicitude() {
        return date_solicitude;
    }

    public void setDate_solicitude(String date_solicitude) {
        this.date_solicitude = date_solicitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int id_user) {
        this.idUser = id_user;
    }

    public SolicitudeEntity() {
    }

    public SolicitudeEntity(String date_solicitude, String state, String description, Long value, int id_user, int id_book) {
        this.date_solicitude = date_solicitude;
        this.state = state;
        this.description = description;
        this.value = value;
        this.idUser = id_user;
        this.idBook = id_book;
    }

    @Override
    public String toString() {
        return "SolicitudeEntity{" +
                "solicitude_id=" + solicitude_id +
                ", date_solicitude='" + date_solicitude + '\'' +
                ", state='" + state + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", id_user=" + idUser +
                ", id_book=" + idBook +
                '}';
    }
}
