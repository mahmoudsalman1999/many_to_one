package org.example;

import javax.persistence.*;

@Entity
@Table (name = "instractor_detail")
public class instraucrtor_Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id ;
    @Column(name = "youtube")
    private String youtube ;
    @Column(name = "follwers")
    private String follwers ;

    public instraucrtor_Detail() {
    }

    public instraucrtor_Detail(String youtube, String follwers) {
        this.youtube = youtube;
        this.follwers = follwers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getFollwers() {
        return follwers;
    }

    public void setFollwers(String follwers) {
        this.follwers = follwers;
    }

    @Override
    public String toString() {
        return "instraucrtor_Detail{" +
                "id=" + id +
                ", youtube='" + youtube + '\'' +
                ", follwers='" + follwers + '\'' +
                '}';
    }
}
