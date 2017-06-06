/*************************************************************************************
 *
 * This class represents a fraction whose numerator and denominator are integers.
 *
 * Requirements:
 * 1. Implement interfaces: SimpleFractionInterface and Comparable (i.e. compareTo())
 * 2. Implement methods equals() and toString() from class Object
 * 3. Must work for both positive and negative fractions
 * 4. Must not reduce fraction to lowest term unless simplifySimpleFraction() is invoked 
 * 5. For input 3/-10 & -3/-10, convert them to -3/10 & 3/10 respectively (see Hint 2. below)
 * 6. Must display negative fraction as -x/y, 
 *    example: (-3)/10 or 3/(-10), must display as -3/10
 * 7. Must throw only SimpleFractionException in case of errors
 * 8. Must not add new or modify existing data fields
 * 9. Must not add new public methods
 * 10.May add private methods
 *
 * Hints:
 *
 * 1. To reduce a fraction such as 4/8 to lowest terms, you need to divide both
 *    the numerator and the denominator by their greatest common denominator.
 *    The greatest common denominator of 4 and 8 is 4, so when you divide
 *    the numerator and denominator of 4/8 by 4, you get the fraction 1/2.
 *    The recursive algorithm which finds the greatest common denominator of
 *    two positive integers is implemnted (see code)
 *       
 * 2. It will be easier to determine the correct sign of a fraction if you force
 *    the fraction's denominator to be positive. However, your implementation must 
 *    handle negative denominators that the client might provide.
 *           
 * 3. You need to downcast reference parameter SimpleFractionInterface to SimpleFraction if  
 *    you want to use it as SimpleFraction. See add, subtract, multiply and divide methods
 *
 * 4. Use "this" to access this object if it is needed
 *
 ************************************************************************************/

/**
 * Author: Poulomi Banerjee
 * Date: March 5th, 2017
 * Project 1: SimpleFraction
 * CSC 220/Spring 2017
 * Professor Wong
 */
package PJ1;

public class SimpleFraction implements SimpleFractionInterface, Comparable<SimpleFraction>
{
	// integer numerator and denominator
	private	int num;	
	private	int den;	

	public SimpleFraction()
	{
            // implement this method!
            //initialize variables
            num = 0;
            den = 1;
            // set fraction to default = 0/1
        }	// end default constructor

	public SimpleFraction(int num, int den) throws SimpleFractionException
	{
            if (den == 0){
                throw new SimpleFractionException ("Error: Denominator cannot be 0!");
            }
            else{
                // current num and den are equal to the values of num and den
                this.num = num;
                this.den = den;
            }
   
            // implement this method!
        }	// end constructor

	public void setSimpleFraction(int num, int den) throws SimpleFractionException
	{
            if (den == 0){
                throw new SimpleFractionException("Error: Denominator cannot be 0!");
            }
            else{
                // current num and den are equal to the values of num and den
                this.num = num;
                this.den = den;
            }

            // implement this method!
            // return SimpleFractionException if initialDenominator is 0
	}   // end setSimpleFraction

        
	public void simplifySimpleFraction()
        {
            int greatCommonDen = GCD(Math.abs(num), Math.abs(den));
            // implement this method!
            num/= greatCommonDen;
            den/= greatCommonDen;
            formatter();
	}

	public double toDouble()
	{
            // implement this method!

            // return double floating point value
            return (double)num/den;
	}	// end toDouble 

	public SimpleFractionInterface add(SimpleFractionInterface secondFraction)
	{
            // implement this method!
            SimpleFraction nSecondFraction = (SimpleFraction)secondFraction;
            SimpleFraction sum = new SimpleFraction(((num*nSecondFraction.den)+(den*nSecondFraction.num)), (den*nSecondFraction.den));
            sum.simplifySimpleFraction();
            sum.formatter();
            // a/b + c/d is (ad + cb)/(bd)
            // return result which is a new reduced SimpleFraction object
            return sum;
	}	// end add

	public SimpleFractionInterface subtract(SimpleFractionInterface secondFraction)
	{
            // implement this method!
            SimpleFraction nSecondFraction = (SimpleFraction) secondFraction;
            SimpleFraction difference = new SimpleFraction(((num*nSecondFraction.den)-(den*nSecondFraction.num)), (den*nSecondFraction.den));
            difference.simplifySimpleFraction();
            difference.formatter();
            // a/b - c/d is (ad - cb)/(bd)
            // return result which is a new reduced SimpleFraction object
            return difference;
	}	// end subtract

	public SimpleFractionInterface multiply(SimpleFractionInterface secondFraction)
	{
            // implement this method!
            SimpleFraction nSecondFraction = (SimpleFraction) secondFraction;
            SimpleFraction product = new SimpleFraction((num*nSecondFraction.num), (den*nSecondFraction.den));
            product.simplifySimpleFraction();
            product.formatter();
            // a/b * c/d is (ac)/(bd)
            // return result which is a new reduced SimpleFraction object
            return product;
	}	// end multiply

	public SimpleFractionInterface divide(SimpleFractionInterface secondFraction)
	{
            // implement this method!
            SimpleFraction nSecondFraction = (SimpleFraction) secondFraction;
            if(num == 0){
                throw new SimpleFractionException();
            }
            SimpleFraction quotient = new SimpleFraction((num*nSecondFraction.den), (den*nSecondFraction.num));
            quotient.simplifySimpleFraction();
            quotient.formatter();
            // return SimpleFractionException if secondFraction is 0
            // a/b / c/d is (ad)/(bc)
            // return result which is a new reduced SimpleFraction object
            return quotient;
	}	// end divide


	public boolean equals(Object other)
	{
            SimpleFraction nOther = (SimpleFraction) other;
            // implement this method!
            if((num* nOther.den)/(den*nOther.num)==1){
                return true;
            }
            return false;
	} // end equals


	public int compareTo(SimpleFraction other)
	{
            SimpleFraction nOther = (SimpleFraction) other;
            // implement this method!

            return Math.abs(den*nOther.num)/(Math.abs(num* nOther.den)) - 1;
	} // end compareTo

	
	public String toString()
	{
            return num + "/" + den;
	} // end toString



        //-----------------------------------------------------------------
        //  private methods start here
        //-----------------------------------------------------------------

	/** Task: Reduces a fraction to lowest terms. */
	private void reduceSimpleFractionToLowestTerms()
	{
                // implement this method!
                int greatCommonDen = GCD(Math.abs(num), Math.abs(den));
                // Outline:
                // compute GCD of num & den
                // GCD works for + numbers.
                // So, you should eliminate - sign
                // then reduce numbers : num/GCD and den/GCD
	}	// end reduceSimpleFractionToLowestTerms

  	/** Task: Computes the greatest common divisor of two integers.
	 *        This is a recursive method!
	 *  @param integerOne	 an integer
	 *  @param integerTwo	 another integer
	 *  @return the greatest common divisor of the two integers */
	private int GCD(int integerOne, int integerTwo)
	{
		 int result;

		 if (integerOne % integerTwo == 0)
			result = integerTwo;
		 else
			result = GCD(integerTwo, integerOne % integerTwo);

		 return result;
	}	// end GCD
        private void formatter (){
            // basically a sign-flipper method. 
            if (den < 0){
                num *= -1;
                den *= -1;
            }
        }

	//-----------------------------------------------------------------
	//  Some tests are given here 

	public static void main(String[] args)
	{
		SimpleFractionInterface firstOperand = null;
		SimpleFractionInterface secondOperand = null;
		SimpleFractionInterface result = null;
                double doubleResult = 0.0;

		System.out.println("\n=========================================\n");
		firstOperand = new SimpleFraction(12, 20);
		System.out.println("Fraction before simplification:\t\t" + firstOperand);
		System.out.println("\tExpected result :\t\t12/20\n");
		firstOperand.simplifySimpleFraction();
		System.out.println("\nFraction after simplification:\t\t" + firstOperand);
		System.out.println("\tExpected result :\t\t3/5\n");

		firstOperand = new SimpleFraction(20, -40);
		System.out.println("\nFraction before simplification:\t\t" + firstOperand);
		System.out.println("\tExpected result :\t\t-20/40\n");
		firstOperand.simplifySimpleFraction();
		System.out.println("\nFraction after simplification:\t\t" + firstOperand);
		System.out.println("\tExpected result :\t\t-1/2\n");


		SimpleFraction nineSixteenths = new SimpleFraction(9, 16);  // 9/16
		SimpleFraction oneFourth = new SimpleFraction(1, 4);        // 1/4

		System.out.println("\n=========================================\n");
		// 7/8 + 9/16
		firstOperand = new SimpleFraction(7, 8);
		result = firstOperand.add(nineSixteenths);
		System.out.println("The sum of " + firstOperand + " and " +
				nineSixteenths + " is \t\t" + result);
		System.out.println("\tExpected result :\t\t23/16\n");

		// 9/16 - 7/8
		firstOperand = nineSixteenths;
		secondOperand = new SimpleFraction(7, 8);
		result = firstOperand.subtract(secondOperand);
		System.out.println("The difference of " + firstOperand	+
				" and " +	secondOperand + " is \t" + result);
		System.out.println("\tExpected result :\t\t-5/16\n");


		// 15/-2 * 1/4
		firstOperand = new SimpleFraction(15, -2); 
		result = firstOperand.multiply(oneFourth);
		System.out.println("The product of " + firstOperand	+
				" and " +	oneFourth + " is \t" + result);
		System.out.println("\tExpected result :\t\t-15/8\n");

		// (-21/2) / (3/7)
		firstOperand = new SimpleFraction(-21, 2); 
		secondOperand= new SimpleFraction(3, 7); 
		result = firstOperand.divide(secondOperand);
		System.out.println("The quotient of " + firstOperand	+
				" and " +	secondOperand + " is \t" + result);
		System.out.println("\tExpected result :\t\t-49/2\n");

		// -21/2 + 7/8
		firstOperand = new SimpleFraction(-21, 2); 
		secondOperand= new SimpleFraction(7, 8); 
		result = firstOperand.add(secondOperand);
		System.out.println("The sum of " + firstOperand	+
				" and " +	secondOperand + " is \t\t" + result);
		System.out.println("\tExpected result :\t\t-77/8\n");


                // 0/10, 5/(-15), (-22)/7
		firstOperand = new SimpleFraction(0, 10); 
                doubleResult = firstOperand.toDouble();
		System.out.println("The double floating point value of " + firstOperand	+ " is \t" + doubleResult);
		System.out.println("\tExpected result \t\t\t0.0\n");
		firstOperand = new SimpleFraction(1, -3); 
                doubleResult = firstOperand.toDouble();
		System.out.println("The double floating point value of " + firstOperand	+ " is \t" + doubleResult);
		System.out.println("\tExpected result \t\t\t-0.333333333...\n");
		firstOperand = new SimpleFraction(-22, 7); 
                doubleResult = firstOperand.toDouble();
		System.out.println("The double floating point value of " + firstOperand	+ " is \t" + doubleResult);
		System.out.println("\tExpected result \t\t\t-3.142857142857143");
		System.out.println("\n=========================================\n");
		firstOperand = new SimpleFraction(-21, 2); 
		System.out.println("First = " + firstOperand);
		// equality check
		System.out.println("check First equals First: ");
		if (firstOperand.equals(firstOperand))
			System.out.println("Identity of fractions OK");
		else
			System.out.println("ERROR in identity of fractions");

		secondOperand = new SimpleFraction(-42, 4); 
		System.out.println("\nSecond = " + secondOperand);
		System.out.println("check First equals Second: ");
		if (firstOperand.equals(secondOperand))
			System.out.println("Equality of fractions OK");
		else
			System.out.println("ERROR in equality of fractions");

		// comparison check
		SimpleFraction first  = (SimpleFraction)firstOperand;
		SimpleFraction second = (SimpleFraction)secondOperand;
		
		System.out.println("\ncheck First compareTo Second: ");
		if (first.compareTo(second) == 0)
			System.out.println("SimpleFractions == operator OK");
		else
			System.out.println("ERROR in fractions == operator");

		second = new SimpleFraction(7, 8);
		System.out.println("\nSecond = " + second);
		System.out.println("check First compareTo Second: ");
		if (first.compareTo(second) < 0)
			System.out.println("SimpleFractions < operator OK");
		else
			System.out.println("ERROR in fractions < operator");

		System.out.println("\ncheck Second compareTo First: ");
		if (second.compareTo(first) > 0)
			System.out.println("SimpleFractions > operator OK");
		else
			System.out.println("ERROR in fractions > operator");

		System.out.println("\n=========================================");

		System.out.println("\ncheck SimpleFractionException: 1/0");
		try {
			SimpleFraction a1 = new SimpleFraction(1, 0);		    
		        System.out.println("Error! No SimpleFractionException");
		}
		catch ( SimpleFractionException fe )
           	{
              		System.err.printf( "Exception: %s\n", fe );
           	} // end catch
		System.out.println("Expected result : SimpleFractionException!\n");

		System.out.println("\ncheck SimpleFractionException: division");
		try {
			SimpleFraction a2 = new SimpleFraction();		    
			SimpleFraction a3 = new SimpleFraction(1, 2);		    
			a3.divide(a2);
		        System.out.println("Error! No SimpleFractionException");
		}
		catch ( SimpleFractionException fe )
           	{
              		System.err.printf( "Exception: %s\n", fe );
           	} // end catch
		System.out.println("Expected result : SimpleFractionException!\n");



	}	// end main
} // end SimpleFraction

