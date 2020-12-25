package dawidos506.ddrops.objects;

import java.util.UUID;

public class User {

    public UUID uuid;
    public String nick;
    public int mined;
    public boolean msg;
    public boolean cobble;
    public boolean inv;
    public int level;
    public int experience;

    public User(UUID uuid, String nick, int mined, boolean msg, boolean cobble, boolean inv, int level, int experience) {
        this.uuid = uuid;
        this.nick = nick;
        this.mined = mined;
        this.msg = msg;
        this.cobble = cobble;
        this.inv = inv;
        this.level = level;
        this.experience = experience;
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
    public int getLevel() {
        return level;
    }
    public int getExperience() {
        return experience;
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
    public void setLevel(int level) {
        this.level = level;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
}
