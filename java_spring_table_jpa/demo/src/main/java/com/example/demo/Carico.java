package com.example.demo;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Carico {
    @Id
    private Integer id;

    @Column(name = "end",nullable=false, length=6)
    private LocalDateTime end;

    @Column(name = "log",nullable=false)
    private Long log;

    @Column(name = "start",nullable=false, length=6)
    private LocalDateTime start;

    @Column(name = "stato",nullable=false, length=255)
    private String stato;

    @Column(name = "idtc",nullable=false, length=255)
    private String idtc;

    @Column(name = "id_uploader",nullable=false, length=255)
    private String id_uploader;

    @OneToMany(mappedBy = "idc",fetch = FetchType.EAGER)
    private Set<Doc> idc;





}
