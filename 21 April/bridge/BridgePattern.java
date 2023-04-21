package bridge;

//The Implementor interface provides the basic operations that can be performed 
//on the various appliance objects
interface Implementor {
	void on();

	void off();
}

//The ConcreteImplementor classes implement the Implementor interface and 
//define specific behaviors for each appliance object
class TV implements Implementor {
	public void on() {
		System.out.println("TV is on");
	}

	public void off() {
		System.out.println("TV is off");
	}
}

class Radio implements Implementor {
	public void on() {
		System.out.println("Radio is on");
	}

	public void off() {
		System.out.println("Radio is off");
	}
}

//The Abstraction class defines an abstract interface for the client code 
//and maintains a reference to an object of the Implementor class
abstract class Abstraction {
	protected Implementor implementor;

	public Abstraction(Implementor implementor) {
		this.implementor = implementor;
	}

	public abstract void turnOn();

	public abstract void turnOff();
}

//The RefinedAbstraction classes extend the Abstraction class and 
//implement the turnOn() and turnOff() methods using the Implementor object
class RemoteControl extends Abstraction {
	public RemoteControl(Implementor implementor) {
		super(implementor);
	}

	public void turnOn() {
		System.out.print("Remote Control: ");
		implementor.on();
	}

	public void turnOff() {
		System.out.print("Remote Control: ");
		implementor.off();
	}
}

class VoiceAssistant extends Abstraction {
	public VoiceAssistant(Implementor implementor) {
		super(implementor);
	}

	public void turnOn() {
		System.out.print("Voice Assistant: ");
		implementor.on();
	}

	public void turnOff() {
		System.out.print("Voice Assistant: ");
		implementor.off();
	}
}

//The client code can use the Abstraction class to control various appliance objects
//without knowing their specific implementation details
public class BridgePattern {
	public static void main(String[] args) {
		Implementor tv = new TV();
		Implementor radio = new Radio();

		Abstraction remoteControl = new RemoteControl(tv);
		Abstraction voiceAssistant = new VoiceAssistant(radio);

		remoteControl.turnOn();
		remoteControl.turnOff();

		voiceAssistant.turnOn();
		voiceAssistant.turnOff();
	}
}
