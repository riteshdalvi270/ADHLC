package designpatterns.strategic.designpuzzle.weapon;

/**
 * @author Ritesh Dalvi (rd026600).
 */
public class SwordBehavior implements WeaponBehavior
{
    @Override public String useWeapon()
    {
        return "Sword";
    }
}
