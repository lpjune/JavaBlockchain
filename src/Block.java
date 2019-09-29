import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    public int ID;
    public long timestamp;

    // constructor
    public Block(int ID, String previousHash) {
        this.ID = ID;
        this.previousHash = previousHash;
        this.timestamp = new Date().getTime();
        this.hash = makeHash();
    }

    // make hash
    public String makeHash() {
        String hash = StringUtil.applySha256(previousHash + Long.toString(timestamp) + ID);
        return hash;
    }
}
