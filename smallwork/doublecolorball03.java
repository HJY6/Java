package number1; /**
 * @author 韩金宇
 * @version 1.0
 * @date 2020-04-07
 */
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class HanJinyu03 {
    public static void main(String[] args)
    {
        buyticket buy = new buyticket();
        buy.dispnowtime();//输出现在时间
        buy.disp();//输出用户购买票张数每张票的所有信息
    }
}
class openprice03{//用户选择号码的类及信息输出类
    openprice03(){}
    Scanner cin = new Scanner(System.in);
    List redball = new ArrayList<>();//存储用户选择的红色球号码
    List blueball = new ArrayList<>();//存储用户存储的蓝色球号码
    void choosered()//用户选择6个红球号码方法
    {
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
    void chooseblue()//用户选择1个蓝球号码方法
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
    void chooseyn()//用户选择是否进行开奖方法
    {
        System.out.print("是否确认选择的号码y/n,输入y确认,输入n重新选择:");
        while(true){
            String c = cin.next();
            Pattern p =Pattern.compile("y|n");
            boolean b= p.matcher(c).matches();
            boolean flag=false;
            if(b)
            {
                if(c.equals("n"))
                {
                    redball.clear();
                    blueball.clear();
                    choosered();
                    chooseblue();
                    dispredchoice();
                    dispbluechoice();
                    chooseyn();
                }
                else
                    flag=true;
            }
            else
            {
                System.out.println("输入字符错误,请重新输入:");
            }
            if(flag)
                break;
        }
    }
    void dispredchoice()//输出用户选择的6个红球号码
    {
        System.out.print("6个红色球号码为:");
        for(int i=0;i<redball.size();i++)
            System.out.print("    "+redball.get(i));
        System.out.println("");
    }
    void dispbluechoice()//输出用户选择的1个蓝球号码
    {
        System.out.print("1个蓝色球号码为:");
        System.out.println("    "+blueball.get(0));
    }
    void all()//每张票执行选择红球号码，蓝球号码，输出红球号码，蓝球号码和选择是否开奖的总方法
    {
        choosered();
        chooseblue();
        dispredchoice();
        dispbluechoice();
        chooseyn();
    }
}
class buyticket{//买票类
    Scanner cin = new Scanner(System.in);
    List redprice = new ArrayList<>();//存储6个红色球的开奖号码
    List blueprice = new ArrayList<>();//存储1个蓝球的开奖号码
    buyticket(){}
    void dispnowtime()//输出现在时间方法
    {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String dateNowStr = sdf.format(date);
        System.out.println("当前时间为:"+dateNowStr);
    }
    void disp()//输出用户买的票数及每张票的选则的红蓝球的号码及选择是否开奖的总方法
    {
        System.out.print("输入购买双色球彩票张数(1张2块钱):");
        while(true) {
            String number = cin.next();
            Pattern p = Pattern.compile("[0-9]+");
            boolean b= p.matcher(number).matches();
            if(b)
            {
                int value1;
                value1 = Integer.parseInt(number);
                openprice03[] op;
                op = new openprice03[value1];//每张票拥有一个用户进行选择和输出的号码类
                for(int i=0;i<value1;i++)
                {
                    op[i]=new openprice03();
                    System.out.println("请输入第"+(i+1)+"张彩票的六个红色球号码(1-33)");
                    op[i].all();
                }
                System.out.println("三张彩票号码为:");
                for(int i=0;i<value1;i++)
                {
                    System.out.print("第"+(i+1)+"张彩票");
                    op[i].dispredchoice();
                    op[i].dispbluechoice();
                }
                dispopentime();//输出开奖时间
                dispopenred();//输出红球的开奖号码
                dispopenblue();//输出蓝球的开奖号码
                dispendtime();//输出结束时间
                dispredprice();//输出红球的开奖号码
                dispblueprice();//输出蓝球的开奖号码
                System.exit(0);//停止程序
            }
            else
                System.out.println("输入中含有非数字字符,请重新输入:");
        }
    }
    void dispopentime()//输出开奖时间方法
    {
        Date datestart = new Date();
        SimpleDateFormat start = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String tell = start.format(datestart);
        System.out.println("开奖时间为:"+tell);
    }
    void dispopenred()//输出红球的开奖号码方法
    {
        Random rand = new Random();
        for(int i=0;i<6;i++)
        {
            int randd = rand.nextInt(32)+1;
            redprice.add(randd);
            System.out.println("第"+(i+1)+"个红球开奖号码为:"+randd);
        }
    }
    void dispopenblue()//输出蓝球的开奖号码方法
    {
        Random rand = new Random();
        int blueopen = rand.nextInt(15)+1;
        blueprice.add(blueopen);
        System.out.println("1个蓝色球开奖号码为:"+blueprice.get(0));
    }
    void dispendtime()//输出结束开奖的时间的方法
    {
        System.out.println("本次开奖结束");
        Date dateend = new Date();
        SimpleDateFormat send = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String endtell = send.format(dateend);
        System.out.println("结束时间为:"+endtell);
    }
    void dispredprice()//输出红球的开奖号码
    {
        System.out.print("6个红色球号码为:");
        for(int i=0;i<6;i++)
            System.out.print("    "+redprice.get(i));
        System.out.println("");
    }
    void dispblueprice()//输出蓝球的开奖号码
    {

        System.out.println("1个蓝色球号码为:    "+blueprice.get(0));
    }
}
