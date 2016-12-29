package designpatterns.strategic.designpuzzle.characters;

/**
 * @author Ritesh Dalvi (rd026600).
 */
public class Queen extends Characters
{
    @Override public void fight()
    {
        System.out.print("Queen Fighting"+weaponBehavior);
    }
}
