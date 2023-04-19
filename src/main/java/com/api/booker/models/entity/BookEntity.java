package com.api.booker.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer book_id;

    private String name;

    private Integer user_id;

    private String description;

    private int quality;

    private String url;

    private boolean reserved;

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean getReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public BookEntity(Integer book_id, String name, Integer user_id, String description, int quality, String url, boolean reserved) {
        this.book_id = book_id;
        this.name = name;
        this.user_id = user_id;
        this.description = description;
        this.quality = quality;
        this.url = url;
        this.reserved = reserved;
    }

    public BookEntity() {
    }

    @Override
    public String toString() {
        return "book{" +
                "book_id=" + book_id +
                ", name='" + name + '\'' +
                ", user_id=" + user_id +
                ", description='" + description + '\'' +
                ", quality=" + quality +
                ", url='" + url + '\'' +
                ", reserved=" + reserved +
                '}';
    }
}
