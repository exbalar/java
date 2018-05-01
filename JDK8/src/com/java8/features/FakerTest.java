package com.java8.features;

import java.util.Random;

public class FakerTest {


	private boolean checkNull(String input){
    	if (input != null && !input.isEmpty()){
        	return true;
        }
        return false;
    	 
    }
    public String letterify(String letterString) {
    
    	String output = "";
    	if(checkNull(letterString)){
    		while(letterString.contains("?")) {
    			System.out.println("hi");
    			System.out.println(letterString);
    			letterString = letterString.replaceFirst("\\?", Character.toString(this.randomSeriesForThreeCharacter()));
    			System.out.println(letterString);
    		}
    		output = letterString;
        }
        return output;
          
    }
    
    private char randomSeriesForThreeCharacter() {
    	Random r = new Random();
    	char c = (char) (r.nextInt(26) + 'a');
    	return c;
    }

    public String numerify(String numberString) {
    
        String output = "";
        System.out.println(numberString);
    	if(checkNull(numberString)){
        	output = numberString.replaceAll("\\#", "1");
        }
        return output;
   
    }

    public String bothify(String string) {
         String output = "";
    	if(checkNull(string)){
    		System.out.println("this.letterify(string)::" + this.letterify(string));
        	output = this.numerify(this.letterify(string));
        }
    	return output;

    }
    public static void main(String[] args) {
    	FakerTest f = new FakerTest();
		System.out.println("output>>>"+f.bothify("Test?1?2#"));
		System.out.println(f.randomSeriesForThreeCharacter());
	}

}