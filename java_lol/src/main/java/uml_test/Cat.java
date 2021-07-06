package uml_test;

/**
 * @author hello word
 * @desc 作用描述
 * @date 2021/7/6
 */
public class Cat extends Animal{
    private String name;
    public Cat(int legs,String name){
        super(legs);
        this.name = name;
    }

    @Override
    public void eat() {

    }
}
