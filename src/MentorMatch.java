

public class MentorMatch {
    //take in file of JSON mentors and mentees, set size based on that
    static Mentor[] enrolledMentors = new Mentor[1];
    static Mentee[] enrolledMentees = new Mentee[1];

    public static void main(String[] args){
        System.out.println("Yeet");
        Mentor m = new Mentor(10, "Computer Science", 2, "Harvard");
        Mentee n = new Mentee(3, "Computer Science", 5, "MIT");
        enrolledMentors[0] = m;
        enrolledMentees[0] = n;
        System.out.println(m.experience);
        generateMenteePreferences(enrolledMentors, enrolledMentees);
        generateMentorPreferences(enrolledMentors, enrolledMentees);
    }

    public static void generateMentorPreferences(Mentor[] enrolledMentors, Mentee[] enrolledMentees){
        for(int i = 0; i < enrolledMentors.length; i++){
            for(int j = 0; j < enrolledMentees.length; j++){
                if (j == 0){
                    enrolledMentors[i].preferences[0] = enrolledMentees[j];
                }
                else{
                    calculateMenteeScore(enrolledMentors[i], enrolledMentees[j]);
                    if(enrolledMentees[j].score > enrolledMentors[i].preferences[j-1].score){
                        enrolledMentors[i].preferences[j] = enrolledMentors[i].preferences[j-1];
                        enrolledMentors[i].preferences[j-1] = enrolledMentees[j];
                    }
                    else{
                        enrolledMentors[i].preferences[j] = enrolledMentees[j];
                    }
                }
            }
        }
    }

    public static void generateMenteePreferences(Mentor[] enrolledMentors, Mentee[] enrolledMentees){
        for(int i = 0; i < enrolledMentees.length; i++){
            for(int j = 0; j < enrolledMentors.length; j++){
                if (j == 0){
                    enrolledMentees[i].preferences[0] = enrolledMentors[j];
                }
                else{
                    calculateMentorScore(enrolledMentors[j], enrolledMentees[i]);
                    if(enrolledMentors[j].score > enrolledMentees[i].preferences[j-1].score){
                        enrolledMentees[i].preferences[j] = enrolledMentees[i].preferences[j-1];
                        enrolledMentees[i].preferences[j-1] = enrolledMentors[j];
                    }
                    else{
                        enrolledMentees[i].preferences[j] = enrolledMentors[j];
                    }
                }
            }
        }
    }

    public static int calculateMentorScore(Mentor i, Mentee j){
        int score = 0;
        score += Math.abs(i.experience - j.experience);
        if(i.field == j.field){
            score += 20;
        }
        if(i.school == j.school){
            score += 10;
        }
        return score;
    }

    public static int calculateMenteeScore(Mentor i, Mentee j){
        int score = 0;
        if(i.field == j.field){
            score += 15;
        }
        if(i.school == j.school){
            score += 10;
        }
        score -= Math.abs(i.time -j.time);
        return score;
    }

    public static Matching[] mentorStableMatching(Mentor[] mentors, Mentee[] mentees){
        Matching[] matchings = new Matching[mentors.length];
        return matchings;
    }
}
