// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes  
// Any problem you faced while coding this :no

// Your code here along with comments explaining your approach
public class Main {
    public static void main(String[] args) {
        List<List<Double>> levels = new ArrayList<>();
		levels.add(Arrays.asList(10000.0, 0.4));
		levels.add(Arrays.asList(20000.0, 0.3));
		levels.add(Arrays.asList(30000.0, 0.2));
		levels.add(Arrays.asList(null, 0.1));
		double tax = calculateTax(levels, 25000);
		System.out.println(tax);
    }
    
    public static double calculateTax(List<List<Double>> levels, double salary){
	    if(levels == null || levels.size() == 0 ) return 0.0;
	    
	    double pendingSalary = salary, limit =0, taxable = 0, totalTax = 0;
	    int index = 0;
	    
	    while(pendingSalary > 0){
	        Double currLimit = levels.get(index).get(0);
	        double percentage = levels.get(index).get(1);
	        //null -> last tax level
	        if(currLimit == null){
	            totalTax += percentage * pendingSalary;
	            return totalTax;
	        }
	        //others
	        taxable = Math.min(pendingSalary, currLimit - limit);
	        totalTax += percentage * taxable;
	        pendingSalary -= taxable;
	        limit = currLimit;
	        index++;
	   
	    }
	    
	    return totalTax;
        
    }
}