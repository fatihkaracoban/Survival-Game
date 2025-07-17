import java.util.Scanner;

public class Player {
	private int damage;
	private int health;
	private int rHealth;
	private int money;
	private String name;
	private String cName;
	private Inventory ınventory;
	Scanner sc = new Scanner(System.in);
	
	public Player(String name) {
		this.name = name;
		this.ınventory = new Inventory();
	}
	
	public void selectCharacter() {
		switch(characterMenu()){
		case 1:
			initPlayer("Samuray",5,21,15);
			break;
			
		case 2:
			initPlayer("Okçu",7,18,20);
			break;
			
		case 3:
			initPlayer("Şövalye",8,24,5);
			break;
			
		default:
			initPlayer("Samuray",5,21,15);
			break;
		}
		System.out.println("Karakter: " + getcName() + "\nHasar: " + getDamage() + "\nSağlık: " + getHealth() +"\nPara: " + getMoney());
	}
	
	public int characterMenu() {
		System.out.println("Lütfen bir karakter seçiniz: ");
		System.out.println("1 - Türü: Samuray \nHasar: 5, Sağlık: 21, Para: 15");
		System.out.println();
		System.out.println("2 - Türü: Okçu \nHasar: 7, Sağlık: 18, Para: 20");
		System.out.println();
		System.out.println("3 - Türü: Şövalye \nHasar: 8, Sağlık: 24, Para: 5");
		System.out.println("Karakter Seçiminiz: ");
		int characterID = sc.nextInt();
		
		while(characterID < 1 || characterID > 3){
			System.out.print("Lütfen geçerli bir karakter seçiniz!");
			characterID = sc.nextInt();
		}
		return characterID;
	}
	
	public int getTotalDamage() {
		return this.getDamage() + this.getInventory().getDamage();
	}
	
	public void initPlayer(String cName, int damage, int health, int money) {
		setcName(cName);
		setDamage(damage);
		setHealth(health);
		setMoney(money);
		setrHealth(health);
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Inventory getInventory() {
		return ınventory;
	}

	public void setInventory(Inventory inventory) {
		ınventory = inventory;
	}

	public int getrHealth() {
		return rHealth;
	}

	public void setrHealth(int rHealth) {
		this.rHealth = rHealth;
	}
	
}
