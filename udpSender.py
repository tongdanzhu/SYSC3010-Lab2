# Source: https://pymotw.com/2/socket/udp.html

import socket, sys, time

host = sys.argv[1]
textport = sys.argv[2]
num = sys.argv[3]

s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
port = int(textport)
server_address = (host, port)
n = int(num)
i = 0


    
while i < n:
    
    print ("Enter data to transmit: ENTER to quit")
    data = "mam"+str(i+1)
    print(data)
    s.sendto(data.encode('utf-8'), server_address)
    i = i + 1
    while 1:
        buf, address = s.recvfrom(port)
        print ("Received %s bytes from %s %s: " % (len(buf), address, buf ))
        break
        
    
            
            
#    s.sendall(data.encode('utf-8'))
#s.shutdown(1)



