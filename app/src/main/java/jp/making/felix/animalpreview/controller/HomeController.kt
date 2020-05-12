package jp.making.felix.animalpreview.controller

import com.airbnb.epoxy.TypedEpoxyController
import jp.making.felix.animalpreview.card

class HomeController : TypedEpoxyController<List<Pair<String, Boolean>>>(){
    override fun buildModels(data: List<Pair<String, Boolean>>?) {
        requireNotNull(data)
        data.forEach { pair ->
            val (thumbnail, isLiked) = pair
            card {
                id(thumbnail)
                thumb(thumbnail)
                isLiked(isLiked)
            }
        }
    }
}