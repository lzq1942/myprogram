package com.myprogram.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/1/19 0019.
 */
@Entity
@Table(name="tb_grade")
public class Grade {
    private int gno;
    private String gname;
    private int gchinese;//语文
    private int gmath;//数学
    private int genglish;//英语
    private int gphysical;//物理
    private int pchemistry;//化学
    private int pbiology;//生物

    //一科成绩对应一个学生
    private Stu stu;


    public Grade() {
    }

    public Grade(int gno, String gname, int gchinese, int gmath, int genglish, int gphysical, int pchemistry, int pbiology) {
        this.gno = gno;
        this.gname = gname;
        this.gchinese = gchinese;
        this.gmath = gmath;
        this.genglish = genglish;
        this.gphysical = gphysical;
        this.pchemistry = pchemistry;
        this.pbiology = pbiology;
    }

    public Grade(int gno, String gname, int gchinese, int gmath, int genglish, int gphysical, int pchemistry, int pbiology, Stu stu) {
        this.gno = gno;
        this.gname = gname;
        this.gchinese = gchinese;
        this.gmath = gmath;
        this.genglish = genglish;
        this.gphysical = gphysical;
        this.pchemistry = pchemistry;
        this.pbiology = pbiology;
        this.stu = stu;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getGno() {
        return gno;
    }

    public void setGno(int gno) {
        this.gno = gno;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public int getGchinese() {
        return gchinese;
    }

    public void setGchinese(int gchinese) {
        this.gchinese = gchinese;
    }

    public int getGmath() {
        return gmath;
    }

    public void setGmath(int gmath) {
        this.gmath = gmath;
    }

    public int getGenglish() {
        return genglish;
    }

    public void setGenglish(int genglish) {
        this.genglish = genglish;
    }

    public int getGphysical() {
        return gphysical;
    }

    public void setGphysical(int gphysical) {
        this.gphysical = gphysical;
    }

    public int getPchemistry() {
        return pchemistry;
    }

    public void setPchemistry(int pchemistry) {
        this.pchemistry = pchemistry;
    }

    public int getPbiology() {
        return pbiology;
    }

    public void setPbiology(int pbiology) {
        this.pbiology = pbiology;
    }

    @ManyToOne
    @JoinColumn(name = "stu_sname")
    public Stu getStu() {
        return stu;
    }

    public void setStu(Stu stu) {
        this.stu = stu;
    }
}
