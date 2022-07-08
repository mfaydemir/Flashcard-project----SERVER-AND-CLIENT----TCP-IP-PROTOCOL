# Flashcard-project----SERVER-AND-CLIENT----TCP-IP-PROTOCOL

işlevsel Özellikler
    1. FlashCard Programı sunucu (server) ve istemci (client) parçalarından oluşur.
    2. FlashCard tüm dosyaları sunucuda saklar, istemciye istediği bilgiyi gönderir.
    3. Sunucu port numarası ve seçilen kategoriyi konsoldan okur. Örnek bilgi
    3300 Kahve
    İlk sayı port numarasını ikinci bilgi kategori klasörünün adını verir. Tanımlı dosya
    bilgilerinde “Kitaplik” klasörü altında “MsKomutlari”, “YemekTarifleri”, “Kahve”
    olarak üç kategori vardır.
    4. Sunucu çalışmaya başlayınca konsoldan port numarasını ve kategori adını alır.
    itaplik klasörü ödev yapacaklara Telegram üzerinden zip dosya olarak
    iletilecektir. Kitaplik.zip Masaüstünde açılırsa programda kategori klasörüne
    erişirken tam dosya yolu verilmelidir.
    5. FlashCard dosyaları iç içe iki klasörde bulunur: Bunlar kitaplik ve kategori
    klasörleridir. İçteki klasörde dizin.txt bulunur. Her dizin satırı
    <dosyaAdı>-<Açıklama> biçimindedir.
          a. Kitaplik klasöründe flashCard kategorileri vardır. Proje için bu kategoriler
          “MsKomutları”, “YemekTarifleri” ve “Kahve” başlıklarından oluşur. Her
          başlık ayrı bir klasörde bulunur. Program çalışmaya başlarken birinin adini
          ister. Bu özellik bitirme projesinin fazla karmaşık olmasını önlemek için
          tasarlanmıştır.
          b. MsKomutlari klasöründe aşağıdaki bilgiler bulunur.
          at-Run a command at specified time
          attrib-used to change file attributes
          cd-change folder
          chkdsk-Check disk
          c. YemekTarifleri klasöründe
          Pizza-Pizza hamuru ve soslari
          Omlet-Fransız usulü omlet
          Döner-Tavuk Döner
          d. Kahveler Klasöründe
          TurkKahvesi
          Americano
          Expresso
          FilitreKahve
          Bulunur. Klasörlerin diziliş biçimi ve dosyalar aşağıda gösterilmiştir:
          Kitaplik klasörü
          Dizin.txt (MsKomutları, YemekTarifleri, Kahveler)
          MsKomutlari Klasörü
          Dizin.txt (at, attrib, cd, chkdsk)
          at.txt
          attrib.txt
          cd.txt
          chkdsk.txt
          YemekTarifleri Klasörü
          Dizin.txt (Pizza, Omlet, Doner)
          Pizza.txt
          Omlet.txt
          Doner.txt
          Kahve Klasörü
          Dizin.txt (TurkKahvesi, americano, Expresso, FilitreKahve)
          TurkKahvesi.txt
          Americano.txt
          Expresso.txt
          FilitreKahve.txt
      6. Sunucu “Kitaplik” klasörünün altındaki seçilen kategori dizinini ArrayList
      ortamına taşır.
      7. Sonra portu dinler. Bağlantı olursa thread yaratır. Bağlanan istemciye istediği
      bilgileri gönderir. İstemcinin işi bitince thread kapatılır.
      8. İstemci aşağıdaki komutları gönderince sunucu belirtilen yanıtları verir.
      İstemci komutları Sunucu Yanıtları
      KLST ArrayList içindeki öğeler istemciye gönderilir.
      Örneğin YemekTarifleri seçilen kategori ise istemciye
          1 - Pizza-Pizza hamuru ve soslari
          2 - Omlet-Fransız usulü omlet
          3 - Döner-Tavuk Döner
          gönderilir.
          LIST <no> <no> ile seçilen satırdaki 2’inci bilgi (Omlet) alınır ve
          Omlet.txt
          satırları istemciye gönderilir.
