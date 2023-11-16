package org.example;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table (name = "courses")
public class course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id ;
    @Column(name = "title")
    private String title ;
@ManyToOne(cascade = {CascadeType.MERGE , CascadeType.PERSIST , CascadeType.DETACH,CascadeType.REFRESH})
@JoinColumn(name = "instractor_Id"  )
private instrauctor instrauctor;

    public course() {
    }

    public course(String title) {
        this.title = title;
    }

    public org.example.instrauctor getInstrauctor() {
        return instrauctor;
    }

    public void setInstrauctor(org.example.instrauctor instrauctor) {
        this.instrauctor = instrauctor;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public instrauctor getInstr() {
        return instrauctor;
    }

    public void setInstr(instrauctor instr) {
        this.instrauctor = instr;
    }

    @Override
    public String toString() {
        return "course{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", instr=" + instrauctor +
                '}';
    }
}
