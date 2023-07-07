class WordFilter {
TrieNode trie;

    public WordFilter(String[] words) {
        trie = new TrieNode();
        for (int weight = 0; weight < words.length; weight++) {
            String word = words[weight] + "{";
            for (int i = 0; i < word.length(); i++) {
                TrieNode cur = trie;
                cur.weight = weight;
                for (int j = i; j < 2 * word.length() - 1; j++) {
                    int k = word.charAt(j % word.length()) - 'a';
                    if (cur.children[k] == null)
                        cur.children[k] = new TrieNode();
                    cur = cur.children[k];
                    cur.weight = weight;
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        TrieNode cur = trie;
        for (char c : (suffix + '{' + prefix).toCharArray()) {
            if (cur.children[c - 'a'] == null)
                return -1;
            cur = cur.children[c - 'a'];
        }
        return cur.weight;
    }

    class TrieNode {
        TrieNode[] children;
        int weight;

        TrieNode() {
            children = new TrieNode[27];
            weight = 0;
        }
    }
}
/* Time Complexity: O(N * M * (2M - 1)) and O(K)
* Space Complexity: O(N * M * (2M - 1)) and O(1)
*/
