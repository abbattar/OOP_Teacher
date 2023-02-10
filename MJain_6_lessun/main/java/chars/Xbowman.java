package chars;

import java.util.List;

public class Xbowman extends Base {
    public Xbowman(List<Base> gang, int x, int y, int amount) {
        super(6, 3, 16, new int[]{2,3}, 10, 10, 4, false, false, "Xbowman");
        super.gang = gang;
        super.position = new Vector2(x, y);
        super.amount = amount;
    }

    @Override
    public void Step(List<Base> group) {
        if(this.status.equals("dead")) return;

        for(Base npc: this.gang)
        {
            if(npc.getName().equals("Peasant") && npc.status.equals("stand"))
            {
                this.shoot++;
                npc.status = "used";
                break;
            }
        }
        if(this.shoot < 1) return;

        int nearestIndex = findAim(group);
        double minDistance = nearestDistance(group.get(nearestIndex));
        this.shoot--;

        Base defendingNpc = group.get(nearestIndex);
        double totalDamage = Damage(defendingNpc);

        if(minDistance > this.getSpeed()){totalDamage = totalDamage / 2;}

        defendingNpc.getDamage(totalDamage);

        checkTheDead(defendingNpc);
    }

    @Override
    public String GetInfo() {
        return "Xbowman(" + amount +") - " +
                "Status(" + status + "), " +
                "HP(10.0 - " + getCurrentHealth() + ")";
    }
}
