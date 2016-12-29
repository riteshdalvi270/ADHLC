package designpatterns.strategic.designpuzzle.characters;

import designpatterns.strategic.designpuzzle.weapon.WeaponBehavior;

/**
 * @author Ritesh Dalvi (rd026600).
 */
public abstract class Characters
{
    WeaponBehavior weaponBehavior = null;

    public abstract void fight();

    public void setWeaponBehavior(final WeaponBehavior weaponBehavior)
    {
        this.weaponBehavior = weaponBehavior;
    }
}
