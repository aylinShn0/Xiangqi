
public class Board extends AbstractBoard{

	char[][] tahta;

	@Override
	public void print() {
		int sıra = 106;
		for(int i = 0; i < tahta.length; i++) {
			System.out.print((char)sıra + "\t");
			for(int j = 0; j < tahta[i].length; j++) {
				for(int k=0; k< items.length; k++) {
					String pozisyon = items[k].getPosition();
					int first  = Math.abs((int)pozisyon.charAt(0)-106);
					int second = Math.abs((int)pozisyon.charAt(1)-49);
					if(first==i & second==j) {
						tahta[i][j] = items[k].getInitial();
						System.out.print(tahta[i][j]);
					}
				}
				if(tahta[i][j]=='-') {
					System.out.print(tahta[i][j]);
				}
				if(j<8)
				System.out.print("--");
				else System.out.println("");
			}
			if(sıra == 106) {
				System.out.println(" \t|  |  |  |\\ | /|  |  |  |");
			}
			else if(sıra== 105) {
				System.out.println(" \t|  |  |  |/ | \\|  |  |  |");
			}
			else if(sıra==102) {
				System.out.println(" \t|                       |");
			}
			else if(sıra == 99) {
				System.out.println(" \t|  |  |  |/ | \\|  |  |  |");
			}
			else if(sıra==98) {
				System.out.println(" \t|  |  |  |\\ | /|  |  |  |");
			}
			else if (sıra==97){
				System.out.println();
			}
			else {
				System.out.println(" \t|  |  |  |  |  |  |  |  |");
			}
			sıra--;
		}
		System.out.println(" \t1--2--3--4--5--6--7--8--9");
	}

	public Board() {
		char[][] tahta = new char[10][9];
		for(int i = 0; i < tahta.length; i++) {
			for(int j = 0; j < tahta[i].length; j++) {
				tahta[i][j] = '-';
			}
		}
		this.tahta = tahta;
		Item[] items = new Item[32];
		this.items = items;

		Item piyon1 = new Piyon("d1", 'p', "red");
		Item piyon2 = new Piyon("d3", 'p', "red");
		Item piyon3 = new Piyon("d5", 'p', "red");
		Item piyon4 = new Piyon("d7", 'p', "red");
		Item piyon5 = new Piyon("d9", 'p', "red");
		Item kale1 = new Kale("a1", 'k', "red");
		Item kale2 = new Kale("a9", 'k', "red");
		Item at1 = new At("a2" , 'a', "red");
		Item at2 = new At("a8", 'a', "red");
		Item fil1 = new Fil("a3", 'f', "red");
		Item fil2 = new Fil("a7", 'f', "red");
		Item top1 = new Top("c2", 't', "red");
		Item top2 = new Top("c8" ,'t', "red");
		Item vezir1 = new Vezir("a4", 'v', "red");
		Item vezir2 = new Vezir("a6", 'v', "red");
		Item sah1 = new Sah("a5" , 'ş', "red");

		Item PIYON1 = new Piyon("g1" ,'P' , "black");
		Item PIYON2 = new Piyon("g3", 'P', "black");
		Item PIYON3 = new Piyon("g5", 'P', "black");
		Item PIYON4 = new Piyon("g7", 'P', "black");
		Item PIYON5 = new Piyon("g9", 'P', "black");
		Item KALE1 = new Kale("j1", 'K', "black");
		Item KALE2 = new Kale("j9", 'K', "black");
		Item AT1 = new At("j2", 'A', "black");
		Item AT2 = new At("j8", 'A', "black");
		Item FIL1 = new Fil("j3", 'F', "black");
		Item FIL2 = new Fil("j7", 'F', "black");
		Item TOP1 = new Top("h2" ,'T', "black");
		Item TOP2 = new Top("h8", 'T', "black");
		Item VEZIR1 = new Vezir("j4", 'V', "black");
		Item VEZIR2 = new Vezir("j6", 'V', "black");
		Item SAH1 = new Sah("j5",'Ş', "black");

		items[0] = piyon1;
		items[1] = piyon2;
		items[2] = piyon3;
		items[3] = piyon4;
		items[4] = piyon5;
		items[5] = kale1;
		items[6] = kale2;
		items[7] = at1;
		items[8] = at2;
		items[9] = fil1;
		items[10] = fil2;
		items[11] = top1;
		items[12] = top2;
		items[13] = vezir1;
		items[14] = vezir2;
		items[15] = sah1;
		items[16] = PIYON1;
		items[17] = PIYON2;
		items[18] = PIYON3;
		items[19] =PIYON4;
		items[20] =PIYON5;
		items[21] =KALE1;
		items[22] =KALE2;
		items[23] =AT1;
		items[24] =AT2;
		items[25] =FIL1;
		items[26] =FIL2;
		items[27] =TOP1;
		items[28] =TOP2;
		items[29] =VEZIR1;
		items[30] =VEZIR2;
		items[31] =SAH1;
	}


	public char[][] getTahta() {
		return this.tahta;
	}

	public Item[] getItems() {
		return this.items;
	}


}
