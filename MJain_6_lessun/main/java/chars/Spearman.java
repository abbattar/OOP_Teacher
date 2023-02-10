package chars;

import java.util.List;
import java.util.Random;

public class Spearman extends Base {
    public Spearman(List<Base> gang, int x, int y, int amount) {
        super(4, 5, 0, new int[]{1,3}, 10, 10, 4, false, false, "Spearman");
        super.gang = gang;
        super.position = new Vector2(x, y);
        super.amount = amount;
    }

    @Override
    public void Step(List<Base> group) {
        if(this.status.equals("dead")) return;

        int nearestIndex = findAim(group);
        Base aimNpc = group.get(nearestIndex);
        double totalDamage = Damage(aimNpc);

        if(nearestDistance(aimNpc) <= 1)
        {
            aimNpc.getDamage(totalDamage);
            checkTheDead(aimNpc);
            return;
        }
        int x = getPosition().x;
        int y = getPosition().y;

        if(aimNpc.getPosition().y > getPosition().y && checkPosition(new Vector2(x, ++y)))
            setPosition(new Vector2(x, y));
        else if(aimNpc.getPosition().y < getPosition().y && checkPosition(new Vector2(x, --y)))
            setPosition(new Vector2(x, y));
        else if(aimNpc.getPosition().x < getPosition().x && checkPosition(new Vector2(--x, y)))
            setPosition(new Vector2(x, y));
        else if(aimNpc.getPosition().x > getPosition().x && checkPosition(new Vector2(++x, y)))
            setPosition(new Vector2(x, y));

    }

    @Override
    public String GetInfo() {
        return "Spearman(" + amount +") - " +
                "Status(" + status + "), " +
                "HP(10.0 - " + getCurrentHealth() + ")";
    }
}
