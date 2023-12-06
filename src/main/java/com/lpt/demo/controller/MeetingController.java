package com.lpt.demo.controller;

import com.lpt.demo.entity.Meeting;
import com.lpt.demo.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/meetings")
public class MeetingController {
    @Autowired
    private MeetingService meetingService;

    @GetMapping
    public List<Meeting> getAllMeetings() {
        return meetingService.getAllMeetings();
    }

    @PostMapping("/{meetingId}/cancel")
    public void cancelMeeting(@PathVariable Long meetingId) {
        meetingService.cancelMeeting(meetingId);
    }

    @PostMapping("/{meetingId}/reschedule")
    public void rescheduleMeeting(@PathVariable Long meetingId, @RequestParam LocalDateTime newDateTime) {
        meetingService.rescheduleMeeting(meetingId, newDateTime);
    }
    @PostMapping("/book-meeting")
    public void bookMeeting(@RequestParam Long userId, @RequestParam Long mentorId,
                                     @RequestParam LocalDateTime meetDate) {
        meetingService.bookMeeting(userId, mentorId, meetDate);
    }

    @PostMapping("/book-recurring")
    public void bookRecurringMeeting(@RequestParam Long userId, @RequestParam Long mentorId,
                                     @RequestParam LocalDateTime startDate, @RequestParam int interval,
                                     @RequestParam int durationInMonths) {
        meetingService.bookRecurringMeeting(userId, mentorId, startDate, interval, durationInMonths);
    }
}
