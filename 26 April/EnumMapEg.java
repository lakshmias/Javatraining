import java.util.EnumMap;

public class EnumMapEg {

	enum Size {
		SMALL, MEDIUM, LARGE, EXTRALARGE
	}

	public static void main(String[] args) {

		// Creating an EnumMap of the Size enum
		EnumMap<Size, Integer> sizes1 = new EnumMap<>(Size.class);

		// Using the put() Method
		sizes1.put(Size.SMALL, 28);
		sizes1.put(Size.MEDIUM, 32);
		sizes1.put(Size.LARGE, 36);
		sizes1.put(Size.EXTRALARGE, 40);
		System.out.println("EnumMap1: " + sizes1);

		EnumMap<Size, Integer> sizes2 = new EnumMap<>(Size.class);

		// Using the putAll() Method
		sizes2.putAll(sizes1);
		sizes2.put(Size.LARGE, 36);
		System.out.println("EnumMap2: " + sizes2);

		// Using the entrySet() Method
		System.out.println("Key/Value mappings: " + sizes2.entrySet());

		// Using the keySet() Method
		System.out.println("Keys: " + sizes2.keySet());

		// Using the values() Method
		System.out.println("Values: " + sizes2.values());
		
		// Using the get() Method
        int value = sizes2.get(Size.MEDIUM);
        System.out.println("Value of MEDIUM: " + value);
	}

}