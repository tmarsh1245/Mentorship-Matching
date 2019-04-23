public class Mentor{
    public int experience;
    public String field;
    public int time;
    public String school;
    public Mentee[] preferences;
    public int score;
    public int openings;

    public Mentor(int experienceLevel, String fieldOfWork, int timeAvailable, String mentorsSchool){
        experience = experienceLevel;
        field = fieldOfWork;
        time = timeAvailable;
        school = mentorsSchool;
        preferences = new Mentee[100];
        //openings = spotsOpen;
    }
//    public void printMentor(){
//        System.out.println("Degree: " + experience);
//        System.out.println("Field: " + field);
//        System.out.println("Time avaiable: " + time + " hours a week");
//        System.out.println("Alumni of: " + school);
//    }
}