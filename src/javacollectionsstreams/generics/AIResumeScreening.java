package JavaCollectionsStreams.generics;

import java.util.ArrayList;
import java.util.List;

// Abstract class for different job roles
abstract class JobRole {
    protected String roleName;
    protected String department;
    protected int experienceRequired;

    public JobRole(String roleName, String department, int experienceRequired) {
        this.roleName = roleName;
        this.department = department;
        this.experienceRequired = experienceRequired;
    }

    public abstract void displayRequirements();

    public String getRoleName() {
        return roleName;
    }

    public String getDepartment() {
        return department;
    }

    public int getExperienceRequired() {
        return experienceRequired;
    }
}

// Concrete job role implementations
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer", "Engineering", 2);
    }

    @Override
    public void displayRequirements() {
        System.out.println("Requirements: Java, Python, Data Structures, Algorithms, System Design");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist", "Analytics", 3);
    }

    @Override
    public void displayRequirements() {
        System.out.println("Requirements: Python, Machine Learning, Statistics, SQL, Data Visualization");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager", "Product", 4);
    }

    @Override
    public void displayRequirements() {
        System.out.println("Requirements: Product Strategy, Agile, Stakeholder Management, Market Analysis");
    }
}

// Generic Resume class with bounded type parameter
class Resume<T extends JobRole> {
    private String candidateName;
    private String email;
    private int yearsOfExperience;
    private T appliedRole;
    private List<String> skills;
    private double aiScore;

    public Resume(String candidateName, String email, int yearsOfExperience, T appliedRole) {
        this.candidateName = candidateName;
        this.email = email;
        this.yearsOfExperience = yearsOfExperience;
        this.appliedRole = appliedRole;
        this.skills = new ArrayList<>();
        this.aiScore = 0.0;
    }

    public void addSkill(String skill) {
        skills.add(skill);
    }

    public void setAiScore(double score) {
        this.aiScore = score;
    }

    public double getAiScore() {
        return aiScore;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public T getAppliedRole() {
        return appliedRole;
    }

    public void displayResumeInfo() {
        System.out.println("\n--- Resume Details ---");
        System.out.println("Candidate: " + candidateName);
        System.out.println("Email: " + email);
        System.out.println("Experience: " + yearsOfExperience + " years");
        System.out.println("Applied Role: " + appliedRole.getRoleName());
        System.out.println("Department: " + appliedRole.getDepartment());
        System.out.println("Skills: " + String.join(", ", skills));
        System.out.println("AI Score: " + String.format("%.2f", aiScore) + "/100");
    }

    public String getCandidateName() {
        return candidateName;
    }

    public List<String> getSkills() {
        return skills;
    }
}

// AI-Driven Resume Screening System
class ResumeScreeningSystem {
    private List<Resume<? extends JobRole>> allResumes = new ArrayList<>();

    // Generic method to add resume
    public <T extends JobRole> void addResume(Resume<T> resume) {
        allResumes.add(resume);
        System.out.println("✓ Resume added for: " + resume.getCandidateName());
    }

    // Generic method to screen resume with AI scoring
    public <T extends JobRole> void screenResume(Resume<T> resume) {
        System.out.println("\n--- Screening Resume: " + resume.getCandidateName() + " ---");

        // AI scoring logic based on experience and role requirements
        double baseScore = 50.0;
        int experienceGap = resume.getYearsOfExperience() - resume.getAppliedRole().getExperienceRequired();

        if (experienceGap >= 0) {
            baseScore += Math.min(experienceGap * 10, 30); // Max 30 bonus points
        } else {
            baseScore += experienceGap * 15; // Penalty for less experience
        }

        // Bonus for number of skills
        baseScore += Math.min(resume.getSkills().size() * 2, 20); // Max 20 bonus points

        resume.setAiScore(Math.max(0, Math.min(100, baseScore)));

        System.out.println("AI Screening Complete!");
        System.out.println("Score: " + String.format("%.2f", resume.getAiScore()) + "/100");

        if (resume.getAiScore() >= 70) {
            System.out.println("Status: ✓ SHORTLISTED");
        } else if (resume.getAiScore() >= 50) {
            System.out.println("Status: ⚠ UNDER REVIEW");
        } else {
            System.out.println("Status: ❌ REJECTED");
        }
    }

    // Wildcard method to process multiple resumes
    public void processResumesBatch(List<? extends Resume<? extends JobRole>> resumes) {
        System.out.println("\n========================================");
        System.out.println("      BATCH RESUME PROCESSING           ");
        System.out.println("========================================");

        for (Resume<? extends JobRole> resume : resumes) {
            screenResume(resume);
        }
    }

    // Wildcard method to display all resumes by job role
    public static void displayResumesByRole(List<? extends JobRole> roles) {
        System.out.println("\n--- Open Positions ---");
        for (JobRole role : roles) {
            System.out.println("\n• " + role.getRoleName() + " (" + role.getDepartment() + ")");
            System.out.println("  Experience Required: " + role.getExperienceRequired() + " years");
            role.displayRequirements();
        }
    }

    // Generic method to find top candidates
    public <T extends JobRole> void findTopCandidates(List<Resume<T>> resumes, int topN) {
        System.out.println("\n--- Top " + topN + " Candidates ---");

        resumes.sort((r1, r2) -> Double.compare(r2.getAiScore(), r1.getAiScore()));

        int count = 0;
        for (Resume<T> resume : resumes) {
            if (count >= topN)
                break;
            System.out.println((count + 1) + ". " + resume.getCandidateName() +
                    " - Score: " + String.format("%.2f", resume.getAiScore()));
            count++;
        }
    }

    public List<Resume<? extends JobRole>> getAllResumes() {
        return allResumes;
    }
}

public class AIResumeScreening {
    public static void main(String[] args) {
        System.out.println("=== AI-Driven Resume Screening System ===\n");

        ResumeScreeningSystem screeningSystem = new ResumeScreeningSystem();

        // Creating resumes for Software Engineers
        Resume<SoftwareEngineer> resume1 = new Resume<>("Alice Johnson", "alice@email.com",
                3, new SoftwareEngineer());
        resume1.addSkill("Java");
        resume1.addSkill("Python");
        resume1.addSkill("Data Structures");
        resume1.addSkill("Algorithms");
        resume1.addSkill("Spring Boot");

        Resume<SoftwareEngineer> resume2 = new Resume<>("Bob Smith", "bob@email.com",
                1, new SoftwareEngineer());
        resume2.addSkill("Java");
        resume2.addSkill("JavaScript");
        resume2.addSkill("React");

        // Creating resumes for Data Scientists
        Resume<DataScientist> resume3 = new Resume<>("Carol Davis", "carol@email.com",
                5, new DataScientist());
        resume3.addSkill("Python");
        resume3.addSkill("Machine Learning");
        resume3.addSkill("TensorFlow");
        resume3.addSkill("SQL");
        resume3.addSkill("Statistics");
        resume3.addSkill("Data Visualization");

        Resume<DataScientist> resume4 = new Resume<>("David Lee", "david@email.com",
                2, new DataScientist());
        resume4.addSkill("Python");
        resume4.addSkill("SQL");
        resume4.addSkill("Pandas");

        // Creating resume for Product Manager
        Resume<ProductManager> resume5 = new Resume<>("Emma Wilson", "emma@email.com",
                6, new ProductManager());
        resume5.addSkill("Product Strategy");
        resume5.addSkill("Agile");
        resume5.addSkill("Stakeholder Management");
        resume5.addSkill("Market Analysis");
        resume5.addSkill("Roadmap Planning");

        // Adding resumes to system
        System.out.println("--- Adding Resumes ---");
        screeningSystem.addResume(resume1);
        screeningSystem.addResume(resume2);
        screeningSystem.addResume(resume3);
        screeningSystem.addResume(resume4);
        screeningSystem.addResume(resume5);

        // Screening individual resumes
        screeningSystem.screenResume(resume1);
        screeningSystem.screenResume(resume3);

        // Batch processing
        List<Resume<SoftwareEngineer>> seResumes = new ArrayList<>();
        seResumes.add(resume1);
        seResumes.add(resume2);
        screeningSystem.processResumesBatch(seResumes);

        // Finding top candidates for Software Engineer
        screeningSystem.findTopCandidates(seResumes, 2);

        // Display all open positions using wildcard
        List<JobRole> openPositions = new ArrayList<>();
        openPositions.add(new SoftwareEngineer());
        openPositions.add(new DataScientist());
        openPositions.add(new ProductManager());

        ResumeScreeningSystem.displayResumesByRole(openPositions);

        System.out.println("\n--- Type Safety Benefits ---");
        System.out.println("✓ Bounded type parameters ensure only valid JobRole types");
        System.out.println("✓ Generic methods provide type-safe resume processing");
        System.out.println("✓ Wildcards enable flexible handling of multiple job roles");
        System.out.println("✓ Compile-time type checking prevents mismatched role assignments");
    }
}
