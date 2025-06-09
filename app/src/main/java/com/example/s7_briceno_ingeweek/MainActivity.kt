package com.example.s7_briceno_ingeweek

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var tabLayout: TabLayout
    lateinit var adapter: EventoAdapter
    lateinit var lugarAdapter: LugarAdapter

    // Datos de la semana
    private val semana = listOf(
        listOf( // Lunes 02-06-25
            Actividad("09:00", "Ceremonia de Inauguración", "Plazuela de la UNS", "Autoridades UNS, delegaciones de escuelas, administrativos, docentes y estudiantes")
        ),
        listOf( // Martes 03-06-25
            Actividad("08:00", "Hidrólisis marinos – vía enzimática", "Auditorio EPIE", "Ing. Gabriel Sifuentes Penagos"),
            Actividad("08:45", "NutriAvo: Agroindustria con propósito", "Auditorio EPIE", "Ing. Miriam Vásquez Chuquizuta"),
            Actividad("09:30", "Innovación, emprendimiento y gestión agroindustrial", "Auditorio EPIE", "Ing. Nadia Esther Gamarra Abanto"),
            Actividad("10:15", "Gestión de Calidad en la producción de Aceite de Pescado para Consumo Humano", "Auditorio EPIE", "Ing. Carmen Pajuelo Carbajal"),
            Actividad("15:00", "Manejo agronómico del cultivo de palto var. Hass", "Auditorio Ing. Agrónoma – Campus II", "Ing. Paco Chicoma Rivera"),
            Actividad("15:45", "Estrés fisiológico de los cultivos", "Auditorio Ing. Agrónoma – Campus II", "Ing. Daleska Longobardi Méndez"),
            Actividad("16:30", "Agroexportación de frutales", "Auditorio Ing. Agrónoma – Campus II", "Ing. Jesús Jaque Chauca"),
            Actividad("17:15", "Experiencias fitosanitarias en el cultivo de palto (Agro Chimu)", "Auditorio Ing. Agrónoma – Campus II", "Ms. Teófilo Arias Miranda"),
            Actividad("18:00", "Nuevas alternativas de nutrición en el cultivo de palta (Yara Perú)", "Auditorio Ing. Agrónoma – Campus II", "Ing. Shimy Zapata Gutiérrez"),
            Actividad("15:00", "La inteligencia artificial y su influencia en la programación", "Auditorio EPIE", "Dr. Carlos Eugenio Vega Moreno"),
            Actividad("15:45", "Estrategias competitivas en los negocios empresariales", "Auditorio EPIE", "Dra. Lisbeth Dora Briones Pereyra"),
            Actividad("16:30", "Del dato a la decisión: Fundamentos y aplicaciones de Power BI", "Auditorio EPIE", "Mts. Johan López Heredia"),
            Actividad("17:15", "Stacking ensemble approach to diagnosing the disease of diabetes", "Auditorio EPIE", "Dr. Alfredo Daza Vergaray"),
            Actividad("18:00", "Un modelo multiclasicador para la predicción de la carga de enfriamiento y calor en edificios residenciales", "Auditorio EPIE", "Mg. Luis Enrique Ramírez Milla")
        ),
        listOf( // Miércoles 04-06-25
            Actividad("09:00", "Agrovoltaica, una alternativa sostenible para la transición energética", "Auditorio EPIE", "Dr. Denis Arangurí Cayetano"),
            Actividad("10:00", "Técnicas nucleares para detección y medición de Radón (Rn-222)", "Auditorio EPIE", "MSc. Carlos Montañez Montenegro"),
            Actividad("11:00", "Implementación de energía Eólica residencial en el Perú", "Auditorio EPIE", "MSc. Ricardo Cedrón Maguiña"),
            Actividad("10:00", "El ingeniero como agente de cambio", "Auditorio Biblioteca Central", "Ing. Jorge Castañeda Centurión"),
            Actividad("10:45", "Desempeño sísmico de un edificio esencial", "Auditorio Biblioteca Central", "Ing. Iván León Malo"),
            Actividad("11:30", "Análisis de fallas en estructuras metálicas", "Auditorio Biblioteca Central", "Ing. Gumercindo Flores Reyes"),
            Actividad("11:30", "Cimentaciones para edificaciones en Chimbote", "Auditorio Biblioteca Central", "Ing. Jorge Morillo Trujillo"),
            Actividad("15:00", "Aplicación del TPM en tratamiento de caldos", "Auditorio EPIE", "M.Sc. Arquímedes Ipárraguirre Lozano"),
            Actividad("15:45", "Bloqueo y etiquetado de energía residual", "Auditorio EPIE", "M.Sc. Luis Carlos Calderón Rodríguez"),
            Actividad("16:15", "Análisis de sistema de transferencia de energía ATS", "Auditorio EPIE", "M.Sc. Fredesbildo Fidel Ríos Noriega"),
            Actividad("17:00", "Aplicación de la hidrocinética en ingeniería", "Auditorio EPIE", "M.Sc. Nelver Javier Escalante Espinoza"),
            Actividad("17:45", "Retos en puentes metálicos con BIM", "Auditorio EPIE", "Ing. Diego Alonso Blondet Belaunde")
        ),
        listOf( // Jueves 05-06-25
            Actividad("09:00", "Misa de Celebración por la Semana de Ingeniería", "Capilla de la UNS", "Participan delegaciones, administrativos, docentes y centros de producción"),
            Actividad("10:00", "Ceremonia Central de la Semana de Ingeniería", "Auditorio de Ingeniería en Energía", "Discursos de autoridades, reconocimientos, brindis de honor"),
            Actividad("15:00", "Corso Inter Escuelas", "Complejo Deportivo UNS", "Inicio en la Puerta 1 del campus universitario"),
            Actividad("16:00", "Partido de Fútbol de Confraternidad", "Complejo Deportivo UNS", "Escuela Campeón 2024 vs Club UNS, Egresados Master 1 vs Master 2")
        ),
        listOf( // Viernes 06-06-25
            Actividad("09:00", "Campeonato Interescuelas", "Complejo Deportivo – UNS", "Eliminatorias de fútbol, vóley y básquet entre escuelas profesionales"),
            Actividad("13:00", "Almuerzo de Confraternidad", "Complejo Deportivo – UNS", "Docentes, estudiantes y personal de la Facultad de Ingeniería"),
            Actividad("14:00", "Campeonato Fulbito Interescuelas - Docentes", "Complejo Deportivo – UNS", "Docentes de distintas escuelas profesionales"),
            Actividad("15:00", "Final del Campeonato Interescuelas - Estudiantes", "Complejo Deportivo – UNS", "Finales de fútbol, vóley y básquet"),
            Actividad("18:00", "Premiación de Equipos Ganadores", "Complejo Deportivo – UNS", "Entrega de premios a equipos destacados"),
            Actividad("18:15", "Clausura", "Complejo Deportivo – UNS", "Cierre oficial de la Semana de Ingeniería")
        )
    )

    private val lugares = listOf(
        Lugar("Plazuela UNS", R.drawable.plazuela_uns),
        Lugar("Auditorio EPIE", R.drawable.auditorio_epie),
        Lugar("Auditorio Ingenieria Agronoma", R.drawable.auditorio_agronoma),
        Lugar("Auditorio Biblioteca Central", R.drawable.auditorio_biblioteca_central),
        Lugar("Capilla UNS", R.drawable.capilla_uns),
        Lugar("Complejo Deportivo UNS", R.drawable.complejo_deportivo_uns)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabLayout)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Inicializa adaptador con actividades del lunes
        adapter = EventoAdapter(semana[0])
        lugarAdapter = LugarAdapter(lugares)
        recyclerView.adapter = adapter

        // Tabs de lunes a viernes
        val dias = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes")
        for (dia in dias) {
            tabLayout.addTab(tabLayout.newTab().setText(dia))
        }

        // Cambio de contenido según pestaña
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val index = tab?.position ?: 0
                recyclerView.adapter = adapter
                val actividadesDelDia = semana[index]
                adapter.actualizarDatos(actividadesDelDia)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        // Menú de la parte de abajo para poder ver la agenda o ubicaciones de las ponencias
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_agenda -> {
                    recyclerView.adapter = adapter
                    adapter.actualizarDatos(semana[tabLayout.selectedTabPosition])
                    true
                }
                R.id.nav_ubicaciones -> {
                    recyclerView.adapter = lugarAdapter
                    true
                }
                else -> false
            }
        }

    }
}
