public class Main {

    public static boolean iscnpvalid(int length) {
        boolean flag = true;
        if (length != 13) {
            flag = false;
        }
        return flag;
    }

    public static String getYearPrefix(char firstNumber) {
        String prefix = "";
        switch (firstNumber) {
            case '1':
                prefix = "19";
                break;
            case '2':
                prefix = "19";
                break;
            case '3':
                prefix = "18";
                break;
            case '4':
                prefix = "18";
                break;
            case '5':
                prefix = "20";
                break;
            case '6':
                prefix = "20";
                break;
            default:
                prefix = "Invalid";
                break;
        }
        return prefix;
    }

    public static String getJudet(String cod) {
        String judet = "";
        switch (cod) {
            case "01":
                judet = "Alba";
                break;
            case "02":
                judet = "Arad";
                break;
            case "03":
                judet = "Arges";
                break;
            case "04":
                judet = "Bacau";
                break;
            case "05":
                judet = "Bihor";
                break;
            case "06":
                judet = "Bistrita Nasaut";
                break;
            case "07":
                judet = "Botosani";
                break;
            case "08":
                judet = "Brasov";
                break;
            case "09":
                judet = "Braila";
                break;
            case "10":
                judet = "Buzau";
                break;
            case "11":
                judet = "Caras-Severin";
                break;
            case "12":
                judet = "Cluj";
                break;
            case "13":
                judet = "Constanta";
                break;
            case "14":
                judet = "Covasna";
                break;
            case "15":
                judet = "Dambovita";
                break;
            case "16":
                judet = "Dolj";
                break;
            case "17":
                judet = "Galati";
                break;
            case "18":
                judet = "Gorj";
                break;
            case "19":
                judet = "Harghita";
                break;
            case "20":
                judet = "Hunedoara";
                break;
            case "21":
                judet = "Ialomita";
                break;
            case "22":
                judet = "Iasi";
                break;
            case "23":
                judet = "Ilfov";
                break;
            case "24":
                judet = "Maramures";
                break;
            case "25":
                judet = "Mehedinti";
                break;
            case "26":
                judet = "Mures";
                break;
            case "27":
                judet = "Neamt";
                break;
            case "28":
                judet = "Olt";
                break;
            case "29":
                judet = "Prahova";
                break;
            case "30":
                judet = "Satu Mare";
                break;
            case "31":
                judet = "Salaj";
                break;
            case "32":
                judet = "Sibiu";
                break;
            case "33":
                judet = "Suceava";
                break;
            case "34":
                judet = "Teleorman";
                break;
            case "35":
                judet = "Timis";
                break;
            case "36":
                judet = "Tulcea";
                break;
            case "37":
                judet = "Vaslui";
                break;
            case "38":
                judet = "Valcea";
                break;
            case "39":
                judet = "Vrancea";
                break;
            case "40":
                judet = "Bucuresti";
                break;
            case "41":
                judet = "Bucuresti Sector 1";
                break;
            case "42":
                judet = "Bucuresti Sector 2";
                break;
            case "43":
                judet = "Bucuresti Sector 3 ";
                break;
            case "44":
                judet = "Bucuresti Sector 4 ";
                break;
            case "45":
                judet = "Bucuresti Sector 5";
                break;
            case "46":
                judet = "Bucuresti Sector 6";
                break;
            case "51":
                judet = "Calarasi";
                break;
            case "52":
                judet = "Giurgiu";
                break;
        }
        return judet;
    }




    /*
     * Metoda returneaza sexul persoanei reprezentat printr-un caracter (M/F) prin verificarea primei cifre din CNP
     * @param firstNumber - primul caracater din CNP transmis din main folosind CNP.charAt(0)
     * @return - Returnam un singur caracter care reprezinta sexul persoanei i.e primul caracter 2 atunci returnam 'F'
     */

    public static char returnSexOfPerson(char firstNumber) {
        char sex;
        if (firstNumber == '1' ||
                firstNumber == '3' ||
                firstNumber == '5' ||
                firstNumber == '7') {
            sex = 'M';
        } else {
            sex = 'F';
        }
        return sex;
    }

    /*
     * Metoda care proceseaza substringul din CNP care contine data si il formateaza intr-un mod prin care putem lucra
       mai usor cu el
     * Astfel daca avem un CNP de forma: 1961201XXXXXX atunci data o sa fie substringul pentru data o sa fie 961201
     * param CNP - Transmitem intregul CNP catre metoda
     * return - Returnam data intr-un format de tipul dd-MM-yyyy in format String
     */

    public static String getBirthDateFromCnpAsString(String CNP) {
        String dateOfBirth = CNP.substring(1, 7);
        String prefix = getYearPrefix(CNP.charAt(0));

        dateOfBirth = prefix + dateOfBirth;
        return dateOfBirth.substring(6, 8) + "-" + dateOfBirth.substring(4, 6) + "-" +
                dateOfBirth.substring(0, 4);
    }

    public static int age (String CNP) {
        String dateOfBirth = getBirthDateFromCnpAsString(CNP);
        String currentDate = "17-12-2022";

        String[] birthDateFormatted = dateOfBirth.split("-");

        int dayOfBirth = Integer.parseInt(birthDateFormatted[0]);
        int monthOfBirth = Integer.parseInt(birthDateFormatted[1]);
        int yearOfBirth = Integer.parseInt(birthDateFormatted[2]);

        String[] currentDateFormatted = currentDate.split("-");

        int currentDay = Integer.parseInt(currentDateFormatted[0]);
        int currentMonth = Integer.parseInt(currentDateFormatted[1]);
        int currentYear = Integer.parseInt(currentDateFormatted[2]);

        int age = currentYear - yearOfBirth;

        if (monthOfBirth > currentMonth)
        {age-=1;}
        else
            if(monthOfBirth == currentMonth)
            {if (dayOfBirth > currentDay)
            {age -= 1;}
        }
        return age;

    }

    public static void main (String [] args)
    {

        String cnp = "2910901170027";
        System.out.println(iscnpvalid(cnp.length()) + " numarul de cifre al codului este: " + cnp.length());
        System.out.println(getBirthDateFromCnpAsString(cnp));
        System.out.println("The person is: " + returnSexOfPerson(cnp.charAt(0)));
        System.out.println("Varsta persoanei este " + age(cnp));
        System.out.println(getJudet(cnp));
    }
}