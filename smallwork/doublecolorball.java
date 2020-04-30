package number1;
/**
 * @author 韩金宇
 * @version 1.0
 * @date 2020-04-07
 */
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class HanJinyu01 {
    public static void main(String[] args)
    {
        openprice op = new openprice();
        op.dispnowtime();//输出现在时间
        op.choosered();//选择红球号码
        op.chooseblue();//选择蓝球号码
        op.dispredchoice();//输出选择的红球号码
        op.dispbluechoice();//输出选择的蓝球号码
        op.dispopentime();//输出开奖时间
        op.dispopenred();//输出红球开奖的6个号码
        op.dispopenblue();//输出蓝球开奖的1个号码
        op.dispendtime();//输出结束开奖时间
        op.dispredprice();//输出红色球开奖号码
        op.dispblueprice();//输出蓝色球开奖号码
    }
}
class openprice{//开奖类
    openprice(){}
    Scanner cin = new Scanner(System.in);
    List redball = new ArrayList<>();//存用户输入的红球号码
    List blueball = new ArrayList<>();//存用户输入的蓝球号码
    List redprice = new ArrayList<>();//存红球开奖号码
    List blueprice = new ArrayList<>();//存蓝球开奖号码
    void dispnowtime()//输出现在时间方法
    {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String dateNowStr = sdf.format(date);
        System.out.println("当前时间为:"+dateNowStr);
    }
    void choosered()//选择红球号码方法
    {
        System.out.println("请输入六个红色球号码(1-33)");
        for(int i=0;i<6;i++)
        {

            System.out.print("第"+(i+1)+"个红球号码:");
            while(true) {
                String number = cin.next();
                Pattern p =Pattern.compile("[0-9]+");
                boolean b = p.matcher(number).matches();
                if(b)
                {
                    int value = Integer.parseInt(number);
                    if(value>=1&&value<=33)
                    {
                        redball.add(number);
                        break;
                    }
                    else
                        System.out.print("输入号码不正确,请重新输入第"+(i+1)+"个红色球号码:");
                }
                else
                    System.out.print("输入号码不正确,请重新输入第"+(i+1)+"个红色球号码:");
            }
        }
    }
    void chooseblue()//选择蓝球号码方法
    {
        System.out.print("输入蓝球号码(1-16):");
        while(true) {
            String blue = cin.next();
            Pattern p =Pattern.compile("[0-9]+");
            boolean b = p.matcher(blue).matches();
            if(b)
            {
                int value1 =  Integer.parseInt(blue);
                if(value1>=1&&value1<=16)
                {
                    blueball.add(blue);
                    break;
                }
                else
                    System.out.print("输入号码不正确,请重新输入蓝球号码(1-16):");
            }
            else
                System.out.print("输入号码不正确,请重新输入蓝球号码(1-16):");
        }
    }
    void dispredchoice()//输出选择的红球号码方法
    {
        System.out.print("6个红色球号码为:");
        for(int i=0;i<redball.size();i++)
            System.out.print("    "+redball.get(i));
        System.out.println("");
    }
    void dispbluechoice()//输出选择的蓝球号码方法
    {
        System.out.print("1个蓝色球号码为:");
        System.out.println("    "+blueball.get(0));
    }
    void dispopentime()//输出开奖时间方法
    {
        Date datestart = new Date();
        SimpleDateFormat start = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String tell = start.format(datestart);
        System.out.println("开奖时间为:"+tell);
    }
    void dispopenred()//输出红球开奖的6个号码方法
    {
        Random rand = new Random();
        for(int i=0;i<6;i++)
        {
            int randd = rand.nextInt(32)+1;
            redprice.add(randd);
            System.out.println("第"+(i+1)+"个红球开奖号码为:"+randd);
        }
    }
    void dispopenblue()//输出蓝球开奖的1个号码方法
    {
        Random rand = new Random();
        int blueopen = rand.nextInt(15)+1;
        blueprice.add(blueopen);
        System.out.println("1个蓝色球开奖号码为:"+blueprice.get(0));
    }
    void dispendtime()//输出结束开奖时间方法
    {
        System.out.println("本次开奖结束");
        Date dateend = new Date();
        SimpleDateFormat send = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String endtell = send.format(dateend);
        System.out.println("结束时间为:"+endtell);
    }
    void dispredprice()//输出红色球开奖号码方法
    {
        System.out.print("6个红色球号码为:");
        for(int i=0;i<6;i++)
            System.out.print("    "+redprice.get(i));
        System.out.println("");
    }
    void dispblueprice()//输出蓝色球开奖号码方法
    {

        System.out.println("1个蓝色球号码为:    "+blueprice.get(0));
    }
}
