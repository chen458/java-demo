package com.csh.demo.effective.java.reusing;

/**
 * @author: shenghong.chen
 * Date: 2016/11/21
 * time: 下午11:44
 */
public class CADSystem extends Shape {
    private Circle c;
    private Triangle t;
    private Line[] lines = new Line[3];
    public CADSystem(int i) {
        super(i + 1);
        for (int j = 0; j < lines.length; j ++ ) {
            lines[j] = new Line(j, j*j);
        }
        c = new Circle(1);
        t = new Triangle(1);
        System.out.println("Combined Constructor");
    }

    @Override
    void display() {
        System.out.println("CADSystem.display()");
        t.display();
        c.display();
        for (int i = lines.length -1 ; i >= 0; i --)
            lines[i].display();
        super.display();
    }

    public static void main(String[] args) {
        CADSystem cs = new CADSystem(47);
        try {

        } finally {
            cs.display();
        }
    }
}

class Shape {
    public Shape(int i ) {
        System.out.println("Shape Constructor");
    }

    void display() {
        System.out.println("Shape display");
    }
}

class Circle extends Shape {

    public Circle(int i) {
        super(i);
        System.out.println("Drawing Circle");
    }

    @Override
    void display() {
        System.out.println("Erasing Circle");
        super.display();
    }
}

class Triangle extends Shape {

    public Triangle(int i) {
        super(i);
        System.out.println("Drawing Triangle");
    }

    @Override
    void display() {
        System.out.println("Erasing Triangle");
        super.display();
    }
}

class Line extends Shape {
    private int start, end;

    public Line(int start, int end) {
        super(start);
        this.start = start;
        this.end = end;
        System.out.println("Drawing Line : " + start + ", " + end);
    }

    @Override
    void display() {
        System.out.println("Erasing Line : " + start + ", " + end);
        super.display();
    }
}