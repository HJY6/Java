package number3;

import jdk.nashorn.internal.objects.annotations.Setter;

public class HanJinyu {
    public static void main(String[] args)
    {
        Staff s = new Staff();
        s.setterName("韩金宇");
        s.setterWage(10000.5);
        s.setterBirthdate("2000-6-24");
        Manager m = new Manager();
        m.setterName("马化腾");
        m.setterWage(1000000.8);
        m.setterBirthdate("1980-1-1");
        m.setterPrice(5000000);
        System.out.println("员工信息为:");
        System.out.println(s.getStaff());
        System.out.println("经理信息为:");
        System.out.println(m.getManager());
    }
}
class Staff{
    private String name;
    private double wage;
    private String birthdate;
    public void setterName(String name){
        this.name=name;
    }
    public String getterName(){
        return this.name;
    }
    public void setterWage(double wage){
        this.wage=wage;
    }
    public double getterWage(){
        return this.wage;
    }
    public void setterBirthdate(String birthdate){
        this.birthdate=birthdate;
    }
    public String getterBirthdate(){
        return this.birthdate;
    }
    String getStaff(){
        return "姓名为:"+this.getterName()+"\n工资为:"+getterWage()+"\n出生日期为:"+getterBirthdate()+"\n";
    }
}
class Manager extends Staff{
    private double price;
    public void setterPrice(double price){
        this.price=price;
    }
    public double getterPrice(){
        return this.price;
    }
    String getManager(){
        System.out.print(getStaff());
        return "工资为:"+getterPrice()+"\n";
    }


}
