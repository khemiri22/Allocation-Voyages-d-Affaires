package com.example.demo.Controllers.Utilities;

public class ControleFields {
    public static boolean verifyEmpty(String s)
    {
        return s.isEmpty() || s.isBlank();
    }
    public static boolean isoDouble(String s)
    {
        if(!s.matches("[^\\\\+\\-0-9.,]"))
        {
            try {
                Double.parseDouble(s);
                return true;
            }catch (NumberFormatException ex)
            {
                return false;
            }
        }
        return false;
    }
    public static Double calculateAvaSold(Double baseCalcule,String typeAva)
    {
        try {
            if(typeAva.equals("A"))
            {
                return baseCalcule * 0.25;
            } else if (typeAva.equals("E")) {
                return baseCalcule * 0.35;
            }else
                return (double)0;
        }catch (NullPointerException ex){
            return (double)0;
        }

    }

}
