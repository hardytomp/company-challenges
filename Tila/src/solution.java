import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class solution {
    
	class Coordinates {
		public int x;
		public int y;
		public Coordinates(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        solution test = new solution();
        int result[][] = new int[50][50];
        for (int n = 0; n < t; n++) {
			int N = sc.nextInt();
			List coordinates = new ArrayList<>();            
			for(int i=0; i<N; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				coordinates.add(test. new Coordinates(x,y));
			//	System.out.println("x > y "+x+" "+y );
				
				//modify distance array
				for(int k=0;k<50;k++) {
				    for(int j=0;j<50;j++) {
			            result[k][j] = result[k][j] + test.calcDistance(x,y,k,j);	        
				    }
				}
				
			}
		//	test.printOpArray(result);
			List<Integer> resultList = test.findResult(result);
			System.out.println(resultList.get(0)+" "+resultList.size());
			result = new int[50][50];
        }

    }
    
    
    public void printOpArray(int op[][]) {
		for(int i=0;i<50;i++) {
		    for(int j=0;j<50;j++) {
	            System.out.print(op[i][j]+" ");      
		    }
		    System.out.println("\n");
		}
    }
    
    public List<Integer> findResult(int op[][]) {
    	List<Integer> res = new ArrayList<>();
    	int currLeastDistance = op[0][0];
		for(int i=0;i<50;i++) {
		    for(int j=0;j<50;j++) {
	            if(currLeastDistance == op[i][j]) {
	            	res.add(op[i][j]);
	            } else if( op[i][j] < currLeastDistance) {
	            	currLeastDistance = op[i][j];
	            	res = new ArrayList<>();
	            	res.add(op[i][j]);
	            }
		    } 
		}
    	return res;
    }
    
    public int calcDistance(int orgX,int orgY,int destX,int destY) {
        int xdistance = orgX>destX? (orgX - destX) : (destX - orgX);
        int ydistance = orgY>destY? (orgY - destY) : (destY - orgY);
        return xdistance+ydistance;
    }
    
}