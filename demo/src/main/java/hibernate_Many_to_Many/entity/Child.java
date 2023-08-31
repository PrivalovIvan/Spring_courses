package hibernate_Many_to_Many.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "children")
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "child_section", joinColumns = @JoinColumn(name = "child_id"), inverseJoinColumns = @JoinColumn(name = "section_id"))
    private List<Section> sections;

    public void addSectionToChild(Section section) {
        if (sections == null) {
            sections = new ArrayList<>();
        }
        sections.add(section);
    }

    public Child(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Child() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return "Children [id=" + id + ", name=" + name + ", age=" + age + "]";
    }

}
