package ph.edu.dlsu.mobdeve.tiu.czarina.basicandroid
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class SwipeCallback(private val userAdapter: UserAdapter) :
    ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
    private var background: ColorDrawable
    //notice that a darker shade of gray appears when you swipe the card
    override fun onChildDraw(
        c: Canvas, recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float, dY: Float, actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        super.onChildDraw(
            c, recyclerView, viewHolder, dX,
            dY, actionState, isCurrentlyActive
        )
        val itemView = viewHolder.itemView
        when {
            dX > 0 -> { // Swiping to the right
                background = ColorDrawable(Color.LTGRAY)
                background.setBounds(
                    itemView.left, itemView.top,
                    itemView.left + dX.toInt(),
                    itemView.bottom
                )
            }
            dX < 0 -> { // Swiping to the left
                background = ColorDrawable(Color.DKGRAY)
                background.setBounds(
                    itemView.right + dX.toInt(),
                    itemView.top, itemView.right, itemView.bottom
                )
            }
            else -> { // view is unSwiped
                background.setBounds(0, 0, 0, 0)
            }
        }
        background.draw(c)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    //what to do if swipe left? swipe right?
    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val position = viewHolder.adapterPosition
        userAdapter.removeUser(position)
    }

    init {
        background = ColorDrawable(Color.BLACK)
    }
}