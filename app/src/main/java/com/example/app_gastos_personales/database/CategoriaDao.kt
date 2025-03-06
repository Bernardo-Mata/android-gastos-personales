import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoriaDao {
    @Insert
    suspend fun insertCategoria(categoria: CategoriaEntity)

    @Query("SELECT * FROM categoria")
    fun getAllCategorias(): Flow<List<CategoriaEntity>>
}