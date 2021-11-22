package it.unisa.diem.softwareengineering.assignment2021;

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

    public static ComplexNumber parseToComplexNumber(String str) throws NumberFormatException {
        //Pattern that matches [real]+j[imm] or [real]+[imm]j:
        Pattern complexPatternRealFirst = Pattern.compile("((\\d+\\.\\d+)|(\\d+))(\\+|-)((((\\d+\\.\\d+)|(\\d+))j)|j((\\d+\\.\\d+)|(\\d+)))");
        Matcher complexPatternRealFirstMatcher = complexPatternRealFirst.matcher(str);
        //Pattern that matches j[imm]+[real] or [imm]j+[real]:
        Pattern complexPatternImmFirst = Pattern.compile("((((\\d+\\.\\d+)|(\\d+))j)|j((\\d+\\.\\d+)|(\\d+)))(\\+|-)((\\d+\\.\\d+)|(\\d+))");
        Matcher complexPatternImmFirstMatcher = complexPatternImmFirst.matcher(str);
        //Pattern that matches real numbers:
        Pattern realPattern = Pattern.compile("(\\d+\\.\\d+)|(\\d+)");
        Matcher realPatternMatcher = realPattern.matcher(str);
        //Now we check what pattern matches our string and we build our ComplexNumber accordingly:
        if (complexPatternRealFirstMatcher.matches()) {
            String [] splitString = str.split("\\+|-");
            Double real = Double.parseDouble(splitString[0]);
            Double imm = Double.parseDouble(splitString[1].replace("j",""));
            return new ComplexNumber(real,imm);
        }
        else if (complexPatternImmFirstMatcher.matches()) {
            String [] splitString = str.split("\\+|-");
            Double real = Double.parseDouble(splitString[1]);
            Double imm = Double.parseDouble(splitString[0].replace("j",""));
            return new ComplexNumber(real,imm);
        }
        else if (realPatternMatcher.matches()) {
            return new ComplexNumber(Double.parseDouble(str),0.0);
        }
        //if none of the above patterns match, throw a Format Exception.
        else {
            String correctFormats = "[real], [real]+j[imm], [real]+[imm]j, j[imm]+[real] or [imm]j+[real]";
            throw new NumberFormatException("Expected formats: "  + correctFormats);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj!=null && obj.getClass().equals(this.getClass())) {
            ComplexNumber c=(ComplexNumber) obj;
            return this.real.equals(c.getReal()) && this.imm.equals(c.getImm());
        }
        return false;
    }

    @Override
    public String toString() {
        //Strip real and imm of decimal value if it's 0.
        String realString = real.toString();
        String immString = imm.toString();
        if (immString.contains(".0"))
            realString = realString.split("\\.")[0];
        if (immString.contains(".0"))
            immString = immString.split("\\.")[0];
        //We only need plus symbol if imm is greather than 0, because - is printed by toString otherwise.
        String plus = imm >= 0.0 ? "+" : "";
        return realString+plus+immString+'j';
    }
}
