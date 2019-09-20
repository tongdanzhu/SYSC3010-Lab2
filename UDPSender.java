import java.net.*;
import java.util.Scanner;

public class UDPSender {
	
	private final static int PACKETSIZE = 100 ;
	public static void main(String[] args) 
   {
	      // Check the arguments
	      if( args.length != 3 )
	      {
	         System.out.println( "usage: java UDPSender host port" ) ;
	         return ;
	      }
	      DatagramSocket socket = null ;
	      try
	      {
	         // Convert the arguments first, to ensure that they are valid
	         InetAddress host = InetAddress.getByName( args[0] ) ;
	         int port         = Integer.parseInt( args[1] ) ;
	         int counter      = Integer.parseInt( args[2] ) ;
	         socket = new DatagramSocket() ;
     
	         Scanner in;
	         in = new Scanner (System.in);
	         String message = null;
	         while (true)
	         {
	        	for(int x = 1; x <= counter; x++)
	        	{
	        		message = "message" + x;
	        		byte [] data = message.getBytes() ;
	        		DatagramPacket packet = new DatagramPacket( data, data.length, host, port ) ;
	        		DatagramPacket rePacket = new DatagramPacket( new byte[PACKETSIZE], PACKETSIZE ) ;
	        		socket.send( packet ) ;
	        		while(true)
	        		{
						socket.receive( rePacket ) ;
						System.out.println( rePacket.getAddress() + " " + rePacket.getPort() + ": " + new String(rePacket.getData()).trim() ) ;
	       
						break;
					}
				}
				break;
	         } 
	         System.out.println ("Closing down");
	      }
	      catch( Exception e )
	      {
	         System.out.println( e ) ;
	      }
	      finally
	      {
	         if( socket != null )
	            socket.close() ;
      }
   }
}

