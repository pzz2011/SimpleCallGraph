package uk.co.halfninja.randomnames;

public class student { 
    
    private String name;

    public student(String name) { 
        this.name = name;
    }

    public String getname() { 
        return name;
    }


    public int getTotalScore() { 
        return getmathscore() + getengscore();   
    }

    public int getmathscore() { 
        return database.getmath(this.name);
    }

    public int getengscore() { 
        return database.geteng(this.name);
    }

}
