import java.util.*;

public class TuringMachine {
	private Map<String, Set<Transition>> instructions;
	private Set<String> acceptingStates;
	private Set<String> rejectingStates;
	private String startState = "";
	
	public TuringMachine() {
		instructions = new HashMap<String, Set<Transition>>();
		acceptingStates = new HashSet<String>();
		rejectingStates = new HashSet<String>();
	}
	
	public void setStartState(String s) {
		startState = s;
	}
	
	public String getStartState() {
		return startState;
	}
	
	// Method to run the Turing Machine on a string
	public int run(String s) {
		System.out.println("Running Turing Machine on input " + s + ":");
		String currState = getStartState();
		Tape myTape = new Tape(s);
		char currChar = ' ';
		
		while(!acceptingStates.contains(currState) && !rejectingStates.contains(currState)) {
			String ID = new String(myTape.getTape());
			System.out.println("State: " + currState + "; Tape: " + ID + "; Curr Char: " + myTape.getCurr());
			currChar = myTape.getCurr();
			Transition tgt = null;
			for(Transition t : instructions.get(currState)) {
				if (t.inSymbol == currChar) {
					tgt = t;
				}
			}
			if (tgt == null) {
				return 0;
			} else {
				currState = tgt.outState;
				myTape.replaceCurr(tgt.outSymbol);
				if (tgt.direction) {
					myTape.moveRight();
				} else {
					myTape.moveLeft();
				}
			}
		}
		if (acceptingStates.contains(currState)) {
			return 1;
		} else {
			return 0;
		}
	}
	
	// Takes instruction in the form of a string (p, a, b, m, q).
	public void addInstruction(String s) {
		String myS = s.substring(1, s.length() - 1);
		myS = myS.replaceAll("\\s+","");
		String[] symbols = myS.split(",");
		String p = symbols[0];
		String a = symbols[1];
		String b = symbols[2];
		String m = symbols[3];
		String q = symbols[4];
		if (instructions.containsKey(p)) {
			Set<Transition> tgt = instructions.get(p);
			tgt.add(new Transition(p, a, b, m, q));
			instructions.put(p, tgt);
		} else {
			Set<Transition> tgt = new HashSet<Transition>();
			tgt.add(new Transition(p, a, b, m, q));
			instructions.put(p, tgt);
		}
	}
	
	public void addAcceptState(String a) {
		acceptingStates.add(a);
	}
	
	public void addRejectState(String a) {
		rejectingStates.add(a);
	}
}

class Tape {
	int pointer = 0;
	List<Character> tape;
	
	public Tape(String s) {
		tape = new LinkedList<Character>();
		for (char c : s.toCharArray()) {
			tape.add(c);
		}
	}
	
	public void moveRight(){
		if (pointer < tape.size() - 1) {
			pointer++;
		} else {
			tape.add('B');
			pointer++;
		}
	}
	
	public void moveLeft(){
		if (pointer > 0) {
			pointer--;
		} else {
			tape.add(0, 'B');
		}
	}
	
	public char getCurr() {
		return tape.get(pointer);
	}
	
	public void replaceCurr(char c) {
		tape.set(pointer, c);
	}
	
	public String getTape() {
		String tgt = "";
		for (char c : tape) {
			tgt += c + "";
		}
		return tgt;
	}
}

class Transition {
	String inState;
	char inSymbol;
	char outSymbol;
	boolean direction;
	String outState;
	
	public Transition(String p, String a, String b, String m, String q) {
		inState = p;
		inSymbol = a.charAt(0);
		outSymbol = b.charAt(0);
		if (m.equals("R")) {
			direction = true;
		} else {
			direction = false;
		}
		outState = q;
	}	
}
