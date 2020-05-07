package textadventure;

public class Death {

	public static void death() {
		
		System.out.println("\t# Du hast " + Game.monstersSlain + " Monster besiegt. #\n" 
						 + "\t# Du hast " + Game.usedHealthPotions + "-mal Heiltränke genutzt. #\n"
		 				 + "\t# Du bist " + Game.runAway + "-mal weggelaufen. #\n");	
		System.out.println("\t# Deine Punktzahl beträgt " + (Game.score - Game.deathPenalty) + " #");
		System.out.println("                                                                 _\r\n" + 
				"                                                              _( (~\\\r\n" + 
				"       _ _                        /                          ( \\> > \\\r\n" + 
				"   -/~/ / ~\\                     :;                \\       _  > /(~\\/\r\n" + 
				"  || | | /\\ ;\\                   |l      _____     |;     ( \\/    > >\r\n" + 
				"  _\\\\)\\)\\)/ ;;;                  `8o __-~     ~\\   d|      \\      //\r\n" + 
				" ///(())(__/~;;\\                  \"88p;.  -. _\\_;.oP        (_._/ /\r\n" + 
				"(((__   __ \\\\   \\                  `>,% (\\  (\\./)8\"         ;:'  i\r\n" + 
				")))--`.'-- (( ;,8 \\               ,;%%%:  ./V^^^V'          ;.   ;.\r\n" + 
				"((\\   |   /)) .,88  `: ..,,;;;;,-::::::'_::\\   ||\\         ;[8:   ;\r\n" + 
				" )|  ~-~  |(|(888; ..``'::::8888oooooo.  :\\`^^^/,,~--._    |88::  |\r\n" + 
				" |\\ -===- /|  \\8;; ``:.      oo.8888888888:`((( o.ooo8888Oo;:;:'  |\r\n" + 
				" |_~-___-~_|   `-\\.   `        `o`88888888b` )) 888b88888P\"\"'     ;\r\n" + 
				" ; ~~~~;~~         \"`--_`.       b`888888888;(.,\"888b888\"  ..::;-'\r\n" + 
				"   ;      ;              ~\"-....  b`8888888:::::.`8888. .:;;;''\r\n" + 
				"      ;    ;                 `:::. `:::OOO:::::::.`OO' ;;;''\r\n" + 
				" :       ;                     `.      \"``::::::''    .'\r\n" + 
				"    ;                           `.   \\_              /\r\n" + 
				"  ;       ;                       +:   ~~--  `:'  -';\r\n" + 
				"                                   `:         : .::/\r\n" + 
				"      ;                            ;;+_  :::. :..;;;\r\n" + 
				"                                   ;;;;;;,;;;;;;;;,;");
		System.out.println();
		
	};

}
