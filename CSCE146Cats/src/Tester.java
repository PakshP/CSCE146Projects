
public class Tester {

	public static void main(String[] args) {
	
		Cat cat01;
		cat01 = new Cat();
	
		System.out.println(cat01);
		System.out.println(cat01.getName());
		
		cat01.setName("Benji");
		cat01.setWeight(9.0);
		cat01.setNumberOfLegs(4);
		
		Cat cat02 = new Cat("Trev",7.6,4);
		System.out.println(cat02);
		
		Cat cat03 = new Cat();
		Cat cat04 = new Cat();
		
		System.out.println(cat03.equals(cat04));
		System.out.println(cat03 == cat04);
	}

}
