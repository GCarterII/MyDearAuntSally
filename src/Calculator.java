import java.util.ArrayList;


public class Calculator implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2040826795301913821L;
	private ArrayList<Object> queue = new ArrayList<>();
	
	public Calculator() {
		
	}
	
	private void calculate() {
		int i = queue.size()-1;
		queue.remove(i);
		i--;
		while (i >= 0) {
			if(queue.get(i).equals('x') || queue.get(i).equals('*')) {
				queue.add(i-1, ((Double)queue.get(i+1) * (Double)queue.get(i-1)));
				queue.remove(i+2);
				queue.remove(i+1);
				queue.remove(i);
				i--;
			} else if(queue.get(i).equals('/')) {
				queue.add(i-1, ((Double)queue.get(i+1) / (Double)queue.get(i-1)));
				queue.remove(i+2);
				queue.remove(i+1);
				queue.remove(i);
				i--;
			}
			i--;
		}
		i = queue.size()-1;
		while (i >= 0) {
			if(queue.get(i).equals('+')) {
				queue.add(i-1, ((Double)queue.get(i+1) + (Double)queue.get(i-1)));
				queue.remove(i+2);
				queue.remove(i+1);
				queue.remove(i);
				i--;
			} else if(queue.get(i).equals('-')) {
				queue.add(i-1, ((Double)queue.get(i+1) - (Double)queue.get(i-1)));
				queue.remove(i+2);
				queue.remove(i+1);
				queue.remove(i);
				i--;
			}
			i--;
		}
		System.out.println(queue);
	}
	
	private void addToQueue(Double val) {
		if(queue.size()>0) {
			if(queue.get(queue.size()-1) instanceof Double) {
				queue.remove(queue.size()-1);
			}
		}
		queue.add(val);
	}
	
	private void addToQueue(Character oper) {
		if(queue.size()>0) {
			if(queue.get(queue.size()-1) instanceof Character) {
				queue.remove(queue.size()-1);
			}
			queue.add(oper);
			if(oper.equals('=')) {
				calculate();
			}
		}
	}
	
	public void performOperation(int num) {
		addToQueue((Double) (double) num);
	}
	public void performOperation(float num) {
		addToQueue((Double) (double) num);
	}
	public void performOperation(double num) {
		addToQueue((Double) num);
	}
	public void performOperation(long num) {
		addToQueue((Double) (double) num);
	}
	public void performOperation(char oper) {
		addToQueue((Character) oper);
	}
	public void getResults() {
		performOperation('=');
	}
}
