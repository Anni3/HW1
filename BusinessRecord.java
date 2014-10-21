
public class BusinessRecord {
	/*create object type Business*/

		public BusinessRecord(String bName, String bNumber) {
		// TODO Auto-generated constructor stub
			BizName= bName;
			BizNumber=bNumber;
	}
		String BizName;
		String BizNumber;
		public String getName() {
			// TODO Auto-generated method stub
			return BizName;
		}
		public int compareTo(BusinessRecord businessRecord) {
			// TODO Auto-generated method stub
			return 0;
		}
}
