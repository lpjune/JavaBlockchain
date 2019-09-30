import com.google.gson.GsonBuilder;

import java.util.ArrayList;


public class Blockchain {

    private static ArrayList<Block> chain = new ArrayList<Block>();
    public static int difficulty = 5;

    private static ArrayList<Block> getChain() {
        return chain;
    }

    private static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');

        //loop through blockchain to check hashes:
        for(int i=1; i < chain.size(); i++) {
            currentBlock = chain.get(i);
            previousBlock = chain.get(i-1);
            //compare registered hash and calculated hash:
            if(!currentBlock.hash.equals(currentBlock.getHash()) ){
                System.out.println("Current Hashes not equal");
                return false;
            }
            //compare previous hash and registered previous hash
            if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
            if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
                System.out.println("This block hasn't been mined");
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        chain.add(new Block(0, "0"));
        System.out.println("Trying to Mine block 0... ");
        chain.get(0).mineBlock(difficulty);

        chain.add(new Block(1, chain.get(chain.size()-1).hash));
        System.out.println("Trying to Mine block 1... ");
        chain.get(1).mineBlock(difficulty);

        chain.add(new Block(2, chain.get(chain.size()-1).hash));
        System.out.println("Trying to Mine block 2... ");
        chain.get(2).mineBlock(difficulty);

        chain.add(new Block(3, chain.get(chain.size()-1).hash));
        System.out.println("Trying to Mine block 3... ");
        chain.get(3).mineBlock(difficulty);

        chain.add(new Block(4, chain.get(chain.size()-1).hash));
        System.out.println("Trying to Mine block 4... ");
        chain.get(4).mineBlock(difficulty);


        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(chain);
        System.out.println(blockchainJson);
        isChainValid();
    }
}
