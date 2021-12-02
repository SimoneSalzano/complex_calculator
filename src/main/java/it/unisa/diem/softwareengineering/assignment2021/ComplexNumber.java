package it.unisa.diem.softwareengineering.assignment2021;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
* A representation of a Complex Number that with a real part and an imaginary part. 
* @author Simone Salzano
* 
*/
public class ComplexNumber {
    private Double real;
    private Double imm;

    public ComplexNumber(Double real, Double imm) {
        this.real=real;
        this.imm=imm;
    }

    
    /** 
     * Gets the real part associated with the complex number.
     * @return Double
     */
    public Double getReal() {
        return this.real;
    }

    
    /** 
     * Sets the real part associated with the complex number to the passed double.
     * @param real
     */
    public void setReal(Double real) {
        this.real = real;
    }

    
    /** 
     * Gets the real imaginary associated with the complex number.
     * @return Double
     */
    public Double getImm() {
        return this.imm;
    }

    
    /** 
     * Sets the imaginary part associated with the complex number to the passed double.
     * @param imm
     */
    public void setImm(Double imm) {
        this.imm = imm;
    }

    
    /** 
     * A method to convert a properly formatted String to a Complex Number.
     * Accepted formats are:
     *      a+bj, a+jb, jb+a, bj+a, a, j.
     * Where a and b are strings parsable to Double. 
     * @param str The string to parse to a complex number.
     * @return ComplexNumber the complex number corresponding to the parsed string
     * @throws NumberFormatException When str doesn't have the correct format, so it can't be covnerted. 
     */
    public static ComplexNumber parseToComplexNumber(String str) throws NumberFormatException {
        //Pattern that matches a+jb or a+bj:
        Pattern complexPatternRealFirst = Pattern.compile("(-|\\+|)((\\d+\\.\\d+)|(\\d+))(\\+|-)(j((\\d+\\.\\d+)|(\\d+))*|(((\\d+\\.\\d+)|(\\d+))*j))");
        Matcher complexPatternRealFirstMatcher = complexPatternRealFirst.matcher(str);
        //Pattern that matches jb+a or aj+b:
        Pattern complexPatternImmFirst = Pattern.compile("(-|\\+|)((((\\d+\\.\\d+)|(\\d+))*j)|j((\\d+\\.\\d+)|(\\d+))*)(\\+|-)((\\d+\\.\\d+)|(\\d+))");
        Matcher complexPatternImmFirstMatcher = complexPatternImmFirst.matcher(str);
        //Pattern that matches real numbers:
        Pattern realPattern = Pattern.compile("(-|\\+|)((\\d+\\.\\d+)|(\\d+))");
        Matcher realPatternMatcher = realPattern.matcher(str);
        //Pattern that matches pure imaginary numbers:
        Pattern immPattern = Pattern.compile("(-|\\+|)((((\\d+\\.\\d+)|(\\d+))+j)|j((\\d+\\.\\d+)|(\\d+))*)");
        Matcher immPatternMatcher = immPattern.matcher(str);
        //Now we check what pattern matches our string and we build our ComplexNumber accordingly:

        if (complexPatternRealFirstMatcher.matches()) {
            //Split string between real and imaginary part
            String [] splitString = str.split("(?<!^)(\\+|-)");
            Double real,imm;
            real = Double.parseDouble(splitString[0]);
            //Check if imm is positive or negative by looking at its sign and parse it accordingly
            if (str.contains("+") && str.indexOf("+",1)>-1)
                imm = convertImmStrToDouble(splitString[1]);
            else
                imm = - convertImmStrToDouble(splitString[1]);
            return new ComplexNumber(real,imm);
        }

        else if (complexPatternImmFirstMatcher.matches()) {
            //Split string between real and imaginary part
            String [] splitString = str.split("(?<!^)(\\+|-)");
            Double real,imm;
            //Check if imm is positive or negative by looking at its sign and parse it accordingly
            if (str.contains("+") && str.indexOf("+",1)>-1)
                real = Double.parseDouble(splitString[1].replace("j",""));
            else
                real = Double.parseDouble("-" + splitString[1].replace("j",""));
            imm = convertImmStrToDouble(splitString[0]);
            return new ComplexNumber(real,imm);
        }

        else if (realPatternMatcher.matches()) {
            return new ComplexNumber(Double.parseDouble(str),0.0);
        }

        else if (immPatternMatcher.matches()) {
            Double imm = convertImmStrToDouble(str);
            return new ComplexNumber(0.0, imm);
        }
        //if none of the above patterns match, throw a Format Exception.
        else {
            String correctFormats = "a, a+jb, a+bj, jb+a or bj+a, bj. \'b\' can be omitted if its value is 1 or -1.";
            throw new NumberFormatException("Expected formats: "  + correctFormats);
        }
    }

    
    /** 
     * Checks if this Complex Number is equal to another one by checking if the real and imaginary parts correspond.  
     * @param obj the object to compare
     * @return boolean ture if the two elements are equal, false if not.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj!=null && obj.getClass().equals(this.getClass())) {
            ComplexNumber c=(ComplexNumber) obj;
            return this.real.equals(c.getReal()) && this.imm.equals(c.getImm());
        }
        return false;
    }

    
    /** 
     * Converts a Complex Number to a String with the format a+bj, precision to the the third digit
     * @return String the String representation of a Complex Number.
     */
    @Override
    public String toString() {
        //Separates with a dot integer part from decimal part 
        DecimalFormatSymbols symbol= new DecimalFormatSymbols(new Locale("US"));
        //Precision is 3, with DecimalFormat if we have 0s, it won't output them.
        DecimalFormat df = new DecimalFormat("#.###",symbol);
        //df.toLocalizedPattern();
        String realString = df.format(real);
        String immString = df.format(imm);
        //We only need plus symbol if imm is greather than 0, because - is printed by toString otherwise.
        String plus = imm >= 0.0 ? "+" : "";
        return realString+plus+immString+'j';
    }



    
    /** 
     * Check if a String is a valid complex number.
     * @param input what you want to check if it's a complex number
     * @return boolean
     */
    public static boolean isComplexNumber(String input) {
        String realNumberRegex = "(-|\\+|)((\\d+\\.\\d+)|(\\d+))";
        String immNumberRegex = "(-|\\+|)((((\\d+\\.\\d+)|(\\d+))+j)|j((\\d+\\.\\d+)|(\\d+))*)";
        String complexNumberRealFirstRegex = "(-|\\+|)((\\d+\\.\\d+)|(\\d+))(\\+|-)(j((\\d+\\.\\d+)|(\\d+))*|(((\\d+\\.\\d+)|(\\d+))*j))";
        String complexNumberImmFirstRegex = "(-|\\+|)((((\\d+\\.\\d+)|(\\d+))*j)|j((\\d+\\.\\d+)|(\\d+))*)(\\+|-)((\\d+\\.\\d+)|(\\d+))";

        boolean check = input.matches(realNumberRegex) || input.matches(immNumberRegex) || input.matches(complexNumberRealFirstRegex) || input.matches(complexNumberImmFirstRegex);

        return check;
    }

    
    /** 
     * Utility method to convert a String formatted as a pure imaginary number to a Double 
     * @param immStr
     * @return Double the Double corresponding to the converted imaginary-formatted String
     */
    private static Double convertImmStrToDouble(String immStr) {
        String jLess = immStr.replace("j","");
        if (jLess.equals("-"))
            return -1.0;
        if (jLess.equals("+") || jLess.equals(""))
            return 1.0;
        return Double.parseDouble(jLess);
    }
}
