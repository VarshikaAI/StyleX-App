package com.stylex.app.data

data class Event(
    val id: String,
    val title: String,
    val emoji: String,
    val subtitle: String
)

data class OutfitSuggestion(
    val top: String,
    val topDetails: String,
    val bottom: String,
    val bottomDetails: String,
    val shoes: String,
    val hair: String,
    val accessories: String,
    val topColors: List<String>,
    val bottomColors: List<String>,
    val styleNotes: String
)

object OutfitData {

    val events = listOf(
        Event("party", "Party Night", "🎉", "Dance the night away"),
        Event("office", "Office Meeting", "💼", "Professional vibes"),
        Event("college", "College Day", "🎓", "Casual & comfy"),
        Event("beach", "Beach Day", "🏖️", "Sun, sand & surf"),
        Event("date", "Date Night", "❤️", "Romantic evening"),
        Event("festival", "Music Festival", "🎵", "Vibrant & fun"),
        Event("gym", "Gym Workout", "💪", "Active & fit"),
        Event("wedding", "Wedding", "💒", "Elegant celebration"),
        Event("brunch", "Brunch", "🥞", "Casual meet-up"),
        Event("hiking", "Hiking", "🥾", "Adventure ready"),
        Event("shopping", "Shopping", "🛍️", "Retail therapy"),
        Event("movie", "Movie Night", "🎬", "Cozy cinema time"),
        Event("sports", "Sports Game", "⚽", "Team spirit"),
        Event("business", "Business Dinner", "🍽️", "Formal dining"),
        Event("casual", "Casual Hangout", "☕", "Relaxed vibes"),
        Event("concert", "Concert", "🎸", "Rock the show"),
        Event("travel", "Travel Day", "✈️", "On the go"),
        Event("birthday", "Birthday Party", "🎂", "Celebration time")
    )

    // Body shape recommendations for bottoms
    private fun getBottomForBodyShape(bodyShape: String, gender: String, eventType: String): Pair<String, String> {
        return if (gender == "Female") {
            when (bodyShape) {
                "Hourglass" -> when (eventType) {
                    "party", "date" -> Pair(
                        "High-waisted skinny jeans or bodycon skirt",
                        "Emphasizes your balanced proportions. Choose fitted styles that highlight your curves."
                    )
                    "office" -> Pair(
                        "Pencil skirt or tailored high-waisted trousers",
                        "Professional yet flattering. Stick to structured pieces that define your waist."
                    )
                    else -> Pair(
                        "High-waisted jeans or A-line skirt",
                        "Balanced silhouette that complements your natural shape."
                    )
                }
                "Pear" -> when (eventType) {
                    "party", "date" -> Pair(
                        "Dark bootcut jeans or A-line midi skirt",
                        "Balance your proportions. Choose darker colors for bottom and draw attention upward."
                    )
                    "office" -> Pair(
                        "Wide-leg trousers or A-line skirt",
                        "Creates a streamlined look. Avoid tight-fitting bottoms, go for flowing styles."
                    )
                    else -> Pair(
                        "Bootcut or straight-leg jeans",
                        "Balances your lower body. Avoid skinny jeans, choose styles that elongate."
                    )
                }
                "Apple" -> when (eventType) {
                    "party", "date" -> Pair(
                        "Mid-rise straight-leg jeans or empire waist skirt",
                        "Defines your legs. Avoid low-rise, choose mid to high-rise styles."
                    )
                    "office" -> Pair(
                        "Straight-leg trousers or empire waist dress",
                        "Creates a balanced silhouette. Choose structured fabrics with slight stretch."
                    )
                    else -> Pair(
                        "Boyfriend jeans or flowy midi skirt",
                        "Comfortable and flattering. Look for styles that skim rather than cling."
                    )
                }
                "Rectangle" -> when (eventType) {
                    "party", "date" -> Pair(
                        "Flared jeans or peplum skirt",
                        "Creates curves. Choose styles with details that add dimension."
                    )
                    "office" -> Pair(
                        "Cigarette pants or pleated skirt",
                        "Adds shape. Look for embellishments or patterns that create visual interest."
                    )
                    else -> Pair(
                        "Wide-leg jeans or tiered skirt",
                        "Adds volume and shape. Choose styles with ruffles or layers."
                    )
                }
                "Inverted Triangle" -> when (eventType) {
                    "party", "date" -> Pair(
                        "Flared or wide-leg jeans in bold colors",
                        "Balances your shoulders. Add volume to lower body with patterns or light colors."
                    )
                    "office" -> Pair(
                        "Wide-leg trousers or pleated skirt",
                        "Creates balance. Choose lighter colors or patterns for bottoms."
                    )
                    else -> Pair(
                        "Bootcut jeans or A-line skirt",
                        "Adds volume to lower half. Look for embellishments or pockets on bottoms."
                    )
                }
                else -> Pair(
                    "Classic straight-leg jeans",
                    "Versatile and flattering for all occasions."
                )
            }
        } else {
            // Male body shapes
            when (bodyShape) {
                "Triangle" -> Pair(
                    "Slim-fit or straight-leg jeans",
                    "Balances your build. Avoid overly baggy styles that add bulk."
                )
                "Inverted Triangle" -> Pair(
                    "Straight or relaxed-fit jeans",
                    "Balances broad shoulders. Choose classic fits, avoid skinny styles."
                )
                "Rectangle" -> Pair(
                    "Slim or tapered jeans",
                    "Creates shape. Choose fitted styles that define your silhouette."
                )
                "Trapezoid" -> Pair(
                    "Athletic fit or tapered jeans",
                    "Complements your muscular build. Look for styles with stretch."
                )
                else -> Pair(
                    "Straight-fit jeans or chinos",
                    "Classic and versatile for your body type."
                )
            }
        }
    }

    // Top recommendations based on body shape
    private fun getTopForBodyShape(bodyShape: String, gender: String, eventType: String): Pair<String, String> {
        return if (gender == "Female") {
            when (bodyShape) {
                "Hourglass" -> Pair(
                    "Fitted wrap top or V-neck blouse",
                    "Highlights your waist. Choose wrap styles or belted options."
                )
                "Pear" -> Pair(
                    "Embellished top or boat neck blouse",
                    "Draws attention upward. Choose bright colors, patterns, or statement sleeves."
                )
                "Apple" -> Pair(
                    "Empire waist top or V-neck tunic",
                    "Elongates torso. Choose flowing fabrics that skim the midsection."
                )
                "Rectangle" -> Pair(
                    "Peplum top or ruffled blouse",
                    "Creates curves. Look for details at bust and hip level."
                )
                "Inverted Triangle" -> Pair(
                    "Scoop neck or halter top",
                    "Balances shoulders. Avoid shoulder pads, choose softer necklines."
                )
                else -> Pair(
                    "Classic fitted top",
                    "Versatile and flattering."
                )
            }
        } else {
            when (bodyShape) {
                "Triangle" -> Pair(
                    "Structured blazer or layered look",
                    "Adds definition to upper body. Choose structured pieces."
                )
                "Inverted Triangle" -> Pair(
                    "Simple fitted shirt",
                    "Keeps focus balanced. Avoid busy patterns on top."
                )
                "Rectangle" -> Pair(
                    "Textured or layered tops",
                    "Adds dimension. Choose varied textures and layers."
                )
                "Trapezoid" -> Pair(
                    "Fitted polo or henley",
                    "Shows off athletic build. Choose fitted but comfortable."
                )
                else -> Pair(
                    "Classic button-down shirt",
                    "Timeless and versatile."
                )
            }
        }
    }

    // Color recommendations based on skin tone
    private fun getColorsForSkinTone(skinTone: String, eventType: String): Pair<List<String>, List<String>> {
        return when (skinTone.lowercase()) {
            "fair" -> when (eventType) {
                "party", "date" -> Pair(
                    listOf("Deep Navy", "Emerald Green", "Royal Blue", "Burgundy", "Ruby Red"),
                    listOf("Black", "Dark Denim", "Charcoal Grey", "Deep Purple")
                )
                "office" -> Pair(
                    listOf("Light Blue", "Soft Pink", "Lavender", "Mint Green", "Cream"),
                    listOf("Navy", "Grey", "Beige", "Taupe")
                )
                else -> Pair(
                    listOf("Pastels", "Jewel Tones", "Navy", "Forest Green", "Dusty Rose"),
                    listOf("Denim", "White", "Grey", "Black", "Charcoal")
                )
            }
            "medium" -> when (eventType) {
                "party", "date" -> Pair(
                    listOf("Coral", "Turquoise", "Fuchsia", "Gold", "Burnt Orange"),
                    listOf("Black", "Dark Blue", "Olive", "Chocolate Brown")
                )
                "office" -> Pair(
                    listOf("Warm Beige", "Coral", "Teal", "Soft Orange", "Warm Grey"),
                    listOf("Brown", "Navy", "Dark Grey", "Charcoal")
                )
                else -> Pair(
                    listOf("Warm Colors", "Earth Tones", "Coral", "Teal", "Mustard"),
                    listOf("Brown", "Khaki", "Olive", "Dark Denim", "Camel")
                )
            }
            "dark" -> when (eventType) {
                "party", "date" -> Pair(
                    listOf("Bright White", "Electric Blue", "Hot Pink", "Yellow", "Emerald"),
                    listOf("Black", "Dark Purple", "Navy", "Deep Red")
                )
                "office" -> Pair(
                    listOf("Crisp White", "Bright Coral", "Cobalt Blue", "Mustard", "Ivory"),
                    listOf("Charcoal", "Navy", "Black", "Dark Brown")
                )
                else -> Pair(
                    listOf("Bright Colors", "White", "Cobalt", "Fuchsia", "Tangerine"),
                    listOf("Black", "Dark Denim", "Navy", "Charcoal", "Deep Green")
                )
            }
            else -> Pair(
                listOf("Universal Colors", "Neutrals", "Blue Tones"),
                listOf("Denim", "Black", "Grey", "Navy")
            )
        }
    }

    fun getOutfitSuggestion(
        eventId: String,
        gender: String,
        skinTone: String,
        bodyShape: String
    ): OutfitSuggestion {
        val colors = getColorsForSkinTone(skinTone, eventId)
        val bottomRec = getBottomForBodyShape(bodyShape, gender, eventId)
        val topRec = getTopForBodyShape(bodyShape, gender, eventId)

        return when (eventId) {
            "party" -> if (gender == "Male") {
                OutfitSuggestion(
                    top = topRec.first,
                    topDetails = topRec.second,
                    bottom = bottomRec.first,
                    bottomDetails = bottomRec.second,
                    shoes = "Clean white sneakers or leather loafers",
                    hair = "Styled with light gel or natural textured look",
                    accessories = "Silver watch, minimal rings, cologne",
                    topColors = colors.first,
                    bottomColors = colors.second,
                    styleNotes = "Keep it sharp but comfortable. Your ${bodyShape} build looks great in fitted pieces."
                )
            } else {
                OutfitSuggestion(
                    top = topRec.first,
                    topDetails = topRec.second,
                    bottom = bottomRec.first,
                    bottomDetails = bottomRec.second,
                    shoes = "Heeled boots or stilettos in metallic or patent",
                    hair = "Loose curls or sleek high ponytail with volume",
                    accessories = "Statement earrings, clutch bag, layered bracelets",
                    topColors = colors.first,
                    bottomColors = colors.second,
                    styleNotes = "Your ${bodyShape} shape looks stunning in these proportions. Add confidence!"
                )
            }

            "office" -> if (gender == "Male") {
                OutfitSuggestion(
                    top = topRec.first,
                    topDetails = topRec.second,
                    bottom = bottomRec.first,
                    bottomDetails = bottomRec.second,
                    shoes = "Black or brown oxford shoes, polished",
                    hair = "Neat side part or professionally styled",
                    accessories = "Leather watch, tie (optional), briefcase",
                    topColors = colors.first,
                    bottomColors = colors.second,
                    styleNotes = "Professional and polished. These proportions work perfectly for your ${bodyShape} build."
                )
            } else {
                OutfitSuggestion(
                    top = topRec.first,
                    topDetails = topRec.second,
                    bottom = bottomRec.first,
                    bottomDetails = bottomRec.second,
                    shoes = "Black pumps or professional flats",
                    hair = "Low bun, straightened, or professional waves",
                    accessories = "Minimal jewelry, tote bag, simple watch",
                    topColors = colors.first,
                    bottomColors = colors.second,
                    styleNotes = "Elegant and professional. These cuts flatter your ${bodyShape} beautifully."
                )
            }

            "college" -> if (gender == "Male") {
                OutfitSuggestion(
                    top = topRec.first,
                    topDetails = topRec.second,
                    bottom = bottomRec.first,
                    bottomDetails = bottomRec.second,
                    shoes = "Sneakers or casual canvas shoes",
                    hair = "Natural messy, cap, or styled casually",
                    accessories = "Backpack, smartwatch, sunglasses",
                    topColors = colors.first,
                    bottomColors = colors.second,
                    styleNotes = "Comfortable campus style that suits your ${bodyShape} frame."
                )
            } else {
                OutfitSuggestion(
                    top = topRec.first,
                    topDetails = topRec.second,
                    bottom = bottomRec.first,
                    bottomDetails = bottomRec.second,
                    shoes = "White sneakers, ankle boots, or casual flats",
                    hair = "Ponytail, half-up style, or loose waves",
                    accessories = "Backpack, scrunchies, minimal jewelry",
                    topColors = colors.first,
                    bottomColors = colors.second,
                    styleNotes = "Effortless college style perfect for your ${bodyShape}."
                )
            }

            "date" -> if (gender == "Male") {
                OutfitSuggestion(
                    top = topRec.first,
                    topDetails = topRec.second,
                    bottom = bottomRec.first,
                    bottomDetails = bottomRec.second,
                    shoes = "Chelsea boots or clean dress shoes",
                    hair = "Styled with product, neat and groomed",
                    accessories = "Nice watch, subtle cologne, pocket square",
                    topColors = colors.first,
                    bottomColors = colors.second,
                    styleNotes = "Romantic yet confident. Perfect proportions for your ${bodyShape}."
                )
            } else {
                OutfitSuggestion(
                    top = topRec.first,
                    topDetails = topRec.second,
                    bottom = bottomRec.first,
                    bottomDetails = bottomRec.second,
                    shoes = "Heeled sandals or elegant boots",
                    hair = "Soft romantic waves or elegant updo",
                    accessories = "Delicate necklace, small purse, subtle perfume",
                    topColors = colors.first,
                    bottomColors = colors.second,
                    styleNotes = "Romantic and elegant. These styles enhance your ${bodyShape} beautifully."
                )
            }

            else -> if (gender == "Male") {
                OutfitSuggestion(
                    top = topRec.first,
                    topDetails = topRec.second,
                    bottom = bottomRec.first,
                    bottomDetails = bottomRec.second,
                    shoes = "Versatile sneakers or casual shoes",
                    hair = "Natural casual style",
                    accessories = "Watch, sunglasses",
                    topColors = colors.first,
                    bottomColors = colors.second,
                    styleNotes = "Versatile style that complements your ${bodyShape}."
                )
            } else {
                OutfitSuggestion(
                    top = topRec.first,
                    topDetails = topRec.second,
                    bottom = bottomRec.first,
                    bottomDetails = bottomRec.second,
                    shoes = "Comfortable flats or sneakers",
                    hair = "Natural casual style",
                    accessories = "Simple jewelry, casual bag",
                    topColors = colors.first,
                    bottomColors = colors.second,
                    styleNotes = "Effortlessly chic for your ${bodyShape}."
                )
            }
        }
    }
}