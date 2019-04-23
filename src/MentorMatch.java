public class MentorMatch {
    static Mentor[] enrolledMentors;
    static Mentee[] enrolledMentees;

    public static void main(String[] args){
        System.out.println("Yeet");
    }

    public static void generateMentorPreferences(){
        for(int i = 0; i < enrolledMentees.length; i++){
            for(int j = 0; j < enrolledMentors.length; j++){
                calculateScore(enrolledMentors[i], enrolledMentees[j]);
                if (enrolledMentors[i].preferences.length == 0){
                    enrolledMentors[i].preferences[0] = enrolledMentees[j];
                }
                else{
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

    public static void generateMenteePreferences(){
        for(int i = 0; i < enrolledMentees.length; i++){
            for(int j = 0; j < enrolledMentors.length; j++){
                calculateScore(enrolledMentors[j], enrolledMentees[i]);
                if (enrolledMentees[i].preferences.length == 0){
                    enrolledMentees[i].preferences[0] = enrolledMentors[j];
                }
                else{
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

    public static int calculateScore(Mentor i, Mentee j){
        int score = 0;
        score += Math.abs(i.experience - j.experience);
        if(i.field == j.field){
            score += 15;
        }
        if(i.school == j.school){
            score += 10;
        }
        score -= Math.abs(i.time - j.time);
        return score;
    }

    public static Matching[] mentorStableMatching(Mentor[] mentors, Mentee[] mentees){
        Matching[] matchings = new Matching[mentors.length];
        return matchings;
    }
}
