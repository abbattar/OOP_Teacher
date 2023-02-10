public class Archer extends BaseHero {
    int shoots;

    public Archer(String name, int attack, int defence, int[] damage, int health, int speed, int shoots) {
        super(name, attack, defence, damage, health, speed);
        this.shoots = shoots;
    }

    @Override
    public String toString() {
        return super.toString() + ", Shoots: " + shoots;
    }
}
