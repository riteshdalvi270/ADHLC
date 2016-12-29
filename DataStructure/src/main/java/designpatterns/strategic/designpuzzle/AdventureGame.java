package designpatterns.strategic.designpuzzle;

import designpatterns.strategic.designpuzzle.characters.Characters;
import designpatterns.strategic.designpuzzle.characters.King;
import designpatterns.strategic.designpuzzle.characters.Queen;
import designpatterns.strategic.designpuzzle.weapon.AxeBehavior;
import designpatterns.strategic.designpuzzle.weapon.BowAndArrowBehavipr;
import designpatterns.strategic.designpuzzle.weapon.KnifeBehavior;
import designpatterns.strategic.designpuzzle.weapon.SwordBehavior;

/**
 * @author Ritesh Dalvi (rd026600).
 */
public class AdventureGame
{
    public static void main(String args[])
    {

        Characters characters = new King();

        characters.setWeaponBehavior(new SwordBehavior());
        characters.fight();

        characters.setWeaponBehavior(new AxeBehavior());
        characters.fight();

        characters = new Queen();
        characters.setWeaponBehavior(new BowAndArrowBehavipr());
        characters.fight();
        characters.setWeaponBehavior(new KnifeBehavior());
        characters.fight();
    }
}
