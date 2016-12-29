package designpatterns.strategic.designpuzzle.weapon;

/**
 * @author Ritesh Dalvi (rd026600).
 */
public class AxeBehavior implements WeaponBehavior
{
    @Override
    public String useWeapon()
    {
        return "Axe Weapon";
    }
}
