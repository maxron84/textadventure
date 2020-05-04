package textadventure;

public class Entity {
	
	// Initialisierte Variablen
	private String name;
	private boolean isMale; // Geschlecht
	
	// G & S
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	// Konstruktor
	public Entity(String name, boolean isMale) {
		
		setName(name);
		setMale(isMale);
		
	}

}