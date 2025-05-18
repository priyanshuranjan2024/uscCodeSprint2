public class IceCream {

    public static boolean canBuyExactIceCream(int budget, int[] iceCreamPrices) {
        for (int price : iceCreamPrices) if (price == budget) return true;
        return false;
    }

    public static void main(String[] args) {
        int budget = 30;
        int[] iceCreamPrices = {10, 25, 30, 50};

        boolean result = canBuyExactIceCream(budget, iceCreamPrices);
        System.out.println(result);
    }
}