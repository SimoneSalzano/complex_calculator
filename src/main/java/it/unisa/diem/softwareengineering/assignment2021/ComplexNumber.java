package it.unisa.diem.softwareengineering.assignment2021;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComplexNumber {
    private Double real;
    private Double imm;

    public ComplexNumber(Double real, Double imm) {
        this.real=real;
        this.imm=imm;
    }

    public Double getReal() {
        return this.real;
    }

    public void setReal(Double real) {
        this.real = real;
    }

    public Double getImm() {
        return this.imm;
    }

    public void setImm(Double imm) {
        this.imm = imm;
    }

    
    /** 
     * @param str The string to parse to a complex number
     * @return ComplexNumber the complex number corresponding to the parsed string
     * @throws NumberFormatException When str doesn't have the correct format. 
     */
    public static ComplexNumber parseToComplexNumber(String str) throws NumberFormatException {
        //Pattern that matches a+jb or a+bj:
        Pattern complexPatternRealFirst = Pattern.compile("(|\\+|-)((\\d+\\.\\d+)|(\\d+))(\\+|-)(j((\\d+\\.\\d+)|(\\d+))*|(((\\d+\\.\\d+)|(\\d+))*j))");
        Matcher complexPatternRealFirstMatcher = complexPatternRealFirst.matcher(str);
        //Pattern that matches jb+a or aj+b:
        Pattern complexPatternImmFirst = Pattern.compile("(|\\+|-)((((\\d+\\.\\d+)|(\\d+))*j)|j((\\d+\\.\\d+)|(\\d+))*)(\\+|-)((\\d+\\.\\d+)|(\\d+))");
        Matcher complexPatternImmFirstMatcher = complexPatternImmFirst.matcher(str);
        //Pattern that matches real numbers:
        Pattern realPattern = Pattern.compile("(|\\+|-)(\\d+\\.\\d+)|(\\d+)");
        Matcher realPatternMatcher = realPattern.matcher(str);
        //Pattern that matches pure imaginary numbers:
        Pattern immPattern = Pattern.compile("((|\\+|-)((\\d+\\.\\d+)|(\\d+))*j)|(j(|\\+|-)((\\d+\\.\\d+)|(\\d+))*)");
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
     * @param obj
     * @return boolean
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
     * @return String
     */
    @Override
    public String toString() {
        //Precision is 5, with DecimalFormat if we have 0s, it won't output them.
        DecimalFormat df = new DecimalFormat("#.###");
        String realString = df.format(real);
        String immString = df.format(imm);
        //We only need plus symbol if imm is greather than 0, because - is printed by toString otherwise.
        String plus = imm >= 0.0 ? "+" : "";
        return realString+plus+immString+'j';
    }

    
    /** 
     * @param immStr
     * @return Double
     */
    private static Double convertImmStrToDouble(String immStr) {
        //utility method to convert a imaginary number
        String jLess = immStr.replace("j","");
        if (jLess.equals("-"))
            return -1.0;
        if (jLess.equals("+") || jLess.equals(""))
            return 1.0;
        return Double.parseDouble(jLess);
    }
}
