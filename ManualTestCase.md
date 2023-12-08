

# Meeting Application Manual Test Case File

## 1. Get All Meetings

**Description:** Verify that the system retrieves a list of all scheduled meetings.

**Steps:**

1.  Send a GET request to `https://lean-assignment-production.up.railway.app/api/meetings`.
2.  Ensure the response contains a JSON array, with the entries provided from `meeting.Json` file.

**Expected Result:** The response should be an JSON array with scheduled meetings data.

----------

## 2. Book a Recurring Meeting

**Description:** Test the functionality to book recurring meetings.

**Steps:**

1.  Send a POST request to `https://lean-assignment-production.up.railway.app/api/meetings/book-recurring`.
    -   Include parameters: userId, mentorId, startDate, interval, durationInMonths.
    -   Example Parameters:
        
        `userId=1
        mentorId=2
        startDate=2023-05-01T09:00:00
        interval=1
        durationInMonths=3` 
        
2.  Ensure the response returns HTTP Status 200.

**Expected Result:** Recurring meetings should be booked successfully.

----------

## 3. Get All Meetings After Booking

**Description:** Verify that the system returns the list of meetings after booking.

**Steps:**

1.  Send a GET request to `https://lean-assignment-production.up.railway.app/api/meetings`.
2.  Ensure the response contains the booked recurring meetings.

**Expected Result:** The response should contain the details of the booked recurring meetings.

----------

## 4. Cancel a Meeting

**Description:** Test the functionality to cancel a booked meeting.

**Steps:**

1.  Send a POST request to `https://lean-assignment-production.up.railway.app/api/meetings/{meetingId}/cancel`, where `{meetingId}` is the ID of a booked meeting.
2.  Ensure the response returns HTTP Status 200.

**Expected Result:** The meeting should be canceled successfully.

----------

## 5. Get All Meetings After Cancellation

**Description:** Verify that the system returns the updated list of meetings after cancellation.

**Steps:**

1.  Send a GET request to `https://lean-assignment-production.up.railway.app/api/meetings`.
2.  Ensure the response does not contain the canceled meeting.

**Expected Result:** The response should not contain the details of the canceled meeting.

----------

## 6. Reschedule a Meeting

**Description:** Test the functionality to reschedule a booked meeting.

**Steps:**

1.  Send a POST request to `https://lean-assignment-production.up.railway.app/api/meetings/{meetingId}/reschedule`, where `{meetingId}` is the ID of a booked meeting.
    -   Include parameters: newDateTime.
    -   Example Parameters:
        
        makefileCopy code
        
        `newDateTime=2023-05-10T10:00:00` 
        
2.  Ensure the response returns HTTP Status 200.

**Expected Result:** The meeting should be rescheduled successfully.

----------

## 7. Get All Meetings After Rescheduling

**Description:** Verify that the system returns the updated list of meetings after rescheduling.

**Steps:**

1.  Send a GET request to `https://lean-assignment-production.up.railway.app/api/meetings`.
2.  Ensure the response contains the details of the rescheduled meeting.

**Expected Result:** The response should contain the details of the rescheduled meeting.

----------

