package ru.itis.affection.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "test_detail")
public class TestDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "test_detail_id")
    private Long id;

    @Column(name = "test_id")
    @ManyToOne(targetEntity = Test.class)
    private Long testId;

    @Column(name = "test_detail_question")
    private String question;

    @Column(name = "test_detail_answer")
    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private Test test;
}
