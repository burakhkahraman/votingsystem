package com.heroes.votingsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "option")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String value;

    @Column(name = "vote_count", nullable = false)
    private int voteCount;

    @ManyToOne
    @JoinColumn(name = "poll_id", nullable = false)
    private Poll poll;
}
