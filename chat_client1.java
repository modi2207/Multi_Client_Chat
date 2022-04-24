import java.net.*;
import java.io.*;
 
  
public class chat_client1
{

  Socket s;
  DataInputStream in;
  DataOutputStream out;
  
  public chat_client1(String host,int port)
  {
    try{
		  
      s=new Socket(host,port);
	  }
	  catch(Exception e)
	  {
		    System.out.println("hello");
	  }
  }
  
  
    public void comm()
	{
		  try
		  {
	     in=new DataInputStream(s.getInputStream());
		 out=new DataOutputStream(s.getOutputStream());
		 
		 while(true)
		 {
		       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			   int i=(int)br.read();
			   
			    if((char)i=='q')
				{
				   out.write(i);
				   break;
				   
				}
				else
				{
				   out.write(i);
				}
			   
			   int c=(int)in.read();
			   System.out.println((char)c+": "+c);
			   
			   if((char)c=='q'){
				   
				    break;
			   }
			   
		 }
		 
		 in.close();
		 out.close();
		 s.close();
		 
		  }
		  catch(Exception e)
		  {
			    System.out.print("hello w");
		  }
		 
	}
  
 public static void main(String[] st)
{
    
	  chat_client1 cc=new chat_client1(st[0],Integer.parseInt(st[1]));
	
      cc.comm();	
	  
} 
}