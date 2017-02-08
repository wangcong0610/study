package com.zp.designpatern.behavior.state;

/**
 * Created by Zhang Peng on 2016/8/2.
 */
public class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public void method(){
        if(state.getValue().equals("state1")){
            state.method1();
        }else if(state.getValue().equals("state2")){
            state.method2();
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
