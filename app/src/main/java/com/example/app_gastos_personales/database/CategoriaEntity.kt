import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(
    tableName = "categoria")
data class CategoriaEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String
)

@Entity(
    tableName = "transaccion",
    foreignKeys = [
        ForeignKey(
            entity = CategoriaEntity::class,
            parentColumns = ["id"],
            childColumns = ["categoria_id"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class TransaccionEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val monto: Double,
    val tipo: String,
    val fecha: String,
    val nota: String?,
    val cuenta_id: Int,
    val categoria_id: Int
)