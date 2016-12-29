package designpatterns.strategic.designpuzzle.characters;

/**
 * @author Ritesh Dalvi (rd026600).
 */
public class King extends Characters
{
    @Override public void fight()
    {
        System.out.print("King Fighting with "+ weaponBehavior.useWeapon());
    }
}
