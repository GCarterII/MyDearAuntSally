
public class CalculatorTest {
	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.performOperation(8);
		c.performOperation('+');
		c.performOperation('*');
		c.performOperation('/');
		c.performOperation(8);
		c.performOperation(8);
		c.performOperation(8);
		c.performOperation('+');
		c.performOperation(5);
		c.performOperation('/');
		c.performOperation(4);
//		c.performOperation('=');
		c.getResults();
	}
}
