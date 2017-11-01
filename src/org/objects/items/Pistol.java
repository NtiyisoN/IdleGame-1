package org.objects.items;

import org.engine.logic.GameObject;
import org.engine.logic.Level;
import org.inventory.Item;
import org.objects.Bullet;
import org.objects.Player;
import org.objects.Zombie;

public class Pistol extends Item
{
    public Pistol(GameObject parent)
    {
        super(parent);

        name = "Pistol";
        desc = "Semi Automatic Pistol";
        id = 1;

        image = "Pistol_Side.png";
    }

    @Override
    public void use()
    {
        super.use();

        if(parent.tag.equals("Player"))
        {
            Player player = (Player)parent;

            if(player.getEquippedItem() == null)
                player.setEquippedItem(this);
            else
                Level.instantiate(new Bullet(player.x, player.y));
        }
    }
}
