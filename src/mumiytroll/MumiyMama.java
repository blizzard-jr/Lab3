package mumiytroll;

import java.util.ArrayList;

public class MumiyMama extends Trolls implements Main_characters {

    TrollsEmotion emotion;

    public MumiyMama(int x, int y, String name){
        super(x, y, name);
    }

    public void recited() {
        this.emotion = TrollsEmotion.PRIDE;
        System.out.println(this.getName() + " городо продекламировала \"Сим крещу тебя на вечные времена, и имя тебе \"Приключение\" (такова формула крещения у всех муми-троллей)");

    }
    @Override
    public void goTravel(){
        System.out.println(this.getName() + " отправилась в путешествие");
    }
    @Override
    public void setGeneralMood(TrollsEmotion stat){
        Friend.generalEmotion = stat;
    }
    @Override
    public TrollsEmotion getGeneralMood(){
        return Friend.generalEmotion;
    }
    @Override
    public void callEveryone(ArrayList<Friend> fr){
        for (int i = 0; i < fr.size(); i++) {
            fr.get(i).setCoordinateX(this.getCoordinateX());
            fr.get(i).setCoordinateY(this.getCoordinateY());
        }
        System.out.println(this.getName() + " подозвала всех");

    }
}
