package hello.hellospring.domain;

import jakarta.persistence.*;

@Entity // 어노테이션을 적어주는 순간 jpa가 관리하는 entity가 된다
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name="username")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
