import java.util.*;
import java.util.Random;
import javax.swing.*;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.math.BigInteger;
import java.awt.Dimension;


public class Main {
        public int k=1;
    public void combinations(String str, int i) {
        if (i == str.length() - 1) {
            System.out.println(k++ + " -> " +str);
            return;
        }
        for (int j = i; j < str.length(); j++) {
            str = swap(str, i, j);
            combinations(str, i + 1);
            str = swap(str, i, j);
        }
    }

    public String swap(String s, int x, int y) {
        char[] a = s.toCharArray();
        char temp = a[x];
        a[x] = a[y];
        a[y] = temp;
        return String.valueOf(a);
    }
	// Factorial Class 
     public static class Factorial {
        static BigInteger factorial(int N)
        {
            // Initialize result
            BigInteger f
                = new BigInteger("1"); // Or BigInteger.ONE
     
            // Multiply f with 2, 3, ...N
            for (int i = 2; i <= N; i++)
                f = f.multiply(BigInteger.valueOf(i));
     
            return f;
        }
     }
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in); // CLI input
        int pas_Strength, len, i, index;
        char ch;
        StringBuilder str = new StringBuilder();
        String Sample = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*?`~1234567890";

        //Factorial objj = new Factorial(); 
        pas_Strength = Integer.parseInt(JOptionPane.showInputDialog(null, "\n" + "     Enter desired characters: " + "\n")); // INPUT GUI

        len = Sample.length();
        String password = "";

		/*           --CLI--
        System.out.println("Enter the Strength of the password that you want " + "\n");
        System.out.println("Your Strength should not exceed 8");
		*/ 
        if (pas_Strength <= 16384) { 
            System.out.println("Your Password Character Lenght is = " + pas_Strength + "\n"); // Shows the number of characters entered into the GUI dialog box in CLI
            Random random = new Random();
            for (i = 0; i < pas_Strength; i++) {
                index = random.nextInt(len);
                ch = Sample.charAt(index);
                str.append(ch);
            }
            password = str.toString();
            System.out.println("Your password generated is: " + password + "\n"); // CLI OUTPUT

            String print = ( "\n" + "      The password generated is " + password + ".       " + "\n" +"      Total combinations are " + Main.Factorial.factorial(str.length()) + "." + "\n" + "\n" );
            JOptionPane.showMessageDialog(null, print); // OUTPUT GUI

            // Copies the password to the clipboard
            Toolkit toolkit = Toolkit.getDefaultToolkit();
		    Clipboard clipboard = toolkit.getSystemClipboard();
		    StringSelection strSel = new StringSelection(password);
		    clipboard.setContents(strSel, null);

        } else {;
            System.out.println("Your limit is exceeded"); // CLI OUTPUT
        }
        Main obj = new Main();
        obj.combinations(password, 0);
    }
}
