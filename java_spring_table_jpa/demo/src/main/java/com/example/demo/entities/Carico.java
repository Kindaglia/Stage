package com.example.demo.entities;

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
    private Date end;
    private Long log;
    private Date start;
    private String stato;
    private Integer idtc;
    private Integer id_uploader;

    @OneToMany(mappedBy = "idc",fetch = FetchType.EAGER)
    private Set<Doc> idc;

    public Carico(Integer id, Date end, Long log, Date start, String stato, Integer idtc,
    Integer id_uploader) {
        this.id = id;
        this.end = end;
        this.log = log;
        this.start = start;
        this.stato = stato;
        this.idtc = idtc;
        this.id_uploader = id_uploader;
    }


    

}
