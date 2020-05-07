package textadventure;

import java.util.Random;
import java.util.Scanner;

/*
 * TODO:
 * [ ] Alternative zum Labeln finden
 * [X] Geschlechter unterscheiden mit boolean und �ber Arrayindex dynamisch ansprechen
 * [ ] Array mit Monstern aus einem gr��eren Array von au�en bef�llen lassen
 * [ ] 2 Charakterklassen mit unterschiedlichen Verhalten ins Game einlassen
 * [ ] Charakter 1 + Angriff - Heiltrankchance
 * [ ] Charakter 2 - Angriff + Heiltrankchance
 * [X] Maximale Spieler HP auf 100 begrenzen
 * [X] Score Variable (int monstersSlain, int usedHealthPotions, float score, float deathPenalty) 
 * 	   mit abschlie�endem Wert in Klassenvariablen von au�en aufrufen
 * [ ] Highscore Tabelle in Datei schreiben lassen
 * 
 */

public class Game {
	
	// Klassenvariablen
	static int monstersSlain = 0;
	static int usedHealthPotions = 0;
	static int runAway = 0;
	static int score = 0;
	static int deathPenalty = 3;

	
	// Prozedurale Spielmethode
	public static void game() {
		
		// Systemobjekte
		Scanner scan = new Scanner(System.in);
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
		int attackDamageC1 = 42;
//		int attackDamageC2 = 27;
		int numHealthPotions = 3;
		int healthPotionHealAmount = 30;
		int healthPotionDropC1 = 67; // Threshold
//		int healthPotionDropC2 = 33; // Threshold
		boolean running = true;
		
		// Testbereich Anfang //
		
		
		
		// Testbereich Ende //

		
		START: // Label
		while (running != false || running == true) /* (~0 + 1) */ {
			
			int monsterHealth = randomizer.nextInt(maxMonsterHealth);
			Monster monster = roster[randomizer.nextInt(roster.length)];
			
			if (monster.isMale() == false) {
				
				System.out.println();
				System.out.println("\t# Eine " + monster.getName() + " erscheint! #\n");
				
				if (monsterHealth == 0) {
					
					System.out.println();
					System.out.println("\t# ... und f�llt vor Schreck tot um! #\n");
					
				}

			} else {
				
				System.out.println();
				System.out.println("\t# Ein " + monster.getName() + " erscheint! #\n");
				
				if (monsterHealth == 0) {
					
					System.out.println();
					System.out.println("\t# ... und f�llt vor Schreck tot um! #\n");
					
				}
				
			}
			
			while (monsterHealth > 0) {
				
				System.out.println("\tDeine HP: " + playerHealth);
				System.out.println("\t" + monster.getName() + " HP: " + monsterHealth);
				System.out.println("\n\tWas m�chtest du tun?");
				System.out.println("\t1. Angreifen");
				System.out.println("\t2. Heiltrank einnehmen");
				System.out.println("\t3. Wegrennen");
				
				String input = scan.nextLine();
				
				if(input.equals("1")) {
					
					int damageDealt = randomizer.nextInt(attackDamageC1);
					int damageTaken = randomizer.nextInt(monsterAttackDamage);
					
					monsterHealth -= damageDealt;
					playerHealth -= damageTaken;
					
					if (monster.isMale() == false) {
						
						System.out.println("\t> Du f�gst der " + monster.getName()  + " " + damageDealt + " Schaden zu.");
						
					} else {
						
						System.out.println("\t> Du f�gst dem " + monster.getName()  + " " + damageDealt + " Schaden zu.");
						
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
								+ "\n\t> Es sind noch " + numHealthPotions + " Heiltr�nke �brig.");
						System.out.println();
						usedHealthPotions++;
						
						} else if (playerHealth >= 70 && playerHealth < 100) {
							
							playerHealth += (100 - playerHealth);
							numHealthPotions--;
							System.out.println("\t> Du hast einen Heiltrank eingenommen und bist nun bei voller Gesundheit."
									+ "\n\t> Du hast jetzt " + playerHealth + " HP."
									+ "\n\t> Es sind noch " + numHealthPotions + " Heiltr�nke �brig.");
							System.out.println();
							usedHealthPotions++;
							
							
						} else if (playerHealth >= 100) {
							
							System.out.println("\t> Deine HP sind bereits auf Maximum!");
							
						}
						
					} else {
						
						System.out.println("\t> Du hast keine Heiltr�nke mehr, besiege weitere Monster um neue zu erhalten!");
						System.out.println();
						
					}
					
				}
				
				else if (input.equals("3")) {
					
					System.out.println("------------------------------------------------------------------------");
					System.out.println();
					System.out.println(" # Du l�ufst weg und h�ngst " + monster.getName() + " gerade so ab! # ");
					System.out.println();
					System.out.println("------------------------------------------------------------------------");
					
					runAway++;
					
					continue START; // Zur�ck zum Start Label
					
				}
				
				else {
					
					System.out.println("\tFalsche Eingabe!");
					
				}
				
			}
			
			if (playerHealth < 1) {
				
				score = (monstersSlain * 2) - (usedHealthPotions + runAway);
				deathPenalty = 3;
				
				System.out.println();				
				System.out.println(monster.getName() + " hat dich erledigt!");
				System.out.println();
				Death.death();
				break;
				
			}
			
			System.out.println("------------------------------------------------------------------------");
			System.out.println("");
			
			if (monster.isMale() == false) {
				
				System.out.println(" # Du hast die " + monster.getName() + " besiegt! # ");
				monstersSlain++;
			
			} else {
				
				System.out.println(" # Du hast den " + monster.getName() + " besiegt! # ");				
				monstersSlain++;
				
			}
			
			System.out.println(" # " + playerHealth + " HP �brig. #");
			
			if (randomizer.nextInt(100) > healthPotionDropC1) {
				
				numHealthPotions++;
				System.out.println(" # " + monster.getName() + " hat einen Heiltrank fallen lassen! # ");
				System.out.println(" # Du hast jetzt " + numHealthPotions + " Heiltr�nke. # ");
				
			}
			
			System.out.println("");
			System.out.println("------------------------------------------------------------------------");
			System.out.println("");
			System.out.println("Was m�chtest du tun?");
			System.out.println("1. Kampf fortsetzen");
			System.out.println("2. Dungeon verlassen");
			
			String input = scan.nextLine();
			
			while(!input.equals("1") && !input.equals("2")) {
				
				System.out.println("Falsche Eingabe!");
				input = scan.nextLine();
				
			}
			
			if(input.equals("1")) {
				
				System.out.println("Du setzt deine Erkundung fort!");
				System.out.println();
				
			}
			
			else if(input.equals("2")) {
				
				score = (monstersSlain * 2) - (usedHealthPotions + runAway);				
				Victory.victory();				
				break;
				
			}
			
		};
		

		
		scan.close();
		
	}

}