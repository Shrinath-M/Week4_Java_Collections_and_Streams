import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
}

class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;
    private int yearsOfExperience;

    public Resume(String candidateName, T jobRole, int yearsOfExperience) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getJobRole() {
        return jobRole;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String toString() {
        return candidateName + " - " + jobRole.getRoleName() + " (" + yearsOfExperience + " years experience)";
    }
}

class ResumeScreeningSystem {
    private List<Resume<? extends JobRole>> resumes = new ArrayList<>();

    public void addResume(Resume<? extends JobRole> resume) {
        resumes.add(resume);
    }

    public List<Resume<? extends JobRole>> getResumes() {
        return resumes;
    }

    public static <T extends JobRole> boolean validateResume(Resume<T> resume) {
        return resume.getYearsOfExperience() >= 1;
    }

    public static void displayResumes(List<Resume<? extends JobRole>> resumes) {
        for (Resume<? extends JobRole> resume : resumes) {
            System.out.println(resume);
        }
    }
}
public class AIResumeScreening {
    public static void main(String[] args) {
        ResumeScreeningSystem screeningSystem = new ResumeScreeningSystem();

        Resume<SoftwareEngineer> resume1 = new Resume<>("Alice Johnson", new SoftwareEngineer(), 5);
        Resume<DataScientist> resume2 = new Resume<>("Bob Smith", new DataScientist(), 3);
        Resume<ProductManager> resume3 = new Resume<>("Charlie Davis", new ProductManager(), 7);

        if (ResumeScreeningSystem.validateResume(resume1)) screeningSystem.addResume(resume1);
        if (ResumeScreeningSystem.validateResume(resume2)) screeningSystem.addResume(resume2);
        if (ResumeScreeningSystem.validateResume(resume3)) screeningSystem.addResume(resume3);

        System.out.println("AI-Driven Resume Screening System:");
        ResumeScreeningSystem.displayResumes(screeningSystem.getResumes());
    }
}

