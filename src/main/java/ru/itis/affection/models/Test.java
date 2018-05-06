package ru.itis.affection.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "test_name")
    private String name;

    @Column(name = "test_popularity")
    private Integer popularity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "test")
    private List<TestDetail> testDetails;
}
