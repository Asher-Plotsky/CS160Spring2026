package CardGame;

public class Program3 {
    public static void main(String[] args) {
    CollectorCard cc = new CollectorCard("General", "gen.img");

    FantasyCard sc = new FantasyCard("Gallactus", "sc.img", "Battle", "Fantasy Clash");

    CreatureCard draconis = new CreatureCard("Draconis", "d101.img", "Battle", "Fantasy Clash", "Fire", 101, "Flame Burst");
    CreatureCard griffin = new CreatureCard("Griffin", "g202.img", "Battle", "Fantasy Clash", "Wind", 202, "Aerial Strike");
    CreatureCard phoenix = new CreatureCard("Phoenix", "p303.img", "Battle", "Fantasy Clash", "Light", 303, "Rebirth");

    CollectorCard[] cards = new CollectorCard[5];

    cards[0] = cc;
    cards[1] = sc;
    cards[2] = draconis;
    cards[3] = griffin;
    cards[4] = phoenix;

    for (CollectorCard card : cards)
        System.out.println(card);
    }
}
