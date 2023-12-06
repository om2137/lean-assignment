package com.lpt.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long mentorId;
    private LocalDateTime date;
    private LocalDateTime bookedAt;
    private LocalDateTime startDate;
    private int intervalMeet;
    private int durationInMonths;

    // getters and setters
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getMentorId() {
        return mentorId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public LocalDateTime getBookedAt() {
        return bookedAt;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setMentorId(Long mentorId) {
        this.mentorId = mentorId;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setBookedAt(LocalDateTime bookedAt) {
        this.bookedAt = bookedAt;
    }
    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public int getIntervalMeet() {
        return intervalMeet;
    }

    public void setInterval(int intervalMeet) {
        this.intervalMeet = intervalMeet;
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(int durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    // Constructors
    // toString, equals, hashCode methods if needed
}
