package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import entity.Node;

public class TrieUtil {

    public static Map<Character, Integer> charMap = new HashMap<Character, Integer>(26);

    static {
        char ch = 'a';
        for (int i = 0; i < 26; i++) {
            charMap.put(ch++, i);
        }
    }

    public static void addWordToTrie(String word, Node root) {
        char[] charArr = word.toCharArray();
        Node current = root;
        for (int i = 0; i < charArr.length; i++) {
            Node[] array = current.getArray();
            Integer _index = charMap.get(charArr[i]);

            // If the node array contains node at this index, increment i counter, update node and proceed.
            if (array[_index] != null) {
                current = array[_index];
                continue;
            } else {
                array[_index] = new Node(_index);
                current = array[_index];
            }

            if (i == charArr.length - 1 && !current.isLeaf()) {
                current.setLeaf(true);
            }
        }
    }

    public static List<String> suggest(String pattern, Node root) {
        List<String> suggestions = new ArrayList<String>();

        char[] charArr = pattern.toCharArray();
        Node current = root;

        for (int i = 0; i < charArr.length; i++) {
            Node[] array = current.getArray();
            Integer _index = charMap.get(charArr[i]);

            // If the node array contains node at this index, increment i counter, update node and proceed.
            if (array[_index] != null) {
                current = array[_index];
                continue;
            } else {
                System.err.println("No match found! Try searching for another pattern.");
                break;
            }
        }

        TrieUtil.getSuggestionsFromNode(pattern, suggestions, current);

        return suggestions;
    }

    /**
     * @param pattern
     * @param suggestions
     * @param current
     */
    public static void getSuggestionsFromNode(String pattern, List<String> suggestions, Node current) {
        String common = pattern.substring(0, pattern.length()-1);
        StringBuilder sbr = new StringBuilder();
        Set<Node> addedNodes = new HashSet<Node>();
        Stack<Node> stack = new Stack<Node>();
        stack.push(current);

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            if (node.isProcessed()) {
                if (sbr.charAt(sbr.length()-1) == (char) (node.getIndex() + 97)) {
                    sbr.setLength(sbr.length()-1);
                }
                continue;
            }

            node.setProcessed(true);
            stack.push(node);

            sbr.append((char) (node.getIndex()+97));

            if (node.isLeaf() && !addedNodes.contains(node)) {
                suggestions.add(common + sbr.toString());
                addedNodes.add(node);
            }

            for (int i=0; i<26; i++) {
                Node[] array = node.getArray();
                if (array[i] != null) {
                    Node temp = array[i];
                    stack.push(temp);
                    if (temp.isLeaf() && !addedNodes.contains(node)) {
                        String word = common + sbr.toString() + (char) (temp.getIndex()+97);
                        suggestions.add(word);
                        addedNodes.add(temp);
                    }
                }
            }
        }
    }
}
