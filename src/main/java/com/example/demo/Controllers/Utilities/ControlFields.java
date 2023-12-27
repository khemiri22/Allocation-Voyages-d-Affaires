package com.example.demo.Controllers.Utilities;

public class ControlFields {
    public static boolean verifyEmpty(String s)
    {
        return s.isEmpty() || s.isBlank();
    }
    public static boolean isoDouble(String s)
    {
        if(!s.matches("[^\\\\+\\-0-9.,]"))
        {
            try {
                double real = Double.parseDouble(s);
                return real > 0;
            }catch (NumberFormatException ex)
            {
                return false;
            }
        }
        return false;
    }
    public static Double calculateAvaSold(Double baseCalcul,String typeAva)
    {
        try {
            if(typeAva.equals("A"))
            {
                return baseCalcul * 0.25;
            } else if (typeAva.equals("E")) {
                return baseCalcul * 0.35;
            }else
                return (double)0;
        }catch (NullPointerException ex){
            return (double)0;
        }

    }

}
