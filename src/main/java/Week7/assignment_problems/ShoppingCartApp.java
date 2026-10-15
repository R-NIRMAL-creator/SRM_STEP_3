package main.java.Week7.assignment_problems;

public class ShoppingCartApp {

    static class Cart {
        private final String cartId;
        private final int[] prices;
        private int count;

        Cart(String cartId, int maxItems) {
            this.cartId = cartId;
            this.prices = new int[maxItems];
        }

        void addItem(int price) {
            if (count < prices.length) {
                prices[count++] = price;
            }
        }

        int getTotal() {
            int total = 0;
            for (int i = 0; i < count; i++) {
                total += prices[i];
            }
            return total;
        }

        int getItemCount() {
            return count;
        }

        String getCartId() {
            return cartId;
        }
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println("Cart " + cart.getCartId());
        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}
