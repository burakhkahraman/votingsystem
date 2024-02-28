package com.heroes.votingsystem.model;

import com.heroes.votingsystem.dto.PollRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "poll")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Poll extends PollRequestDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;

    private String title;
    private String description;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL)
    private List<Option> options;
}
