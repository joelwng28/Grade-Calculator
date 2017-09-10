import java.util.*;

/*
 * Zi Zhou Wang
 * zw3948
 */

public class Program3 implements IProgram3 {

    private int numClasses;
    private int maxGrade;
    GradeFunction gf;

    public Program3() {
    	 this.numClasses = 0;
         this.maxGrade = 0;
         this.gf = null;
    }

    public void initialize(int n, int g, GradeFunction gf) {
    	 this.numClasses = n;
         this.maxGrade = g;
         this.gf = gf;
    }
    
    public int[] computeHours(int totalHours) {
    	int[] computeHours = new int[numClasses];
    	int[][] memory = new int[numClasses + 1][totalHours + 1];
    	int[][] hours = new int[numClasses + 1][totalHours + 1];
    	int n = numClasses;
    	for(int i=1; i <= numClasses; i++){
    		for(int j = 0; j <= totalHours; j++){
    			int temp;
    			for(int k=0; k<=j; k++){
    				temp = gf.grade(i-1, k) + memory[i-1][j - k];
    				if(temp>memory[i][j]){
    					memory[i][j]=temp;
    					hours[i][j] = k;
    				}
   				}
   			}
    	}
    	while(totalHours>=0 && n!= 0){
    		computeHours[n-1] = hours[n][totalHours];
    		totalHours = totalHours - hours[n][totalHours];
    		n--;
    	}
    	return computeHours;
    }

    public int[] computeGrades(int totalHours) {
    	int[] computeGrades = new int[numClasses];
  	  	int[][] memory = new int[numClasses+1][totalHours+1];
  	  	int[][] hours = new int[numClasses+1][totalHours+1];
  	  	int n = numClasses;
  	  	for(int i=1; i <= numClasses; i++){
  	  		for(int j = 0; j <= totalHours; j++){
  	  			int temp;
  	  			for(int k=0; k<=j; k++){
  	  				temp = gf.grade(i-1, k) + memory[i-1][j - k];
  	  				if(temp>memory[i][j]){
  	  				memory[i][j]=temp;
  	  				hours[i][j] = k;
  	  				}
  	  			}
  	  		}
  	  	}
  	  	while(totalHours>=0 && n!=0){
  	  		computeGrades[n-1] = gf.grade(n-1, hours[n][totalHours]);
  	  		totalHours = totalHours - hours[n][totalHours];
  	  		n--;
  	  	}
  	  	return computeGrades;
    }
}