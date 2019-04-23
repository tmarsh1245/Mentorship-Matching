public class Mentee {
    public int experience;
    public String field;
    public int time;
    public String school;
    public Mentor[] preferences;
    public int score;

    Mentee(int experienceLevel, String fieldOfWork, int timeAvailable, String mentorsSchool, int spotsOpen){
        experience = experienceLevel;
        field = fieldOfWork;
        time = timeAvailable;
        school = mentorsSchool;
    }
    public void printMentee(){
        System.out.println("Degree: " + experience);
        System.out.println("Field: " + field);
        System.out.println("Time avaiable: " + time + " hours a week");
        System.out.println("Alumni of: " + school);
    }
}
