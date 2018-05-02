import java.util.Arrays;

public class BlockChain {

	public static class Block{
		private String blockName;
		private int previousHash;
		private String[] transaction;
		private int blockHash;
		
		public Block(String blockName,int previousHash,String[] transaction) {
			this.blockName=blockName;
			this.previousHash=previousHash;
			this.transaction=transaction;
			Object[] contents= {Arrays.hashCode(transaction),previousHash};
			this.blockHash=Arrays.hashCode(contents);
		}
		public int getPreviousHash() {
			return previousHash;
		}
		public String[] getTransaction() {
			return transaction;
		}
		public int getBlockHash() {
			return blockHash;
		}
		public void printBlockHash() {
			System.out.println(blockName+" hash code is : "+blockHash);
		}
		
	}
	
	public static void main(String[] args) {
		String[] genesisTransaction= {"derek send me 9 bitcoin"};
		Block genesisBlock=new Block("genesisBlock",0,genesisTransaction);
		genesisBlock.printBlockHash();
		
		String[] secondTransaction= {"I send 20 bitcoins to sunny"};
		Block secondBlock=new Block("secondBlock",genesisBlock.getBlockHash(),secondTransaction);
		secondBlock.printBlockHash();
		
		String[] thirdTransaction= {"sunny send 40 bitcoins to derek"};
		Block thirdBlock=new Block("thirdBlock",secondBlock.getBlockHash(),thirdTransaction);
		thirdBlock.printBlockHash();
	}
}