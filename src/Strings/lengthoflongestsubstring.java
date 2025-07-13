package Strings;

/**
 * 3 !!
 */
class lengthoflongestsubstring {
    public static int problem(String s) {
        if (s.length() <= 1){
            return s.length();
        }
        int[] dict = new int[128];
        int l = 0, r = 0, max_length = 0, current_length = 0;
        while(r < s.length()) {
            dict[ s.charAt(r) ]++;
            while(dict[ s.charAt(r) ] > 1) {
                dict[ s.charAt(l) ]--;
                current_length--;
                l++;
            }
            current_length++;
            if (current_length > max_length){
                max_length = current_length;
            }
            r++;
        }
        return max_length;
    }

    // Custom test case runner
    public static void main(String[] args) {
        // Test cases
        runTest("", 0);
        runTest("a", 1);
        runTest("ac", 2);
        runTest("abcabcbb", 3);
        runTest("bbbbb", 1);
        runTest("pwwkew", 3);
        runTest(" ", 1);
        runTest("!!!", 1);
        runTest("abc!a", 4);
    }

    static int runNumber = 1;
    // Test runner (throws AssertionError if test fails)
    private static void runTest(String param1, int expected) {
        int result = problem(param1);
        assert result == expected : String.format("❌ Failed: run %d", runNumber);
        System.out.println("✅ Passed:" + runNumber++);
    }
}