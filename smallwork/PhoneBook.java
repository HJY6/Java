package number1; /**
 * @author 韩金宇
 * @version 1.0
 * @date 2020-03-30
 */
import java.util.Vector;
import java.util.Scanner;
public class phonebook {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Vector<String> name = new Vector<String>();
        Vector<String> phonenumber = new Vector<String>();
        Vector<String> birthday = new Vector<>();
        Vector<String> address = new Vector<>();
        String[] name1 = {"爸爸", "妈妈", "姐姐", "弟弟"};
        String[] phonenum1 = {"93727495739", "74839275843", "85038483928", "74658493628"};
        String[] birthday1 = {"3.12", "1.07", "7.14", "11.16"};
        String[] address1 = {"安徽", "江苏", "北京", "四川"};
        for (int i = 0; i < name1.length; i++) {
            name.add(name1[i]);
            phonenumber.add(phonenum1[i]);
            birthday.add(birthday1[i]);
            address.add(address1[i]);
        }
        maindisp m1 = new maindisp();
        m1.disp();
        while (true) {
            System.out.println("请输入进行操作的序号:");
            int num = cin.nextInt();
            switch (num) {
                case 1://查看通讯录
                    m1.look(name, phonenumber, birthday, address);
                    m1.disp();
                    break;
                case 2://新增联系人
                    System.out.println("请输入添加的联系人的姓名");
                    String name2 = cin.next();
                    System.out.println("请输入添加的联系人的电话");
                    String phone2 = cin.next();
                    System.out.println("请输入添加的联系人的生日");
                    String birthday2 = cin.next();
                    System.out.println("请输入添加的联系人的地址");
                    String address2 = cin.next();
                    m1.add(name, phonenumber, birthday, address, name2, phone2, birthday2, address2);
                    m1.disp();
                    break;
                case 3://删除联系人
                    System.out.println("请输入删除的联系人的姓名");
                    String name4 = cin.next();
                    m1.delete(name, phonenumber, birthday, address, name4);
                    m1.disp();
                    break;
                case 4://编辑联系人
                    System.out.println("请输入要进行修改的联系人姓名");
                    String name6 = cin.next();
                    int flag = name.indexOf(name6);
                    if (flag == -1) {
                        System.out.println("无法找到该联系人的姓名");
                        m1.disp();
                        break;
                    } else {
                        while(true){
                            boolean flag3 = false;
                            System.out.println("请输入相关编辑操作的序号");
                            m1.disp1();
                            int numm = cin.nextInt();
                            switch (numm) {
                                case 1:
                                    System.out.println("请输入修改过后联系人的姓名");
                                    String name7 = cin.next();
                                    m1.changename(name, name6,name7);
                                    name6=name7;
                                    break;
                                case 2:
                                    System.out.println("请输入修改过后联系人的电话");
                                    String phone6 = cin.next();
                                    m1.changephone(name, name6, phonenumber, phone6);
                                    break;
                                case 3:
                                    System.out.println("请输入修改过后联系人的生日");
                                    String birth6 = cin.next();
                                    m1.changephone(name, name6, birthday, birth6);
                                    break;
                                case 4:
                                    System.out.println("请输入修改过后联系人的地址");
                                    String address6 = cin.next();
                                    m1.changephone(name, name6, address, address6);
                                    break;
                                case 5:
                                    flag3 = true;
                                    break;
                                default:
                                    System.out.println("输入编辑操作序号错误,请重新输入!");
                            }
                            if (flag3)
                                break;
                        }
                        m1.disp();
                        break;
                    }
                case 5://查找联系人
                    System.out.println("请输入要查找的联系人姓名:");
                    String name0=cin.next();
                    m1.getmassage(name,phonenumber,birthday,address,name0);
                    m1.disp();
                    break;
                case 6://拨打联系人
                    System.out.println("请输入拨打联系人的姓名:");
                    String callname=cin.next();
                    m1.callperson(name,callname);
                    m1.disp();
                    break;
                case 7://给联系人发送信息
                    System.out.println("请输入收信人:");
                    String sendperson=cin.next();
                    int sendflag = name.indexOf(sendperson);
                    if (sendflag == -1) {
                        System.out.println("无法找到删除联系人的姓名");
                    }
                    else {
                        System.out.println("请输入发送内容:");
                        String taxt = cin.next();
                        m1.sendmessage(name,sendperson,sendperson);
                    }
                    m1.disp();
                    break;
                case 8://关闭应用
                    System.exit(0);
                default:
                    System.out.println("无法找到进行操作的序号:");
                    m1.disp();
            }
        }
    }
}
class maindisp {
    maindisp() {
    }

    void disp() {//输出主菜单
        System.out.println("-------------------------------------");
        System.out.println("|           通  讯  录  应  用      |");
        System.out.println("|             1.查看通讯录          |");
        System.out.println("|             2.新增联系人          |");
        System.out.println("|             3.删除联系人          |");
        System.out.println("|             4.编辑联系人          |");
        System.out.println("|             5.查找联系人          |");
        System.out.println("|             6.拨打联系人          |");
        System.out.println("|             7.发送联系人信息      |");
        System.out.println("|             8.关闭应用            |");
        System.out.println("-------------------------------------");
    }

    void disp1() {//输出编辑菜单
        System.out.println("--------------------------------------");
        System.out.println("|           编 辑 该 联 系 人         |");
        System.out.println("|             1.修改其姓名            |");
        System.out.println("|             2.修改其电话            |");
        System.out.println("|             3.修改其生日            |");
        System.out.println("|             4.修改其地址            |");
        System.out.println("|             5.结束编辑该联系人       |");
        System.out.println("--------------------------------------");

    }
    //查看通讯录
    void look(Vector name, Vector phone, Vector birthday, Vector address) {
        System.out.println("   联系人         电话            生日          地址");
        for (int i = 0; i < name.size(); i++) {
            System.out.println((i + 1) + ". " + name.elementAt(i) + "        " + phone.elementAt(i) + "        " + birthday.elementAt(i) + "        " + address.elementAt(i));
        }
        System.out.println("通讯录共计" + name.size() + "人");
    }
    //新增联系人
    void add(Vector name, Vector phone, Vector birthday, Vector address, String nn, String tt, String bi, String ad) {
        name.add(nn);
        phone.add(tt);
        birthday.add(bi);
        address.add(ad);
        System.out.println("添加联系人成功!");
    }
    //删除联系人
    void delete(Vector name, Vector phone, Vector birthday, Vector adress, String c) {
        int flag = name.indexOf(c);
        if (flag == -1) {
            System.out.println("无法找到删除联系人的姓名");
        } else {
            name.remove(flag);
            phone.remove(flag);
            birthday.remove(flag);
            adress.remove(flag);
            System.out.println("删除联系人成功!");
        }
    }
    //修改联系人姓名
    void changename(Vector name, String n1,String n2) {
        int flag1 = name.indexOf(n1);
        name.set(flag1, n2);
        System.out.println("联系人姓名修改成功!");
    }
    //修改联系人号码
    void changephone(Vector name, String na, Vector phone, String ph) {
        int flag1 = name.indexOf(na);
        phone.set(flag1, ph);
        System.out.println("联系人电话修改成功!");
    }
    //修改联系人生日
    void changebirthday(Vector name, String na, Vector birthday, String bi) {
        int flag1 = name.indexOf(na);
        birthday.set(flag1, bi);
        System.out.println("联系人生日修改成功!");
    }
    //修改联系人地址
    void changeaddress(Vector name, String na, Vector address, String ad) {
        int flag1 = name.indexOf(na);
        address.set(flag1, ad);
        System.out.println("联系人地址修改成功!");
    }
    //获取该联系人信息
    void getmassage(Vector name,Vector phone,Vector birthday,Vector address,String namee){
        int i = name.indexOf(namee);
        if(i==-1)
            System.out.println("通讯录中无此人相关信息!");
        else
        {
            System.out.println("通讯录位置   联系人         电话            生日          地址");
            System.out.println("    "+(i + 1) + ".       " + name.elementAt(i) + "        " + phone.elementAt(i) + "        " + birthday.elementAt(i) + "        " + address.elementAt(i));
        }
    }
//给联系人打电话
void callperson(Vector name,String namee)
{
    int flag1 = name.indexOf(namee);
    if(flag1==-1)
        System.out.println("通讯录中无该联系人");
    else
        System.out.println("您已成功拨打"+namee+"的号码!");
}
    //给联系人发信息
    void sendmessage(Vector name,String namee,String massage)
    {
        System.out.println("您成功向"+namee+"发送信息");
    }
}
