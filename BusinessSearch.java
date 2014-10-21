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
			BusinessRecord tempBiz = new BusinessRecord();
			String line = fileInput.nextLine();
			String [] ar = line.split(",");
			tempBiz.BizName= ar[0];
			tempBiz.BizNumber=ar[1];
			
			//add record to the collection
			Biz.add(tempBiz);	
		}
		/*Sort*/
	} 
	catch (FileNotFoundException e){
		System.out.println("FILE NOT FOUND");
	}
	catch (IOException e){
		System.out.println("CANNOT READ FROM FILE");
	}
		
}
}
