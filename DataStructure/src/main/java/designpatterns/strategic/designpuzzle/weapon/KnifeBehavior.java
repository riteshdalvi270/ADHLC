package designpatterns.strategic.designpuzzle.weapon;

/**
 * @author Ritesh Dalvi (rd026600).
 */
public class KnifeBehavior implements WeaponBehavior
{
    @Override
    public String useWeapon()
    {
        return "Knife";
    }
}
