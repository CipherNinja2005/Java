import java.io.*;
import java.util.*;

public class StudentCSVManager {
    private static final String FILE_PATH = "Students.csv";
    private static final String HEADER = "studentId,name,branch,marks1,marks2,marks3,marks4,marks5,percentage";

    public static void main(String[] args) {
        StudentCSVManager manager = new StudentCSVManager();
        
        System.out.println("=== STUDENT CSV CRUD OPERATIONS ===\n");
        
        // Display initial data
        System.out.println("1. READING INITIAL DATA:");
        manager.displayCSV();
        
        // CREATE: Add 3 new rows with marks4 and marks5 as zero
        System.out.println("\n2. CREATE OPERATION - Adding 3 new students:");
        manager.addStudent(3, "Charlie Brown", "Electrical", 90, 85, 88, 0, 0);
        manager.addStudent(4, "Diana Prince", "Civil", 92, 89, 91, 0, 0);
        manager.addStudent(5, "Eve Wilson", "Computer Science", 87, 84, 90, 0, 0);
        manager.displayCSV();
        
        // UPDATE: Update marks4 and marks5 for all students
        System.out.println("\n3. UPDATE OPERATION - Updating marks4 and marks5:");
        manager.updateMarks(3, 89, 91);
        manager.updateMarks(4, 88, 90);
        manager.updateMarks(5, 86, 92);
        manager.displayCSV();
        
        // Calculate and update percentage for all students
        System.out.println("\n4. CALCULATE & UPDATE PERCENTAGE:");
        manager.calculateAndUpdatePercentages();
        manager.displayCSV();
        
        // DELETE: Delete a row
        System.out.println("\n5. DELETE OPERATION - Deleting student with ID 2:");
        manager.deleteStudent(2);
        manager.displayCSV();
        
        // Demonstrate exception handling
        System.out.println("\n6. EXCEPTION HANDLING DEMONSTRATION:");
        manager.demonstrateException();
        
        System.out.println("\n=== ALL OPERATIONS COMPLETED ===");
    }
    
    // CREATE: Add new student record
    public void addStudent(int id, String name, String branch, 
                          int marks1, int marks2, int marks3, int marks4, int marks5) {
        try (FileWriter fw = new FileWriter(FILE_PATH, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            
            double percentage = calculatePercentage(marks1, marks2, marks3, marks4, marks5);
            String record = String.format("%d,%s,%s,%d,%d,%d,%d,%d,%.1f",
                id, name, branch, marks1, marks2, marks3, marks4, marks5, percentage);
            out.println(record);
            System.out.println("   Added: " + name + " (ID: " + id + ")");
            
        } catch (IOException e) {
            System.err.println("ERROR: Failed to add student - " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // READ: Display all records
    public void displayCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            System.out.println("   " + "-".repeat(120));
            while ((line = br.readLine()) != null) {
                System.out.println("   " + line);
            }
            System.out.println("   " + "-".repeat(120));
            
        } catch (IOException e) {
            System.err.println("ERROR: Failed to read file - " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // UPDATE: Update marks for a specific student
    public void updateMarks(int studentId, int marks4, int marks5) {
        List<String> records = new ArrayList<>();
        boolean updated = false;
        
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("studentId")) {
                    records.add(line);
                } else {
                    String[] fields = line.split(",");
                    if (Integer.parseInt(fields[0]) == studentId) {
                        fields[6] = String.valueOf(marks4);
                        fields[7] = String.valueOf(marks5);
                        double percentage = calculatePercentage(
                            Integer.parseInt(fields[3]),
                            Integer.parseInt(fields[4]),
                            Integer.parseInt(fields[5]),
                            Integer.parseInt(fields[6]),
                            Integer.parseInt(fields[7])
                        );
                        fields[8] = String.format("%.1f", percentage);
                        records.add(String.join(",", fields));
                        updated = true;
                        System.out.println("   Updated marks for student ID " + studentId);
                    } else {
                        records.add(line);
                    }
                }
            }
            
            // Write back to file
            try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH))) {
                for (String record : records) {
                    pw.println(record);
                }
            }
            
            if (!updated) {
                System.out.println("   Student ID " + studentId + " not found");
            }
            
        } catch (IOException e) {
            System.err.println("ERROR: Failed to update marks - " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("ERROR: Invalid number format in CSV - " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // Calculate percentage based on 5 marks
    private double calculatePercentage(int m1, int m2, int m3, int m4, int m5) {
        return (m1 + m2 + m3 + m4 + m5) / 5.0;
    }
    
    // Calculate and update percentages for all students
    public void calculateAndUpdatePercentages() {
        List<String> records = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("studentId")) {
                    records.add(line);
                } else {
                    String[] fields = line.split(",");
                    double percentage = calculatePercentage(
                        Integer.parseInt(fields[3]),
                        Integer.parseInt(fields[4]),
                        Integer.parseInt(fields[5]),
                        Integer.parseInt(fields[6]),
                        Integer.parseInt(fields[7])
                    );
                    fields[8] = String.format("%.1f", percentage);
                    records.add(String.join(",", fields));
                }
            }
            
            // Write back to file
            try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH))) {
                for (String record : records) {
                    pw.println(record);
                }
            }
            
            System.out.println("   Percentages calculated and updated for all students");
            
        } catch (IOException e) {
            System.err.println("ERROR: Failed to calculate percentages - " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("ERROR: Invalid number format in CSV - " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // DELETE: Delete a student record
    public void deleteStudent(int studentId) {
        List<String> records = new ArrayList<>();
        boolean deleted = false;
        
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("studentId")) {
                    records.add(line);
                } else {
                    String[] fields = line.split(",");
                    if (Integer.parseInt(fields[0]) == studentId) {
                        deleted = true;
                        System.out.println("   Deleted: " + fields[1] + " (ID: " + studentId + ")");
                    } else {
                        records.add(line);
                    }
                }
            }
            
            // Write back to file
            try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH))) {
                for (String record : records) {
                    pw.println(record);
                }
            }
            
            if (!deleted) {
                System.out.println("   Student ID " + studentId + " not found");
            }
            
        } catch (IOException e) {
            System.err.println("ERROR: Failed to delete student - " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("ERROR: Invalid number format in CSV - " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // Demonstrate exception handling
    public void demonstrateException() {
        System.out.println("   Attempting to read from non-existent file...");
        try (BufferedReader br = new BufferedReader(new FileReader("NonExistentFile.csv"))) {
            String line = br.readLine();
            System.out.println(line);
        } catch (FileNotFoundException e) {
            System.err.println("   CAUGHT FileNotFoundException: " + e.getMessage());
            System.out.println("   Exception handled gracefully - program continues");
        } catch (IOException e) {
            System.err.println("   CAUGHT IOException: " + e.getMessage());
            System.out.println("   Exception handled gracefully - program continues");
        }
        
        System.out.println("\n   Attempting to write to read-only directory...");
        try (PrintWriter pw = new PrintWriter(new FileWriter("/root/readonly.csv"))) {
            pw.println("This should fail");
        } catch (IOException e) {
            System.err.println("   CAUGHT IOException: " + e.getMessage());
            System.out.println("   Exception handled gracefully - program continues");
        }
    }
}