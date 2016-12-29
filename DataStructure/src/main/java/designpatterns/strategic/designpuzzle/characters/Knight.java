package designpatterns.strategic.designpuzzle.characters;

/**
 * @author Ritesh Dalvi (rd026600).
 */
public class Knight extends Characters
{
    @Override public void fight()
    {
        System.out.print("Knight Fighting"+weaponBehavior);
    }
}
