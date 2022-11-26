package com.autoirrigate.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_plot")
public class Plot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Double size;

    @Column(name="createdon")
    private Date createdOn;

    @Column(name="updatedon")
    private Date updatedOn;
}
