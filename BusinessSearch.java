import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


class BusinessSearch {
	public static void main (String [] args){
		/*load file*/
		if(args.length != 2) throw new IllegalArgumentException("Must enter text file name");
		try{
			Scanner fileInput = new Scanner (new FileReader(args[0]));
		
		/*read through file*/
		int numOfBiz = fileInput.nextInt();
		ArrayList <BusinessRecord> Biz = new ArrayList<BusinessRecord>();
		
		/*load businesses into array Biz*/
		int x=0;
		while (x<numOfBiz){
			String line = fileInput.nextLine();
			String [] ar = line.split(",");

			//add record to the collection
			Biz.add(new BusinessRecord(ar[0], ar[1]));	
		}
		/*Sort!!!!*/
	
		/*Ask user for business name*/
		Scanner console = new Scanner (System.in);
		System.out.println("What business are you searching for?");
		while(console.hasNextLine()){
			String BizName = console.nextLine();
			if(BusinessSearch == true){
				/*print phone number of biz!!!!*/
			}
			else{
				System.out.println("NOT FOUND");
			}
			
		}
		/*Search through BusinessRecord array for nameUrBiz*/
		
		
	} 
	catch (FileNotFoundException e){
		System.out.println("FILE NOT FOUND");
	}
	catch (IOException e){
		System.out.println("CANNOT READ FROM FILE");
	}
		
}
}
