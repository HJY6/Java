package number4;
import java.util.*;
public class HanJinyu {
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        String name;
        while(true){
            System.out.println("请输入购买的汽车品牌:");
            name = cin.next();
            if(name.equals("宝马")||name.equals("奔驰")||name.equals("大众")||name.equals("法拉利")||name.equals("兰博基尼")||name.equals("奥迪")) {
                Car cc = new Car();
                cc.setterBrand(name);
                //System.out.println(c.getterBrand());
                cc.buywhichone(cc,cc.getterBrand());
            }
            else{
                break;
            }
        }
    }
}
class Car{
    protected String brand;
    public void getinformation(){
        System.out.println("调取汽车:");
    }
    public void buywhichone(Car c,String name){
        if(name.equals("宝马"))
        {
            c = new Baoma();
        }
        else if(name.equals("奔驰"))
        {
            c = new Benchi();
        }
        else if(name.equals("大众"))
        {
            c = new Dazhong();
        }
        else if(name.equals("法拉利"))
        {
            c = new Falali();
        }
        else if(name.equals("兰博基尼"))
        {
            c = new Lanbojini();
        }
        else if(name.equals("奥迪"))
        {
            c = new Aodi();
        }
        c.getinformation();
    }//汽车工厂方法
    public void setterBrand(String brand){
        this.brand=brand;
    }
    public String getterBrand(){
        return this.brand;
    }

}
class Baoma extends Car{
    protected String brand="宝马";
    public void getinformation(){//方法覆盖
        super.setterBrand(brand);
        System.out.println("调取汽车:"+super.brand);//成员隐藏
    }
    public void setterBrand(String brand){
        this.brand=brand;
    }
    public String getterBrand(){
        return this.brand;
    }
}
class Benchi extends Car{
    protected String brand="奔驰";
    public void getinformation(){//方法覆盖
        super.setterBrand(brand);
        System.out.println("调取汽车:"+super.brand);//成员隐藏
    }
    public void setterBrand(String brand){
        this.brand=brand;
    }
    public String getterBrand(){
        return this.brand;
    }
}
class Dazhong extends Car{
    protected String brand="大众";
    public void getinformation(){//方法覆盖
        super.setterBrand(brand);
        System.out.println("调取汽车:"+super.brand);//成员隐藏
    }
    public void setterBrand(String brand){
        this.brand=brand;
    }
    public String getterBrand(){
        return this.brand;
    }
}
class Falali extends Car{
    protected String brand="法拉利";
    public void getinformation(){//方法覆盖
        super.setterBrand(brand);
        System.out.println("调取汽车:"+super.brand);//成员隐藏
    }
    public void setterBrand(String brand){
        this.brand=brand;
    }
    public String getterBrand(){
        return this.brand;
    }
}

class Lanbojini extends Car{
    protected String brand="兰博基尼";
    public void getinformation(){//方法覆盖
        super.setterBrand(brand);
        System.out.println("调取汽车:"+super.brand);//成员隐藏
    }
    public void setterBrand(String brand){
        this.brand=brand;
    }
    public String getterBrand(){
        return this.brand;
    }
}
class Aodi extends Car{
    protected String brand="奥迪";
    public void getinformation(){//方法覆盖
        super.setterBrand(brand);
        System.out.println("调取汽车:"+super.brand);//成员隐藏
    }
    public void setterBrand(String brand){
        this.brand=brand;
    }
    public String getterBrand(){
        return this.brand;
    }
}
