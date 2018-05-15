import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class ParametersExample {
	public  String name;
	public int age;
   public ParametersExample(String name,int age){
	   this.name=name;
	   this.age=age;
   }
   
   @Test
  public void test(){
	  System.out.println("name is "+name+" age is  "+age);
  }
   @Parameters
   public static Collection<Object[]> parameter(){
	   Object[][] ob=new Object[2][2];
	   ob[0][0]="tom";
	   ob[0][1]=30;
	   ob[1][0]="harry";
	   ob[1][1]=25;
	   /* al1 = new ArrayList<Object[]>();
	    * al1.add(ob[0]);
	    * al1.add(ob[1]);
	    */
	   return Arrays.asList(ob);
   }
}


/*int main () {
	Collection<Object[]> cl = ParametersExample.parameter();
	for (element in cl) {
		ParamatersExample pe = new ParametersExample(element[0],element[1]);
		pe.test();
	}
}
*/
