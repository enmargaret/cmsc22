/*
*Created by enmargaret on 11/25/2016;
*/

import java.util.*;

public class CharacterTest{
	public static void main(String[] args){
		Character queen = new Queen(new BowAndArrowBehavior());
		queen.fight();
		Character troll = new Troll(new AxeBehavior());
		troll.fight();
		Character knight = new Knight(new SwordBehavior());
		knight.fight();
		Character king = new King(new KnifeBehavior());
		king.fight();
		
		queen = new Queen(new KnifeBehavior());
		queen.fight();
	}
}