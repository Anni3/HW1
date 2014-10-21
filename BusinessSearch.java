import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;



class BusinessSearch {
	public static void main (String [] args) throws FileNotFoundException{
		/*load file*/
		if(args.length < 1) {
			System.out.println("Please use the following syntax: BusinessSearch businessDB where businessDB is the name of the data file");
			System.exit(0);
		}	

		Scanner fileInput = new Scanner (new FileReader(args[0]));
		
		
		/*read through file*/
		int numOfBiz = fileInput.nextInt(); 
		ArrayList <BusinessRecord> Biz = new ArrayList<BusinessRecord>();
		
		/*load businesses into array Biz*/
		int x=0;
		
		while (fileInput.hasNextLine()){
			String line = fileInput.nextLine();
			String [] ar = line.split(",");
			if (ar.length==2){
			//add record to the collection
				Biz.add(new BusinessRecord(ar[0], ar[1]));	
			}
		}
		//close file
		fileInput.close();
		
		/*MergeSort!!!!*/
		Biz=mergeSort(Biz);
	
		/*Ask user for business name*/
		Scanner console = new Scanner (System.in);
		System.out.println("What business are you searching for?");
		while(console.hasNextLine()){
		
			BusinessRecord brSearch = new BusinessRecord(console.nextLine(),null);
			int index = Collections.binarySearch(Biz, brSearch, new BizComp());
			if (index>=0) {
				System.out.println("Company Phone Number is: "+ Biz.get(index).BizNumber);
				System.out.println("Good bye!");
				System.exit(0);
			}
			else {
				System.out.println("Company not found. Good bye!"); 
				System.exit(0);
			}
	
		}
		
		} 
	/*	catch (FileNotFoundException e){
			System.out.println("FILE NOT FOUND");
		}
		catch (IOException e){
			System.out.println("CANNOT READ FROM FILE");
		}
		*/
	
	public static ArrayList< BusinessRecord > mergeSort(ArrayList< BusinessRecord > list)
	  {
	    ArrayList < BusinessRecord > sorted = new ArrayList< BusinessRecord >();
	    if (list.size() == 1)
	    {
	        sorted = list;
	    } else {
	        int mid1 = list.size() /2;

	        ArrayList< BusinessRecord > left = new ArrayList< BusinessRecord >();
	        ArrayList< BusinessRecord > right = new ArrayList< BusinessRecord >();

	        for ( int x = 0; x < mid1; x++) {
	            left.add(list.get(x));

	        }
	        for ( int x = mid1; x < list.size(); x++) {
	            right.add(list.get(x));
	        }

	        //System.out.println("Left Array: " + left);
	        //System.out.println("Right Array)" + right);

	        left=mergeSort(left);
	        right=mergeSort(right);
	        sorted=mergeArray(left,right);
	    }

	    return sorted;
	  }
	
	private static ArrayList< BusinessRecord > mergeArray(ArrayList< BusinessRecord> left, ArrayList< BusinessRecord > right)
	{
	    ArrayList< BusinessRecord > merged = new ArrayList< BusinessRecord >();

	    int i = 0;
	    int l = 0;
	    int r = 0;

	    while (l < left.size() && r < right.size())
	           {
	              if ((left.get(l)).BizName.compareTo(right.get(r).BizName) < 0)
	              {
	                 merged.add(left.get(l));
	                 l++;
	              }
	              else
	              {
	                 merged.add(right.get(r));
	                 r++;
	              }

	              i++;
	           }


	           while (l < left.size())
	           {
	              merged.add(left.get(l));
	              l++;
	              i++;
	           }

	           // Append rest of the values in the right half, if any...
	           while (r < right.size())
	           {
	              merged.add(right.get(r));
	              r++;
	                  i++;
	           }

	    return merged;


	  }

	}
class BizComp implements Comparator<BusinessRecord>{
	
	@Override
    public int compare(BusinessRecord r1, BusinessRecord r2) {
		int x = r1.BizName.compareTo(r2.BizName);
        return x;
    }

	
}


