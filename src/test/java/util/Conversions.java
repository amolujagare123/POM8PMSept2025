package util;

import java.util.HashMap;

public class Conversions {

    public static String getCountry(String countryShortCode)
    {
        HashMap<String,String> countries = new HashMap<>();
        countries.put("IN","India");
        countries.put("US", "United States");
        countries.put("UK", "United Kingdom");
        countries.put("CA", "Canada");
        countries.put("AU", "Australia");
        countries.put("NZ", "New Zealand");
        countries.put("JP", "Japan");
        countries.put("CN", "China");
        countries.put("RU", "Russia");
        countries.put("BR", "Brazil");
        countries.put("ZA", "South Africa");
        countries.put("FR", "France");
        countries.put("DE", "Germany");
        countries.put("IT", "Italy");
        countries.put("ES", "Spain");
        countries.put("MX", "Mexico");
        countries.put("KR", "South Korea");
        countries.put("SG", "Singapore");
        countries.put("AE", "United Arab Emirates");
        countries.put("SA", "Saudi Arabia");
        countries.put("CH", "Switzerland");

        return  countries.get(countryShortCode);

    }


    public static  String getGender(String genderID)
    {
        HashMap<String,String> gender = new HashMap<>();
        gender.put("0","Male");
        gender.put("1","Female");
        gender.put("2","Other");
        return gender.get(genderID);
    }
}
