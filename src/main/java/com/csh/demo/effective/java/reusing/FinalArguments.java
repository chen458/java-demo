package com.csh.demo.effective.java.reusing;

/**
 * @author: shenghong.chen
 * Date: 2016/11/23
 * time: 下午3:31
 */
public class FinalArguments {
    void with (final Gizmo g) {
//        g = new Gizmo();
    }

    void without (Gizmo g) {
        g = new Gizmo();
        g.spin();
    }

    void g (final int i) {

    }
}

class Gizmo {
    public void spin () {}
}
