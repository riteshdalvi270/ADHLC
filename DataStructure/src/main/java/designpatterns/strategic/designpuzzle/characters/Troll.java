package designpatterns.strategic.designpuzzle.characters;

/**
 * @author Ritesh Dalvi (rd026600).
 */
public class Troll extends Characters
{

    @Override public void fight()
    {
        System.out.print("Troll Fighting"+weaponBehavior);
    }
}
