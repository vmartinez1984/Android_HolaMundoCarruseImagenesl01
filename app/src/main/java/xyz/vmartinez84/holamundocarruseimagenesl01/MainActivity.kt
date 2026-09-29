package xyz.vmartinez84.holamundocarruseimagenesl01

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
//    var lista = listOf(
//        "https://images.pexels.com/photos/30932492/pexels-photo-30932492.jpeg",
//        "https://images.pexels.com/photos/20791380/pexels-photo-20791380.jpeg",
//        "https://images.pexels.com/photos/29951793/pexels-photo-29951793.jpeg",
//        "https://images.pexels.com/photos/39257093/pexels-photo-39257093.jpeg",
//        "https://images.pexels.com/photos/12709870/pexels-photo-12709870.jpeg"
//    )
    var lista = ArrayList<String>();
    var indice = 0

    lateinit  var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        imageView = findViewById<ImageView>(R.id.imageView)

        lista.add("https://images.pexels.com/photos/30932492/pexels-photo-30932492.jpeg")
        lista.add("https://images.pexels.com/photos/20791380/pexels-photo-20791380.jpeg")
        lista.add("https://images.pexels.com/photos/29951793/pexels-photo-29951793.jpeg")
        lista.add("https://images.pexels.com/photos/39257093/pexels-photo-39257093.jpeg")
        lista.add("https://images.pexels.com/photos/12709870/pexels-photo-12709870.jpeg")

        Glide.with(this).load(lista[0]).into(imageView)
    }

    fun siguienteImagen(view: View){
        if(indice < lista.count())
            indice++
        else
            indice = 0
        Glide.with(this).load(lista[indice]).into(imageView)
    }

    fun atrasImagen(view: View){
        if(indice == 0)
            indice = lista.count()
        else
            indice--
        Glide.with(this).load(lista[indice]).into(imageView)
    }
}