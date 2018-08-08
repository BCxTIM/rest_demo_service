package com.timrusso.bcxtim.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by tmoiseev on 3/2/2018.
 */
@Entity
@Table(name = "notebook")
@ApiModel(description = "All details about notebooks")
public class Notebook implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "${notebook.id}")
    private int id;

    @ApiModelProperty(notes = "Should be a string", value = "${notebook.title}")
    @Size(min = 2, message = "title should have atleast 2 symbols")
    @Column(name = "title")
    private String title;

    @ApiModelProperty(notes = "Should be a string", value = "${notebook.author}")
    @Column(name = "author")
    private String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
