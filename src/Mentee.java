public class Mentee{
    public String name;
    public int experience;
    public String field;
    public int time;
    public String school;
    public Mentor[] preferences;
    public int score;
    public boolean matched;
    public Mentor myMentor;

    public Mentee(String n,int experienceLevel, String fieldOfWork, int timeAvailable, String mentorsSchool){
        name = n;
        experience = experienceLevel;
        field = fieldOfWork;
        time = timeAvailable;
        school = mentorsSchool;
        matched = false;
    }

    public void setPrefs(Mentor[] mentorsPref){
        this.preferences = mentorsPref;
    }

    public void setMyMentor(Mentor m){
        this.myMentor = m;
    }
    public void printMentee(){
        System.out.println("Degree: " + experience);
        System.out.println("Field: " + field);
        System.out.println("Time avaiable: " + time + " hours a week");
        System.out.println("Alumni of: " + school);
    }
}
