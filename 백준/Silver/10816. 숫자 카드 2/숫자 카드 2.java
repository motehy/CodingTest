import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main{
    public static List<Integer> nlist = new ArrayList<>();
    public static List<Integer> mlist = new ArrayList<>();
    
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            
            Integer N = Integer.parseInt(st.nextToken());
            
           
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                nlist.add(Integer.parseInt(st.nextToken()));
            }
            
            st = new StringTokenizer(br.readLine());
            Integer M = Integer.parseInt(st.nextToken());
           
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                mlist.add(Integer.parseInt(st.nextToken()));
            }
            
            nlist = nlist.stream()
                    .sorted()
    			    .collect(Collectors.toList());
    			    
    	   
    	    for(Integer value : mlist){
    	        sb.append(getUpperBound(value) - getLowerBound(value)).append(' ');
    	    }
    	    System.out.print(sb);
    		  
        } catch(Exception e) {
            e.printStackTrace();  // 정확한 에러 메시지, 라인 확인
        }
        
    }
    
    public static int getLowerBound(Integer value){
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
    
    public static int getUpperBound(Integer value){
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