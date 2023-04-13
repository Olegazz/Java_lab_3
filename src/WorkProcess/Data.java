package WorkProcess;

import java.time.LocalDate;
import java.time.Period;

public class Data {

    /**
     *Divides a string into elements
     * @param personData
     * @return
     */
    public static String stringSplit(String personData){
        String buffer[] = personData.split(" ");
        String buffer_1 = buffer[0] + " " + buffer[1] + " " + buffer[2];
        return getInitial(buffer_1) + " " + getGender(buffer[2]) + " " + getAge(buffer[3]);
    }

    /**
     * Converts first name and patronymic into initials
     * @param personData
     * @return
     */
    public static String getInitial(String personData) {
        String[] buffer = personData.split(" ");
        String resultInit = buffer[0] + " ";
        for (int i = 1; i < 3; i++) {
            resultInit += buffer[i].substring(0,1).toUpperCase() + ".";
        }
        return resultInit.trim();
    }

    /**
     * Determines the gender of the person
     * @param personData
     * @return
     */
    public static String getGender(String personData){
        try {
            if (personData.charAt(personData.length()-1) == 'ч'){
                return "М";
            }
            else if (personData.charAt(personData.length()-1) == 'а'){
                return "Ж";
            }
            else {
                System.out.println("Wrong name");
            }

        }catch (Exception e){
            System.out.println("Wrong name");
        }
        System.exit(0);
        return null;
    }

    /**
     * Determines the age of the person
     * @param personData
     * @return
     */
    public static String getAge(String personData){
        String buffer[] = personData.split("\\.");
        try {
            LocalDate nowDate = LocalDate.now();
            LocalDate birthday = LocalDate.of(Integer.parseInt(buffer[2]),Integer.parseInt(buffer[1]), Integer.parseInt(buffer[0]));
            String age = Integer.toString(Period.between(birthday, nowDate).getYears());
            int age_1 = Integer.parseInt(age);
            if ((age_1 % 10 <= 9 && age_1 % 10 > 4) || (age_1 % 10 == 0) || (age_1 < 15 && age_1 > 10)) {
                age += " лет";
            } else if (age_1%10 > 1 && age_1%10 < 5) {
                age += " года";
            }
            else {
                age+=" год";
            }
            return age;
        }catch (Exception e){
            System.out.println("wrong date");
        }
        System.exit(0);
        return null;
    }
}
