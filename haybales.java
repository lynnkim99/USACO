/*
ID: lynnkim99
Lang: java
Task: haybales
*/

import java.io.*;
import java.util.*;

class haybales {

  	public static void main (String [] args) throws IOException {
	    // Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("haybales.in"));   // input file name goes above
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
	    // Use StringTokenizer vs. readLine/split -- lots faster
		//Integer.parseInt(st.nextToken());
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int Q = Integer.parseInt(st.nextToken());
	    
	    int [] hay = new int [N];
	    
	    st = new StringTokenizer(f.readLine());
	    for(int i=0; i<N; i++){
	    	hay[i]=Integer.parseInt(st.nextToken());
	    }
	    
	    Arrays.sort(hay, 0, N);
	    
	    
	    for(int i=0; i<Q; i++){
	    	int count = 0;
	    	st = new StringTokenizer(f.readLine());
	    	int A = Integer.parseInt(st.nextToken());
	    	int B = Integer.parseInt(st.nextToken());
	    	
	    	int Aindex = Arrays.binarySearch(hay, A);
	    	int Bindex = Arrays.binarySearch(hay, B);
	    	
	    	//out.println(Aindex+" "+Bindex);
	    	
	    	if(Aindex>=0 && Bindex>=0){
	    		out.println(Bindex-Aindex+1);
	    	}
	    	
	    	else if(Aindex>=0 && Bindex<0){
	    		Bindex*=-1;
	    		Bindex--;
	    		out.println(Bindex-Aindex);
	    	}
	    	
	    	else if(Aindex<0 && Bindex>=0){
	    		Aindex*=-1;
	    		Aindex--;
	    		out.println(Bindex-Aindex+1);
	    	}
	    	
	    	else if(Aindex<0 && Bindex<0){
	    		if(Aindex==Bindex){
	    			out.println(0);
	    		}
	    		else{
	    			Aindex*=-1;
	    			Bindex*=-1;
	    			out.println(Bindex-Aindex);
	    		}
	    	}
	    }
	    
		out.close();                                  // close the output file
	    System.exit(0);
	}
}