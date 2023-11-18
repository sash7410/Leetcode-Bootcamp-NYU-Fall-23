import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Node {
    Map<Character, Node> children;
    boolean isWord;

    public Node() {
        children = new HashMap<>();
        isWord = false;
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new Node());
            current = current.children.get(ch);
        }
        current.isWord = true;
    }
}

public class Solution {
    Trie trie;
    int rows, cols;
    Map<String, Boolean> ans;

    public List<String> findWords(char[][] board, String[] words) {
        trie = new Trie();
        rows = board.length;
        cols = board[0].length;
        ans = new HashMap<>();

        for (String word : words) {
            trie.insert(word);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, i, j, "", trie.root);
            }
        }

        return new ArrayList<>(ans.keySet());
    }

    private void dfs(char[][] board, int i, int j, String path, Node root) {
        char ch = board[i][j];
        if (!root.children.containsKey(ch)) {
            return;
        }

        path += ch;
        board[i][j] = '#'; // Mark as visited

        root = root.children.get(ch);
        if (root.isWord) {
            ans.put(path, true);
        }

        int[] rowOffsets = {-1, 1, 0, 0};
        int[] colOffsets = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int newRow = i + rowOffsets[k];
            int newCol = j + colOffsets[k];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && board[newRow][newCol] != '#') {
                dfs(board, newRow, newCol, path, root);
            }
        }

        board[i][j] = ch; // Reset
    }
}
