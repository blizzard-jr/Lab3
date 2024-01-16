package Things;

import Things.Inanimate;
import Things.ThingStatus;

public class Boat extends Inanimate {
    public final int maxSize;
    private ThingStatus stat;
    public Boat(int maxS, double w, String c, String n){
        super(w, c, n);
        maxSize = maxS;

    }
    public ThingStatus getBoatStat(){
        return stat;
    }
    public void setBoatStat(ThingStatus stat){
        this.stat = stat;
    }


}
