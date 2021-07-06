package property;

/**
 * @author hello word
 * @desc 物品类
 * @date 2021/7/1
 */
public class Item {
    public String name;
    public int price;
    public void buy(){
        System.out.println("购买");
    }
    public void effect(){
        System.out.println("物品使用后,可以有效果");
    }

    public static void main(String[] args) {
        Item i1 = new LifePotion();
        Item i2 = new MagicPotion();
        System.out.println("i1  是Item类型，执行effect打印：");
        i1.effect();
        System.out.println("i1 也是Item类型，执行effect打印：");
        i2.effect();
    }
}
