package other;

import merchants.AuctionMerchant;
import merchants.Merchant;

/**
 * Represents a bid in an auction, a neat way to store data
 * 
 * @author Eylam
 *
 */
public class Bid {
	private Player player;
	private int bid;

	/**
	 * New bid made by player
	 * 
	 * @param p   Player making bid
	 * @param bid amount put into bid
	 */
	public Bid(Player p, int bid) {
		player = p;
		this.bid = bid;
	}

	/**
	 * 
	 * @return bonus amount from Auction Merchant
	 */
	public int bonus() {
		int bonus = 0;

		for (Merchant m : player.getMerchants()) {
			if (m instanceof AuctionMerchant) {
				bonus += ((AuctionMerchant) m).auction(m.getLevel());
			}
		}

		return bonus;
	}

	/**
	 * 
	 * @return player making bid
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * 
	 * @return bid amount
	 */
	public int getAmount() {
		return bid + bonus();
	}

	/**
	 * Set bid amount
	 * 
	 * @param val amount set into bid
	 */
	public void setAmount(int val) {
		bid = val;
	}

}
