package uk.co.halfninja.randomnames;


public class Main { 

    public static void dotest() { 
        // Test 
        database.inputengscore("A1", 90);
        database.inputengscore("A2", 80);
        database.inputmathscore("A1", 95);
        database.inputmathscore("A2", 100);

//        int A1engscore = database.geteng("A1");
//        int A1mathscore = database.getmath("A1");
        student A1 = new student("A1");
        student A2 = new student("A2");

        int A1Total = A1.getTotalScore();
        int A2Total = A2.getTotalScore();

        System.out.println("A1Total" + A1Total);
        System.out.println("A2Total" + A2Total);
        return;
    }

    public static void main(String[] args) { 
        dotest();
    }

}
