public class Piyon extends Item {

    public Piyon(String str, char initial, String oyuncu) {
        this.setPosition(str);
        this.point = 1.0;
        this.initial= initial;
        this.oyuncu = oyuncu;
    }
    
    @Override
	public void move(String destination) throws Exception {
		String pozisyon = this.getPosition();
        String oyuncusırası = this.getOyuncu();
        if(oyuncusırası.equals("red")) { 
            if( pozisyon.charAt(0) >= 'a'& pozisyon.charAt(0) <'f') {
                if((int)destination.charAt(0) == ((int)pozisyon.charAt(0) + 1) & destination.charAt(1)== pozisyon.charAt(1)) {
                    this.setPosition(destination);
                }
                else {
                    throw new Exception("hatali hareket");
                }
            } 
            else if(pozisyon.charAt(0)>='f' & pozisyon.charAt(0) <= 'j') {
                if((int)destination.charAt(0) == ((int)pozisyon.charAt(0) + 1) & destination.charAt(1)== pozisyon.charAt(1)) {
                    this.setPosition(destination);
                }
                else if((int)destination.charAt(0) == (int)pozisyon.charAt(0) & (destination.charAt(1)== (pozisyon.charAt(1)+1) || destination.charAt(1)== (pozisyon.charAt(1)-1))) {
                    this.setPosition(destination);
                }
                else {
                    throw new Exception("hatali hareket");
                }
            } 
        }

        if(oyuncusırası.equals("black")) { 
            if( pozisyon.charAt(0) >= 'f'& pozisyon.charAt(0) <='j') {
                if((int)destination.charAt(0) == ((int)pozisyon.charAt(0) - 1) & destination.charAt(1)== pozisyon.charAt(1)) {
                    this.setPosition(destination);
                }
                else {
                    throw new Exception("hatali hareket");
                }
            } 
            else if(pozisyon.charAt(0)>='a' & pozisyon.charAt(0) <= 'e') {
                if((int)destination.charAt(0) == ((int)pozisyon.charAt(0) - 1) & destination.charAt(1)== pozisyon.charAt(1)) {
                    this.setPosition(destination);
                }
                else if((int)destination.charAt(0) == (int)pozisyon.charAt(0) & (destination.charAt(1)== (pozisyon.charAt(1)+1) || destination.charAt(1)== (pozisyon.charAt(1)-1))) {
                    this.setPosition(destination);
                }
                else {
                    throw new Exception("hatali hareket");
                }
            } 
        }
       
		
	}
}
