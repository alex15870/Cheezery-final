package Molina.Arenas.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_combos.*
import kotlinx.android.synthetic.main.combo_view.view.*
import mx.itson.thecheezery.R

class combos : AppCompatActivity() {

    var salties = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_combos)


        cargarProductos()

        var adaptador = AdaptadorProductos(this, salties)

        gridview.adapter = adaptador

    }



    fun cargarProductos(){
        salties.add(
            Product(
                "Combo 1",
                R.drawable.combo1,
                "Fine crepes stuffed with Alfredo chicken, spinach and mushrooms.",
                6
            )
        )

        salties.add(
            Product(
                "Combo 2",
                R.drawable.combo2,
                "A delicious sandwich served with french fries.",
                5
            )
        )

        salties.add(
            Product(
                "Combo 3",
                R.drawable.combo3,
                "Sandwich made with Italian bread served warmed by grilling.",
                4
            )
        )

        salties.add(
            Product(
                "Combo 4",
                R.drawable.combo4,
                "Smothered in grilled onions, green peppers, mushrooms, and Provolone.",
                6
            )
        )

        salties.add(
            Product(
                "Combo 5",
                R.drawable.combo5,
                "Tortilla chips layered with beef and melted cheddar cheese. Served with fried beans, guacamole, pico de gallo, and sour topping.",
                7
            )
        )

    }

    private class AdaptadorProductos: BaseAdapter {
        var productos = ArrayList<Product>()
        var contexto: Context? = null

        constructor(contexto: Context, productos: ArrayList<Product>){
            this.contexto = contexto
            this.productos = productos
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod = productos[position]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.combo_view, null)

            vista.iv_imagen.setImageResource(prod.image)
            vista.tv_titulo.setText(prod.name)

            return vista
        }

        override fun getItem(position: Int): Any {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return productos.size
        }

    }

}
