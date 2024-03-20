public class Sah  extends Item{
    
    public Sah(String str, char initial, String oyuncu) {
        this.setPosition(str);
        this.initial= initial;
        this.oyuncu = oyuncu;
    }

    public void move(String destination) throws Exception {
        String pozisyon = this.getPosition();
        String oyuncusırası = this.getOyuncu();
        if(oyuncusırası.equals("red")) {
            if(destination.charAt(0)>'c' & (destination.charAt(1)<4 & destination.charAt(1)>6)) {
                throw new Exception("hatali hareket");
            }
            else{
                if( destination.charAt(0)== pozisyon.charAt(0) & (destination.charAt(1)== pozisyon.charAt(1)+1 || destination.charAt(1)== pozisyon.charAt(1)-1 )) {
                    this.setPosition(destination);
                }
                else if (((destination.charAt(0) == pozisyon.charAt(0)-1) || destination.charAt(0) ==  pozisyon.charAt(0)+1) & destination.charAt(1)== pozisyon.charAt(1) ) {
                    this.setPosition(destination);
                }
                
            }
        }

        if(oyuncusırası.equals("black")) {
            if(destination.charAt(0)<'h' & (destination.charAt(1)<4 & destination.charAt(1)>6)) {
                throw new Exception("hatali hareket");
            }
            else{
                if( destination.charAt(0)== pozisyon.charAt(0) & (destination.charAt(1)== pozisyon.charAt(1)+1 || destination.charAt(1)== pozisyon.charAt(1)-1 )) {
                    this.setPosition(destination);
                }
                else if (((destination.charAt(0) == pozisyon.charAt(0)-1) || destination.charAt(0) ==  pozisyon.charAt(0)+1) & destination.charAt(1)== pozisyon.charAt(1) ) {
                    this.setPosition(destination);
                }
            }
        }
    }
}

