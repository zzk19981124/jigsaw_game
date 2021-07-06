package property;

/**
 * @author hello word
 * @desc 作用描述
 * @date 2021/7/2
 */
public class LifePotion extends Item{
    @Override
    public void effect() {
        System.out.println("血瓶使用后，可以回血");
    }
}
