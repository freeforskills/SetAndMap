import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        // Создаем массив строк с дублями
        String[] msv = {"вода", "округ", "поезд", "больной", "грудь", "передача",
                "конкурс", "вода", "уход", "поезд", "сотрудник", "правило", "пол", "капитан",
                "плата", "объем", "партнер", "вода", "поезд", "капитан"};

        Set<String> sS = new TreeSet<>();
        Map<String, Integer> sM = new TreeMap<>();


        System.out.println("Добавить массив в СЭТ: "+addMsv(msv, sS));
        System.out.println("Обработка массива : "+checkData(msv, sS, sM));
        System.out.println("Массив уникальных слов : "+Arrays.toString(sS.toArray()));
        System.out.println("Подсчет количества слов: "+printData(sM));

    }

    private static boolean addMsv(String[] msv, Set<String> sS) {
        if (msv==null || !(msv.length >0) || sS.containsAll(Arrays.asList(msv))) return false;
        sS.addAll(Arrays.asList(msv));
        return true;
    }
    private static boolean checkData(String[] msv, Set<String> sS, Map<String, Integer> sM) {
        if (msv==null || !(msv.length>0)) return false;
        if (sS==null || sS.isEmpty()) return false;
        if (sM==null) return false;
        Iterator<String> iter = sS.iterator();
        while (iter.hasNext()) {
            String getString = iter.next();
            int values = 0;
            for (String str : msv) {
                if (str.equals(getString)) values++;
            }
            sM.put(getString, values);
        }
        return true;
    }

    private static boolean printData(Map<String, Integer> sM) {
        if (sM==null || sM.isEmpty()) return false;
        for (String str : sM.keySet()) {
            System.out.println("Слово \"" + str + "\" встречается " + sM.get(str) + " раз.");
        }
        return true;
    }
}
