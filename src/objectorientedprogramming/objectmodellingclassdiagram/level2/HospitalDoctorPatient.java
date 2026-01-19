
package objectorientedprogramming.objectmodellingclassdiagram.level2;
import java.util.ArrayList;

class Patient {
    String name;
    String patientId;
    String ailment;

    public Patient(String name, String patientId, String ailment) {
        this.name = name;
        this.patientId = patientId;
        this.ailment = ailment;
    }

    public void displayDetails() {
        System.out.println("Patient: " + name + " (" + patientId + ") - " + ailment);
    }
}

class Doctor {
    String name;
    String doctorId;
    String specialization;
    ArrayList<Patient> patients;

    public Doctor(String name, String doctorId, String specialization) {
        this.name = name;
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    public void consult(Patient patient) {
        patients.add(patient);
        System.out.println("Dr. " + name + " consulting " + patient.name + " for " + patient.ailment);
    }

    public void displayPatients() {
        System.out.println("\nDr. " + name + " (" + specialization + ")");
        System.out.println("Patients:");
        for (Patient patient : patients) {
            System.out.println("  - " + patient.name + " (" + patient.ailment + ")");
        }
    }
}

class Hospital {
    String hospitalName;
    ArrayList<Doctor> doctors;
    ArrayList<Patient> patients;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void registerPatient(Patient patient) {
        patients.add(patient);
    }

    public void displayHospitalInfo() {
        System.out.println("\n=== " + hospitalName + " ===");
        System.out.println("Total Doctors: " + doctors.size());
        System.out.println("Total Patients: " + patients.size());
    }
}

public class HospitalDoctorPatient {
    public static void main(String[] args) {
        System.out.println("=== Hospital, Doctors, and Patients ===\n");

        // Create Hospital
        Hospital hospital = new Hospital("City General Hospital");

        // Create Doctors
        Doctor doctor1 = new Doctor("Alice Johnson", "D001", "Cardiologist");
        Doctor doctor2 = new Doctor("Bob Smith", "D002", "Neurologist");
        Doctor doctor3 = new Doctor("Charlie Brown", "D003", "General Physician");

        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addDoctor(doctor3);

        // Create Patients
        Patient patient1 = new Patient("John Doe", "P001", "Heart Disease");
        Patient patient2 = new Patient("Jane Smith", "P002", "Migraine");
        Patient patient3 = new Patient("Bob Johnson", "P003", "Fever");
        Patient patient4 = new Patient("Sarah Connor", "P004", "Chest Pain");

        hospital.registerPatient(patient1);
        hospital.registerPatient(patient2);
        hospital.registerPatient(patient3);
        hospital.registerPatient(patient4);

        // Doctors consult patients (Association with communication)
        System.out.println("Consultations:");
        doctor1.consult(patient1);
        doctor1.consult(patient4);
        doctor2.consult(patient2);
        doctor3.consult(patient3);

        // Display hospital info
        hospital.displayHospitalInfo();

        // Display doctor's patients
        doctor1.displayPatients();
        doctor2.displayPatients();
    }
}
