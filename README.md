# Coding Club Dashboard

**One Place for Every Coder**

A comprehensive web application designed to serve as a centralized hub for managing coding club activities, member engagement, and community interaction.

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-green)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![Maven](https://img.shields.io/badge/Maven-3.9-red)

---

## 📋 Table of Contents

- [About the Project](#about-the-project)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Architecture](#architecture)
- [Database Design](#database-design)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Configuration](#configuration)
  - [Running the Application](#running-the-application)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Future Enhancements](#future-enhancements)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [License](#license)

---

## 🎯 About the Project

The Coding Club Dashboard is a **dynamic web application** that brings together all essential features a coding club needs in one unified platform. It's not just a static website - it's a fully interactive system with real-time data management.

### Purpose:
- **Streamline club management** by centralizing all activities
- **Enhance member engagement** through gamification elements
- **Improve communication** with announcements and event tracking
- **Foster healthy competition** via leaderboards and achievements

---

## ✨ Features

### 1. **Welcome Dashboard with Live Clock**
The home page greets users with a personalized welcome message and a real-time clock, creating an engaging user experience from the moment they log in.

### 2. **Quick Statistics Panel**
Users can instantly see their:
- Number of events they've joined
- Badges they've earned
- Current learning streak

### 3. **Upcoming Events Section**
All future coding club events are displayed prominently, pulled directly from the database. Members never miss important workshops, hackathons, or meetups.

### 4. **Announcements Board**
Important club announcements are displayed in a dedicated section, ensuring everyone stays informed about club activities, policy changes, or urgent updates.

### 5. **Leaderboard System**
A competitive leaderboard showcases top performers, encouraging healthy competition and recognizing member achievements publicly.

### 6. **Recent Projects Showcase**
Members can see what others are building, fostering collaboration and inspiration within the community.

### 7. **Theme Toggle**
A dark/light mode toggle accommodates user preferences and reduces eye strain during extended coding sessions.

---

## 🛠️ Technology Stack

### Backend Technologies:
- **Spring Boot 3.5.7** - Core framework providing powerful features while reducing boilerplate code
- **Java 17** - Latest Long-Term Support version ensuring stability and modern language features
- **Spring Data JPA** - Handles all database operations efficiently and type-safely
- **Spring MVC** - Web framework for building RESTful applications

### Frontend Technologies:
- **Thymeleaf** - Server-side template engine for dynamic HTML generation
- **HTML5, CSS3, JavaScript** - Standard web technologies for user interface
- **Bootstrap** (optional) - For responsive design

### Database:
- **MySQL 8.0** - Robust relational database system for secure data storage

### Build Tool:
- **Maven** - Manages project dependencies and build processes automatically

---

## 🏗️ Architecture

### MVC Pattern
The application follows the **Model-View-Controller** architecture pattern:

- **Model** - Entity classes represent database tables (Event, User, Announcement, etc.)
- **View** - Thymeleaf templates render the HTML that users see
- **Controller** - Spring MVC controllers handle HTTP requests and coordinate between model and view

### Layered Architecture
```
┌─────────────────────────────────┐
│     Presentation Layer          │  ← Thymeleaf Templates
├─────────────────────────────────┤
│     Controller Layer            │  ← Spring MVC Controllers
├─────────────────────────────────┤
│     Service Layer               │  ← Business Logic
├─────────────────────────────────┤
│     Repository Layer            │  ← Spring Data JPA
├─────────────────────────────────┤
│     Database Layer              │  ← MySQL Database
└─────────────────────────────────┘
```

### Why This Architecture?
- **Separation of Concerns** - Each layer has a specific responsibility
- **Maintainability** - Easy to update and debug individual components
- **Scalability** - Can easily add new features without affecting existing code
- **Testability** - Each layer can be tested independently

---

## 🗄️ Database Design

### Key Tables:
- **Users/Members** - Stores member profiles, credentials, and statistics
- **Events** - Contains event details like title, date, time, location, and description
- **Announcements** - Stores club-wide announcements with timestamps
- **Projects** - Tracks member projects with descriptions and links
- **Badges** - Stores achievement badges with criteria and images
- **Leaderboard** - Maintains user scores and rankings

### Relationships:
- Users can join multiple events (Many-to-Many)
- Users can earn multiple badges (Many-to-Many)
- Users can create multiple projects (One-to-Many)

All relationships are managed through JPA annotations, ensuring data integrity.

---

## 🚀 Getting Started

### Prerequisites

You need the following software installed on your system:

1. **Java Development Kit (JDK) 17**
   - Download: [Oracle JDK](https://www.oracle.com/java/technologies/downloads/#java17) or [OpenJDK](https://adoptium.net/)
   - Verify: `java -version`

2. **MySQL Database Server**
   - Download: [MySQL Community Server](https://dev.mysql.com/downloads/mysql/)
   - Or use [XAMPP](https://www.apachefriends.org/) (includes MySQL + phpMyAdmin)

3. **Maven** (Optional)
   - The project includes Maven Wrapper (`mvnw` and `mvnw.cmd`)

4. **IDE** (Recommended)
   - [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/)
   - [Eclipse IDE](https://www.eclipse.org/downloads/)
   - [VS Code](https://code.visualstudio.com/) with Java extensions

---

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/coding-club-dashboard.git
   cd coding-club-dashboard
   ```

2. **Set up MySQL Database**

   Open MySQL command line or phpMyAdmin and create a database:
   ```sql
   CREATE DATABASE coding_club_db;
   ```

3. **Configure Database Connection**

   Create or edit `src/main/resources/application.properties`:
   ```properties
   # Database Configuration
   spring.datasource.url=jdbc:mysql://localhost:3306/coding_club_db
   spring.datasource.username=root
   spring.datasource.password=your_mysql_password
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

   # JPA/Hibernate Configuration
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

   # Server Configuration
   server.port=8080

   # Thymeleaf Configuration
   spring.thymeleaf.cache=false
   ```

   **⚠️ Important:** Replace `your_mysql_password` with your actual MySQL password.

---

### Configuration

#### Database Configuration Options

- `spring.jpa.hibernate.ddl-auto=update` - Automatically creates/updates tables
- `spring.jpa.hibernate.ddl-auto=create` - Drops and creates tables on startup (use for testing)
- `spring.jpa.hibernate.ddl-auto=validate` - Only validates schema (use for production)

#### Server Port Configuration

If port 8080 is already in use, change it:
```properties
server.port=8081
```

---

### Running the Application

#### Option 1: Using Maven Wrapper (Recommended)

**Windows:**
```bash
mvnw.cmd spring-boot:run
```

#### Option 2: Using Installed Maven
```bash
mvn spring-boot:run
```

#### Option 3: Using IDE

**IntelliJ IDEA:**
1. Open the project
2. Wait for Maven dependencies to download
3. Find the main class (e.g., `DashboardAppApplication.java`)
4. Right-click → Run

**Eclipse:**
1. Import as "Existing Maven Project"
2. Right-click project → Run As → Spring Boot App

#### Option 4: Building JAR File
```bash
mvnw.cmd clean package
java -jar target/dashboard-app-0.0.1-SNAPSHOT.jar
```

---

### Accessing the Application

Once the application starts successfully, open your browser and navigate to:
```
http://localhost:8080
```

You should see the welcome page of the Coding Club Dashboard.

---

## 📖 Usage

### How It Works - Request Flow

1. **User Request**: User opens browser and navigates to `localhost:8080`
2. **Controller**: Spring MVC controller receives the HTTP request
3. **Service Layer**: Business logic is applied
4. **Repository**: Data is fetched from MySQL database using JPA
5. **View**: Thymeleaf merges data with HTML templates
6. **Response**: Final HTML page is sent back to the browser

### Example User Journey

1. User visits the dashboard homepage
2. Views quick stats showing their participation metrics
3. Checks upcoming events and RSVPs
4. Reads latest announcements
5. Views the leaderboard to see their ranking
6. Browses recent projects from other members
7. Toggles between dark/light theme based on preference

---

## 📁 Project Structure

```
dashboard-app/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/dashboardapp/
│   │   │       ├── controller/       # MVC Controllers
│   │   │       ├── model/            # Entity Classes
│   │   │       ├── repository/       # JPA Repositories
│   │   │       ├── service/          # Business Logic
│   │   │       └── DashboardAppApplication.java  # Main Class
│   │   │
│   │   └── resources/
│   │       ├── static/               # CSS, JS, Images
│   │       ├── templates/            # Thymeleaf HTML
│   │       └── application.properties # Configuration
│   │
│   └── test/                         # Unit & Integration Tests
│
├── target/                           # Compiled files (ignored by git)
├── .gitignore                        # Git ignore rules
├── pom.xml                           # Maven dependencies
├── mvnw / mvnw.cmd                   # Maven wrapper scripts
└── README.md                         # This file
```

---

## 🔮 Future Enhancements

### Phase 1 (Short-term)
- [ ] User Authentication & Authorization (Spring Security)
- [ ] Email Notifications for events
- [ ] User Profile Pages
- [ ] Event RSVP System with attendance tracking
- [ ] Search and Filter functionality

### Phase 2 (Medium-term)
- [ ] REST API for mobile applications
- [ ] File upload for project submissions
- [ ] Comments and discussion forums
- [ ] Advanced analytics dashboard
- [ ] Export reports (PDF/Excel)

### Phase 3 (Long-term)
- [ ] Native Mobile Applications (iOS/Android)
- [ ] Integration with GitHub, LinkedIn
- [ ] AI-powered recommendations
- [ ] Video conferencing integration
- [ ] Microservices architecture
- [ ] Real-time notifications using WebSockets

---

## 🐛 Troubleshooting

### Common Issues and Solutions

#### Issue 1: Port 8080 Already in Use
**Error:** `Port 8080 is already in use`

**Solution:**
```properties
# Change port in application.properties
server.port=8081
```

#### Issue 2: Cannot Connect to Database
**Error:** `Communications link failure`

**Solution:**
1. Verify MySQL is running (check Services or XAMPP)
2. Check credentials in `application.properties`
3. Verify database exists: `SHOW DATABASES;`
4. Check firewall settings

#### Issue 3: Java Version Mismatch
**Error:** `Unsupported class file major version`

**Solution:**
1. Ensure JDK 17 is installed: `java -version`
2. Set JAVA_HOME environment variable
3. Update IDE project SDK settings

#### Issue 4: Maven Dependencies Not Downloading
**Error:** `Could not resolve dependencies`

**Solution:**
```bash
# Clean and rebuild
mvnw.cmd clean install -U

# Or delete .m2 cache and retry
```

#### Issue 5: Thymeleaf Template Not Found
**Error:** `Error resolving template`

**Solution:**
1. Check template files are in `src/main/resources/templates/`
2. Verify file names match controller return values
3. Ensure `.html` extension is used

#### Issue 6: Database Tables Not Created
**Solution:**
1. Check `spring.jpa.hibernate.ddl-auto=update` in properties
2. Verify entity classes have `@Entity` annotation
3. Check database user has CREATE privileges

---

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. **Fork the repository**
2. **Create a feature branch** (`git checkout -b feature/AmazingFeature`)
3. **Commit your changes** (`git commit -m 'Add some AmazingFeature'`)
4. **Push to the branch** (`git push origin feature/AmazingFeature`)
5. **Open a Pull Request**

### Coding Standards
- Follow Java naming conventions
- Write meaningful commit messages
- Add comments for complex logic
- Write unit tests for new features
- Update documentation as needed

---

## 🙏 Acknowledgments

- Spring Boot Team for the excellent framework
- Thymeleaf for powerful templating
- MySQL for reliable database management
- The open-source community

---

## 📞 Contact & Support

- **Project Link:** https://github.com/YASH-RAJBHAR/CodingCludDashboard.git
- **Email:** yashrajbhar033@gmail.com
- **Documentation:** [Wiki](https://github.com/yourusername/coding-club-dashboard/wiki)

---

## 📊 Project Status

🟢 **Active Development** - Actively maintained and accepting contributions

---

## 🎓 Learning Resources

If you're new to the technologies used in this project:

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA Guide](https://spring.io/guides/gs/accessing-data-jpa/)
- [Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html)
- [MySQL Tutorial](https://dev.mysql.com/doc/mysql-tutorial-excerpt/8.0/en/)
- [Maven Guide](https://maven.apache.org/guides/getting-started/)

---


---

**Made with ❤️ for the Coding Community**
