import java.util.ArrayList;

public class Assignment3 {
	
	ArrayList<Integer> sumArr = new ArrayList<Integer>();

    public int maxFruitCount (int[] sections) {
    	
    	
        int sum = 0;
        for(int i = 0; i < sections.length; i++) {
        	sum += sections[i];
        	sumArr.add(i, sum);
        	
        }
        int target = sum / 2;
        
        int i;
        for(i = 0; sumArr.get(i) < target; i++) {
        }
        
        int end1;
        if(i == 0) {
        	end1 = 0;
        } else {
        	if (sumArr.get(i) - (sum - sumArr.get(i)) > (sum - sumArr.get(i-1)) - sumArr.get(i-1)) {
            	end1 = i-1;
            } else {
            	end1 = i;
            }
        }
        int x = sumArr.get(end1) + recurseFunc(0, end1, sections[0]);
        int y = (sum - sumArr.get(end1)) + recurseFunc(end1 + 1, sections.length - 1, sections[end1 + 1]);
        
        
        if(x > y)
        	return y;
        else
        	return x;
    }
    
    public int recurseFunc(int startArr, int endArr, int startNum) {			// sumArr is a running tab of the sum until that index
    	if(endArr == startArr)
    		return 0;
    	int sum = sumArr.get(endArr) - sumArr.get(startArr) + startNum;		// startNum is the actual value in the sections array for the beginning
    	int target = sum / 2;
        
        int i;
        for(i = startArr; (sumArr.get(i) - sumArr.get(startArr) + startNum) < target ; i++) {
        }
        
        int end1;
        if(i == startArr) {
        	end1 = startArr;
        } else {
        	int first = sumArr.get(i) - sumArr.get(startArr) + startNum;
            int second = sumArr.get(i-1) - sumArr.get(startArr) + startNum;
            if (first - (sum - first) > (sum - second) - second) { 
            	end1 = i-1;
            } else {
            	end1 = i;
            }
        }
        
        int firstArrSum = sumArr.get(end1) - sumArr.get(startArr) + startNum;
        int x = firstArrSum + recurseFunc(startArr, end1, startNum);
        int y = sum - firstArrSum + recurseFunc(end1 + 1, endArr, sum - firstArrSum - (sumArr.get(endArr) - sumArr.get(end1 + 1)));		// last part is getting the beginning value of the sections array
        if(x > y)
        	return y;
        else 
        	return x;
    	
    }
}
