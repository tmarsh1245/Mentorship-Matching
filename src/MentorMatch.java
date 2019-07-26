public class MentorMatch {
    //take in file of JSON mentors and mentees, set size based on that

    public static void main(String[] args){
        Mentor Steve = new Mentor("Steve", 10, "Computer Science", 2, "Harvard");
        Mentor Bill = new Mentor("Bill",12, "Engineering", 5, "Harvard");
        Mentor Mark = new Mentor("Mark",12, "Engineering", 5, "Harvard");
        Mentee Tanner = new Mentee("Tanner",2, "Computer Science", 5, "UMass");
        Mentee Temma = new Mentee("Temma" ,2, "Computer Science", 5, "UMass");
        Mentee Danny = new Mentee("Danny",2, "Computer Science", 5, "UMass");

        Mentor[] tannerPref = new Mentor[] {Steve, Bill, Mark};
        Tanner.setPrefs(tannerPref);
        Mentor[] dannyPref = new Mentor[] {Bill, Mark, Steve};
        Danny.setPrefs(dannyPref);
        Mentor[] temmaPref = new Mentor[] {Steve, Bill, Mark};
        Temma.setPrefs(temmaPref);

        Mentee[] stevePref = new Mentee[] {Danny, Tanner, Temma};
        Steve.setPrefs(stevePref);
        Mentee[] billPref = new Mentee[] {Danny, Tanner, Temma};
        Bill.setPrefs(billPref);
        Mentee[] markPref = new Mentee[] {Tanner, Temma, Danny};
        Mark.setPrefs(markPref);

        Mentor[] enrolledMentors = new Mentor[] {Steve, Bill, Mark};
        Mentee[] enrolledMentees = new Mentee[] {Tanner, Temma, Danny};
        //generateMenteePreferences(enrolledMentors, enrolledMentees);
        mentorStableMatching(enrolledMentors, enrolledMentees);
        printMatchings(enrolledMentors);
    }

    public static void generateMentorPreferences(Mentor[] enrolledMentors, Mentee[] enrolledMentees){
        for(int i = 0; i < enrolledMentors.length; i++){
            for(int j = 0; j < enrolledMentees.length; j++){
                int score = calculateMenteeScore(enrolledMentors[i], enrolledMentees[j]);
                System.out.println(score);
                if (j == 0){
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

    public static boolean menteePrefSwap(Mentor[] preferences, Mentor m1, Mentor m2){
        for(int i = 0; i < preferences.length; i++){
            if(preferences[i] == m1){
                return false;
            }
            if(preferences[i] == m2)
                return true;
        }
        return false;
    }

    public static String[] mentorStableMatching(Mentor[] mentors, Mentee[] mentees){
        String[] matchings = new String[mentors.length];
        int free = mentors.length;

        while(free > 0){
            int i;
            for(i = 0; i < mentors.length; i++){
                if(mentors[i].matched == false)
                    break;
            }
            Mentor currMentor = mentors[i];
            for(int j = 0; j < mentors.length && currMentor.matched == false; j++){
                //System.out.println(currMentor.name);
                Mentee currMentee = currMentor.preferences[j];
                if(currMentee.matched == false){
                    currMentee.setMyMentor(currMentor);
                    currMentor.setMyMentee(currMentee);
                    currMentor.matched = true;
                    currMentee.matched = true;
                    free--;
                    System.out.println(currMentor.name + " currently with (op1)" + currMentee.name);
                }
                else{
                    if(menteePrefSwap(currMentee.preferences, currMentor, currMentee.myMentor) == false){
                        currMentee.myMentor.matched = false;
                        currMentee.setMyMentor(currMentor);
                        currMentor.setMyMentee(currMentee);
                        currMentor.matched = true;
                        currMentee.matched = true;
                        System.out.println(currMentor.name + " currently with (op2)" + currMentee.name);
                    }
                }
            }
        }
        return matchings;
    }

    public static void printMatchings(Mentor[] m){
        for(int i = 0; i < m.length; i++){
            System.out.println(m[i].name + " mentors " + m[i].myMentee.name);
        }
    }
}


