
/**
 *
 */
class Template {
    public static int problem(String s) {

        return 0;
    }

    // Custom test case runner
    public static void main(String[] args) {
        // Test cases
        runTest("abcabcbb", 3);
        runTest("bbbbb", 1);
        runTest("pwwkew", 3);
    }

    static int runNumber = 1;
    // Test runner (throws AssertionError if test fails)
    private static void runTest(String param1, int expected) {
        int result = problem(param1);
        assert result == expected : String.format("❌ Failed: run %d", runNumber);
        System.out.println("✅ Passed:" + runNumber++);
    }
}