package number1; /**
 * @author 韩金宇
 * @version 1.0
 * @date 2020-04-07
 */
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class HanJinyu02 {
    public static void main(String[] args)
    {
        openprice02 op = new openprice02();
        op.dispnowtime();//输出现在时间
        op.choosered();//用户选择红色球号码
        op.chooseblue();//用户选择蓝色球号码
        op.dispreschoice();//输出用户选择的红色球号码
        op.dispbluechoice();//输出用户选择的蓝色球号码
        op.chooseyn();//用户选择是否开奖
    }
}
class openprice02{//开奖类
    openprice02(){}
    Scanner cin = new Scanner(System.in);
    List redball = new ArrayList<>();//存储用户选择的红色球的号码
    List blueball = new ArrayList<>();//存储用户选择的蓝色球号码
    List redprice = new ArrayList<>();//存储红色球开奖的号码
    List blueprice = new ArrayList<>();//存储蓝色球开奖的号码
    void dispnowtime()//输出现在时间方法
    {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String dateNowStr = sdf.format(date);
        System.out.println("当前时间为:"+dateNowStr);
    }
    void choosered()//用户选择红色球号码方法
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
    void chooseblue()//用户选择蓝色球号码方法
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
    void chooseyn()//用户选择是否开奖方法
    {
        System.out.println("是否确认选择的号码y/n,输入y确认,输入n重新选择:");
        while(true){
            String c = cin.next();
            Pattern p =Pattern.compile("y|n");
            boolean b= p.matcher(c).matches();
            if(b)
            {
                if(c.equals("n"))
                {
                    redball.clear();
                    blueball.clear();
                    choosered();
                    chooseblue();
                    dispreschoice();
                    dispbluechoice();
                    chooseyn();
                }
                else
                {
                    dispopentime();
                    dispopenred();
                    dispopenblue();
                    dispendtime();
                    dispredprice();
                    dispblueprice();
                    System.exit(0);
                }
            }
            else
            {
                System.out.println("输入字符错误,请重新输入:");
            }
        }
    }
    void dispreschoice()//输出用户选择的红色球号码方法
    {
        System.out.print("6个红色球号码为:");
        for(int i=0;i<redball.size();i++)
            System.out.print("    "+redball.get(i));
        System.out.println("");
    }
    void dispbluechoice()//输出用户选择的的蓝色球号码方法
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
    void dispopenred()//输出6个红色球开奖的号码方法
    {
        Random rand = new Random();
        for(int i=0;i<6;i++)
        {
            int randd = rand.nextInt(32)+1;
            redprice.add(randd);
            System.out.println("第"+(i+1)+"个红球开奖号码为:"+randd);
        }
    }
    void dispopenblue()//输出1个蓝色球开奖的号码方法
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
    void dispredprice()//输出6个红色球开奖号码方法
    {
        System.out.print("6个红色球号码为:");
        for(int i=0;i<6;i++)
            System.out.print("    "+redprice.get(i));
        System.out.println("");
    }
    void dispblueprice()//输出1个蓝色球开奖号码方法
    {

        System.out.println("1个蓝色球号码为:    "+blueprice.get(0));
    }
}
