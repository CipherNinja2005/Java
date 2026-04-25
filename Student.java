public class Student {
    int PRN;
    String firstName;
    String lastName;
    int age;
    int currentYear;
    double fees;
    String branch;

    public void study(String subject, int hours) {
        System.out.println("You have utilized " + hours + " hours for the study of " + subject);
    }

    public void enroll(String courseCode) {
        System.out.println("You are enrolled in " + courseCode + " with PRN " + PRN);
    }

    void joinclub(){

    }
    
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.PRN = 197;
        s1.firstName = "Varsha";
        s1.lastName = "Rai";
        s1.age = 20;
        s1.branch = "AIML";
        s1.currentYear = 3;
        s1.fees = 350000;

        s1.enroll("AIML1235");
        s1.study("Java", 4);
    }
}
