public class Mentor{
    public String name;
    public int experience;
    public String field;
    public int time;
    public String school;
    public Mentee[] preferences;
    public int score;
    public boolean matched;
    public Mentee myMentee;

    public Mentor(String n, int experienceLevel, String fieldOfWork, int timeAvailable, String mentorsSchool){
        name = n;
        experience = experienceLevel;
        field = fieldOfWork;
        time = timeAvailable;
        school = mentorsSchool;
        matched = false;
        //openings = spotsOpen;
    }

    public void setPrefs(Mentee[] menteesPref){
        this.preferences = menteesPref;
    }

    public void setMyMentee(Mentee m){
        this.myMentee = m;
    }
//    public void printMentor(){
//        System.out.println("Degree: " + experience);
//        System.out.println("Field: " + field);
//        System.out.println("Time avaiable: " + time + " hours a week");
//        System.out.println("Alumni of: " + school);
//    }
}