package com.serjshul.bubble.data

import com.serjshul.bubble.model.Article
import com.serjshul.bubble.model.Comment
import com.serjshul.bubble.model.User
import java.util.Date

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
    type = "Movie",
    tags = listOf("Comedy", "Drama"),
    coverUrl = "https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2Ff629b099-4698-40c7-8c31-9f270dd5e243%2F5d76f7c9-51f5-4c2b-ac33-8a55fc4cab74%2Fcover_horizontal.jpg?id=0c09df19-d385-4d62-b782-ebe306a4de9a&table=block&spaceId=f629b099-4698-40c7-8c31-9f270dd5e243&width=1880&userId=db0bfdfe-2f6e-4646-b69c-7397cf9bd8d0&cache=v2",
    color = "#c22f2f",
    backgroundUrl = "https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2Ff629b099-4698-40c7-8c31-9f270dd5e243%2Fe25474fc-297a-4431-b785-639e62dd1937%2Fbackground.jpg?table=block&id=0c09df19-d385-4d62-b782-ebe306a4de9a&spaceId=f629b099-4698-40c7-8c31-9f270dd5e243&width=2000&userId=db0bfdfe-2f6e-4646-b69c-7397cf9bd8d0&cache=v2",
    uid = "",
    owner = User(
        uid = "uid",
        photoUrl = "https://sun9-13.userapi.com/impg/0hcngQRHKeTQupgE4o4CD5AYE0ezO-Jta_MTDg/e9YqYdkAXVw.jpg?size=1080x1350&quality=95&sign=468e9c0b5d080643534757230681000e&type=album",
        nickname = "serjshul"
    ),
    date = Date(),
    comments = listOf(
        Comment(
            text = "love this movie so much",
            owner = User(
                uid = "uid",
                nickname = "serjshul"
            )
        ),
        Comment(
            text = "OMG THATS AWESOME",
            owner = User(
                uid = "uid",
                nickname = "kdukality"
            )
        ),
        Comment(
            text = "Saw this!!",
            owner = User(
                uid = "uid",
                nickname = "lalari"
            )
        )
    )
)

val articlesDemo = listOf(
    Article(
        id = "1",
        title = "HIT ME HARD AND SOFT",
        description = "The pop star teams with her brother Finneas for their third album together, " +
                "expanding the cooly dark vision of their sound. It’s an honest and ambitious album " +
                "when it’s not inert and repetitive.",
        creator = "Billie Eilish",
        type = "Music",
        tags = listOf("Pop", "R&B"),
        coverUrl = "https://billboard.it/wp-content/uploads/2024/04/billie-eilish-hit-me-hard-and-soft-tracklist-album-1.jpg",
        color = "#46475c",
        backgroundUrl = "https://readrange.com/wp-content/uploads/elementor/thumbs/2-7-qo9bqja2cuxqfv906vv81m0sg3hdsh3ufo4uhy1hxs.jpg",
        uid = "",
        owner = User(
            uid = "uid",
            photoUrl = "https://sun9-13.userapi.com/impg/0hcngQRHKeTQupgE4o4CD5AYE0ezO-Jta_MTDg/e9YqYdkAXVw.jpg?size=1080x1350&quality=95&sign=468e9c0b5d080643534757230681000e&type=album",
            nickname = "serjshul"
        ),
        date = Date()
    ),
    Article(
        id = "2",
        title = "Poor Things",
        description = "The director of The Favourite teams up again with the fearless Hollywood star" +
                " in a funny, filthy and explosively inventive spin on Frankenstein",
        creator = "Yorgos Lanthimos",
        type = "Movie",
        tags = listOf("Comedy", "Drama", "Romance"),
        coverUrl = "https://www.lab111.nl/wp-content/uploads/2024/01/Poor-Things-Banner-2.jpg",
        color = "#719faf",
        backgroundUrl = "https://media.npr.org/assets/img/2023/12/07/poor-things-022_054_poorthings_ov_v30464704_fp_dpo_prohq_uhd-sdr_24_eng-166_eng-5120_a_ops9z8mjw_tiff53_rgb_custom-dbfbdcbf8bfa378f9047be6e3e78ff32b595dc84.jpg",
        uid = "",
        owner = User(
            uid = "uid",
            photoUrl = "https://sun9-13.userapi.com/impg/0hcngQRHKeTQupgE4o4CD5AYE0ezO-Jta_MTDg/e9YqYdkAXVw.jpg?size=1080x1350&quality=95&sign=468e9c0b5d080643534757230681000e&type=album",
            nickname = "serjshul"
        ),
        date = Date()
    ),
    Article(
        id = "3",
        title = "Radical Optimism",
        description = "Dua Lipa’s star power sounds muffled on her much-anticipated third album, " +
                "which has many interesting ideas for songs and a surprisingly low hit rate.",
        creator = "Dua Lipa",
        type = "Music",
        tags = listOf("Pop", "R&B"),
        coverUrl = "https://hips.hearstapps.com/hmg-prod/images/dua-lipa-radical-optimism-release-date-track-list-660fd4e9658a1.jpg?crop=1xw:0.5625xh;center,top",
        color = "#055c62",
        backgroundUrl = "https://www.rollingstone.com/wp-content/uploads/2024/05/dua-lipa-album-is-out.jpg?w=1581&h=1054&crop=1",
        uid = "",
        owner = User(
            uid = "uid",
            photoUrl = "https://sun9-13.userapi.com/impg/0hcngQRHKeTQupgE4o4CD5AYE0ezO-Jta_MTDg/e9YqYdkAXVw.jpg?size=1080x1350&quality=95&sign=468e9c0b5d080643534757230681000e&type=album",
            nickname = "serjshul"
        ),
        date = Date()
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
        type = "Movie",
        tags = listOf("Science Fiction", "Fantasy", "Adventure"),
        coverUrl = "https://static1.colliderimages.com/wordpress/wp-content/uploads/2021/08/dune-poster-social-featured.jpg",
        color = "#a46d58",
        backgroundUrl = "https://platform.vox.com/wp-content/uploads/sites/2/chorus/uploads/chorus_asset/file/22945150/dune1.jpeg?quality=90&strip=all&crop=0,2.4869791666667,100,66.666666666667",
        uid = "",
        owner = User(
            uid = "uid",
            photoUrl = "https://sun9-13.userapi.com/impg/0hcngQRHKeTQupgE4o4CD5AYE0ezO-Jta_MTDg/e9YqYdkAXVw.jpg?size=1080x1350&quality=95&sign=468e9c0b5d080643534757230681000e&type=album",
            nickname = "serjshul"
        ),
        date = Date()
    ),
    Article(
        id = "5",
        title = "Fleabag",
        description = "Phoebe Waller-Bridge’s sitcom is full of people who are defeated and " +
                "unlikable – including her own character who masturbates to Barack Obama speeches. " +
                "But it’s utterly riveting",
        creator = "Phoebe Waller-Bridge",
        type = "Series",
        tags = listOf("Comedy", "Drama"),
        coverUrl = "https://media.myshows.me/shows/760/d/9d/d9df55dc471adbc0376a47f398cafa82.jpg",
        color = "#5f4f5b",
        backgroundUrl = "https://media.vanityfair.com/photos/593f04ebe9423741a1f17696/master/pass/Phoebe-Waller-Bridge-Fleabag.jpg",
        uid = "",
        owner = User(
            uid = "uid",
            photoUrl = "https://sun9-13.userapi.com/impg/0hcngQRHKeTQupgE4o4CD5AYE0ezO-Jta_MTDg/e9YqYdkAXVw.jpg?size=1080x1350&quality=95&sign=468e9c0b5d080643534757230681000e&type=album",
            nickname = "serjshul"
        ),
        date = Date()
    )
)