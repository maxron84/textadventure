package textadventure;

import java.util.Random;
import java.util.Scanner;

/*
 * TODO:
 * Alternative zum Labeln finden
 * [X] Geschlechter unterscheiden mit boolean und über Arrayindex dynamisch ansprechen
 * Array mit Monstern aus einem größeren Array von außen befüllen lassen
 * 2 Charakterklassen mit unterschiedlichen Verhalten ins Game einlassen
 * Charakter 1 + Angriff - Heiltrankchance
 * Charakter 2 - Angriff + Heiltrankchance
 * [X] Maximale Spieler HP auf 100 begrenzen
 * Score Variable (int monstersSlain) mit abschließendem Wert in eigenständiger Klassenmethode aufrufen
 * 
 */

public class Game {

	public static void game() {
		
		// Testbereich Anfang //
		
		// Testbereich Ende //
		
		// Systemobjekte
		Scanner stringInput = new Scanner(System.in);
		Random randomizer = new Random(); // Diese Methode gibt eine Zufallszahl zwischen 0 und (Argument) aus
		
		// Gamevariablen
		Monster walkyre = new Monster("Walkyre", false);
		Monster zombie = new Monster("Zombie", true);
		Monster ghul = new Monster("Ghul", true);
		Monster ork = new Monster("Ork", true);
		Monster[] roster = {walkyre, zombie, ghul, ork};
		int maxMonsterHealth = 75;
		int monsterAttackDamage = 25;
		
		// Playervariablen
		int playerHealth = 100;
		int attackDamage = 50;
		int numHealthPotions = 3;
		int healthPotionHealAmount = 30;
		int healthPotionDropChance = 50; // Prozentwert
		int monstersSlain = 0;
		boolean running = true;
		

		
		START: // Label
		while (running != false || running == true) /* (~0 v 1) */ {
			
			int monsterHealth = randomizer.nextInt(maxMonsterHealth);
			Monster monster = roster[randomizer.nextInt(roster.length)];
			
			if (monster.isMale() == false) {
				
				System.out.println();
				System.out.println("\t# Eine " + monster.getName() + " erscheint! #\n");

			} else {
				
				System.out.println();
				System.out.println("\t# Ein " + monster.getName() + " erscheint! #\n");
			}
			
			while (monsterHealth > 0) {
				
				System.out.println("\tDeine HP: " + playerHealth);
				System.out.println("\t" + monster.getName() + " HP: " + monsterHealth);
				System.out.println("\n\tWas möchtest du tun?");
				System.out.println("\t1. Angreifen");
				System.out.println("\t2. Heiltrank einnehmen");
				System.out.println("\t3. Wegrennen");
				
				String input = stringInput.nextLine();
				
				if(input.equals("1")) {
					
					int damageDealt = randomizer.nextInt(attackDamage);
					int damageTaken = randomizer.nextInt(monsterAttackDamage);
					
					monsterHealth -= damageDealt;
					playerHealth -= damageTaken;
					
					if (monster.isMale() == false) {
						
						System.out.println("\t> Du fügst der " + monster.getName()  + " " + damageDealt + " Schaden zu.");
						
					} else {
						
						System.out.println("\t> Du fügst dem " + monster.getName()  + " " + damageDealt + " Schaden zu.");
						
					}

					System.out.println("\t> Du erleidest dabei " + damageTaken + " Schaden!");
					System.out.println("");
					
					if (playerHealth < 1) {
						
						System.out.println("\t> Du hast zuviel Schaden erlitten!");
						break;
						
					}
					
				}
				
				else if (input.equals("2")) {
					
					if (numHealthPotions > 0) {
						
						if (playerHealth < 70) {
						
						playerHealth += healthPotionHealAmount;
						numHealthPotions--;
						System.out.println("\t> Du hast einen Heiltrank eingenommen und " + healthPotionHealAmount + " HP erhalten."
								+ "\n\t> Du hast jetzt " + playerHealth + " HP."
								+ "\n\t> Es sind noch " + numHealthPotions + " Heiltränke übrig.");
						System.out.println();
						
						} else if (playerHealth >= 70 && playerHealth < 100) {
							
							playerHealth += (100 - playerHealth);
							numHealthPotions--;
							System.out.println("\t> Du hast einen Heiltrank eingenommen und bist nun bei voller Gesundheit."
									+ "\n\t> Du hast jetzt " + playerHealth + " HP."
									+ "\n\t> Es sind noch " + numHealthPotions + " Heiltränke übrig.");
							System.out.println();
							
							
						} else if (playerHealth >= 100) {
							
							System.out.println("\t> Deine HP sind bereits auf Maximum!");
							
						}
						
					} else {
						
						System.out.println("\t> Du hast keine Heiltränke mehr, besiege weitere Monster um neue zu erhalten!");
						System.out.println();
						
					}
					
				}
				
				else if (input.equals("3")) {
					
					System.out.println("\tDu läufst weg und hängst " + monster.getName() + " gerade so ab!");
					
					continue START; // Zurück zum Start Label
					
				}
				
				else {
					
					System.out.println("\tFalsche Eingabe!");
					
				}
				
			}
			
			if (playerHealth < 1) {
				
				System.out.println();				
				System.out.println("# " + monster.getName() + " hat dich erledigt! #");
				Death.death();
				break;
				
			}
			
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.println("");
			
			if (monster.isMale() == false) {
				
				System.out.println(" # Du hast die " + monster.getName() + " besiegt! # ");
				monstersSlain++;
			
			} else {
				
				System.out.println(" # Du hast den " + monster.getName() + " besiegt! # ");				
				monstersSlain++;
				
			}
			
			System.out.println(" # " + playerHealth + " HP übrig. #");
			
			if (randomizer.nextInt(100) > healthPotionDropChance) {
				
				numHealthPotions++;
				System.out.println(" # " + monster.getName() + " hat einen Heiltrank fallen lassen! # ");
				System.out.println(" # Du hast jetzt " + numHealthPotions + " Heiltränke. # ");
				
			}
			
			System.out.println("");
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.println("");
			System.out.println("Was möchtest du tun?");
			System.out.println("1. Kampf fortsetzen");
			System.out.println("2. Dungeon verlassen");
			
			String input = stringInput.nextLine();
			
			while(!input.equals("1") && !input.equals("2")) {
				
				System.out.println("Falsche Eingabe!");
				input = stringInput.nextLine();
				
			}
			
			if(input.equals("1")) {
				
				System.out.println("Du setzt deine Erkundung fort!");
				System.out.println();
				
			}
			
			else if(input.equals("2")) {
				
				System.out.println("Du verlässt das Dungeon und hast " + monstersSlain + " Monster besiegt!");
				System.out.println();
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
				break;
				
			}
			
		};
		
		stringInput.close();
		
	}

}