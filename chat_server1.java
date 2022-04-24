import java.net.*;
import java.io.*;
 
  
public class chat_server1
{
   ServerSocket ss;

   chat_server1(int p) throws IOException
   {
   
      ss=new ServerSocket(p);
	  
	  while(true)
	  {
	       new ServerThread(ss.accept()).start();
	  }
         
        
          
   }
 
   public static void main(String[] st) throws IOException
   {
        chat_server1 cs=new chat_server1(Integer.parseInt(st[0]));
		
		
   }
   
}
 class ServerThread extends Thread
{

  Socket s;
  DataInputStream in;
  DataOutputStream out;
  
  public ServerThread(Socket s) throws IOException
  {
      this.s=s;
	  in=new DataInputStream(s.getInputStream());
	  out=new DataOutputStream(s.getOutputStream());
	  
	  
     
  }
  
  
    public void run()
	{
		  try
		  {
		  
	     while(true)
		 {
			    int c=(int)in.read();
			   System.out.println((char)c+": "+c);
			   char t=(char)c;
			    if(t=='q')
				{
					  break;
				}
			
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
			   
			 //  int c=(int)in.read();
			   //System.out.println((char)c+": "+c);
			   
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
  

}