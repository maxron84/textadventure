package textadventure;

public class Victory {

	public static void victory() {
		
		System.out.println("\t# Du verlässt das Dungeon und hast " + Game.monstersSlain + " Monster besiegt. #\n"  
						 + "\t# Du hast " + Game.usedHealthPotions + "-mal Heiltränke genutzt. #\n"
						 + "\t# Du bist " + Game.runAway + "-mal weggelaufen. #\n");
		System.out.println("\t# Deine Punktzahl beträgt " + Game.score + " #");	
		System.out.println("   .\n" + 
				"  / \\\n" + 
				"  | |\n" + 
				"  |.|\n" + 
				"  |.|\n" + 
				"  |:|      __\n" + 
				",_|:|_,   /  )\n" + 
				"  (Oo    / _I_\n" + 
				"   +\\ \\  || __|\n" + 
				"      \\ \\||___|\n" + 
				"        \\ /.:.\\-\\\n" + 
				"         |.:. /-----\\\n" + 
				"         |___|::oOo::|\n" + 
				"         /   |:<_T_>:|\n" + 
				"        |_____\\ ::: /\n" + 
				"         | |  \\ \\:/\n" + 
				"         | |   | |\n" + 
				"         \\ /   | \\___\n" + 
				"         / |   \\_____\\\n" + 
				"         `-'");
		
	}

}
