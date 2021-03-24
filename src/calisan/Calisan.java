public class Calisan {

	private long sicilNo;       /* sicil no */
	private String adSoyad;     /* ad, soyad */
	private double satisTutari; /* satış tutarı */
	private double prim;        /* prim */

	/* yaratıcı işlev, nesnenin tüm öz niteliklerine parametrede verilen değerleri atar. */
	public Calisan(long sicilNo, String adSoyad, double satisTutari) {
		this.sicilNo=sicilNo;
		this.adSoyad=adSoyad;
		this.satisTutari=satisTutari;
		this.prim = 0;
	}

	/* getsicilNo işlevi, sicil no'yu döner. */
	public long getSicilNo() {
		return sicilNo;
	}

	/* getAdSoyad işlevi, ad ve soyadı döner. */
	public String getAdSoyad() {
		return adSoyad;
	}

	/* getSatisTutari işlevi, satış tutarını döner. */
	public double getSatisTutari() {
		return satisTutari;
	}

	/* getPrim işlevi, o kişinin alacağı prim tutarını döner. */
	public double getPrim() {
		return prim;
	}

	/* setAdSoyad işlevi, verilen s değerini adSoyad'a atar. */
	public void setAdSoyad(String s) {  /* s boş (uzunluğu sıfır) ise hata ver */
		if(s.length() == 0) throw new RuntimeException("Hata: Ad bos");
		adSoyad = s;                 /* değilse, adSoyad'a aktar */
	}

	/* setSicilNo işlevi, verilen n değerini sicilNo'ya atar. */
	public void setSicilNo(long n) {  /* n negatif ise hata ver */
		if(n < 0) throw new RuntimeException("Hata: Negatif satisTutari");
		sicilNo = n;              /* değilse, sicilNo'ya aktar */
	}

	/* setSatisTutari işlevi, verilen n değerini satisTutari'na atar. */
	public void setSatisTutari(double n) {  /* n negatif ise hata ver */
		if(n < 0) throw new RuntimeException("Hata: Negatif satisTutari");
		satisTutari=n;              /* değilse, satisTutari'na aktar */
	}

	/* setPrim işlevi, verilen n değerini prim'e atar. */
	public void setPrim(double n) {  /* n negatif ise hata ver */
		if(n < 0) throw new RuntimeException("Hata: Negatif satisTutari");
		prim = n;              /* değilse, prim'e aktar */
	}

	public static void guncelle(Calisan[] calisanlar, Calisan[] liste){
		int indis = 0;
		for(Calisan k: liste){
			int varmi = 1;
			if(k == null)
				break;
                
			/*	liste icindekiler, calisanlar dizisine aktarilir 
				Bu aşamada aynı calisanların değerleri güncellenir.     */    
			for (Calisan j: calisanlar){
				if (j != null &&  k.getSicilNo() == j.getSicilNo()){
					j.setSatisTutari(j.getSatisTutari() + k.getSatisTutari());
					varmi = 0;
					break; 
				}
			}
			/* calisanlar dizisi icinde olmayanlar calisanlar dizisine eklenir */ 
			if(varmi == 1){
				calisanlar[indis] = k;
				indis++;
			}
		}
	}

	public static void primHesapla(Calisan[] calisanlar, double primOrani){
		for (Calisan i: calisanlar)
			if(i != null)
				i.setPrim(i.getSatisTutari() * primOrani);
	}

	public static void listele(Calisan[] calisanlar){
		for (Calisan i: calisanlar)
			if(i != null)
				System.out.println("Sicil No: "+i.getSicilNo()+", Ad-Soyad: "+i.getAdSoyad()+", Satis Tutari: "+i.getSatisTutari()+", Prim: "+i.getPrim());
	}


	public static void main(String[] args) {

		/*	****************************************
					TEST 1
			**************************************** */

		// Yöntem 1: dizi tanımlama, yaratma ve değer atama bir arada

		Calisan[] liste={new Calisan(1111111111l,"Ali Deniz", 23455.0),
						new Calisan(2222222222l,"Derya Gunes", 5696.70),
						new Calisan(3333333333l,"Mehmet Mavi", 2750.0),
						new Calisan(4444444444l,"Ada Yesil",7255),
						new Calisan(5555555555l,"Yagmur Kirmizi",2753),
						new Calisan(4444444444l,"Ada Yesil",2750.0)}; 

		Calisan[] calisanlar = new Calisan[30];

		// Size verilen liste icerisinde tekrarlayan sicilNolar bulunabilir. Guncelle islevi ile sizden tekrarlanan sicil numaralarını birleştirmenizi bekliyoruz. Bu esnada ayni sicil numarasina sahip olan kisilerin satis tutarlari toplanmalidir. Sicil numarasi ayni olan kisilerin ad ve soyadlarida ayni olacaktir.
		guncelle(calisanlar, liste);

		// primHesapla islevi ile her bir calisanin alacagi primi: satisTutari *  primOrani (0 ile 1 arasinda verilecektir) ile hesaplanmalidir. 
		primHesapla(calisanlar, 0.1);

		//listele islevi ile guncellenen ve alacaklari primleri hesaplanan calisanlar sirayla yazdirilacaktir. 
	
		System.out.println("ORNEK 1: -- Prim: 0.1");
	
		listele(calisanlar);

		System.out.println("\n");

		/*	****************************************
					TEST 2
			**************************************** */

		// Yöntem 1: dizi tanımlama, yaratma ve değer atama bir arada
		Calisan[] liste2={new Calisan(1111111111l,"Ali Deniz", 23455.0),
						new Calisan(1111111111l,"Ali Deniz", 5696.70),
						new Calisan(1111111111l,"Ali Deniz", 2750.0),
						new Calisan(1111111111l,"Ali Deniz",7255),
						new Calisan(1111111111l,"Ali Deniz",2753),
						new Calisan(1111111111l,"Ali Deniz",2750.0)}; 

		Calisan[] calisanlar2 = new Calisan[30];
		guncelle(calisanlar2, liste2);

		primHesapla(calisanlar2, 0.5);
		System.out.println("ORNEK 2: -- Prim: 0.5");
		listele(calisanlar2);

		System.out.println("\n");

		/*	****************************************
					TEST 3
			**************************************** */
		Calisan[] liste3={new Calisan(1111111111l,"Ahmet Sari",950),
						new Calisan(2222222222l,"Derya Gunes", 1250.70),
						new Calisan(3333333333l,"Mehmet Mavi", 600.0),
						new Calisan(4444444444l,"Deniz Irmak",5005),
						new Calisan(5555555555l,"Cicek Gunes", 1000.0),
						new Calisan(6666666666l,"Duygu Sari", 5000.70)}; 

		Calisan[] calisanlar3 = new Calisan[30];
		guncelle(calisanlar3, liste3);

		primHesapla(calisanlar3, 0.9);
		System.out.println("ORNEK 3 -- Prim: 0.9");
		listele(calisanlar3);

	
		System.out.println("\n");
		/*	****************************************
					TEST 4-5
			**************************************** */
		Calisan[] liste4={new Calisan(1111111111l,"Ahmet Sarı",3455),
						new Calisan(2222222222l,"Derya Gunes", 5696.70),
						new Calisan(3333333333l,"Mehmet Mavi", 2750.0),
						new Calisan(1111111111l,"Ahmet Sarı",3455),
						new Calisan(3333333333l,"Mehmet Mavi", 2750.0),
						new Calisan(2222222222l,"Derya Gunes", 5696.70)};

		Calisan[] calisanlar4 = new Calisan[30];
		guncelle(calisanlar4, liste4);

	
		primHesapla(calisanlar4, 0.0);
		System.out.println("ORNEK 4 -- Prim: 0.0");
		listele(calisanlar4);

		System.out.println("\n");

		primHesapla(calisanlar4, 1.0);
		System.out.println("ORNEK 5 -- Prim: 1.0");
		listele(calisanlar4);

	}

} 
