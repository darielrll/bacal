package drll.problems.leetCodeContest.LargestPalindromicNumber;

import java.util.*;

public class Solution {
    public String largestPalindromic(String num) {
        HashMap<Integer, Integer> register = getDigitsRegister(num);

        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : register.entrySet()) {
            Integer value = entry.getValue();
            Integer key = entry.getKey();
            if(value % 2 == 0){
                even.add(key);
                register.replace(key, value / 2);
            }
            else {
                odd.add(key);
                if(value > 2){
                    register.replace(key, (value - 1) / 2);
                    even.add(key);
                }
            }
        }

        even.sort(Comparator.reverseOrder());
        odd.sort(Comparator.reverseOrder());

        StringBuilder bufferLeft = new StringBuilder();
        for (int i = 0; i < even.size(); i++) {
            Integer digit = even.get(i);
            if (digit != 0 || i != 0) {
                bufferLeft.append(String.join("",
                        Collections.nCopies(register.get(digit), digit.toString())));
            }
        }
        StringBuilder bufferRight = new StringBuilder(bufferLeft).reverse();
        if(!odd.isEmpty()){
            bufferLeft.append(odd.get(0).toString());
        }
        bufferLeft.append(bufferRight);

        return bufferLeft.length() == 0 ? "0" : bufferLeft.toString();
    }

    private HashMap<Integer, Integer> getDigitsRegister(String num) {
        HashMap<Integer, Integer> register = new HashMap<>();

        int length = num.length();
        for (int i = 0; i < length; i++) {
            int digit = Character.getNumericValue(num.charAt(i));
            if(register.containsKey(digit)){
                register.replace(digit, register.get(digit) + 1);
            }
            else {
                register.put(digit, 1);
            }
        }
        return register;
    }
}