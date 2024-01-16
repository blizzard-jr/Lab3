package Main;
import Things.*;
import mumiytroll.*;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.history_course();
    }


    public void history_course(){
        MumiyPapa papa = makeMumiyPapa();
        MumiyMama mama = makeMumiyMama();
        if(Math.abs(mama.getCoordinateX() - papa.getCoordinateX()) < 10 && Math.abs(mama.getCoordinateY() - papa.getCoordinateY()) < 10){
            System.out.println("Главные герои успешно созданы");
        }
        else{
            System.out.println("У нас патриархат, вы что, мама не может быть так далеко от отца, подумайте над этим и возвращайтесь");
            return;
        }
        ArrayList<Friend> friends = makeFriends(papa, mama);
        if(friends.isEmpty()){
            System.out.println("Упс, друзей не оказалось ни рядом с МумиПапой, ни рядом с МумиМамой, какое же путешествие без друзей(");
            return;
        }
        Boat boat = new Boat(5, 1000, "Жёлтый", "Лодка");
        Jar jar = new Jar(3.5, "Прозрачный", "Банка");

        papa.take_sip();
        if(!(story_check(papa))){
            return;
        }
        friends.get(0).initiatorOfFill(jar);
        friends.get(0).initiatorOfBreak(jar);
        mama.callEveryone(friends);
        mama.recited();
        friends.get(0).initiatorOfScream();
        papa.callEveryone(friends);
        second_part(boat);
        for (int i = 0; i < friends.size(); i++) {
            friends.get(i).goTravel();
        }
        mama.goTravel();
        papa.goTravel();
        MumiyMama m = new MumiyMama(1, 1, "Диана");
        MumiyMama m1 = new MumiyMama(1, 1, "Диана");
        System.out.println(m.equals(m1));
        Friend fr = new Friend(2, 2, "Bob");
        Friend fr1 = new Friend(2, 2, "Bob");
        System.out.println(fr.equals(fr1));
        Boat b = new Boat(1, 1, "Blue", "Лодка");
        Boat b1 = new Boat(15, 1, "Blue", "Лодка");



    }
    public MumiyPapa makeMumiyPapa(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вам выпала честь дать имя отцу семейства: ");
        String name = scanner.nextLine();
        System.out.println("Теперь определите его местоположение: ");
        System.out.println("Координата x: ");
        int x = scanner.nextInt();
        System.out.println("Координата y: ");
        int y = scanner.nextInt();
        return new MumiyPapa(x, y, name);
    }
    public MumiyMama makeMumiyMama(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Не менее почётная задача, дайте имя маме семейства: ");
        String name = scanner.nextLine();
        System.out.println("Теперь определите её местоположение: ");
        System.out.println("Координата x: ");
        int x = scanner.nextInt();
        System.out.println("Координата y: ");
        int y = scanner.nextInt();
        return new MumiyMama(x, y, name);
    }
    public boolean story_check(MumiyPapa papa){
        if(papa.getGeneralMood() == TrollsEmotion.SADNESS){
            System.out.println("Друзья расстроились и разьехались по домам, на этом история закончилась");
            return false;
        }
        else{
            System.out.println(papa.getName() +  " просиял от удовольствия");
            return true;
        }
    }
    public ArrayList<Friend> makeFriends(MumiyPapa papa, MumiyMama mama){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Теперь нужно создать в нашем абстрактном мирке друзей: Tap Enter please");
        ArrayList<Friend> friends = new ArrayList<>();
        while(scanner.nextLine() == ""){
            System.out.println("Введите имя: ");
            String name = scanner.nextLine();
            System.out.println("Теперь определимся с местоположением: ");
            System.out.println("Координата x: ");
            int x = scanner.nextInt();
            System.out.println("Координата y: ");
            int y = scanner.nextInt();
            friends.add(new Friend(x, y, name));
            System.out.println("\"Продолжить\" - Enter, \"Достаточно\" - Another");
            scanner.nextLine();

        }
        for (int i = 0; i < friends.size(); i++) {
            if((Math.abs(papa.getCoordinateX() - friends.get(i).getCoordinateX()) > 10 || Math.abs(papa.getCoordinateY() - friends.get(i).getCoordinateY()) > 10) && (Math.abs(mama.getCoordinateX() - friends.get(i).getCoordinateX()) > 10 || Math.abs(mama.getCoordinateY() - friends.get(i).getCoordinateY()) > 10)){
                friends.remove(i);
            }
        }
        System.out.println("Итак, в истории будут принимать участие " + friends.size() + " друзей");
        return friends;
    }

    public void second_part(Boat boat){
        System.out.println("Настало время погрузки\nВыберите вещь, которую собираетесь погузить: \n0 - Удочка, 1 - Плавки, 2 - Подушка, 3 - Одеяло, 4 - Зонтик, 5 - Корзина, 6 - Кастрюля, 7 - завершить погрузку");
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        ArrayList<Thing> things = new ArrayList<>();
        while(m != 7){
            if(boat.maxSize == things.size()){
                boat.setBoatStat(ThingStatus.UPLOADED);
                System.out.println("Лодка полностью загружена");
                break;
            }
            else{
                switch (m) {
                    case 0 -> things.add(new Rod(2, "Коричневый", "Удочка"));
                    case 1 -> things.add(new Trunks(0.12, "Белый", "Плавки"));
                    case 2 -> things.add(new Pillow(5, "Жёлтый", "Подушка"));
                    case 3 -> things.add(new Blanket(1.32, "Белый", "Одеяло"));
                    case 4 -> things.add(new Umbrella(1, "Чёрный", "Зонтик"));
                    case 5 -> things.add(new Basket(5, "Бежевый", "Корзина"));
                    case 6 -> things.add(new Pot(1, "Серебряный", "Кастрюля"));
                }
                System.out.println("Шмоточка успешно погружена\nВыберите вещь, которую собираетесь погузить: \n0 - Удочка, 1 - Плавки, 2 - Подушка, 3 - Одеяло, 4 - Зонтик, 5 - Корзина, 6 - Кастрюля, 7 - завершить погрузку");
                m = scanner.nextInt();
            }
        }
        System.out.println("Погрузка звершена");
        System.out.println("Итак, вы погрузили: ");
        for (int i = 0; i < things.size(); i++) {
            System.out.println(things.get(i).toString());
        }

    }
}
