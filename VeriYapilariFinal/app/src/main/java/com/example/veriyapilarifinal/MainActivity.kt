package com.example.veriyapilarifinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun Tekrarla(view: View)
    {
        val textSiralanmamis = findViewById<TextView>(R.id.textSiralanmamis)//TextView'ımı tanıttım
        textSiralanmamis.setText("Sıralanmamış Hali\n")//Belirtmek için Sıralanmamış hali yazdım
        val rastgeleSayilar = IntArray(10) { Random.nextInt(0, 100) }//0 ila 100 arasında rastgele seçilmiş 10 sayıdan array oluşturdum
        var index = 1//İndex değeri oluşturdum (Görüntü için)
        rastgeleSayilar.forEach{
            textSiralanmamis.setText(textSiralanmamis.text.toString()+"Değer "+index.toString()+": "+it.toString()+"\n")//Değerleri sırasıyla TextView'ıma yazdım
            index=index+1
        }
        var siralanmamis = true//Kontrol için bolean bir değer oluşturdum
        //Bubble Sort kısmı
        while(siralanmamis) {//Sıralanmamış iken döngünün dönmesini sağladım
            siralanmamis = false
            for (i in 0 until rastgeleSayilar.size - 1) {//Arrayim içerisinde for oluşturdum
                if (rastgeleSayilar[i] > rastgeleSayilar[i + 1]) {//Eğer önceki değer sonraki değerden büyük ise:
                    val gecici = rastgeleSayilar[i]// Önceki değeri geçici bir elemana atıp
                    rastgeleSayilar[i] = rastgeleSayilar[i + 1]//Önceki değeri sonraki değer yaptım
                    rastgeleSayilar[i + 1] = gecici// Sonraki değeri de geçici değer yaptım
                    siralanmamis = true //Sıralanmamış bir değer bulduğum için tüm listeyi tekrar arattım
                }
            }
        }
        val textSiralanmis =findViewById<TextView>(R.id.textSiralanmis)//TextView'ımı tanıttım
        textSiralanmis.setText("Sıralanmış Hali\n")//Belirtmek için Sıralanmış hali yazdım
        index=1//index değerini yeniden bir yaptım
        rastgeleSayilar.forEach{
            textSiralanmis.setText(textSiralanmis.text.toString()+"Değer "+index.toString()+": "+it.toString()+"\n")//Ekrana yazdırdım
            index=index+1
        }
    }
}
