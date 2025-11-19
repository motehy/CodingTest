import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
public class Main
{
	public static void main(String[] args) {
		try {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    
		    String input = st.nextToken();

            int startNum = 'a' - 0;
		    int endNum = 'z' - 0;
		
		    int size = endNum - startNum;
		    int[] numbers = new int[size+1];
		
		    for(int i=0; i< input.length(); i++){
		        int idx = input.charAt(i) - 0;
		        numbers[idx- startNum]++;
		    }
		
	    	for(int sum : numbers){
		        System.out.print(sum+" ");
		    }
		    
		} catch(Exception e) {
		    System.out.println(e.getMessage());
		}
	}
}