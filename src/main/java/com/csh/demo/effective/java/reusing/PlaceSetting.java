package com.csh.demo.effective.java.reusing;

/**
 * @author: shenghong.chen
 * Date: 2016/11/21
 * time: 下午11:30
 */
public class PlaceSetting extends Custom{
    private Spoon spoon;
    private Fork fork;
    private DinnerPlate dp;

    public PlaceSetting(int i) {
        super(i + 1);
        spoon = new Spoon(i + 2);
        fork = new Fork( i + 3 );
        dp = new DinnerPlate(i + 4);
        System.out.println("PlaceSetting Constructor : " + i);
    }

    public static void main(String[] args) {
        new PlaceSetting(9);
    }
}

class Custom {
    public Custom(int i) {
        System.out.println("Custom Constructor : " + i);
    }
}

class Plate {
    public Plate(int i) {
        System.out.println("Plate Constructor : " + i);
    }
}

class DinnerPlate extends Plate {
    public DinnerPlate(int i) {
        super(i);
        System.out.println("DinnerPlate Constructor : " + i);
    }
}

class Utensil {
    public Utensil(int i) {
        System.out.println("Utensil Constructor : " + i);
    }
}

class Spoon extends Utensil {
    public Spoon(int i) {
        super(i);
        System.out.println("Spoon Constructor : " + i);
    }
}

class Fork extends Utensil {

    public Fork(int i) {
        super(i);
        System.out.println("Fork Constructor : " + i);
    }
}
