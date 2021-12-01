import java.util.Vector;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
public class Polynome {
	private  String Pol;

	public String takePolynom() {
		return this.Pol;
	}
	public void setPolinome(String vec){
		this.Pol=vec;
		
	}
	
	public Polynome add(Polynome p) {
		Polynome r=new Polynome();
		// проверка на корректность  Дописать!!!
		String result=p.takePolynom();
		for (int i=this.Pol.length()-1;i<result.length();i++) {
			this.Pol=this.Pol+"0";				
		}
		for (int i=result.length();i<this.Pol.length();i++) {
			result=result+"0";
		}
		for(int i=0;i<result.length();i++) {
			
			result=result.substring(0, i)+(Integer.toString((Integer.parseInt(result.substring(i, i+1))+Integer.parseInt(this.Pol.substring(i, i+1)) )%2)).charAt(0)+result.substring(i+1, result.length());	
		}
		 r.setPolinome(result);
		 r.simplify();
		return r;
	}
	
	public void Print(int []a, int n) 
	{
	  int num = 1;
	  for (int i = 0; i < n; i++)
	   System.out.print(a[i]);
	  System.out.println("");
	}
	public String div(Polynome p) {
		Polynome smaler=new Polynome();
		smaler.setPolinome(p.takePolynom());
		Polynome bigger=new Polynome();
		bigger.setPolinome(this.Pol);
		Polynome devision=new Polynome();
		smaler.simplify();
		bigger.simplify();
		Polynome result=new Polynome();
		Polynome ost=new Polynome();
		for(int i=0;i<bigger.takePolynom().length();i++) {
			result.setPolinome("0"+result.takePolynom());
		}
		while(bigger.takePolynom().length()>=smaler.takePolynom().length()) {
			
		
			devision.setPolinome(smaler.takePolynom());
			int index=0;
			for(int i=0;devision.takePolynom().length()<bigger.takePolynom().length();i++) {
				devision.setPolinome("0"+devision.takePolynom());
				index=i;
			}
		
			if(index==0 && devision.takePolynom().compareTo(bigger.takePolynom())==0) {
				index=-1;
				result.setPolinome(result.takePolynom().substring(0,index+1)+"1"+result.takePolynom().substring(index+2,result.takePolynom().length()));
				break;
			}
			
			result.setPolinome(result.takePolynom().substring(0,index+1)+"1"+result.takePolynom().substring(index+2,result.takePolynom().length()));
			bigger=devision.add(bigger);
		}
		ost.setPolinome(bigger.takePolynom());
		result.simplify();
		ost.simplify();
		return result.takePolynom();
    }
	public boolean NextSet(int []a, int n, int m)
	{
	  int j = m - 1;
	  while (j >= 0 && a[j] == n) j--;
	  if (j < 0) return false;
	  if (a[j] >= n)
	    j--;
	  a[j]++;
	  if (j == m - 1) return true;
	  for (int k = j + 1; k < m; k++)
	    a[k] = 1;
	  return true;
	}
	public String[] createCombinations(int []arr) {
		int []a=arr;
		String[] copbinations=new String[1000000];
		for (int i = 0; i < a.length; i++)
		    a[i] = 1;
		 String ss="";
		  for (int t=0;t<a.length;t++) {
			  if(a[t]==2) {
				 ss+="0";
			  }
			  else {
			  ss+=Integer.toString(a[t]);
			  }
		  }
		  copbinations[0]=ss;

		int tt=1;
		  while (NextSet(a, 2, a.length)) {
			  String s="";
			  for (int t=0;t<a.length;t++) {
				  if(a[t]==2) {
						 s+="0";
					  }
					  else {
					  s+=Integer.toString(a[t]);
					  }
			  }
			  copbinations[tt]=s;
			  tt++;
		  }
		  
		return copbinations;
	}
	
	public String sum(Polynome p) {
		Polynome r=new Polynome();
		String result=p.takePolynom();
		for (int i=this.Pol.length()-1;i<result.length();i++) {
			this.Pol=this.Pol+"0";				
		}
		for (int i=result.length();i<this.Pol.length();i++) {
			result=result+"0";
		}
		for(int i=0;i<result.length();i++) {
			
			result=result.substring(0, i)+(Integer.toString((Integer.parseInt(result.substring(i, i+1))+Integer.parseInt(this.Pol.substring(i, i+1)) )%2)).charAt(0)+result.substring(i+1, result.length());	
		}
		 r.setPolinome(result);
		 r.simplify();
		return r.takePolynom();
	}
	public void simplify() {
		int i=this.Pol.length()-1;
		while(Pol.charAt(i)=='0' &&  Pol.length()>1) {
			Pol=Pol.substring(0, Pol.length()-1);
			i--;
		}
	}
	public String mult(Polynome p) {
		ArrayList<String> polynomes = new ArrayList<String>();
	
		for(int i=0;i<Pol.length();i++) {
			if (Pol.charAt(i)!='0') {
				String s=p.takePolynom();
				for(int j=0;j<i;j++) {
					s="0"+s;
				}
			polynomes.add(s);
			}
		}
		String sum="0";
		for(int i=0;i<polynomes.size();i++){
			sum=add(sum,polynomes.get(i));
		}
		return sum;
	}
	public String mult(String p,String pol) {
		ArrayList<String> polynomes = new ArrayList<String>();
	
		for(int i=0;i<pol.length();i++) {
			if (pol.charAt(i)!='0') {
				String s=p;
				for(int j=0;j<i;j++) {
					s="0"+s;
				}
			polynomes.add(s);
			}
		}
		String sum="0";
		for(int i=0;i<polynomes.size();i++){
			sum=add(sum,polynomes.get(i));
		}
		return sum;
	}
	public String inc(int k) {
		Polynome f=new Polynome();
		f.setPolinome(this.Pol);
		for(int i=0;i<k-1;i++) {
			f.setPolinome(f.mult(this));
		}
		f.simplify();
		return f.takePolynom();
	}
	
	public String add(String s,String c) {
		String result=s;
		for (int i=c.length()-1;i<result.length();i++) {
			c=c+"0";				
		}
		for (int i=result.length();i<c.length();i++) {
			result=result+"0";
		}
		
		for(int i=0;i<result.length();i++) {
			
			result=result.substring(0, i)+(Integer.toString((Integer.parseInt(result.substring(i, i+1))+Integer.parseInt(c.substring(i, i+1)) )%2)).charAt(0)+result.substring(i+1, result.length());	
		}
		
		return result;
	}
	
	
	public String divost(Polynome p) {
		Polynome smaler=new Polynome();
		smaler.setPolinome(p.takePolynom());
		Polynome bigger=new Polynome();
		bigger.setPolinome(this.Pol);
		Polynome devision=new Polynome();
		smaler.simplify();
		bigger.simplify();
		Polynome result=new Polynome();
		Polynome ost=new Polynome();
		for(int i=0;i<bigger.takePolynom().length();i++) {
			result.setPolinome("0"+result.takePolynom());
		}
		while(bigger.takePolynom().length()>=smaler.takePolynom().length()) {
			
		
			devision.setPolinome(smaler.takePolynom());
			int index=0;
			for(int i=0;devision.takePolynom().length()<bigger.takePolynom().length();i++) {
				devision.setPolinome("0"+devision.takePolynom());
				index=i;
			}
			if(index==0 && devision.takePolynom().compareTo(bigger.takePolynom())==0) {
				index=-1;
				result.setPolinome(result.takePolynom().substring(0,index+1)+"1"+result.takePolynom().substring(index+2,result.takePolynom().length()));
				break;
			}
			
			result.setPolinome(result.takePolynom().substring(0,index+1)+"1"+result.takePolynom().substring(index+2,result.takePolynom().length()));
			bigger=devision.add(bigger);
		}
		ost.setPolinome(bigger.takePolynom());
		result.simplify();
		ost.simplify();
		return ost.takePolynom();
    }
	public String inverse(Polynome g) {
		Polynome inv=new Polynome();
		int []a=new int[g.takePolynom().length()-1];
		for(int i=0;i<a.length;i++) {
			a[i]=Integer.parseInt(g.takePolynom().substring(i,i+1));
		}
		String []combin=createCombinations(a);
		int index=0;
		while(  combin[index].compareTo("")!=0) {
			Polynome newP=new Polynome(); 
				newP.setPolinome(mult(combin[index],this.takePolynom()));
				newP.simplify();
				
			if ( newP.divost(g).compareTo("1")==0 ) {
				return combin[index];
			}
			index++;
		}
		return null;
	}
	public Polynome() {
		Pol="0";
	}
	public Polynome(String p) {
		Pol=p;
	}
	
}

