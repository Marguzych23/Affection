package ru.itis.affection.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@Entity
@Table(name = "user_test")
public class UserTest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_test_id")
    private Long id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne(targetEntity = Test.class)
    @JoinColumn(name = "test_id", referencedColumnName = "test_id")
    private Test test;

    private String teacherType;

    private String friendType;

    private Integer percent;

    private Date date;
}
