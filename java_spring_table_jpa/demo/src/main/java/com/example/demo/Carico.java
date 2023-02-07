package com.example.demo;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Setter
@Getter
@Entity
@NoArgsConstructor
public class Carico {
    @Id
    private Integer id;

    @Column(name = "end",nullable=false, length=6)
    private Date end;

    @Column(name = "log",nullable=false)
    private Long log;

    @Column(name = "start",nullable=false, length=6)
    private Date start;

    @Column(name = "stato",nullable=false, length=255)
    private String stato;

    @Column(name = "idtc",nullable=false, length=255)
    private String idtc;

    @Column(name = "id_uploader",nullable=false, length=255)
    private String id_uploader;

    @OneToMany(mappedBy = "idc",fetch = FetchType.EAGER)
    private Set<Doc> idc;

    public Carico(Integer id, Date end, Long log, Date start, String stato, String idtc,
            String id_uploader) {
        this.id = id;
        this.end = end;
        this.log = log;
        this.start = start;
        this.stato = stato;
        this.idtc = idtc;
        this.id_uploader = id_uploader;
    }


    

}
