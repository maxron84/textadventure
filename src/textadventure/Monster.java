package textadventure;

public class Monster extends Entity {
	
	public Monster(String name, boolean isMale) {
		
		super(name, isMale);
		
	}
	
	@Override
	public String toString() {
		
		String output = getName();
		
		return output;
		
	}	
	
}