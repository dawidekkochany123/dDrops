package dawidos506.ddrops.objects;

import java.util.UUID;

public class User {

    public UUID uuid;
    public String nick;
    public int mined;
    public boolean msg;
    public boolean cobble;
    public boolean inv;

    public User(UUID uuid, String nick, int mined, boolean msg, boolean cobble, boolean inv) {
        this.uuid = uuid;
        this.nick = nick;
        this.mined = mined;
        this.msg = msg;
        this.cobble = cobble;
        this.inv = inv;
    }

    public UUID getUuid() {
        return uuid;
    }
    public String getNick() {
        return nick;
    }
    public int getMined() {
        return mined;
    }
    public boolean isMsg() {
        return msg;
    }
    public boolean isCobble() {
        return cobble;
    }
    public boolean isInv() {
        return inv;
    }

    public void setMined(int mined) {
        this.mined = mined;
    }
    public void setMsg(boolean msg) {
        this.msg = msg;
    }
    public void setCobble(boolean cobble) {
        this.cobble = cobble;
    }
    public void setInv(boolean inv) {
        this.inv = inv;
    }
}
