public class At extends Item{
    public At(String str, char initial, String oyuncu) {
        this.setPosition(str);
        this.point = 4.0;
        this.initial= initial;
        this.oyuncu = oyuncu;
    }

    @Override
	public void move(String destination) throws Exception {
        String pozisyon = this.getPosition();
        String oyuncusırası = this.getOyuncu();
        if(oyuncusırası.equals("red")) {
            if((destination.charAt(0)== pozisyon.charAt(0)+2 ||destination.charAt(0)== pozisyon.charAt(0)-2) & (destination.charAt(1) == pozisyon.charAt(1)-1 ||destination.charAt(1) == pozisyon.charAt(1)+1 ) ) {
                this.setPosition(destination);
            }
            else if((destination.charAt(0)== pozisyon.charAt(0)+1 ||destination.charAt(0)== pozisyon.charAt(0)-1) & (destination.charAt(1) == pozisyon.charAt(1)-2 ||destination.charAt(1) == pozisyon.charAt(1)+2)) {
                this.setPosition(destination);
            }
            else{
                throw new Exception("hatali hareket");
            }
        }
        if(oyuncusırası.equals("black")) {
            if((destination.charAt(0)== pozisyon.charAt(0)+2 ||destination.charAt(0)== pozisyon.charAt(0)-2) & (destination.charAt(1) == pozisyon.charAt(1)-1 ||destination.charAt(1) == pozisyon.charAt(1)+1 ) ) {
                this.setPosition(destination);
            }
            else if((destination.charAt(0)== pozisyon.charAt(0)+1 ||destination.charAt(0)== pozisyon.charAt(0)-1) & (destination.charAt(1) == pozisyon.charAt(1)-2 ||destination.charAt(1) == pozisyon.charAt(1)+2)) {
                this.setPosition(destination);
            }
            else{
                throw new Exception("hatali hareket");
            }
        }
    }
}
