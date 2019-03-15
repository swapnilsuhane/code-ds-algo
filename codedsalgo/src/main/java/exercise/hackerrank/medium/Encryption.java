package exercise.hackerrank.medium;

public class Encryption {

    // Complete the encryption function below.
    static String encryption(String s) {
        int l = s.length();
        int r = Double.valueOf(Math.sqrt(l)).intValue();
        int c = r;
        if(r*r < l){
            c = r+1;
        }

        char[] chars = new char[l+(c-1)];
        for (int i = 0, row=0, col=0; i < chars.length; i++, row++) {

            int idx = col+(row*c);
            if(idx>=s.length()){
                chars[i] = " ".charAt(0);
                col++;
                row=-1; //as increments to 1 in same loop
                continue;
            } else {
                char c1 = s.substring(idx, idx + 1).charAt(0);
                System.out.println(c1);
                chars[i] = c1;
            }
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(encryption("haveaniceday"));
    }
}
