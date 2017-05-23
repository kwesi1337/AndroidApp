package app

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries

class MainActivity : AppCompatActivity() {
/*x lyd y tid x
    Grafer lyd
    */



    lateinit internal var velocityLine: LineGraphSeries<DataPoint>
    lateinit internal var soundline: LineGraphSeries<DataPoint>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var y: Double
        var x: Double
        x = -5.0

        val graph = findViewById(R.id.graph) as GraphView
        velocityLine = LineGraphSeries<DataPoint>()
        soundline = LineGraphSeries<DataPoint>()

        velocityLine.setTitle("Hastighed")
        soundline.setTitle("DB")

        velocityLine.setColor(Color.BLUE)
        soundline.setColor(Color.GREEN)

        for (i in 0..499) {

            x = x + 0.1
            y = Math.sin(x)
            velocityLine.appendData(DataPoint(x, y), true, 500)

        }

        for (i in 0..60) {

            x = i.toDouble()
            y = Math.sqrt(i.toDouble())
            soundline.appendData(DataPoint(x, y), true, 60)

        }
        graph.addSeries(velocityLine)
        graph.addSeries(soundline)

        graph.getLegendRenderer().setVisible(true)
        graph.getLegendRenderer().setFixedPosition(0,0)





    }
}
