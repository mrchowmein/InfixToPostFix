public class Converter {
	


	public static String toPostFix(String infixString){

		char[] charString = infixString.toCharArray();
		String[] parsedInfix = parse(charString);

		String postfixString ="";
		
		LinkedStack<String> operatorStack = new LinkedStack<String>();

		for(int i = 0; i < parsedInfix.length; i++){

			if(parsedInfix[i] != null){

				//add to postfix if operand
				if(isNumeric(parsedInfix[i])){
					postfixString = postfixString + parsedInfix[i] + " ";
					//System.out.println(postfixString);

				} else if(parsedInfix[i].equals("(")){ //check if (
					operatorStack.push(parsedInfix[i]);
					//System.out.println("pushed " + parsedInfix[i]);

				} else if(parsedInfix[i].equals(")")){ //if ), pop and add to postfixString until )
					//System.out.println("popping 31" + operatorStack.peek());

					while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")){
						postfixString = postfixString + operatorStack.pop() + " ";
						//System.out.println(postfixString);
					}
					//System.out.println("peek 37 " + operatorStack.peek());
					operatorStack.pop();

				} else {
					while(!operatorStack.isEmpty() && weight(operatorStack.peek()) >= weight(parsedInfix[i])){
						
						//System.out.println("popping 43" + operatorStack.peek());

						postfixString = postfixString + operatorStack.pop() + " ";

						//System.out.println(postfixString);

					}
					operatorStack.push(parsedInfix[i]);
					//System.out.println("pushed " + parsedInfix[i]);
					
				}


			}
		}


		while (!operatorStack.isEmpty()){

			//System.out.println("popping last" + operatorStack.peek());
			postfixString += operatorStack.pop() + " ";
			//System.out.println(postfixString);
		}
        

		return postfixString;
	}// end of method


	private static int weight(String operator){

		int result = 0;

		switch(operator){
			case "+":
				//System.out.println("+ detected");
				result = 1;
				break;
			case "-":
				//System.out.println("- detected");
				result = 1;
				break;
			case "*":
				//System.out.println("* detected");
				result = 2;
				break;
			case "/":
				//System.out.println("/ detected");
				result = 2;
				break;
			case "^":
				//System.out.println("^ detected");
				result = 3;
				break;
		}
		
		return result;

	}

	private static String[] parse(char[] input) {
	    int inputLength = input.length;
	    
	    LinkedStack<String> expStack = new LinkedStack<String>();
	    
	    for (int i = 0; i < inputLength; ++i) {
	        char c = input[i];
	        if (Character.isDigit(c)) {
	            String number = input[i] + "";
	            for (int j = i + 1; j < inputLength; ++j) {
	                if (Character.isDigit(input[j])) {
	                    number += input[j];
	                    i = j;
	                } else {
	                    break;
	                }
	            }
	            //System.out.println(number);
	            //System.out.println("pos "+ i);
	            expStack.push(number+"");
	        } else if (c == '*' || c == '/' || 
	                   c == '+' || c == '^' || 
	                   c == '-' || c == '(' || c == ')') {
	            //System.out.println(c);
	            //System.out.println("pos "+ i);
	            expStack.push(c+"");
	        }
	    }
	   	

	    String[] parsed = new String[expStack.size()];
	    for(int i = expStack.size()-1; i > -1; i--){
	    	parsed[i] = expStack.pop();
	    }
	    

	    return parsed;
	}

	//check to see if string is a number
	private static boolean isNumeric(String s){  
		try{  
		double d = Double.parseDouble(s);  
		}  
		catch(NumberFormatException nfe)  
		{  
		return false;  
		}  
		return true;  
	}
	
}