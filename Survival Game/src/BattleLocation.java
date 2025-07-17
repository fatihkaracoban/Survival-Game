
public abstract class BattleLocation extends Location {

	protected Obstacle obstacle;
	protected String awardInventory;

	BattleLocation(Player player, String name, Obstacle obstacle, String awardInventory) {
		super(player);
		this.obstacle = obstacle;
		this.name = name;
		this.awardInventory = awardInventory;
	}

	@Override
	public boolean getLocation() {
		int obsCount = obstacle.count();
		System.out.println("Şuan Buradasınız: " + this.getName());
		System.out.println("Dikkatli ol! Burada " + obsCount + " tane " + obstacle.getName() + " yaşıyor!!");
		System.out.println("<F>ight or <R>un");
		String selectCase = sc.nextLine();
		selectCase = selectCase.toUpperCase();

		if (selectCase.equals("F")) {
			if (combat(obsCount)) {
				System.out.println(this.getName() + " bölgesindeki tüm düşmanları yendiniz !");
				if (this.awardInventory.equals("Food") && player.getInventory().isFood() == false) {
					System.out.println(this.awardInventory + " Kazandınız!!");
					player.getInventory().setFood(true);
				} else if (this.awardInventory.equals("Fire Wood") && player.getInventory().isFirewood() == false) {
					System.out.println(this.awardInventory + " Kazandınız!!");
					player.getInventory().setFirewood(true);
				} else if (this.awardInventory.equals("Water") && player.getInventory().isWater() == false) {
					System.out.println(this.awardInventory + " Kazandınız!!");
					player.getInventory().setWater(true);
				}
				return true;
			} else {
				
			}
			
			if (player.getHealth() <= 0) {
				System.out.println("Öldünüz!");
				return false;
			}

		}
		return true;
	}

	public boolean combat(int obsCount) {
		for (int i = 0; i < obsCount; i++) {
			int defalutObstacleHealth = obstacle.getHealth();
			playerStats();
			enemyStats();
			while (player.getHealth() > 0 && obstacle.getHealth() > 0) {
				System.out.println("<H>it or <R>un: ");
				String selectCase = sc.nextLine();
				selectCase = selectCase.toUpperCase();
				if (selectCase.equals("H")) {
					System.out.println("You hit the Enemy!!");
					obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
					afterHit();
					if (obstacle.getHealth() > 0) {
						System.out.println();
						System.out.println(obstacle.getName() + " size vurdu!");
						player.setHealth(
								player.getHealth() - (obstacle.getDamage() - player.getInventory().getDodge()));
						afterHit();
					}
				} else {
					return false	;
				}
			}

			if (obstacle.getHealth() < player.getHealth()) {
				System.out.println("Düşmanı yendiniz!!");
				player.setMoney(player.getMoney() + obstacle.getAward());
				System.out.println("Güncel paranız: " + player.getMoney());
				obstacle.setHealth(defalutObstacleHealth);
			} else {
				return false;
			}
			System.out.println("********************************************");
		}
		return true;
	}

	public void playerStats() {
		System.out.println("Oyuncu Değerleri\n*****************");
		System.out.println("Can: " + player.getHealth());
		System.out.println("Hasar: " + player.getTotalDamage());
		if (player.getInventory().getDamage() > 0) {
			System.out.println("Silah: " + player.getInventory().getWeaponName());
		}
		if (player.getInventory().getDodge() > 0) {
			System.out.println("Zırh: " + player.getInventory().getArmorName());
		}
	}

	public void enemyStats() {
		System.out.println(obstacle.getName() + " Değerleri\n*****************");
		System.out.println("Can: " + obstacle.getHealth());
		System.out.println("Hasar: " + obstacle.getDamage());
		System.out.println("Ödül: " + obstacle.getAward());
	}

	public void afterHit() {
		System.out.println("Oyuncu Canı: " + player.getHealth());
		System.out.println(obstacle.getName() + " Canı: " + obstacle.getHealth());
		System.out.println();
	}

}
