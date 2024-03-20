
public class Game extends AbstractGame{

    private String oyunsırası = "red";

    public Game(String p1, String p2) {
        Player red=new Player();
        this.red=red;
        Player black = new Player();
        this.black=black;
        red.setName(p1);
        black.setName(p2);
        Board board = new Board();
        this.board= board;
    }


    @Override
    void play(String from, String to) { //movelardan puanlara bak.
        try{
            if(from.length()==2 || to.length()==2){
                if(from.charAt(0)>='a' & from.charAt(0)<='j') {
                    if(from.charAt(1)>=1 & from.charAt(1)>=9) {
                        if(to.charAt(0)>='a' & to.charAt(0)<='j') {
                            if(to.charAt(1)>=1 & to.charAt(1)>=9){
                                if(oyunsırası.equals("red")) {  //item arrayden piyona bakıp move u çağır.
                                    for(int i = 0; i < board.items.length;i++) {
                                        if((board.items[i].getPosition()).equals(from) & board.items[i].getOyuncu().equals("red")) {
                                            if(board.items[i] instanceof At) {
                                                if(from.charAt(0)+2 == to.charAt(0)) {
                                                    String engel = ""+(from.charAt(0)+1)+ from.charAt(1);
                                                    for(int j =0; j<board.items.length; j++) {
                                                        if(board.items[j].getPosition().equals(engel)) {
                                                            throw new Exception("hatali hareket");
                                                        }
                                                    }
                                                } else if (from.charAt(0)-2 == to.charAt(0)) {
                                                    String engel = ""+(from.charAt(0)-1)+ from.charAt(1);
                                                    for(int j =0; j<board.items.length; j++) {
                                                        if(board.items[j].getPosition().equals(engel)) {
                                                            throw new Exception("hatali hareket");
                                                        }
                                                    }
                                                } else if (from.charAt(1)+2 == to.charAt(1)) {
                                                    String engel = ""+(from.charAt(0))+ (from.charAt(1)+1);
                                                    for(int j =0; j<board.items.length; j++) {
                                                        if(board.items[j].getPosition().equals(engel)) {
                                                            throw new Exception("hatali hareket");
                                                        }
                                                    }
                                                } else if (from.charAt(1)-2 == to.charAt(1)) {
                                                    String engel = ""+(from.charAt(0))+ (from.charAt(1)-1);
                                                    for(int j =0; j<board.items.length; j++) {
                                                        if(board.items[j].getPosition().equals(engel)) {
                                                            throw new Exception("hatali hareket");
                                                        }
                                                    }
                                                } else { boolean hedeftetaşvar= false;
                                                    for(int m=0; m<board.items.length;m++){
                                                        if(board.items[m].getPosition().equals(to)& board.items[m].getOyuncu().equals("black")) {
                                                            hedeftetaşvar= true;
                                                            board.items[m].setPosition("xx");
                                                            board.items[i].move(to);
                                                            oyunsırası="black";
                                                            
                                                        }
                                                        if(board.items[m].getPosition().equals(to)& board.items[m].getOyuncu().equals("red")) {
                                                            hedeftetaşvar= true;
                                                            throw new Exception("hatali hareket");
                                                        }
                                                        
                                                    } if(!hedeftetaşvar) {board.items[i].move(to);
                                                    oyunsırası="black";}
                                                    
                                                }
                                                
                                            } else if (board.items[i] instanceof Top) {
                                                if(from.charAt(0)== to.charAt(0) & from.charAt(1)!=to.charAt(1)) {
                                                    char maks= '.';
                                                    char min=',';
                                                    if(from.charAt(1)>to.charAt(1)){maks= from.charAt(1);
                                                    min=to.charAt(1); }
                                                    else {
                                                        maks=to.charAt(1);
                                                        min = from.charAt(1);
                                                    }
                                                    boolean hedefdolu = false;
                                                    boolean arataşvar= false;
                                                    for(int k=0; k<board.items.length;k++) {
                                                        if(board.items[k].getPosition().charAt(0)== from.charAt(0) & board.items[k].getPosition().charAt(1)<maks & board.items[k].getPosition().charAt(1)>min) {
                                                            for(int j =0; j<board.items.length; j++) {
                                                                
                                                                if(board.items[j].getPosition().equals(to)){
                                                                    hedefdolu=true;
                                                                }
                                                                if(board.items[j].getPosition().equals(to) & board.items[j].getOyuncu().equals("black")) {
                                                                    board.items[j].setPosition("xx");
                                                                    board.items[i].move(to);
                                                                    oyunsırası="black";
                                                                }
                                                                if(board.items[j].getPosition().equals(to)& board.items[j].getOyuncu().equals("red")) {
                                                                    throw new Exception("hatali hareket");
                                                                }if(!hedefdolu) {
                                                                    throw new Exception("hatali hareket");
                                                                }

                                                            }
                                                            arataşvar=true;
                                                        } 
                                                    }if(!hedefdolu & !arataşvar){board.items[i].move(to);
                                                        oyunsırası="black";
                                                        } 
                                                } else if(from.charAt(1)==to.charAt(1) & from.charAt(0)!=to.charAt(0)) { //yukarı aşağı aynını yaz ve boş ilerlemeyi yaz
                                                    char maks= '.';
                                                    char min=',';
                                                    if(from.charAt(0)>to.charAt(0)){maks= from.charAt(0);
                                                        min=to.charAt(0); }
                                                    else {
                                                        maks=to.charAt(0);
                                                        min = from.charAt(0);
                                                    }
                                                    boolean hedefdolu = false;
                                                    boolean arataşvar= false;
                                                    for(int k=0; k<board.items.length;k++) {
                                                        if(board.items[k].getPosition().charAt(1)== from.charAt(1) & board.items[k].getPosition().charAt(0)<maks & board.items[k].getPosition().charAt(0)>min) {
                                                            for(int j =0; j<board.items.length; j++) {
                                                                if(board.items[j].getPosition().equals(to)){
                                                                    hedefdolu=true;
                                                                }
                                                                if(board.items[j].getPosition().equals(to) & board.items[j].getOyuncu().equals("black")) {
                                                                    board.items[j].setPosition("xx");
                                                                    board.items[i].move(to); 
                                                                    oyunsırası="black";
                                                                }
                                                                if(board.items[j].getPosition().equals(to)& board.items[j].getOyuncu().equals("red")) {
                                                                    throw new Exception("hatali hareket");
                                                                }if(!hedefdolu) {
                                                                    throw new Exception("hatali hareket");
                                                                }
                                                            } arataşvar=true;
                                                        }
                                                    }if(!hedefdolu & !arataşvar) {board.items[i].move(to);
                                                        oyunsırası="black";
                                                    }
                                                }
                                                
                                            } else if(board.items[i] instanceof Fil) {
                                                if(from.charAt(0)+2 == to.charAt(0) &from.charAt(1)+2 == to.charAt(1)) {
                                                    String engel = ""+(from.charAt(0)+1)+ (from.charAt(1)+1);
                                                    for(int j =0; j<board.items.length; j++) {
                                                        if(board.items[j].getPosition().equals(engel)) {
                                                            throw new Exception("hatali hareket");
                                                        }
                                                    }
                                                } else if(from.charAt(0)+2 == to.charAt(0) &from.charAt(1)-2 == to.charAt(1)) {
                                                    String engel = ""+(from.charAt(0)+1)+ (from.charAt(1)-1);
                                                    for(int j =0; j<board.items.length; j++) {
                                                        if(board.items[j].getPosition().equals(engel)) {
                                                            throw new Exception("hatali hareket");
                                                        }
                                                    }
                                                } else if(from.charAt(0)-2 == to.charAt(0) &from.charAt(1)+2 == to.charAt(1)) {
                                                    String engel = ""+(from.charAt(0)-1)+ (from.charAt(1)+1);
                                                    for(int j =0; j<board.items.length; j++) {
                                                        if(board.items[j].getPosition().equals(engel)) {
                                                            throw new Exception("hatali hareket");
                                                        }
                                                    }
                                                } else if(from.charAt(0)-2 == to.charAt(0) &from.charAt(1)-2 == to.charAt(1)) {
                                                    String engel = ""+(from.charAt(0)-1)+ (from.charAt(1)-1);
                                                    for(int j =0; j<board.items.length; j++) {
                                                        if(board.items[j].getPosition().equals(engel)) {
                                                            throw new Exception("hatali hareket");
                                                        }
                                                    }
                                                } else {boolean hedeftetaşvar= false;
                                                    for(int m=0; m<board.items.length;m++){
                                                        if(board.items[m].getPosition().equals(to) & board.items[m].getOyuncu().equals("black")) {
                                                            hedeftetaşvar= true;
                                                            board.items[m].setPosition("xx");
                                                            board.items[i].move(to); 
                                                            oyunsırası="black";
                                                        }
                                                        if(board.items[m].getPosition().equals(to)& board.items[m].getOyuncu().equals("red")) {
                                                            hedeftetaşvar= true;
                                                            throw new Exception("hatali hareket");
                                                        }
                                                        
                                                    } if(!hedeftetaşvar) {board.items[i].move(to);
                                                        oyunsırası="black";}
                                                }
                                            } else {boolean hedeftetaşvar= false;
                                                for(int m=0; m<board.items.length;m++){
                                                    if(board.items[m].getPosition().equals(to) & board.items[m].getOyuncu().equals("black")) {
                                                        hedeftetaşvar= true;
                                                        board.items[m].setPosition("xx");
                                                        board.items[i].move(to); 
                                                        oyunsırası="black";
                                                    }
                                                    if(board.items[m].getPosition().equals(to)& board.items[m].getOyuncu().equals("red")) {
                                                        hedeftetaşvar= true;
                                                        throw new Exception("hatali hareket");
                                                    }
                                                      
                                                }if(!hedeftetaşvar) {board.items[i].move(to);
                                                    oyunsırası="black";}
                                            }
                                        } //else //throw new Exception("hatali hareket"); //hata var
                                    } //galiba burda hata vermeli
                                } else if(oyunsırası.equals("black")) {
                                    for(int i = 0; i < board.items.length;i++) {
                                        if((board.items[i].getPosition()).equals(from) & board.items[i].getOyuncu().equals("black")) {
                                            if(board.items[i] instanceof At) {
                                                if(from.charAt(0)+2 == to.charAt(0)) {
                                                    String engel = ""+(from.charAt(0)+1)+ from.charAt(1);
                                                    for(int j =0; j<board.items.length; j++) {
                                                        if(board.items[j].getPosition().equals(engel)) {
                                                            throw new Exception("hatali hareket");
                                                        }
                                                    }
                                                } else if (from.charAt(0)-2 == to.charAt(0)) {
                                                    String engel = ""+(from.charAt(0)-1)+ from.charAt(1);
                                                    for(int j =0; j<board.items.length; j++) {
                                                        if(board.items[j].getPosition().equals(engel)) {
                                                            throw new Exception("hatali hareket");
                                                        }
                                                    }
                                                } else if (from.charAt(1)+2 == to.charAt(1)) {
                                                    String engel = ""+(from.charAt(0))+ (from.charAt(1)+1);
                                                    for(int j =0; j<board.items.length; j++) {
                                                        if(board.items[j].getPosition().equals(engel)) {
                                                            throw new Exception("hatali hareket");
                                                        }
                                                    }
                                                } else if (from.charAt(1)-2 == to.charAt(1)) {
                                                    String engel = ""+(from.charAt(0))+ (from.charAt(1)-1);
                                                    for(int j =0; j<board.items.length; j++) {
                                                        if(board.items[j].getPosition().equals(engel)) {
                                                            throw new Exception("hatali hareket");
                                                        }
                                                    }
                                                } else { boolean hedeftetaşvar= false;
                                                    for(int m=0; m<board.items.length;m++){
                                                        if(board.items[m].getPosition().equals(to)& board.items[m].getOyuncu().equals("red")) {
                                                            hedeftetaşvar= true;
                                                            board.items[m].setPosition("xx");
                                                            board.items[i].move(to);
                                                            oyunsırası="red";
                                                            
                                                        }
                                                        if(board.items[m].getPosition().equals(to)& board.items[m].getOyuncu().equals("black")) {
                                                            hedeftetaşvar= true;
                                                            throw new Exception("hatali hareket");
                                                        }
                                                        
                                                    } if(!hedeftetaşvar) {board.items[i].move(to);
                                                    oyunsırası="red";}
                                                    
                                                }
                                                
                                            } else if (board.items[i] instanceof Top) {
                                                if(from.charAt(0)== to.charAt(0) & from.charAt(1)!=to.charAt(1)) {
                                                    char maks= '.';
                                                    char min=',';
                                                    if(from.charAt(1)>to.charAt(1)){maks= from.charAt(1);
                                                    min=to.charAt(1); }
                                                    else {
                                                        maks=to.charAt(1);
                                                        min = from.charAt(1);
                                                    }
                                                    boolean hedefdolu = false;
                                                    boolean arataşvar= false;
                                                    for(int k=0; k<board.items.length;k++) {
                                                        if(board.items[k].getPosition().charAt(0)== from.charAt(0) & board.items[k].getPosition().charAt(1)<maks & board.items[k].getPosition().charAt(1)>min) {
                                                            for(int j =0; j<board.items.length; j++) {
                                                                
                                                                if(board.items[j].getPosition().equals(to)){
                                                                    hedefdolu=true;
                                                                }
                                                                if(board.items[j].getPosition().equals(to) & board.items[j].getOyuncu().equals("red")) {
                                                                    board.items[j].setPosition("xx");
                                                                    board.items[i].move(to);
                                                                    oyunsırası="red";
                                                                }
                                                                if(board.items[j].getPosition().equals(to)& board.items[j].getOyuncu().equals("black")) {
                                                                    throw new Exception("hatali hareket");
                                                                }if(!hedefdolu) {
                                                                    throw new Exception("hatali hareket");
                                                                }

                                                            }
                                                            arataşvar=true;
                                                        } 
                                                    }if(!hedefdolu & !arataşvar){board.items[i].move(to);
                                                        oyunsırası="red";
                                                        } 
                                                } else if(from.charAt(1)==to.charAt(1) & from.charAt(0)!=to.charAt(0)) { //yukarı aşağı aynını yaz ve boş ilerlemeyi yaz
                                                    char maks= '.';
                                                    char min=',';
                                                    if(from.charAt(0)>to.charAt(0)){maks= from.charAt(0);
                                                        min=to.charAt(0); }
                                                    else {
                                                        maks=to.charAt(0);
                                                        min = from.charAt(0);
                                                    }
                                                    boolean hedefdolu = false;
                                                    boolean arataşvar= false;
                                                    for(int k=0; k<board.items.length;k++) {
                                                        if(board.items[k].getPosition().charAt(1)== from.charAt(1) & board.items[k].getPosition().charAt(0)<maks & board.items[k].getPosition().charAt(0)>min) {
                                                            for(int j =0; j<board.items.length; j++) {
                                                                if(board.items[j].getPosition().equals(to)){
                                                                    hedefdolu=true;
                                                                }
                                                                if(board.items[j].getPosition().equals(to) & board.items[j].getOyuncu().equals("red")) {
                                                                    board.items[j].setPosition("xx");
                                                                    board.items[i].move(to); 
                                                                    oyunsırası="red";
                                                                }
                                                                if(board.items[j].getPosition().equals(to)& board.items[j].getOyuncu().equals("black")) {
                                                                    throw new Exception("hatali hareket");
                                                                }if(!hedefdolu) {
                                                                    throw new Exception("hatali hareket");
                                                                }
                                                            } arataşvar=true;
                                                        }
                                                    }if(!hedefdolu & !arataşvar) {board.items[i].move(to);
                                                        oyunsırası="red";
                                                    }
                                                }
                                                
                                            } else if(board.items[i] instanceof Fil) {
                                                if(from.charAt(0)+2 == to.charAt(0) &from.charAt(1)+2 == to.charAt(1)) {
                                                    String engel = ""+(from.charAt(0)+1)+ (from.charAt(1)+1);
                                                    for(int j =0; j<board.items.length; j++) {
                                                        if(board.items[j].getPosition().equals(engel)) {
                                                            throw new Exception("hatali hareket");
                                                        }
                                                    }
                                                } else if(from.charAt(0)+2 == to.charAt(0) &from.charAt(1)-2 == to.charAt(1)) {
                                                    String engel = ""+(from.charAt(0)+1)+ (from.charAt(1)-1);
                                                    for(int j =0; j<board.items.length; j++) {
                                                        if(board.items[j].getPosition().equals(engel)) {
                                                            throw new Exception("hatali hareket");
                                                        }
                                                    }
                                                } else if(from.charAt(0)-2 == to.charAt(0) &from.charAt(1)+2 == to.charAt(1)) {
                                                    String engel = ""+(from.charAt(0)-1)+ (from.charAt(1)+1);
                                                    for(int j =0; j<board.items.length; j++) {
                                                        if(board.items[j].getPosition().equals(engel)) {
                                                            throw new Exception("hatali hareket");
                                                        }
                                                    }
                                                } else if(from.charAt(0)-2 == to.charAt(0) &from.charAt(1)-2 == to.charAt(1)) {
                                                    String engel = ""+(from.charAt(0)-1)+ (from.charAt(1)-1);
                                                    for(int j =0; j<board.items.length; j++) {
                                                        if(board.items[j].getPosition().equals(engel)) {
                                                            throw new Exception("hatali hareket");
                                                        }
                                                    }
                                                } else {boolean hedeftetaşvar= false;
                                                    for(int m=0; m<board.items.length;m++){
                                                        if(board.items[m].getPosition().equals(to) & board.items[m].getOyuncu().equals("red")) {
                                                            hedeftetaşvar= true;
                                                            board.items[m].setPosition("xx");
                                                            board.items[i].move(to); 
                                                            oyunsırası="red";
                                                        }
                                                        if(board.items[m].getPosition().equals(to)& board.items[m].getOyuncu().equals("black")) {
                                                            hedeftetaşvar= true;
                                                            throw new Exception("hatali hareket");
                                                        }
                                                        
                                                    } if(!hedeftetaşvar) {board.items[i].move(to);
                                                        oyunsırası="red";}
                                                }
                                            } else {boolean hedeftetaşvar= false;
                                                for(int m=0; m<board.items.length;m++){
                                                    if(board.items[m].getPosition().equals(to) & board.items[m].getOyuncu().equals("red")) {
                                                        hedeftetaşvar= true;
                                                        board.items[m].setPosition("xx");
                                                        board.items[i].move(to); 
                                                        oyunsırası="red";
                                                    }
                                                    if(board.items[m].getPosition().equals(to)& board.items[m].getOyuncu().equals("black")) {
                                                        hedeftetaşvar= true;
                                                        throw new Exception("hatali hareket");
                                                    }
                                                      
                                                }if(!hedeftetaşvar) {board.items[i].move(to);
                                                    oyunsırası="red";}
                                            }
                                        } //else //throw new Exception("hatali hareket"); //hata var
                                    } 
                                }  

                            } else throw new Exception("hatali hareket");
                        } else throw new Exception("hatali hareket");
                    } else throw new Exception("hatali hareket");
                } else throw new Exception("hatali hareket");
            } else throw new Exception("hatali hareket");           
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    void save_binary(String address) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save_binary'");
    }

    @Override
    void save_text(String address) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save_text'");
    }

    @Override
    void load_text(String address) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'load_text'");
    }

    @Override
    void load_binary(String address) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'load_binary'");
    }
    
}
