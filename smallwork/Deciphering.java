/**
 * @author 韩金宇
 * @version 1.0
 * @date 2020-04-15
 */
package number2;
import java.lang.Character;
import java.util.*;
public class HanJinyu02 {
    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        System.out.println("需要破解的字符串为:");
        String sen = "Zzp†#zyz~5{#y5†~~†z5p~{##zp5{y5†~~†z5p~{zp#5†z{{";
        System.out.println(sen);
        deciphering d = new deciphering();
        d.sentence = new String(sen);
        d.solve();
    }
}
class deciphering{
    deciphering(){}
    String sentence;
    void solve() {
        String[] arrey = sentence.split("#");
        ArrayList list = new ArrayList();
        String newa = "";
        for (String str : arrey)
            newa += str;
        //System.out.println(newa);//分割拼接
        for (int i = 0; i < newa.length(); i++) {
            char ch = newa.charAt(i);
            int a = newa.charAt(i);
            if ((a >= 65 && a <= 90) || ((a >= 97 && a <= 122)))
            {
                String test=Character.toString(ch);
                list.add(test);
            }
        }
       for(int i=0;i<list.size();i++)
       {
           String chh=list.get(i).toString();
           char chhh=chh.charAt(0);
           int k=chh.charAt(0);
           char aim=(char)(k-3);
           newa=newa.replace(chhh,aim);//替换
       }
        System.out.println("解密后的字符串为:\n"+newa);
    }

}
