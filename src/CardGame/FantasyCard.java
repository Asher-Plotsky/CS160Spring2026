package CardGame;

public class FantasyCard extends CollectorCard{
    String genre;
    String universe;
    public FantasyCard(String title, String image, String genre, String universe) {
        super(title, image);
        this.genre = genre;
        this.universe = universe;
    }
    public  String getGenre() {
        return genre;
    }
    public String getUniverse() {
        return universe;
    }
    public String toString() {
        return (title + ": " +  universe + " character");
    }
}
