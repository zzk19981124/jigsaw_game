package uml_test;

/**
 * @author hello word
 * @desc 作用描述
 * @date 2021/7/6
 */
public abstract class Animal {
    public int legs;

    public Animal(int legs) {
        this.legs = legs;
    }
    public void walk(){
    }
    public abstract void eat();
}
