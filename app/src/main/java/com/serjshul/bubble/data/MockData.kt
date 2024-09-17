package com.serjshul.bubble.data

import com.serjshul.bubble.model.collections.Article
import com.serjshul.bubble.model.collections.User
import com.serjshul.bubble.model.subcollections.Comment
import com.serjshul.bubble.model.subcollections.Post
import java.util.Date

val users = listOf(
    User(
        uid = "237465719432",
        nickname = "serjshul",
        name = "Serge, 21",
        bio = "Graduated from SPbSTU, read a lot of books just to download yet another app",
        dateOfBirth = Date(),
        photoUrl = "https://sun9-13.userapi.com/impg/0hcngQRHKeTQupgE4o4CD5AYE0ezO-Jta_MTDg/e9YqYdkAXVw.jpg?size=1080x1350&quality=95&sign=468e9c0b5d080643534757230681000e&type=album",
        pids = listOf("45g2j23fd8723", "jkef5s7dfjk23", "223fgh425kj2g3"),
        cids = emptyList(),
        lids = emptyList(),
        followers = listOf("hjk3h6j41204fsd", "354h6g13fh25jk7l73"),
        following = listOf("hjk3h6j41204fsd", "354h6g13fh25jk7l73")
    ),
    User(
        uid = "hjk3h6j41204fsd",
        nickname = "laralara",
        name = "Lara Porgeson",
        bio = "The best things come from living outside of your comfort zone",
        dateOfBirth = Date(),
        photoUrl = "https://sun9-33.userapi.com/impg/OCpXCGU_onFqorHoOKdIpd-PpTTv9LVLVf7GUw/-YnVlqx9i4s.jpg?size=2560x2560&quality=95&sign=c438255c1a90959632cfdbdba900bbb4&type=album",
        pids = listOf("9882735230", "12895729800", "9723400864"),
        cids = emptyList(),
        lids = emptyList(),
        followers = listOf("237465719432", "354h6g13fh25jk7l73"),
        following = listOf("237465719432", "354h6g13fh25jk7l73")
    ),
    User(
        uid = "354h6g13fh25jk7l73",
        nickname = "fabkins4u",
        name = "Samanta",
        bio = "I’m a cupcake in search of her stud muffin",
        dateOfBirth = Date(),
        photoUrl = "https://sun9-69.userapi.com/impg/00uihckUHW4fgg4-ZdihyAPUFnH1FtNmwBLSpA/lkt1MWMkUes.jpg?size=1029x1280&quality=95&sign=e294ed0dcb5bdf230f392ba9ba78a988&type=album",
        pids = emptyList(),
        cids = emptyList(),
        lids = emptyList(),
        followers = listOf("237465719432", "hjk3h6j41204fsd"),
        following = listOf("237465719432", "hjk3h6j41204fsd")
    )
)

val articles = listOf(
    Article(
        rid = "89287892374",
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
        quote = "Marion McPherson: I want you to be the very best version of yourself that you can be.\n" +
                "Christine 'Lady Bird' McPherson: What if this is the best version?",
        coverUrl = "https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2Ff629b099-4698-40c7-8c31-9f270dd5e243%2F5d76f7c9-51f5-4c2b-ac33-8a55fc4cab74%2Fcover_horizontal.jpg?id=0c09df19-d385-4d62-b782-ebe306a4de9a&table=block&spaceId=f629b099-4698-40c7-8c31-9f270dd5e243&width=1880&userId=db0bfdfe-2f6e-4646-b69c-7397cf9bd8d0&cache=v2",
        color = "#c22f2f",
        backgroundUrl = "https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2Ff629b099-4698-40c7-8c31-9f270dd5e243%2Fe25474fc-297a-4431-b785-639e62dd1937%2Fbackground.jpg?table=block&id=0c09df19-d385-4d62-b782-ebe306a4de9a&spaceId=f629b099-4698-40c7-8c31-9f270dd5e243&width=2000&userId=db0bfdfe-2f6e-4646-b69c-7397cf9bd8d0&cache=v2",
        uid = "237465719432",
        owner = users[0],
        date = Date(),
        comments = emptyList()
    ),
    Article(
        rid = "7656294214",
        title = "HIT ME HARD AND SOFT",
        description = "The pop star teams with her brother Finneas for their third album together, " +
                "expanding the cooly dark vision of their sound. It’s an honest and ambitious album " +
                "when it’s not inert and repetitive.",
        creator = "Billie Eilish",
        type = "Music",
        tags = listOf("Pop", "R&B"),
        quote = "PEOPLE SAY I LOOK HAPPY JUST BECAUSE I GOT SKINNY BUT THE OLD ME IS STILL ME AND MAYBE THE REAL ME AND I THINK SHE’S PRETTY",
        coverUrl = "https://billboard.it/wp-content/uploads/2024/04/billie-eilish-hit-me-hard-and-soft-tracklist-album-1.jpg",
        color = "#46475c",
        backgroundUrl = "https://readrange.com/wp-content/uploads/elementor/thumbs/2-7-qo9bqja2cuxqfv906vv81m0sg3hdsh3ufo4uhy1hxs.jpg",
        uid = "237465719432",
        owner = users[0],
        date = Date()
    ),
    Article(
        rid = "56288952340",
        title = "Poor Things",
        description = "The director of The Favourite teams up again with the fearless Hollywood star" +
                " in a funny, filthy and explosively inventive spin on Frankenstein",
        creator = "Yorgos Lanthimos",
        type = "Movie",
        tags = listOf("Comedy", "Drama", "Romance"),
        quote = "Dr. Godwin Baxter: My father once told me, \"Always carve with compassion.\" He was a fucking idiot, but it's not bad advice.",
        coverUrl = "https://www.lab111.nl/wp-content/uploads/2024/01/Poor-Things-Banner-2.jpg",
        color = "#719faf",
        backgroundUrl = "https://media.npr.org/assets/img/2023/12/07/poor-things-022_054_poorthings_ov_v30464704_fp_dpo_prohq_uhd-sdr_24_eng-166_eng-5120_a_ops9z8mjw_tiff53_rgb_custom-dbfbdcbf8bfa378f9047be6e3e78ff32b595dc84.jpg",
        uid = "237465719432",
        owner = users[0],
        date = Date()
    ),
    Article(
        rid = "9882735230",
        title = "Radical Optimism",
        description = "Dua Lipa’s star power sounds muffled on her much-anticipated third album, " +
                "which has many interesting ideas for songs and a surprisingly low hit rate.",
        creator = "Dua Lipa",
        type = "Music",
        tags = listOf("Pop", "R&B"),
        coverUrl = "https://hips.hearstapps.com/hmg-prod/images/dua-lipa-radical-optimism-release-date-track-list-660fd4e9658a1.jpg?crop=1xw:0.5625xh;center,top",
        color = "#055c62",
        backgroundUrl = "https://www.rollingstone.com/wp-content/uploads/2024/05/dua-lipa-album-is-out.jpg?w=1581&h=1054&crop=1",
        uid = "hjk3h6j41204fsd",
        owner = users[1],
        date = Date()
    ),
    Article(
        rid = "12895729800",
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
        uid = "hjk3h6j41204fsd",
        owner = users[1],
        date = Date()
    ),
    Article(
        rid = "9723400864",
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
        uid = "hjk3h6j41204fsd",
        owner = users[1],
        date = Date()
    )
)

val posts = listOf(
    Post(
        pid = "45g2j23fd8723",
        rid = "89287892374",
        uid = "237465719432",
        isReposted = false,
        date = Date()
    ),
    Post(
        pid = "jkef5s7dfjk23",
        rid = "7656294214",
        uid = "237465719432",
        isReposted = false,
        date = Date()
    ),
    Post(
        pid = "223fgh425kj2g3",
        rid = "56288952340",
        uid = "237465719432",
        isReposted = false,
        date = Date()
    ),
    Post(
        pid = "jh34k5hjk45h",
        rid = "9882735230",
        uid = "hjk3h6j41204fsd",
        isReposted = false,
        date = Date()
    ),
    Post(
        pid = "d234gh5h43jh6g",
        rid = "12895729800",
        uid = "hjk3h6j41204fsd",
        isReposted = false,
        date = Date()
    ),
    Post(
        pid = "23ghf5h34m6k3jh5",
        rid = "9723400864",
        uid = "hjk3h6j41204fsd",
        isReposted = false,
        date = Date()
    )
)

val comment = Comment(
    cid = "j4g5345hkj34h5kj3h246",
    rid = "9882735230",
    article = articles[3],
    uid = "354h6g13fh25jk7l73",
    nickname = "fabkins4u",
    photoUrl = "https://sun9-69.userapi.com/impg/00uihckUHW4fgg4-ZdihyAPUFnH1FtNmwBLSpA/lkt1MWMkUes.jpg?size=1029x1280&quality=95&sign=e294ed0dcb5bdf230f392ba9ba78a988&type=album",
    text = "la-la-la demo comment la-la-la demo comment la-la-la demo comment la-la-la demo comment la-la-la demo comment",
    repliedCid = null,
    date = Date(),
    likedBy = emptyList()
)