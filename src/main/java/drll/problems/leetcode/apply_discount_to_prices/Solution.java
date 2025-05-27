package drll.problems.leetcode.apply_discount_to_prices;

import java.text.DecimalFormat;

public class Solution {
    public String discountPrices(String sentence, int discount) {
        StringBuffer buffer = new StringBuffer();

        String[] prices = sentence.split(" ");
        for (int i = 0; i < prices.length; i++) {
            String priceString = prices[i];
            if(isValidPrice(priceString)){
                double price = Double.parseDouble(priceString.substring(1));
                price = price - price * discount / 100;
                DecimalFormat format1 = new DecimalFormat("0.00");
                String format = format1.format(price);
                buffer.append("$");
                buffer.append(format);
            }
            else{
                buffer.append(priceString);
            }
            if(i < prices.length - 1){
                buffer.append(" ");
            }
        }

        return buffer.toString();
    }

    private boolean isValidPrice(String priceString) {
        if(priceString.startsWith("$")){
            try{
                Double.parseDouble(priceString.substring(1));
                return true;
            }
            catch (Exception e){
                return false;
            }
        }
        return false;
    }
}