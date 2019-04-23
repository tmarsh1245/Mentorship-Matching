public class Mentee{
    public int experience;
    public String field;
    public int time;
    public String school;
    public Mentor[] preferences;
    public int score;

    public Mentee(int experienceLevel, String fieldOfWork, int timeAvailable, String mentorsSchool){
        experience = experienceLevel;
        field = fieldOfWork;
        time = timeAvailable;
        school = mentorsSchool;
        preferences = new Mentor[100];
    }
    public void printMentee(){
        System.out.println("Degree: " + experience);
        System.out.println("Field: " + field);
        System.out.println("Time avaiable: " + time + " hours a week");
        System.out.println("Alumni of: " + school);
    }
}
