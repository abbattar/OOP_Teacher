public class Spearman extends BaseHero {
    public Spearman(String name, int attack, int defence, int[] damage, int health, int speed) {
        super(name, attack, defence, damage, health, speed);
    }
    public Spearman(String name){
        super(name, 4, 5, new int[] {1, 3}, 10, 4);
    }
}
