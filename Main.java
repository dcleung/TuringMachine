
public class Main {
	
	public static void main(String[] args) 
	{
		// Construct a new Turing Machine
		TuringMachine TM = new TuringMachine();
		
		// Add accept state, reject state, and set start state
		TM.addAcceptState("accept");
		TM.addRejectState("q12");
		TM.setStartState("q0");
		
		// Add instructions for Turing Machine
		TM.addInstruction("(q0, #, #, R, q0)");
		TM.addInstruction("(q0, a, #, R, q1)");
		TM.addInstruction("(q0, b, #, R, q2)");
		TM.addInstruction("(q0, B, 0, R, q12)");
		TM.addInstruction("(q0, c, c, R, q10)");
		
		TM.addInstruction("(q1, #, #, R, q1)");
		TM.addInstruction("(q1, a, a, R, q1)");
		TM.addInstruction("(q1, b, b, R, q1)");
		TM.addInstruction("(q1, c, c, R, q3)");
		TM.addInstruction("(q1, B, B, L, q11)");
		
		TM.addInstruction("(q2, #, #, R, q2)");
		TM.addInstruction("(q2, a, a, R, q2)");
		TM.addInstruction("(q2, b, b, R, q2)");
		TM.addInstruction("(q2, c, c, R, q4)");
		TM.addInstruction("(q2, B, B, L, q11)");
		
		TM.addInstruction("(q3, #, #, R, q3)");
		TM.addInstruction("(q3, a, #, R, q5)");
		TM.addInstruction("(q3, b, b, R, q10)");
		TM.addInstruction("(q3, c, c, R, q10)");
		TM.addInstruction("(q3, B, B, L, q11)");
		
		TM.addInstruction("(q4, #, #, R, q4)");
		TM.addInstruction("(q4, b, #, R, q5)");
		TM.addInstruction("(q4, a, a, R, q10)");
		TM.addInstruction("(q4, c, c, R, q10)");
		TM.addInstruction("(q4, B, B, L, q11)");
		
		TM.addInstruction("(q5, a, a, R, q5)");
		TM.addInstruction("(q5, b, b, R, q5)");
		TM.addInstruction("(q5, B, B, L, q6)");
		TM.addInstruction("(q5, c, c, R, q10)");
		
		TM.addInstruction("(q6, #, #, L, q6)");
		TM.addInstruction("(q6, c, c, L, q7)");
		TM.addInstruction("(q6, a, a, L, q9)");
		TM.addInstruction("(q6, b, b, L, q9)");
		
		TM.addInstruction("(q7, #, #, L, q7)");
		TM.addInstruction("(q7, B, B, R, q8)");
		TM.addInstruction("(q7, a, a, L, q9)");
		TM.addInstruction("(q7, b, b, L, q9)");
		
		TM.addInstruction("(q8, #, B, R, q8)");
		TM.addInstruction("(q8, c, B, R, q8)");
		TM.addInstruction("(q8, B, 1, R, accept)");
		TM.addInstruction("(accept, B, b, L, accept)");
		
		TM.addInstruction("(q9, #, #, L, q9)");
		TM.addInstruction("(q9, a, a, L, q9)");
		TM.addInstruction("(q9, b, b, L, q9)");
		TM.addInstruction("(q9, c, c, L, q9)");
		TM.addInstruction("(q9, B, B, R, q0)");
		
		TM.addInstruction("(q10, a, a, R, q10)");
		TM.addInstruction("(q10, b, b, R, q10)");
		TM.addInstruction("(q10, c, c, R, q10)");
		TM.addInstruction("(q10, #, #, R, q10)");
		TM.addInstruction("(q10, B, B, L, q11)");
		
		TM.addInstruction("(q11, a, B, L, q11)");
		TM.addInstruction("(q11, b, B, L, q11)");
		TM.addInstruction("(q11, c, B, L, q11)");
		TM.addInstruction("(q11, #, B, L, q11)");
		TM.addInstruction("(q11, B, 0, R, q12)");
		TM.addInstruction("(q11, B, B, L, q12)");
		
		
		// Accept Test Cases => prints 1
		System.out.println(TM.run("aca") + "\n");
		System.out.println(TM.run("bcb") + "\n");
		System.out.println(TM.run("abcab") + "\n");
		System.out.println(TM.run("abacaba") + "\n");
		
		// Reject Test Cases => prints 0
		System.out.println(TM.run("bca") + "\n");
		System.out.println(TM.run("aaca") + "\n");
		System.out.println(TM.run("acab") + "\n");
		System.out.println(TM.run("abacabab") + "\n");
		
	}
}
