interface State {
    void switchOn(LightSwitch lightSwitch);
    void switchOff(LightSwitch lightSwitch);
}

class LightSwitch {
    private State state;
    
    public LightSwitch() {
        state = new OffState();
    }
    
    public void setState(State state) {
        this.state = state;
    }
    
    public void switchOn() {
        state.switchOn(this);
    }
    
    public void switchOff() {
        state.switchOff(this);
    }
}

class OnState implements State {
    @Override
    public void switchOn(LightSwitch lightSwitch) {
        System.out.println("Light is already on");
    }
    
    @Override
    public void switchOff(LightSwitch lightSwitch) {
        System.out.println("Switching light off");
        lightSwitch.setState(new OffState());
    }
}

class OffState implements State {
    @Override
    public void switchOn(LightSwitch lightSwitch) {
        System.out.println("Switching light on");
        lightSwitch.setState(new OnState());
    }
    
    @Override
    public void switchOff(LightSwitch lightSwitch) {
        System.out.println("Light is already off");
    }
}

public class StateExample {
    public static void main(String[] args) {
        LightSwitch lightSwitch = new LightSwitch();
        lightSwitch.switchOn();
        lightSwitch.switchOff();
        lightSwitch.switchOff();
        lightSwitch.switchOn();
        lightSwitch.switchOn();
    }
}