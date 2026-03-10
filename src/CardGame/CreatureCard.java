package CardGame;

public class CreatureCard extends FantasyCard{
    String element;
    int creatureID;
    String specialSkill;
    public CreatureCard(String title, String image, String genre, String universe, String element, int creatureID, String specialSkill) {
        super(title, image, genre, universe);
        this.element = element;
        this.creatureID = creatureID;
        this.specialSkill = specialSkill;
    }
    public String getElement() {
        return element;
    }
    public void setElement(String element) {
        this.element = element;
    }
    public int getCreatureId() {
        return creatureID;
    }
    public void setCreatureId(int creatureID) {
        this.creatureID = creatureID;
    }
    public String getSpecialSkill() {
        return specialSkill;
    }
    public void setSpecialSkill(String specialSkill) {
        this.specialSkill = specialSkill;
    }
    public String toString() {
        return (title + ": " +  universe + " character, " + creatureID + ", a " + element + "-element being with " +  specialSkill + " power.");
    }
}
