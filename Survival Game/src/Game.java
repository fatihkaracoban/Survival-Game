import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner sc = new Scanner(System.in);

	public void login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Macera Oyununa Hoş Geldiniz!!!");
		System.out.print("Oyuna başlamadan önce isminizi giriniz: ");
		String playerName = sc.nextLine();
		player = new Player(playerName);
		player.selectCharacter();
		start();
	}

	public void start() {
		while (true) {
			System.out.println();
			System.out.println("*********************************************");
			System.out.println();
			System.out.println("Eylem gerçekleştirmek için bir yer seçiniz: ");
			System.out.println("1. Güvenli Ev --> Size ait güvenli bir mekan, düşman yok!");
			System.out.println("2. Mağara --> Karşınıza Zombi çıkabilir!");
			System.out.println("3. Orman --> Karşınıza Vampir çıkabilir!");
			System.out.println("4. Nehir --> Karşınıza Ayı çıkabilir!");
			System.out.println("5. Mağaza --> Silah veya Zırh alabilirsiniz!");
			System.out.println("Gitmek istediğiniz yer: ");
			int selectLocation = sc.nextInt();
			while (selectLocation < 0 || selectLocation > 5) {
				System.out.println("Lütfen geçerli bir yer seçiniz: ");
				selectLocation = sc.nextInt();
			}

			switch (selectLocation) {
			case 1:
				location = new SafeHouse(player);
				break;
			case 2:
				location = new Cave(player);
				break;
			case 3:
				location = new Forest(player);
				break;
			case 4:
				location = new River(player);
				break;
			case 5:
				location = new ToolStore(player);
				break;
			default:
				location = new SafeHouse(player);
				break;
			}

			if (location.getClass().getName().equals("SafeHouse")) {
				if(player.getInventory().isFirewood() && player.getInventory().isFood() && player.getInventory().isWater()) {
					System.out.println("Tebrikler oyunu kazandınız !");
					break;
				}
			}
			if (!location.getLocation()) {
				System.out.println("Oyun Bitti!");
				break;
			}
		}
	}
}
