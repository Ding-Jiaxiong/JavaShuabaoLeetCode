package DynamicProgramming_4.PresentBriefly_2.计数问题.卡特兰数.不同的二叉搜索树;

public class Main {

    public static int numTrees(int n) {

        int[] dp = new int[n + 1];  // dp[i] 的值为所有可能的左子树和右子树组合的乘积之和

        dp[0] = 1; // 空树
        dp[1] = 1; // 只有一个节点

        // 从 2 个节点开始计算
        for (int i = 2; i <= n; i++) {

            // 对于每个i，依次以每个节点作为根节点，计算总数
            for (int j = 1; j <= i; j++) {

                // dp[i] 的值为所有可能的根节点组合的数量之和
                dp[i] += dp[j - 1] * dp[i - j];  // dp[j-1] 是左子树的数量，dp[i-j] 是右子树的数量
            }
        }

        return dp[n];  // n个节点组成的二叉搜索树的总数量
    }

    public static void main(String[] args) {

        int n = 3;

        System.out.println(numTrees(n));

    }
}
