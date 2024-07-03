package com.serjshul.bubble.data

import com.serjshul.bubble.model.Article

val articleDemo = Article(
    id = "1",
    title = "Lady Bird",
    description = "Writer-director Greta Gerwig’s semiautobiographical Lady Bird is both generous " +
            "and joyous, but when it stings, it stings deep. At one point, Saoirse Ronan, as " +
            "disgruntled high school senior Christine, begs her mother, Laurie Metcalf’s Marion, " +
            "for a magazine at the supermarket: “It’s only \$3! I’m having a bad week!” Marion " +
            "brushes her off, and it could be the usual mom move of just saying no–until she " +
            "reaches the cash register and you realize that this respectable-looking suburban " +
            "woman can barely cover the family groceries.",
    creator = "Greta Gerwig",
    tags = listOf("Comedy", "Drama"),
    coverUrl = "https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2Ff629b099-4698-40c7-8c31-9f270dd5e243%2F5d76f7c9-51f5-4c2b-ac33-8a55fc4cab74%2Fcover_horizontal.jpg?id=0c09df19-d385-4d62-b782-ebe306a4de9a&table=block&spaceId=f629b099-4698-40c7-8c31-9f270dd5e243&width=1880&userId=db0bfdfe-2f6e-4646-b69c-7397cf9bd8d0&cache=v2",
    color = "#c22f2f"
)

val articlesDemo = listOf(
    Article(
        id = "1",
        title = "HIT ME HARD AND SOFT",
        description = "The pop star teams with her brother Finneas for their third album together, " +
                "expanding the cooly dark vision of their sound. It’s an honest and ambitious album " +
                "when it’s not inert and repetitive.",
        creator = "Billie Eilish",
        tags = listOf("Pop", "R&B"),
        coverUrl = "https://readrange.com/wp-content/uploads/elementor/thumbs/2-7-qo9bqja2cuxqfv906vv81m0sg3hdsh3ufo4uhy1hxs.jpg",
        color = "#46475c"
    ),
    Article(
        id = "2",
        title = "Poor Things",
        description = "The director of The Favourite teams up again with the fearless Hollywood star" +
                " in a funny, filthy and explosively inventive spin on Frankenstein",
        creator = "Yorgos Lanthimos",
        tags = listOf("Comedy", "Drama", "Romance"),
        coverUrl = "https://media.npr.org/assets/img/2023/12/07/poor-things-022_054_poorthings_ov_v30464704_fp_dpo_prohq_uhd-sdr_24_eng-166_eng-5120_a_ops9z8mjw_tiff53_rgb_custom-dbfbdcbf8bfa378f9047be6e3e78ff32b595dc84.jpg",
        color = "#719faf"
    ),
    Article(
        id = "3",
        title = "Radical Optimism",
        description = "Dua Lipa’s star power sounds muffled on her much-anticipated third album, " +
                "which has many interesting ideas for songs and a surprisingly low hit rate.",
        creator = "Dua Lipa",
        tags = listOf("Pop", "R&B"),
        coverUrl = "https://media.pitchfork.com/photos/65f1fd21a52ec7e13d476691/1:1/w_320,c_limit/Dua-Lipa-Radical-Optimism.jpg",
        color = "#055c62"
    ),
    Article(
        id = "4",
        title = "Dune",
        description = "Set on the desert planet Arrakis, Dune is the story of the boy Paul Atreides," +
                " heir to a noble family tasked with ruling an inhospitable world where the only " +
                "thing of value is the “spice” melange, a drug capable of extending life and " +
                "enhancing consciousness. Coveted across the known universe, melange is a prize " +
                "worth killing for...",
        creator = "Frank Herbert",
        tags = listOf("Science Fiction", "Fantasy", "Adventure"),
        coverUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7mbZab9zXvJQw9Wx7r6Jn54-SVk6KRBivwg&s",
        color = "#a46d58"
    ),
    Article(
        id = "5",
        title = "Fleabag",
        description = "Phoebe Waller-Bridge’s sitcom is full of people who are defeated and " +
                "unlikable – including her own character who masturbates to Barack Obama speeches. " +
                "But it’s utterly riveting",
        creator = "Phoebe Waller-Bridge",
        tags = listOf("Comedy", "Drama"),
        coverUrl = "https://pyxis.nymag.com/v1/imgs/ca3/511/51eb0123af72c1d58a45fb140c11a151e0-16-fleabag.2x.h473.w710.jpg",
        color = "#5f4f5b"
    )
)