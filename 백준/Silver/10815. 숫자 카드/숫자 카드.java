/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
public class Main
{
    public static List<Integer> nlist = new ArrayList<>();
    
	public static void main(String[] args) {
	    try{
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st = new StringTokenizer(br.readLine());    //입력
    		StringBuilder sb = new StringBuilder();
    		
    		Integer N = Integer.parseInt(st.nextToken());
    		
    		st = new StringTokenizer(br.readLine());    //입력
    		
    		//첫번 째 입력 줄 
    		for(int i=0; i<N; i++){
    		    nlist.add(Integer.parseInt(st.nextToken()));
    		}
    		
    		 st = new StringTokenizer(br.readLine());    //입력
    		Integer M = Integer.parseInt(st.nextToken());
    		
    		st = new StringTokenizer(br.readLine());    //입력
    		
    		nlist = nlist.stream().sorted().collect(Collectors.toList());
    		
    		//두번 째 입력 줄 
    		for(int i=0; i<M; i++){
    		    Integer keyValue = Integer.parseInt(st.nextToken());
    		    sb.append(getUppderBound(keyValue) - getLowerBound(keyValue)).append(' ');
    		}
    		System.out.print(sb);
	    } catch (Exception ex){
	        
	        System.out.println("error");
	    }
		
	}
	
	static int getLowerBound(int value) {
	    int low = 0;
	    int high = nlist.size();
	    
	    while(low < high){
	        int mid = (low + high) / 2;
	        if(nlist.get(mid) >= value){
	            high = mid;
	        }else {
	            low = mid + 1;
	        }
	    }
	    return low;
	}
	
	static int getUppderBound(int value) {
	    int low = 0;
	    int high = nlist.size();
	    
	    while(low < high){
	        int mid = (low + high) / 2;
	        if(nlist.get(mid) > value){
	            high = mid;
	        }else {
	            low = mid + 1;
	        }
	    }
	    return high;
	}
}