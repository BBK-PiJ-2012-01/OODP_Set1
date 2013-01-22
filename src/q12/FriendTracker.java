package q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static util.CollectionsUtil.listOf;

/**
 * User: Sam Wright
 * Date: 22/01/2013
 * Time: 12:26
 */
public class FriendTracker {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        map.put("Sue", listOf("Bob", "Jose", "Alex", "Cathy"));
        map.put("Cathy", listOf("Bob", "Alex"));
        map.put("Bob", listOf("Jose", "Alex", "Jerry"));

        String input;
        do {
            try {
                System.out.print("Enter a name (Sue, Cathy or Bob): ");
                input = br.readLine();
                if (input == null || input.isEmpty())
                    break;
            } catch (IOException e) {
                break;
            }

            List<String> friends = map.get(input);

            if (friends == null) {
                System.out.format("Name '%s' was not found\n", input);
            } else {
                System.out.format("'%s' has friends: %s\n", input, friends);
            }

        } while (true);
    }
}
