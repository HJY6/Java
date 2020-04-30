package number2;
import java.sql.Connection;
import java.util.*;
import java.util.regex.Pattern;

public class HanJinyu01 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        ArrayList list = new ArrayList();
        sortname ss = new sortname();
        ss.takename(list);
        ss.choose(list);

    }
}
class sortname{
    Scanner cin = new Scanner(System.in);
    String name;
    sortname(){}
    void takename(ArrayList list)
    {
        System.out.println("请输入用户名:");
        while (cin.hasNext()) {
            String namee = cin.next();
            this.name=new String(namee);
            if(this.name.equals("-1"))
                break;
            list.add(namee);
        }
    }
    void sortup(ArrayList list)
    {
            System.out.println("ASCII从小到大排序为:");
            Collections.sort(list);
            list.stream().forEach(
                item -> {
                    System.out.println(item);
                });
    }
    void sortdown(ArrayList list)
    {
        System.out.println("ASCII从大到小排序为:");
        Collections.reverse(list);
        list.stream().forEach(
                item -> {
                    System.out.println(item);
                });
    }
    void choose(ArrayList list)
    {
        System.out.println("请选择排序方案:");
        System.out.println("1.ASCII从小到大排序");
        System.out.println("1.ASCII从大到小排序");
        String num=cin.next();
        Pattern p =Pattern.compile("[0-9]+");
        boolean b = p.matcher(num).matches();
        if(!b)
            System.out.println("输入错误!");
        if(num.equals("1"))
            sortup(list);
        else if(num.equals("2"))
            sortdown(list);
        else
            System.out.println("输入错误:");

    }
}
