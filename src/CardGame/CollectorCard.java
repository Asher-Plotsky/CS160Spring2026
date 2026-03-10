package CardGame;

public class CollectorCard {
    String title;
    String image;
    public CollectorCard(String title, String image) {
        this.title = title;
        this.image = image;
    }
    public String getTitle() {
        return title;
    }
    public String getImage() {
        return image;
    }
    public String toString() {
        return getTitle();
    }
}
