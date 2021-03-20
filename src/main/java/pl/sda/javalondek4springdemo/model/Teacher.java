package pl.sda.javalondek4springdemo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Address address;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "teacher")
    private List<Course> courseList;

    public Teacher() {
    }

    public Teacher(Address address, List<Course> courseList) {
        this.address = address;
        this.courseList = courseList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", address=" + address +
                ", courseList=" + courseList +
                '}';
    }
}
