package other;

import java.awt.Color;
import java.util.ArrayList;

import board.Tile;
import merchants.Merchant;
import merchants.MoneyMerchant;

/**
 * 
 * @author Eylam Tagor
 * 
 *         Represents one of the game's Players, and manages merchants,
 *         territory and income.
 *
 */
public class Player {

	private int id, balance;
	private String name;
	private final Color color;
	private int income, auctionBonus, landBonus;
	private ArrayList<Merchant> merchants;
	private ArrayList<Tile> territory;

	/**
	 * Creates a new Player object with 5 regular merchants and no territory.
	 * 
	 * @param id      the player's number in relation to other players
	 * @param balance the player's starting balance, used to expand territory and
	 *                upgrade merchants
	 * @param name    the username of the player
	 * @param color   the player's color
	 * @param initX   the player's initial starting location's x-coordinate
	 * @param initY   the player's initial starting location's y-coordinate
	 */
	public Player(int id, int balance, String name, Color color, Merchant merchant) {
		this.setId(id);
		this.setBalance(balance);
		this.name = name;
		this.color = color;

		auctionBonus = 0;
		landBonus = 0;

		merchants = new ArrayList<Merchant>();
		merchant.setColor(color);
		merchants.add(merchant);

		territory = new ArrayList<Tile>();
	}

	public void increaseIncome(int x) {
		setIncome(getIncome() + x);
	}

	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}

	public void upgradeMerchant(int i, char type) {
//		switch (type) {
//		case 'a':
//			AuctionMerchant am = new AuctionMerchant(merchants[i].getX(), merchants[i].getY());
//			merchants[i] = am;
//			break;
//		case 's':
//			SpeedMerchant sm = new SpeedMerchant(merchants[i].getX(), merchants[i].getY());
//			merchants[i] = sm;
//			break;
//		case 'l':
//			LandMerchant lm = new LandMerchant(merchants[i].getX(), merchants[i].getY());
//			merchants[i] = lm;
//			break;
//		case 'i':
//			InvisibleMerchant im = new InvisibleMerchant(merchants[i].getX(), merchants[i].getY());
//			merchants[i] = im;
//			break;
//		case 'm':
//			MoneyMerchant mm = new MoneyMerchant(merchants[i].getX(), merchants[i].getY());
//			merchants[i] = mm;
//			break;
//		default:
//			break;
//		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public ArrayList<Tile> getTerritory() {
		return territory;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public void update() {

		for (int i = 0; i < merchants.size(); i++) {
			if (merchants.get(i) instanceof MoneyMerchant)
				income += 10;
		}
	}

	public ArrayList<Merchant> getMerchants() {
		return merchants;
	}
	
	public void addTerritory(Tile t) {
		territory.add(t);
	}
}
