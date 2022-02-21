# online-todo-list

<b>This project is implemented as a part of Deloitte Java Developer assignment.</b> <br><br>
It is a web application which is built using Spring Boot Framework and H2 database (in memory). 
<b>The war file is located in the target directory and the name is "online-todo-list-0.0.1-SNAPSHOT.war".</b> <br>
#### Path: https://github.com/mansichowkkar/TODO-Online-List/tree/main/target/online-todo-list-0.0.1-SNAPSHOT.war


<br>

The below description explains about the project structure, frameworks, design pattern and use cases used in this project.

### Frameworks:
1. Spring Boot Framework 2.1.1
2. Spring Boot Security
3. H2 Database (In-Memory Database)
4. JPA
5. Thymeleaf
<br>

### Design Pattern:
- This project is implemented using Spring Boot framework. I have used this framework because nowadays, this is widely used for designing the web-based application. Additionally, it a bit more comfortable to configure classes as compared to other Spring MVC frameworks.
- I have used the Model - View - Controller design pattern. Being a web application, it contains the UI component (Front End) along with back end and database. Also, it is easily possible to encapsulate POJO classes, endpoint Controller and HTML pages using MVC pattern.
<br>

### Use Cases:
The following use cases are implemented as a part of this web application:
1. User Management
  - Create a New User.
  - Log In to the portal.
  - Assign Roles to User (Eg: User, ADMIN)
2. Task Management
  - Create a new Task
  - Delete a Task.
  - Update a Task.
  - Read All tasks of a user.
<br>

### Additional Things:
- In the user management section, I have created different roles for each created user. There is a One to many relationships between User and Role. 
- <b>Spring Boot Security</b> API is used to secure web application and unauthorised access to the portal.
- Additionally, I have encrypted the password while user creation and decrypted it during loging process by using Java <b>BCryptPasswordEncoder</b> API. Also, the encrypted password is stored in the database so that even Admin can not view it.
<br>

### Steps:
1. Deploy war file using Tomcat.
2. Launch the URL: http://localhost:8080/online-todo-list-0.0.1-SNAPSHOT/
31. First Create a new User by clicking on Sign Up.
4. Go Back to Login Page and enter the credentials.
5. Add New Task.
6. Edit or Delete a created task.
# Deloitee-Online-TODO
