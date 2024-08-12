package DynamicProgramming_4.PresentBriefly_2.计数问题.隐晦的递推关系.屏幕可显示句子的数量;

public class Main {

    public static int wordsTyping(String[] sentence, int rows, int cols) {

        // 将整个句子拼接成一个字符串，每个单词之间用一个空格隔开，并在最后添加一个空格
        String sentenceStr = String.join(" ", sentence) + " ";

        // 记录当前要显示的字符的位置
        int pos = 0;
        int len = sentenceStr.length();

        // 遍历每一行
        for (int i = 0; i < rows; i++) {

            // 直接将这一行的列数加到当前字符的位置上
            pos += cols;

            // 如果当前字符的位置在空格上，说明刚好可以放下一个完整的单词
            if (sentenceStr.charAt(pos % len) == ' ') {
                pos++; // 跳过这个空格
            } else {

                // 如果当前位置不在空格上，说明这一行的最后部分没有放下一个完整的单词
                // 向前移动到上一个空格的位置，确保单词不会被分割到两行
                while (pos > 0 && sentenceStr.charAt((pos - 1) % len) != ' ') {

                    pos--;
                }
            }
        }

        return pos / len;
    }

    public static void main(String[] args) {

        String[] sentence = {"hello", "world"};

        int rows = 2;
        int cols = 8;

        System.out.println(wordsTyping(sentence, rows, cols));

    }
}
