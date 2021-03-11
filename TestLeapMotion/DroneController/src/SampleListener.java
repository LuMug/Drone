import com.leapmotion.leap.*;

public class SampleListener extends Listener {
    Thread tt;
    UDPSender udpS;

    SampleListener(){
      udpS = new UDPSender();
      tt = new Thread(udpS);
      tt.start();
    }

    public void onConnect(Controller controller) {
        System.out.println("Connected");
    }

    public void onFrame(Controller controller) {
        //System.out.println("Frame available");
        Frame frame = controller.frame();
        /*System.out.println("Frame id: " + frame.id()
                   + ", timestamp: " + frame.timestamp()
                   + ", hands: " + frame.hands().count()
                   + ", fingers: " + frame.fingers().count());*/

        HandList hl = new HandList();
        hl = frame.hands();

        FingerList fl = new FingerList();
        //fl = frame.fingers();

        System.out.println("----------------");
        for(int i = 0; i<hl.count();i++){
        	fl = hl.get(i).fingers();
        	String hand = hl.get(i).isLeft()?"LEFT":"RIGHT";
        	Finger fing = new Finger();
          	fing = fl.get(i);
          	//for sulle dita
          	System.out.println("Hand: " + hand +"|" + fing.type()+"|Tip: " + fing.tipPosition() + " |direction:" + fing.direction());
            udpS.write=hand;
        }


        
        /*for(int i = 0; i<fl.count();i++){
          Finger fing = new Finger();
          fing = fl.get(i);
          System.out.println(fing.type()+"|Tip: " + fing.tipPosition() + " |direction:" + fing.direction());
        }*/
        try{
          Thread.sleep(1000);  
        }catch(Exception e){
          
        }
        


    }
}