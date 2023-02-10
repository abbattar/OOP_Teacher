package chars;

import java.util.List;


public class Robber extends Base{
    public Robber(List<Base> gang, int x, int y, int amount) {
        super(8, 3, 0, new int[]{2,4}, 10, 10, 6, false, false, "Robber");
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

        if((int)nearestDistance(aimNpc) <= 1)
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
        return "Robber(" + amount +")  - " +
                "Status(" + status + "), " +
                "HP(10.0 - " + getCurrentHealth() + ") ";
    }
}

