import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;



import java.util.Collections;
public class test {

	
	
	
	public static void filewriter(String text) {
		 try(FileWriter writer = new FileWriter("output.txt", false))
	        {
	          
	            writer.write(text);
	            writer.append('\n'); 
	            writer.flush();
	        }
	        catch(IOException ex){
	             
	            System.out.println(ex.getMessage());
	        } 
	}
	
	
	public static void main(String[] args) {
		Polynome f=new Polynome();
		Polynome f1=new Polynome();
		Polynome f2=new Polynome();
		
		int k=1;
		
		String arr[]=fileparser();
		 try {
	            File file = new File("polynom.txt");
	            FileReader fr = new FileReader(file);
	            BufferedReader reader = new BufferedReader(fr);
	            String line ="";
	            while (line != null) {
	                line = reader.readLine();
	                if (line.compareTo("")!=0) {
	                						f.setPolinome(line);
	                						break;
	                }
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		 
		if(arr[2].compareTo("1")==0) {
			
			f1.setPolinome(arr[0]);
			f2.setPolinome(arr[1]);
			filewriter((new Polynome(f1.sum(f2))).divost(f));
			
		}
		if(arr[2].compareTo("2")==0) {

			f1.setPolinome(arr[0]);
			f2.setPolinome(arr[1]);
			filewriter((new Polynome(f1.mult(f2))).divost(f));
		}
		if(arr[2].compareTo("3")==0) {

			f1.setPolinome(arr[0]);
			f2.setPolinome(arr[1]);
			filewriter((new Polynome(f1.div(f2))).divost(f));
		}
			if(arr[2].compareTo("4")==0) {

			f1.setPolinome(arr[0]);
			k=Integer.parseInt(arr[1]);
			filewriter((new Polynome(f1.inc(k))).divost(f));
			}
			if(arr[2].compareTo("5")==0) {

			f1.setPolinome(arr[0]);
			filewriter(f1.inverse(f));
			}

	}
	public static String[] fileparser() {
		String arr[]=new String[3];
		String operation="-1";
		 try {
	            File file = new File("input.txt");
	           
	            FileReader fr = new FileReader(file);
	            
	            BufferedReader reader = new BufferedReader(fr);
	          
	            String line = "";
	            while (line != null) {
	                line = reader.readLine();
	             try{
	            	String pref=line.substring(0,line.indexOf('+'));
	            	String postf=line.substring(line.indexOf('+')+1,line.length());
	            	operation="1";
	            	arr[0]=pref;
	            	arr[1]=postf;
	            	arr[2]=operation;
	            	return arr;
	             }
	             catch(Exception e0) {
	            	 try{
	 	            	String pref=line.substring(0,line.indexOf('*'));
	 	            	String postf=line.substring(line.indexOf('*')+1,line.length());
	 	            	operation="2";
	 	            	arr[0]=pref;
		            	arr[1]=postf;
		            	arr[2]=operation;
		            	return arr;
	 	             }
	 	             catch(Exception e1) {
	 	            	 try{
	 		            	String pref=line.substring(0,line.indexOf('/'));
	 		            	String postf=line.substring(line.indexOf('/')+1,line.length());
	 		            	operation="3";
	 		            	arr[0]=pref;
	 		            	arr[1]=postf;
	 		            	arr[2]=operation;
	 		            	return arr;
	 		             }
	 		             catch(Exception e2) {
	 		            	 try{
	 		            		 if (line.charAt(1+line.indexOf('^'))=='-') {
	 		            			 throw new Exception();
	 		            		 }
	 			            	String pref=line.substring(0,line.indexOf('^'));
	 			            	String postf=line.substring(line.indexOf('^')+1,line.length());
	 			            	operation="4";
	 			            	arr[0]=pref;
	 			            	arr[1]=postf;
	 			            	arr[2]=operation;
	 			            	return arr;
	 			            	
	 			             }
	 			             catch(Exception e3) {
	 			            	try{
		 		            		 if (line.indexOf("-")==1+line.indexOf('^')) {
		 		            			
		 		            		 
		 			            	String pref=line.substring(0,line.indexOf('^'));
		 			            	String postf="";
		 			            	operation="5";
		 			            	arr[0]=pref;
		 			            	arr[1]=postf;
		 			            	arr[2]=operation;
		 			            	return arr;
		 		            		 }
		 			             }
	 			            	  catch(Exception e4) {
	 			            		  
	 			            	  }
	 			             }
	 		             }
	 	             }
	             }
	                
	                if (line==null) {
		                break;
		            }
	                
	                
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		return arr;
		
	}
}
