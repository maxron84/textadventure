package textadventure;

public abstract class Entity {
	
	private String name;
	private boolean isMale; // Geschlecht
	
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