import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String name;
    public CourseType(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-Based Course");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment-Based Course");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-Based Course");
    }
}

class Course<T extends CourseType> {
    private String title;
    private String dept;
    private T courseType;

    public Course(String title, String dept, T courseType) {
        this.title = title;
        this.dept = dept;
        this.courseType = courseType;
    }

    public String getTitle() {
        return title;
    }

    public String getDept() {
        return dept;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return title + " (" + dept + ") - " + courseType.getName();
    }
}

class CourseCatalog {
    private List<Course<? extends CourseType>> courses = new ArrayList<>();

    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
    }

    public List<Course<? extends CourseType>> getCourses() {
        return courses;
    }

    public static void displayCourses(List<Course<? extends CourseType>> courses) {
        for (Course<? extends CourseType> course : courses) {
            System.out.println(course);
        }
    }
}

public class UniversityCourseManagement {
    public static void main(String[] args) {
        CourseCatalog catalog = new CourseCatalog();

        Course<ExamCourse> mathCourse = new Course<>("Advanced Mathematics", "Science", new ExamCourse());
        Course<AssignmentCourse> literatureCourse = new Course<>("World Literature", "Arts", new AssignmentCourse());
        Course<ResearchCourse> physicsCourse = new Course<>("Quantum Physics", "Engineering", new ResearchCourse());

        catalog.addCourse(mathCourse);
        catalog.addCourse(literatureCourse);
        catalog.addCourse(physicsCourse);

        System.out.println("University Course Catalog:");
        CourseCatalog.displayCourses(catalog.getCourses());
    }
}

