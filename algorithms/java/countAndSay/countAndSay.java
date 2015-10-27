package countAndSay;

//todo
public class countAndSay {
    /*  found nobody answered this question in Java. Actually I got some trouble even this question is not so hard.

      Maybe many other people had some trouble too. So I put my answer here.*/
    public String countAndSay(int n) {
        StringBuilder curr = new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;
        for (int i = 1; i < n; i++) {
            prev = curr;
            curr = new StringBuilder();
            count = 1;
            say = prev.charAt(0);

            for (int j = 1, len = prev.length(); j < len; j++) {
                if (prev.charAt(j) != say) {
                    curr.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                } else count++;
            }
            curr.append(count).append(say);
        }
        return curr.toString();

    }

   /* @code StringBuilder.append() is the default way to append one string to another. While I have tried String.cancate(),which is not working properly.

    Any comment is welcomed.*/

}
