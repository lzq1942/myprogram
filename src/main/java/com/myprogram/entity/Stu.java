package com.myprogram.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by hjk on 2017/12/24.
 */
@Entity
@Table(name = "tb_stu")
public class Stu implements Serializable {
    private int sno;
    private String sname;
    private int sage;
    private String ssex;
    private String sphone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date stime;
    private String simage;

    private Cls cls;

    public Stu() {
    }

    public Stu(int sno, String sname, int sage, String ssex, String sphone, Date stime, String simage) {
        this.sno = sno;
        this.sname = sname;
        this.sage = sage;
        this.ssex = ssex;
        this.sphone = sphone;
        this.stime = stime;
        this.simage = simage;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }


    public Date getStime() {
        return stime;
    }

    @Column(columnDefinition = "date")
    public void setStime(Date stime) {
        this.stime = stime;
    }

    public String getSimage() {
        return simage;
    }

    public void setSimage(String simage) {
        this.simage = simage;
    }

    @ManyToOne
    @JoinColumn(name = "cno")
    public Cls getCls() {
        return cls;
    }

    public void setCls(Cls cls) {
        this.cls = cls;
    }
}
