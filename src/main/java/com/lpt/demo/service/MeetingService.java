package com.lpt.demo.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lpt.demo.entity.Meeting;
import com.lpt.demo.repository.MeetingRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class MeetingService {
    @Autowired
    private MeetingRepository meetingRepository;

    @PostConstruct
    public void init() {
        // Load meetings from JSON file during startup
        loadMeetingsFromJson();
    }

    private void loadMeetingsFromJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Configure ObjectMapper to handle Java 8 date/time types
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            List<Meeting> meetings = Arrays.asList(objectMapper.readValue(
                    Paths.get("src/main/resources/meetings.json").toFile(),
                    Meeting[].class
            ));

            // Save meetings to the database
            meetingRepository.saveAll(meetings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Meeting> getAllMeetings() {
        return meetingRepository.findAll();
    }

    public void cancelMeeting(Long meetingId) {
        // Implement cancellation logic here
        meetingRepository.deleteById(meetingId);
    }

    public void rescheduleMeeting(Long meetingId, LocalDateTime newDateTime) {
        // Implement rescheduling logic here
        Meeting meeting = meetingRepository.getById(meetingId);
        meeting.setDate(newDateTime);
        meetingRepository.save(meeting);
    }
    public void bookMeeting(Long userId, Long mentorId, LocalDateTime meetDate) {
        // Add a new meeting
        Meeting meeting = new Meeting();
        meeting.setUserId(userId);
        meeting.setMentorId(mentorId);
        meeting.setDate(meetDate);
        meeting.setBookedAt(LocalDateTime.now());
        meetingRepository.save(meeting);
    }

    public void bookRecurringMeeting(Long userId, Long mentorId, LocalDateTime startDate, int interval, int durationInMonths) {
        // Implement recurring booking logic here
        LocalDateTime currentDateTime = startDate;
        int totalMeets = interval * 4 * durationInMonths;
        for (int i = 0; i < totalMeets; i++) {
            Meeting meeting = new Meeting();
            meeting.setUserId(userId);
            meeting.setMentorId(mentorId);
            meeting.setDate(currentDateTime);
            meeting.setBookedAt(LocalDateTime.now());

            meetingRepository.save(meeting);

            currentDateTime = currentDateTime.plusWeeks(interval);
        }
    }
}