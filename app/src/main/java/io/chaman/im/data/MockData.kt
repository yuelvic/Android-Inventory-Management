package io.chaman.im.data

class MockData {

    companion object {

        fun provideItems(): List<Item> {
            val items = ArrayList<Item>()

            for (i in 1..10) {
                var item = Item()
                item.name = "Pentel Pen"
                item.imageUrl = "http://www.wiredsystems.com/pub/media/catalog/product/cache/1/image/1000x1320/e9c3970ab036de70892d86c6d221abfe/p/i/pilot_pentel_pen_super_color_marker_black_fine_cebu_city_philippines.jpg"
                item.barCode = "49325632060369"
                item.quantity = 10
                items += item
            }

            return items
        }

    }

}