# task-management-api
## Setup Instructions

To run the application, use the following command:

```bash
docker run -p 8080:8080 test-task-management
```
The application will now be available at: http://localhost:8080

If the application does not start, then run the following commands in the application directory


```bash
docker build -t test-task-management .
docker run -p 8080:8080 test-task-management
```


## Discription of the API endpoints

### 1. Create a Task

URL: "/api/v1/tasks"

Method: POST

Body:

```json
{
    "text": "Task description",
    "status": "IN_PROGRES"
}
```

Response:

```json
{
  "id": 1,
  "text": "Task description",
  "status": "IN_PROGRES"
}
```

### 2. Update the status of a task

URL: "/api/v1/tasks/:id"

Method: PUT

Query Parameters: The new status for the task (either "IN_PROGRES" or "COMPLETED")

Response:

```json
{
  "id": 1,
  "text": "Task description",
  "status": "COMPLETED"
}
```

### 3. Delete a task

URL: "/api/v1/tasks/:id"

Method: DELETE

Response: 
HTTP Status: `204 No Content`

### 4. Retrieve a list of tasks with optional filters (status: "in progress" or "completed")

URL: "/api/v1/tasks"

Method: GET

Query Parameters: (optional) Filter tasks by status (either "IN_PROGRES" or "COMPLETED")

Response:

```json
[
  {
    "id": 1,
    "text": "Task description",
    "status": "COMPLETED"
  },
  {
    "id": 2,
    "text": "Another task",
    "status": "COMPLETED"
  }
]
```

## Notes

- The `status` field supports only the following values:
  - `IN_PROGRES`: The task is in progress.
  - `COMPLETED`: The task has been completed.
