import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CategoriaViewModel(private val categoriaDao: CategoriaDao) : ViewModel() {
    val categorias: Flow<List<CategoriaEntity>> = categoriaDao.getAllCategorias()

    fun agregarCategoria(nombre: String) {
        viewModelScope.launch {
            categoriaDao.insertCategoria(CategoriaEntity(nombre = nombre))
        }
    }

    fun agregarCategoriasPredefinidas() {
        viewModelScope.launch {
            val categoriasPredefinidas = listOf(
                CategoriaEntity(nombre = "Ocio"),
                CategoriaEntity(nombre = "Comida"),
                CategoriaEntity(nombre = "Deporte"),
                CategoriaEntity(nombre = "Educación"),
                CategoriaEntity(nombre = "Salud")
            )
            categoriasPredefinidas.forEach { categoriaDao.insertCategoria(it) }
        }
    }
}
