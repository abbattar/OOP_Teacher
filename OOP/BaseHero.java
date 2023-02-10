import java.util.Arrays;

public class BaseHero {
    String name;
    int attack, defence, health, speed;
    int[] damage;

    public BaseHero(String name, int attack, int defence, int[] damage, int health, int speed) {
        this.name = name;
        this.attack = attack;
        this.defence = defence;
        this.damage = damage;
        this.health = health;
        this.speed = speed;
    }


    @Override
    public String toString() {
        return "Name: " + name + ", Attack: " + attack + ", Defence: " + defence + ", Damage: " + Arrays.toString(damage) + ", Health: " + health + ", Speed: " + speed;
    }
}
