package lesson4.homework;

import lesson4.homework.expert.GeneratorExpertHomework;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Homework {
    public static void main(String[] args) {

        //Базовый
        //Задача №1
        //Дано (их менять нельзя)
        System.out.println("\nБазовый 1");

        String hi = "                Hello ";
        String world = " WoRld!";
        char newLine = '\n';
        //Создать из трех переменных единую строку,
        //Привести к правильному виду (Ниже), убрать лишние пробелы,
        //затроить (Можно вызвать тольку одну команду System.out.print())
        //
        //Результат вывода на экран:
        //Hello world!
        //Hello world!
        //Hello world!
        StringBuilder hw1 = new StringBuilder();

        hw1.append(hi.trim())
           .append(world.toLowerCase())
           .append(newLine);

        System.out.println(hw1.toString().repeat(3));


        // Задание №2 - Написать цикл, который выводит через пробел 100 чисел с приставкой "a".
        // Ожидаемый результат: 1а 2а 3а .. 100а
        System.out.println("\nБазовый 2");

        StringBuilder hw2 = new StringBuilder();
        for(int i=1;i<=100;i++){
            hw2.append(i).append("a ");
        }

        System.out.println(hw2);

        // Задание №3
        // Создать два класса, которые описывают виды животных (имеют два атрибута).
        // Написать к ним конструктор, сеттеры, геттеры.
        // Например: класс Кот, класс Собака
        System.out.println("\nБазовый 3");

        Dog dog = new Dog(2,"Шарик");
        Cat cat = new Cat(5,"Барсик");

        System.out.println(dog.toString());
        System.out.println(cat);

        //Продвинутый
        // Задание №1: Написать цикл, который будет прибавлять число к result до тех пор,
        // пока не получиться больше 1_000_000.
        System.out.println("\nПродвинутый 1");
        // Дано:
        double increment = 0.01123;
        double result = 0;
        // Вывести на экран, количество итераций, которое потребовалось, чтобы дойти до миллиона.
        // Если число отрицательное, то сразу заканчиваем цикл, ничего не выводя.
        // Внимание: число может измениться, и не должно приводить к изменению вашего кода.
        double finalSum = 1_000_000;
        int counter=0;
        while (result<finalSum){
            result += increment;
            if(result<0) break;
            counter++;
        }
        System.out.println("Количество операций: "+counter);

        // Задание №2: Дан массив единиц, произвольной длины. Создать цикл, который заменяет каждый
        // нечетный элемент на 0;
        // Например, дано: [1,1,1,1,1]
        // Ожидаемый результат: [0,1,0,1,0]
        // Подсказка: прочитай про операнд "%".
        System.out.println("\nПродвинутый 2");

        int[] numbers = {1,1,1,1,1,1,1,1,1,1};
        for (int i = 0; i < numbers.length; i++) {
            if(i%2==0)
                numbers[i] = 0;
        }
        System.out.println(Arrays.toString(numbers));

        //Задача №3
        //Создать два массив чисел:
        // 1,2,5,7,10
        // 2,3,2,17,15
        // Создать массив чисел, в котором будут: все числа из этих двух массивов,
        // и результат умножения чисел с одинаковым порядковым номером
        //
        //Ожидаемый результат:
        //1,2,5,7,10,2,3,2,17,15,2,6,10,119,150
        //(первый массив - 1,2,5,7,10), (второй массив - 2,3,2,17,15),
        //(результат перемножения - (1*2), (2*3), (5*2), (7*17), (10*15)
        System.out.println("\nПродвинутый 3");

        int array1[] = {1,2,5,7,10};
        int array2[] = {2,3,2,17,15};

        if(array1.length==array2.length){
            int[] bigArray = new int[array1.length*3];
            for(int i=0;i<array1.length;i++){
                bigArray[i] = array1[i];
                bigArray[i+array1.length] = array2[i];
                bigArray[i+array1.length*2] = array1[i]*array2[i];
            }
            System.out.println(Arrays.toString(bigArray));
        }


        //Задача №4
        //В слове "Hello world!" заменить l на r, сделать все буквы заглавными, выбрать первые 8 символов
        System.out.println("\nПродвинутый 4");

        String helloWorld = "Hello world!";
        System.out.println(helloWorld.replace('l','r'));
        System.out.println(helloWorld.toUpperCase());
        System.out.println(helloWorld.substring(0,8));


        // Экспертный уровень:
        // Предыстория: Мы находимся в статистическом институте. Хочется понять уровень миграции между регионами за месяц.
        // Для этого было решено произвести анализ передвижения автомобилей: на границе каждого региона стоят камеры,
        // фиксирующие въезд и выезд автомобилей. Формат автомобильного номера: (буква)(3 цифры)(2 буквы)(2-3 цифры)
        // К474СЕ178 - где 178 регион

        // Задача №1: узнать сколько всего машин со спец номерами(вывести на экран): начинаются на M
        // и заканчиваются на АВ (русские буквы).
        // Не повторяющиеся
        //Для генерации данных воспользоваться GeneratorExpertHomework.getData()

        //Входящие данные
        // Map<Integer, Map<String, String[]>> - где ключ первого уровня - номер региона,
        // out, input - ключи второго уровня (выезд, въезд), и String[] - массивы номеров.
        // { 1 : {
        //      "out" : ["К474СЕ178"],
        //      "input": ["А222РТ178"]
        //    },
        //   2 : {
        //        "out" : ["К722АВ12", "А222РТ178"],
        //        "input" : ["М001АВ01", "А023РВ73"],
        //   }
        // ..
        //  }

        //Список технологий:
        // Set (HashSet) - узнать что это, set.contains(), set.put()
        // Map (HashMap) - узнать что это, map.get(), map.put(), map.entrySet() - для итерации, entry.getValue(), entry.getKey()
        // <Integer> - обозначает тип который хранится в этой структуре данных (Generics)
        // Регулярные выражения - вытащить регион авто
        System.out.println("\nЭкспертный");

        Map<Integer, Map<String, String[]>> gosNumbers = new HashMap<>();
        gosNumbers = GeneratorExpertHomework.getData();

        Set<String> foundNumbers = new HashSet<>();
        int specialsCount = 0;
        Pattern p = Pattern.compile("М\\d{3}АВ\\d{2,3}");
        for (Map.Entry<Integer, Map<String, String[]>> entry : gosNumbers.entrySet()) {
            Integer region = entry.getKey();
            Map<String, String[]> value = entry.getValue();
            //System.out.println(region);
            for(Map.Entry<String, String[]> subEntry: value.entrySet()){
                String movement = subEntry.getKey();
                String[] subValues = subEntry.getValue();

                for(String gn: subValues){
                    Matcher m = p.matcher(gn);
                    if(m.matches()){
                        if(!foundNumbers.contains(gn)){
                            specialsCount++;
                            foundNumbers.add(gn);
                        }
                        System.out.println( new StringBuilder()
                                                .append(gn).append(" ")
                                .append(movement.equalsIgnoreCase("out") ? "покинул " : "прибыл в ")
                                .append("регион ")
                                .append(region)
                        );
                    }
                }
            }
        }
        System.out.println("Список спецномеров: ");
        System.out.println(foundNumbers.toString());

    }
}
