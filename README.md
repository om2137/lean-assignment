Demo video correction: https://drive.google.com/file/d/1TTQ4FkZQi02_9yDgZMGpP0ulu4hIaBew/view?usp=sharing

# LPT BE 5 
Deployed URL for this assignment https://lean-assignment-production.up.railway.app/api/meetings

This is my solution for the assignment that was assigned to me for backend intern position. 

**Description**

This Spring Boot application is a simple backend system for managing appointments or meetings between users/clients and mentors. The system allows users to register, search for available mentors, book recurring sessions, cancel booked sessions, and reschedule existing meetings. The application uses an in-memory H2 database for data storage and provides a set of RESTful APIs for these functionalities.

Backend is integrated with the frontend that is made with react and deployed on vercel
Frontend URL: https://lpt-frontend.vercel.app/

## API endpoints

### Get all meetings
Retrieves a list of all scheduled meetings.
	
    https://lean-assignment-production.up.railway.app/api/meetings

### 1. Rescheduling
Permits users to reschedule a booked meeting.

    https://lean-assignment-production.up.railway.app/api/meetings/{meetingId}/reschedule

### 2. Canceling
Enables users to cancel a booked meeting.

    https://lean-assignment-production.up.railway.app/api/meetings/{meetingId}/cancel
    
### 3. Book Recurring Meetings
Allows users to book recurring sessions with a mentor, specifying parameters such as 
user ID, mentor ID, start date, recurrence interval, and duration.

    https://lean-assignment-production.up.railway.app/api/meetings/book-recurring

### 4. Book Meeting
Book a single meeting, pecifying parameters such as 
user ID, mentor ID, meeting date

    https://lean-assignment-production.up.railway.app/api/meetings/book-meeting
