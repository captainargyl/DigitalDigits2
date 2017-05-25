import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DigitalDigits {
	
	public static void main(String[] args) throws IOException{
		FileReader inputStream = null;
        int interations = 0;
        String bignum = "";
        try {
            inputStream = new FileReader("digital.txt");
            
            int c;
            while ((c = inputStream.read()) != -1) {
            	interations++;
            	System.out.println("read: " + interations + " " + c);
                bignum += (c-48);
            }}
            catch(Exception e){
            	System.out.println("ERROR: " + e);
            }
         finally {
            if (inputStream != null) {
                inputStream.close();
            }
            
        }
        

       
		
		List<String> results = new LinkedList<String>();
		List<String> results2 = new LinkedList<String>();
		    int count = 0;
		    System.out.println("about");
		    System.out.println((1<<(bignum.length()))-1);
		    for ( long i = 1; i <= 4294967294L; i++ ) {

		      String builder = "";
		      for ( int j = 0; j < bignum.length(); j++ ) {

		        if ( (i & (1<<j)) != 0) {

		          builder = (bignum.substring(j,j+1));
		        }
		      }
		      if (i<=2147483647){
		    	  results.add(builder);
		      }
		      else{
		    	  results2.add(builder);
		      }
		    }
		    
		    
		    //System.out.println(results);
		BigInteger five = new BigInteger("5");
			for(int i = 0; i < results.size(); i++){
		BigInteger nums = new BigInteger(results.get(i));
		//System.out.println("droot test: " + droot(nums));
			if (droot(nums).equals(five)){
				System.out.println("nums: " + nums);
				count++;
			}
			}
			for(int i = 0; i < results2.size(); i++){
				BigInteger nums = new BigInteger(results2.get(i));
				//System.out.println("droot test: " + droot(nums));
					if (droot(nums).equals(five)){
						System.out.println("nums: " + nums);
						count++;
					}
					}
			System.out.println(count);
	
	}
	
	// public static int combo(String args) {
		    
		 // }
	 
	 public static BigInteger droot(BigInteger n){
		 BigInteger x = new BigInteger("10");
		 if(n.compareTo(x) < 0){
			 return n;
		 }
		 else{
			 return droot(dsum(n));
			 
		 }
	 }
	 
	 public static BigInteger dsum(BigInteger n){
		BigInteger sum = new BigInteger("0");
		BigInteger x = new BigInteger("0");
		BigInteger ten = new BigInteger("10");
		
		 while (n.compareTo(x) > 0) {
	            sum = sum.add(n.mod(ten)) ;
	            n = n.divide(ten) ;
	        }
		
		 return sum;
	 }
}
