
public class SafeHouse extends NormalLocation {

	SafeHouse(Player player) {
		super(player, "Güvenli ev");
	}
	
	@Override
	public boolean getLocation() {
		player.setHealth(player.getrHealth());
		System.out.println("Canınız tamamen doldu!");
		System.out.println("Şuan Güvenli Evdesiniz.");
		return true;
	}
	
}
