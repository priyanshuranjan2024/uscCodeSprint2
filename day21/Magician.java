import java.util.*;

public class Magician{

  private static int[] deckSortedTrick(int[] deck){
    int n=deck.length;
    int[] sortedDeck=deck.clone();
    Arrays.sort(sortedDeck);

    Deque<Integer> result=new ArrayDeque<>();
    for(int i=n-1;i>=0;i--){
      result.addFirst(sortedDeck[i]);
      if(i>0){
        int lastCard=result.removeLast();
        result.addFirst(lastCard);
      }
    }

    return result.stream().mapToInt(Integer::intValue).toArray();
     
  }
  
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int[] deck=Arrays.stream(sc.nextLine().trim().split(" "))
      .mapToInt(Integer::parseInt).toArray();

    int[] result=deckSortedTrick(deck);
    System.out.println(Arrays.toString(result));
    sc.close();
  }
}