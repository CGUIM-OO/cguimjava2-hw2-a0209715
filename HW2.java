import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: please add student ID and name here
 *  * B0444241 胡洺碩
 * Try to write some comments for your codes (methods, 15 points)
 * 首先在Card的class中，用兩個switch迴圈分別處理su、rk這兩個變數，su拿來存放花色，rk用來存放1~13，最後用System.out.println print出來。
 * 再來在Dec的class中，先用三個for迴圈，最外面一層是根據幾副牌決定裡面那兩個要跑幾次，中間那層是因為有四種花色所以跑四次，最裡面一層是因為一種花色有13張所以跑13次。
 * 在printDec中使用for迴圈裡面放get來抓陣列裡的資料，使用printCard這個method來印出來
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards �������
	 * @param nDeck 蝮賢��嗾����
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: TODO: please add description here
 */
class Deck{
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end

		for (int i = 1; i <= nDeck; i++) {
			for (int j = 1; j <= 4; j++) {
				for (int m = 1; m <= 13; m++) {
					Card card = new Card(j, m);
					cards.add(card);
				}
			}
		}

		
	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)

		
		for(int l = 0; l < cards.size(); l++) {
			Card takecard = cards.get(l);
			takecard.printCard();
		}

		
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: TODO: please add description here
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace

		String su = "";
		String rk = "";

		switch (suit) {
		case 1:
			su = "Clubs";
			break;
			
		case 2:
			su = "Diamonds";
			break;
			
		case 3:
			su = "Hearts";
			break;
			
		case 4:
			su = "Spades";
			break;
		}

		switch (rank) {
		case 1:
			rk = "Ace";
			break;
			
		case 2:
			rk = "Two";
			break;
			
		case 3:
			rk = "Three";
			break;
			
		case 4:
			rk = "Four";
			break;
			
		case 5:
			rk = "Five";
			break;
			
		case 6:
			rk = "Six";
			break;
			
		case 7:
			rk = "Seven";
			break;
			
		case 8:
			rk = "Eight";
			break;
			
		case 9:
			rk = "Nine";
			break;
			
		case 10:
			rk = "Ten";
			break;
			
		case 11:
			rk = "Jack";
			break;
			
		case 12:
			rk = "Queen";
			break;
			
		case 13:
			rk = "King";
			break;
		}
		System.out.println(suit + "," + rank + " as " + su + " " + rk);
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
