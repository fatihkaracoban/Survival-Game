
public class Inventory {
	private boolean water;
	private boolean food;
	private boolean firewood;
	private String weaponName;
	private String armorName;
	private int damage;
	private int dodge;
	
	Inventory(){
		this.water = false;
		this.food = false;
		this.firewood = false;
		this.damage = 0;
		this.dodge = 0;
		this.armorName= null;
		this.weaponName = null;
	}

	public boolean isWater() {
		return water;
	}

	public void setWater(boolean water) {
		this.water = water;
	}

	public boolean isFood() {
		return food;
	}

	public void setFood(boolean food) {
		this.food = food;
	}

	public boolean isFirewood() {
		return firewood;
	}

	public void setFirewood(boolean firewood) {
		this.firewood = firewood;
	}

	public String getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	public String getArmorName() {
		return armorName;
	}

	public void setArmorName(String armorName) {
		this.armorName = armorName;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getDodge() {
		return dodge;
	}

	public void setDodge(int dodge) {
		this.dodge = dodge;
	}
	
}	
