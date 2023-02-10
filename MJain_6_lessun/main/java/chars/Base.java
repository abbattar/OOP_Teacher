package chars;

import java.util.Arrays;
import java.util.List;

public abstract class Base implements IAction {
    private int attack;
    private int protection;
    protected int shoot;
    private int[] damage;
    private final double  maxHealth;
    private double currentHealth;
    private int speed;
    private boolean delivery;
    private boolean magic;
    private String name;
    protected String status;
    protected List<Base> gang;
    protected Vector2 position;
    protected int amount;

    public Base(int attack, int protection, int shoot, int[] damage,
                double maxHealth, double currentHealth, int speed, boolean delivery,
                boolean magic, String name)
    {
        this.attack = attack;
        this.protection = protection;
        this.shoot = shoot;
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.speed = speed;
        this.delivery = delivery;
        this.magic = magic;
        this.name = name;
        this.amount = 1;
        this.status = "stand";
    }

    public Vector2 getPosition() {return position;}
    public void setPosition(Vector2 position){this.position = position;}
    public String getName() {return name;}
    public String getStatus(){return status;}
    protected int getSpeed(){return speed;}
    protected int[] getDamage(){
        return damage;
    }
    protected double getCurrentHealth() {
        return currentHealth;
    }
    protected void setCurrentHealth(double health) {
        currentHealth = health;
    }
    protected double getMaxHealth() {
        return maxHealth;
    }
    protected void checkTheDead(Base npc){if(npc.amount <= 0) npc.status = "dead";}
    protected boolean checkHp(Base npc){
        if(npc.maxHealth * 70/100 >= npc.currentHealth)
            return true;
        return false;
    }

    protected double Damage(Base npc){
        double totalDamage = 0.0;
        double damage = this.attack - npc.protection;

        if(damage == 0)
        {
            totalDamage = (this.damage[0] + this.damage[1])/2;
        }
        else if(damage > 0){totalDamage = this.damage[1];}
        else if(damage < 0){totalDamage = this.damage[0];}

        return totalDamage * this.amount;
    }

    protected void getDamage(double damage)
    {
        double stackHp = (this.amount - 1) * maxHealth + currentHealth;
        stackHp -= damage;
        if(stackHp <= 0)
        {
            amount = 0; currentHealth = 0;
        }
        amount = (int)(stackHp/ maxHealth);
        if(stackHp % maxHealth != 0) {
            currentHealth = stackHp - amount * maxHealth;
            amount+=1;
        }
    }
    protected double nearestDistance(Base hero)
    {
        return Math.sqrt((hero.getPosition().x - this.getPosition().x) * (hero.getPosition().x - this.getPosition().x)
                + (hero.getPosition().y - this.getPosition().y) * (hero.getPosition().y - this.getPosition().y));
    }

    protected int findAim(List<Base> group)
    {
        double minDistance = Double.MAX_VALUE;
        int nearestIndex = 0;
        for (int i = 0, j = 0; i < group.size(); i++)
        {
            if(!group.get(i).status.equals("dead"))
            {
                double temp = this.nearestDistance(group.get(i));
                if(minDistance > temp)
                {
                    minDistance = temp;
                    nearestIndex = i;
                }
            }else if(group.get(nearestIndex).status.equals("dead") && j < group.size() - 1){
                while(j < group.size() - 1)
                {
                    if(!group.get(j).status.equals("dead")) break;
                    else j++;
                }
                nearestIndex = j;
                j = 0;
            }
        }
        return nearestIndex;
    }

    protected boolean checkPosition( Vector2 position)
    {
        for (Base npc: this.gang) {
            if(npc.getPosition().isEqual(position))
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  name +
                " - attack=" + attack +
                ", protection=" + protection +
                ", shoot=" + shoot +
                ", damage=" + Arrays.toString(damage) +
                ", maxHealth=" + maxHealth +
                ", currentHealth=" + currentHealth +
                ", speed=" + speed +
                ", delivery=" + delivery +
                ", magic=" + magic;
    }

}