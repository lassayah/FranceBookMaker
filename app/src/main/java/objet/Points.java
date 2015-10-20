package objet;

public class Points {

    public Points()
    {

    }

    public Points(String name, int points, String rank)
    {
        this.nom = name;
        this.points = points;
        this.rank = rank;
    }

    private String nom;
    private int points;
    private String rank;

    public String getNom() {
        return nom;
    }

    private void setNom(String nom) {
        this.nom = nom;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }


}

