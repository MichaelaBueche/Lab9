package lab9;

public class DelimiterChecker {

	private StackX delimiters;
	private String data;
	public DelimiterChecker(String input) {
		data=input;
		delimiters=new StackX(input.length());
		check();
	}
	
	public boolean check() {
		for(int i=0;i<data.length();i++) {
			if(notDelimiter(data.charAt(i))==true)
				continue;
			else if(isOpeningDelimiter(data.charAt(i))==true)
				delimiters.push(data.charAt(i));
			else if(delimiters.isEmpty()==false) {
				if(data.charAt(i)=='}'&&delimiters.peek()=='{')
					delimiters.pop();
				else if(data.charAt(i)==']'&&delimiters.peek()=='[')
					delimiters.pop();
				else if(data.charAt(i)==')'&&delimiters.peek()=='(')
					delimiters.pop();
				else {
					System.out.println("Matching error on: "+data);
					return false;
				}
			}
		}
		if(delimiters.isEmpty()==false) {
			System.out.println("Missing right delimiter error on: "+data);
			return false;
		}
		return true;
	}
	public boolean notDelimiter(char in) {
		if(in!='{'&&in!='['&&in!='('&&in!='}'&&in!=']'&&in!=')')
			return true;
		return false;
	}
	public boolean isOpeningDelimiter(char in) {
		if(in=='{'||in=='['||in=='(')
			return true;
		return false;
	}
}
