package org.leetcode.easy;

/*
    Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
    You can use each character in text at most once. Return the maximum number of instances that can be formed.
 */

/*
    Example 1:

    Input: text = "nlaebolko"
    Output: 1


    Example 2:

    Input: text = "loonbalxballpoon"
    Output: 2


    Example 3:

    Input: text = "leetcode"
    Output: 0

    Constraints:
    1 <= text.length <= 10^4
    text consists of lower case English letters only.
 */

public class Leetcode_1189 {

    /**
     * Ref. https://leetcode.jp/leetcode-1189-maximum-number-of-balloons-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/
     * @param text
     * @return
     */
    private static int maxNumberOfBalloons(String text) {
        int[] count = new int[26]; // 计算出每种字符出现的次数
        for (int i = 0; i < text.length(); i++) {
            count[text.charAt(i) - 'a']++;
        }
        int res = Integer.MAX_VALUE; // 返回结果
        for (int i = 0; i < 5; i++) {
            char c = "balon".charAt(i); // 查看balon每个字符出现的次数
            int num = count[c - 'a'];
            if (c == 'l' || c == 'o') { // 如果是l或者o，次数除以2
                num /= 2;
            }
            if (num == 0) { // 如果出现次数为0，直接返回0
                return 0;
            }
            res = Math.min(res, num); // 找到出现次数最少的即是结果
        }
        return res;
    }

    public static void main(String[] args) {
        // HashMap<Character, Integer> mapA = parseCharList("balloon");
        // HashMap<Character, Integer> mapB = (HashMap<Character, Integer>) mapA.clone();
        // System.out.println(mapA);
        // mapB.remove('l');
        // System.out.println(mapA);

        // String text = "nlaebolko";
        // String text = "loonbalxballpoon";
        // String text = "leetcode";
        String text = "krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw";
        System.out.println("ans = " + maxNumberOfBalloons(text));
    }
}
