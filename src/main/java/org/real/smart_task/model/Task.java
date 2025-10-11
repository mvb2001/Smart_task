package org.real.smart_task.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "task")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime deadline;

    @Column(nullable = false)
    private int importance;

    private String category;
    private String filePath;

    @Column(nullable = true)
    private int priorityScore;

    @PrePersist
    @PreUpdate
    public void calculatePriorityScore() {
        long hoursUntilDeadline = Math.max(1, Duration.between(LocalDateTime.now(), deadline).toHours());
        int urgency = (int) (1000 / hoursUntilDeadline);
        this.priorityScore = (importance * 2) + urgency;
    }
}
