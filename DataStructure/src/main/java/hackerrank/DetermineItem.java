package hackerrank;

import java.util.*;

/**
 * Created by ritesh on 9/4/16.
 */
public class DetermineItem {

    public static void main(String args[]) {


    }


    static int[] determineRecommendation(String itemId, String[] purchases) {

        final Map<String, List<String>> customerItemPurchases = new HashMap<>();
        final Map<String,List<String>> itemCustomerPurchases = new HashMap<>();

        // Pre-setup
        // Create a map of customerByItem and ItemByCutomer.
        for(final String purchase: purchases) {

            String[] customerPurchase = purchase.split(":");

            final String customer = customerPurchase[0];
            final String purchaseItem = customerPurchase[1];

            if(customerItemPurchases.get(customer)==null){
                final List<String> purchaseItems = new ArrayList<>();
                purchaseItems.add(purchaseItem);
            }else {
                final List<String> puchaseItems = customerItemPurchases.get(customer);
                puchaseItems.add(purchaseItem);
            }

            if(itemCustomerPurchases.get(purchaseItem) == null) {
                final List<String> customers = new ArrayList<>();
                customers.add(customer);
            }else {
                final List<String> customers = itemCustomerPurchases.get(purchaseItem);
                customers.add(customer);
            }
        }

        // Logic initiated
        int[] output = new int[2];
        int stronglyConnected = 0;

        final List<String> itemsPurchased = new ArrayList<>();
        final List<String> customersPurchased = new ArrayList<>();

        // strong link
        for(final Map.Entry<String,List<String>> customerItemPurchase : customerItemPurchases.entrySet()) {

            List<String> items = customerItemPurchase.getValue();

            // item purchased by the customer. Also save all the items he purchased for strong link.
            if(items.contains(itemId)) {

                // Remove the strong link item, only add weak links for future logic.
                itemsPurchased.addAll(items);
                itemsPurchased.remove(itemId);

                final String customer = customerItemPurchase.getKey();
                customersPurchased.add(customer);

                stronglyConnected = stronglyConnected + items.size()-1;
            }
        }

        final Stack<String> stack = new Stack<>();
        int weaklyConnected = 0;

        // weak link
        for(final String itemPurchased : itemsPurchased) {

            stack.push(itemPurchased);

            while(!stack.isEmpty()) {

                final String item = stack.pop();
                final List<String> customers = itemCustomerPurchases.get(item);

                // Determine which customers purchases the weak link items (which is related to the items purchased by the customer, who purchased the strong link item).
                for(final String customer : customers) {

                    if(!customersPurchased.contains(customer))  {

                        List<String> items = customerItemPurchases.get(customer);

                        for(final String stackItem : items) {
                            if(!itemsPurchased.contains(stackItem)) {
                                stack.push(stackItem);
                                weaklyConnected = weaklyConnected + 1;
                            }
                        }

                        customersPurchased.add(customer);
                    }
                }
            }
        }

        output[0] = stronglyConnected;
        output[1] = weaklyConnected;

        return output;
    }
}
