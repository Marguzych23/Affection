package ru.itis.affection.models;

import com.sun.javafx.beans.IDProperty;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @OneToMany(targetEntity = TestDetail.class, cascade = CascadeType.ALL)
    @Column(name = "test_detail_id")
    private Long id;

    @Column(name = "test_name")
    private String name;

    @Column(name = "test_popularity")
    private Integer popularity;
}
