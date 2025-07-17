
public class ToolStore extends NormalLocation {

	ToolStore(Player player) {
		super(player, "Mağazadasınız!");
	}

	@Override
	public boolean getLocation() {
		System.out.println("Para : " + player.getMoney());
		System.out.println("1. Silahlar");
		System.out.println("2. Zırhlar");
		System.out.println("3. Çıkış");
		System.out.println("Seçiminiz: ");
		int selectTool = sc.nextInt();
		int selectItemID = 0;

		switch (selectTool) {
		case 1:
			selectItemID = weaponMenu();
			buyWeapon(selectItemID);
			break;
		case 2:
			selectItemID = armorMenu();
			buyArmor(selectItemID);
			break;
		default:
			break;
		}

		return true;
	}

	public int armorMenu() {
		System.out.println("1. Hafif Zırh \nFiyat: 15 - Hasar: 1");
		System.out.println();
		System.out.println("2. Orta Zırh \nFiyat: 25 - Hasar: 3");
		System.out.println();
		System.out.println("3. Ağır Zırh \nFiyat: 40 - Hasar: 5");
		System.out.println();
		System.out.println("4. Çıkış");
		System.out.println();
		System.out.println("Zırh Seçiniz: ");
		int selectArmorID = sc.nextInt();
		return selectArmorID;
	}

	public int weaponMenu() {
		System.out.println("1. Tabanca \nFiyat: 25 - Hasar: 2");
		System.out.println();
		System.out.println("2. Kılıç \nFiyat: 35 - Hasar: 3");
		System.out.println();
		System.out.println("3. Tüfek \nFiyat: 45 - Hasar: 7");
		System.out.println();
		System.out.println("4. Çıkış");
		System.out.println();
		System.out.println("Silah Seçiniz: ");
		int selectWeaponID = sc.nextInt();
		return selectWeaponID;
	}

	public void buyArmor(int ıtemID) {
		int dodge = 0;
		int price = 0;
		String armorName = null;

		switch (ıtemID) {
		case 1:
			dodge = 1;
			armorName = "Hafif Zırh";
			price = 15;
			break;
		case 2:
			dodge = 3;
			armorName = "Orta Zırh";
			price = 25;
			break;
		case 3:
			dodge = 5;
			armorName = "Ağır Zırh";
			price = 40;
			break;
		case 4:
			System.out.println("Çıkış yapılıyor...");
			break;
		default:
			System.out.println("Geçersiz İşlem!");
			break;
		}

		if (price > 0) {
			if (player.getMoney() >= price) {
				player.getInventory().setDodge(dodge);
				player.getInventory().setArmorName(armorName);
				player.setMoney(player.getMoney() - price);
				System.out.println(armorName + " satın aldınız. \nEngellenen Hasar : " 
						+ "+" + player.getInventory().getDodge());
				System.out.println("Kalan para: " + player.getMoney());
			} else {
				System.out.println("Yetersiz Bakiye.");
			}
		}
	}

	public void buyWeapon(int itemID) {
		int damage = 0;
		int price = 0;
		String weaponName = null;

		switch (itemID) {
		case 1:
			damage = 2;
			weaponName = "Tabanca";
			price = 25;
			break;
		case 2:
			damage = 3;
			weaponName = "Kılıç";
			price = 35;
			break;
		case 3:
			damage = 7;
			weaponName = "Tüfek";
			price = 45;
			break;
		case 4:
			System.out.println("Çıkış yapılıyor...");
			break;
		default:
			System.out.println("Geçersiz İşlem!");
			break;
		}

		if (price > 0) {
			if (player.getMoney() >= price) {
				player.getInventory().setDamage(damage);
				player.getInventory().setWeaponName(weaponName);
				player.setMoney(player.getMoney() - price);
				System.out.println(weaponName + " satın aldınız. \nHasarınız: " + player.getDamage() + " --> "
						+ player.getTotalDamage());
				System.out.println("Kalan para: " + player.getMoney());
			} else {
				System.out.println("Yetersiz Bakiye.");
			}
		}

	}

}
