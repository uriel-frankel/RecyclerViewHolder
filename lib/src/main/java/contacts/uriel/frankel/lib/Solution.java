package uriel.frankel.lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                answer[0] = map.get(target - nums[i]);
                answer[1] = nums[i];
                return answer;
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }


    private void mergeSort(ArrayList<Integer> list) {
        int i = list.size() / 2;
        while (i > 1) {
            for (int j = 0; j < i; j++) {


                int jump2 = (list.size() / i) / 2;
                for (int l = 0; l < jump2; l++) {
                    int i1 = l + j * jump2 * 2 + jump2;
                    int i2 = l + j * jump2 * 2;
                    System.out.println("index 1 = " + i2 + "   index 2 = " + i1);
                    if (list.get(i2) > list.get(i1)) {
                        Collections.swap(list, i2, i1);
                    }
                }

            }
            i = i / 2;
        }


    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode node = null;
        int co = 0;
        while (l1 != null || l2 != null || co > 0) {
            int a = 0, b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }

            int sum = a + b + co;
            if (sum >= 10) {
                co = 1;
                sum = sum - 10;
            } else {
                co = 0;
            }
            if (head == null) {
                head = new ListNode(sum);
                node = head;
            } else {
                node.next = new ListNode(sum);
                node = node.next;
            }

        }
        return head;

    }

    /*
    Input: "abcadefghijk"
    Output: 3
     */
//    public int lengthOfLongestSubstring(String s) {
//        if (s == null) return 0;
//        int maxLength = 0;
//        int currentLength = 0;
//        int currentIndex;
//        HashSet<Character> set = new HashSet<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i); //c = c
//            if (set.contains(c)) {
//                set.clear();
//                currentLength = 0;
//            } else {
//                set.add(c);//set = {a,b,c}
//                currentLength++; //currentLength = 3
//            }
//            if (currentLength > maxLength) {
//                maxLength = currentLength;//maxLength = 3
//            }
//        }
//        return maxLength;
//    }


    public int lengthOfLongestSubstring(String s) {//abcadefghijk
        if (s == null) return 0;
        int maxLength = 0; // maxLength = 0;
        for (int i = 0; i < s.length(); i++) { //i=0
            String sub = "";
            for (int j = i; j < s.length(); j++) {
                String c = s.substring(j, j + 1); //j=0 c=a
                if (sub.contains(c)) {
                    break;
                } else {
                    sub = sub.concat(c); //sub = a
                }
            }
            int currentLength = sub.length();
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }

        }
        return maxLength;
    }

    public int isInterleave(String A, String B, String C) {
        int counterA = 0;
        int counterB = 0;
        int lenA = A.length();
        int lenB = B.length();
        char[] aAsChars = A.toCharArray();
        char[] bAsChars = B.toCharArray();
        for (int i = 0; i < C.length(); i++) {
            char c = C.charAt(i);
            if (counterA < lenA && c == aAsChars[counterA]) {
                counterA++;
            }
            if (counterB < lenB && c == bAsChars[counterB]) {
                counterB++;
            }
        }
        return (counterA == lenA && counterB == lenB) ? 1 : 0;
    }

    public int strongPasswordChecker(String s) {
        int change = 0;
        if (s.length() < 6) {
            change = 6 - s.length();
        }
        if (s.length() > 20) {
            change = s.length() - 20;
        }

        boolean hasLowChar = false;
        boolean hasUpperChar = false;
        boolean hasDigit = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                hasLowChar = true;
            }
            if (c >= 'A' && c <= 'Z') {
                hasUpperChar = true;
            }
            if (c >= '0' && c <= '9') {
                hasDigit = true;
            }
        }
        if (!hasDigit) {
            change++;

        }
        if (!hasLowChar) {
            change++;
        }
        if (!hasUpperChar) {
            change++;
        }
        char test = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

        }

        return change;
    }


//    public boolean isRhyming(String s1, String s2) {
//        if (s1.length() != s2.length()) {
//            return false;
//        }
//        HashMap<Character, Character> map = new HashMap<>();
//        for (int i = 0; i < s1.length(); i++) {
//            char c1 = s1.charAt(i);
//            char c2 = s2.charAt(i);
//            if (map.containsKey(c1) && map.get(c1) != c2) {
//                return false;
//            }
//            if (map.containsKey(c2) && map.get(c2) != c1) {
//                return false;
//            }
//            map.put(c1, c2);
//            map.put(c2, c1);
//
//        }
//        return true;
//    }
//
//
//    public int isRhyming(String s1, String s2) {
//        if (s1.length() != s2.length()) {
//            return false;
//        }
//        HashMap<Character, Character> map = new HashMap<>();
//        for (int i = 0; i < s1.length(); i++) {
//            char c1 = s1.charAt(i);
//            char c2 = s2.charAt(i);
//            if (map.containsKey(c1) && map.get(c1) != c2) {
//                return false;
//            }
//            if (map.containsKey(c2) && map.get(c2) != c1) {
//                return false;
//            }
//            map.put(c1, c2);
//            map.put(c2, c1);
//
//        }
//        return true;
//    }


    public static void main(String[] arg) {
        Solution solution = new Solution();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        solution.mergeSort(list);
        boolean isSorted = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                isSorted = false;
            }
        }
        System.out.println(list);
        if (isSorted) {
            System.out.println("list is sorted");
        } else {
            System.out.println("list isn't sorted");

        }
    }
}
