
package ohtu;

public class Player {
    private String name;
    private String team;
    private int goals;
    private int assists;
    private String nationality;
    

    public Player(String name, String team, int goals, int assists, String nationality){
        this.name=name;
        this.team=team;
        this.goals=goals;
        this.assists=assists;
        this.nationality=nationality;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeam() {
        return team;
    }
    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getGoals() {
        return goals;
    }
    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getAssists() {
        return assists;
    }
    
    public int getPoints() {
        return goals + assists;
    }
    
    public void setNationality(String nationality) {
        this.nationality=nationality;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    @Override
    public String toString() {
        return String.format("%-20s",name) + " " + team + " " + String.format("%2d",goals) + " + " 
                + String.format("%2d",assists) + " = " + getPoints();
    }
      
}
