package org.example;

import javax.persistence.*;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instractor")
public class instrauctor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "Id")
    private int id ;
@Column(name = "fname")
    private String fname ;
@Column (name = "lname")
    private String lname ;
@Column (name = "email")
    private String email ;
@OneToMany(mappedBy = "instrauctor" ,
        cascade = {CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.PERSIST
                ,CascadeType.REFRESH})
private List <course> courses;
// set up mapping
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instractor_Id")
    private instraucrtor_Detail instraucrtorDetail;

    public instrauctor() {
    }

    public instrauctor(String fname, String lname, String email) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "instrauctor{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", instraucrtorDetail=" + instraucrtorDetail +
                '}';
    }

    public List<course> getCourses() {
        return courses;
    }

    public void setCourses(List<course> courses) {
        this.courses = courses;
    }

    public instraucrtor_Detail getInstraucrtorDetail() {
        return instraucrtorDetail;
    }

    public void setInstraucrtorDetail(instraucrtor_Detail instraucrtorDetail) {
        this.instraucrtorDetail = instraucrtorDetail;
    }
    // ADD CONVENIENCE METHOD FOR BI-DIRECTIONAL RELATIONSHIP
    public void add (course tempcourse)
    {
        if (courses ==null)
        {
            courses =new ArrayList<>();
        }
        courses.add(tempcourse);
        tempcourse.setInstr(this);
    }
}
