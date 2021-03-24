# Operations with Arrays of Objects 
 Bu ödevde sizlerden aşağıdaki işlemleri yapmanızı istiyoruz:  Ders notlarındaki Kisi sınıfına benzer yapıda ve Kapsülleme kavramını uygulayarak bir “Calisan” sınıfı oluşturunuz. “Calisan” sınıfı aşağıdaki öznitelikleri içermelidir:      adSoyad     sicilNo     satisTutari     prim  Sınıfın yaratıcı işlevini:  public Calisan(long sicilNo, String adSoyad, double satisTutari)  imzasına sahip olacak şekilde oluşturunuz.  Gerekli olduğunu düşündüğünüz get ve set işlevlerini de sınıfa ekleyiniz.  Tekrarlayan kişileri bulup, yeni dizide sadece bir kişi olmasını garanti etmek için:  public static void guncelle(Calisan[] calisanlar, Calisan[] liste)  imzalı güncelle işlevini yazınız. Bu işlevde liste içerisinde eğer varsa tekrarlayan sicil numaralarini bulunuz. Bu sicil numaralarına ait satış tutarlarını toplayarak, aynı sicil numaralarına sahip olan nesneleri, calisanlar dizisinde tek bir nesne olarak ifade ediniz.   Çalışanların alacağı primi hesaplamak için:  public static void primHesapla(Calisan[] calisanlar, double primOrani)  imzalı prim hesapla işlevini yazınız. Bu işlev, parametre olarak aldığı calisanlar dizisindeki calisan nesnelerinden her biri için primOrani parametresini kullanarak her bir çalışanın primini hesaplayacak. Hesaplanan bu değeri, buna karşılık gelen öznitelikte saklayacaktır. primOranı [0,1] kapalı aralığından seçilecek bir sayı olacaktır.  Bunlara ek olarak:  public static void listele(Calisan[] calisanlar)  işlevi ile tüm calisanlar listelenecektir. Listelemeyi aşağıda bulunan örnek çıktıda olduğu gibi yapınız. Çıktılar size verilen sırada yazdırılmalıdır.  Tüm bunlarla birlikte aşağıda verilen main işlevini de Calisan sınıfının içinde tanımlamalısınız. Ödev teslimi için Calisan.java dosyasını yüklemeniz yeterli olacaktır.  Ödevleriniz aşağıda paylaşılan örnek main işlevinde olduğu gibi çağrılıp değerlendirilecektir. Bu sebeple kodlarınızı main içinde değil, Calisan sınıfını içerisinde, yukarıdaki kurallara uygun olacak şekilde tanımlayacağınız işlevlerin içerisine yazınız.