package org.leetcode.easy;

import javafx.beans.binding.StringBinding;

import java.util.HashSet;
import java.util.Set;

/*
    Every email consists of a local name and a domain name, separated by the @ sign.
    For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
    Besides lowercase letters, these emails may contain '.'s or '+'s.
    If you add periods ('.') between some characters in the local name part of an email address,
    mail sent there will be forwarded to the same address without dots in the local name.
    For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)
    If you add a plus ('+') in the local name, everything after the first plus sign will be ignored.
    This allows certain emails to be filtered,
    for example:
        m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)
    It is possible to use both of these rules at the same time.
    Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?

    Example 1:
    Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
    Output: 2
    Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails

    Note:
    1 <= emails[i].length <= 100
    1 <= emails.length <= 100
    Each emails[i] contains exactly one '@' character.
    All local and domain names are non-empty.
    Local names do not start with a '+' character.
 */
public class Leetcode_929 {

    private static int numUniqueEmails(String[] emails) {
        Set<String> hset = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            String localName = emails[i].split("@")[0];
            String domainName = emails[i].split("@")[1];

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < localName.length(); j++) {
                char ch = localName.charAt(j);
                switch (ch) {
                    case '.':
                        continue;
                    case '+':
                        j = localName.length() - 1;
                        break;
                    default:
                        sb.append(ch);
                        continue;
                }
            }
            sb.append("@").append(domainName);
            // System.out.println(sb.toString());
            hset.add(sb.toString());
        }
        return hset.size();
    }

    public static void main(String[] args) {
        String[] emails = { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com" };
        System.out.println("ans = " + numUniqueEmails(emails));
    }
}
