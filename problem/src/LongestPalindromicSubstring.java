public class LongestPalindromicSubstring{
    private static String longestPalindromeN3(String s) {
        int maxLength =1;
        String output =s.substring(0,1);
        int n = s.length();
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                String current = s.substring(i,j+1);
                System.out.println("current "+current);
                if(isPalindrome(current) && current.length()>maxLength){
                    maxLength = current.length();
                    output = current;
                }
            }
        }
        return output;
    }
    private static boolean isPalindrome(String s) {
        // Compare characters from start and end of the string
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Expand from center
    private static String longestPalindromeExpandFromCenter(String s) {
        if(s.length()<=1){
            return s;
        }
        String output = s.substring(0,1);
        for (int i = 0; i < s.length()-1; i++) {
            String odd = expandFromCenter(s,i,i);
            String even = expandFromCenter(s,i,i+1);
            if(odd.length()>output.length()){
                output = odd;
            }
            if(even.length()> output.length()){
                output = even;
            }
            System.out.println(output);
        }
        return output;
    }

    private static String expandFromCenter(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }

    public static void main(String args[]){
        System.out.println(longestPalindromeExpandFromCenter("babad"));
    }
}