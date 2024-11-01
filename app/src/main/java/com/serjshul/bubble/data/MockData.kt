package com.serjshul.bubble.data

import com.serjshul.bubble.model.collections.Article
import com.serjshul.bubble.model.collections.Paragraph
import com.serjshul.bubble.model.collections.Tag
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
        aids = listOf("45g2j23fd8723", "jkef5s7dfjk23", "223fgh425kj2g3"),
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
        aids = listOf("9882735230", "12895729800", "9723400864"),
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
        aids = emptyList(),
        cids = emptyList(),
        lids = emptyList(),
        followers = listOf("237465719432", "hjk3h6j41204fsd"),
        following = listOf("237465719432", "hjk3h6j41204fsd")
    )
)

val articles = listOf(
    Article(
        aid = "89287892374",
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
        year = 2018,
        tags = listOf("Comedy", "Drama"),
        quote = "Marion McPherson: I want you to be the very best version of yourself that you can be.\n" +
                "Christine 'Lady Bird' McPherson: What if this is the best version?",
        content = listOf(
            Paragraph(
                title = "The endearing shagginess and goofy imperfection",
                imageUrl = "https://static01.nyt.com/images/2017/11/03/arts/03LADYBIRD1/03LADYBIRD1-superJumbo-v3.jpg",
                text = "In the conversations that have ushered in its theatrical release, Lady Bird " +
                        "has been described as Greta Gerwig’s directorial debut. Yet, with seven " +
                        "screenplays to her name and a co-director credit on Joe Swanberg’s 2008 " +
                        "mumblecore drama Nights and Weekends, it’s not as though she is new to " +
                        "making movies. Still, the endearing shagginess and goofy imperfection " +
                        "associated with Gerwig’s work in front of and behind the camera are " +
                        "noticeably absent in this polished, muscular, Oscar-nominated debut proper. " +
                        "Not a criticism exactly, but perhaps an explanation for why the film has " +
                        "managed to transcend its indie dramedy trappings."
            ),
            Paragraph(
                title = "Lady Bird’s coming of age",
                imageUrl = "https://compote.slate.com/images/65093ba9-f66a-4912-92a7-090af2f5ef20.jpeg?crop=1560%2C1040%2Cx0%2Cy0",
                text = "Set in Sacramento, California in 2002, it centres on Christine “Lady Bird” " +
                        "McPherson (Saoirse Ronan), a high-schooler who behaves with the unselfconscious " +
                        "conviction of a young kid. She insists she be called by her “given” name of " +
                        "Lady Bird (“It was given to me, by me”), extols the benefits of bathtub " +
                        "masturbation to her best friend Julie while eating communion wafers (“They’re " +
                        "not consecrated!”) and jabs her crush in the shoulder, asking him to dance. " +
                        "Gerwig’s pink-haired protagonist is seemingly unencumbered by the awkwardness " +
                        "and fear that dogs most teenagers on the cusp of change. This cusp-ness " +
                        "is where the film’s magic resides; its joyful, forward-rushing narrative " +
                        "rhythm captures the feeling of adolescence ending before it has barely " +
                        "begun.\nThough the film gives us milestones from Lady Bird’s coming of age, " +
                        "its key preoccupation is the jagged relationship between Lady Bird and her " +
                        "mother Marion (Laurie Metcalf), an overworked nurse whose blunt pragmatism " +
                        "butts heads with her daughter’s dreams of moving to New York, “where culture " +
                        "is”. The scenes between Ronan and Metcalf are electric; Gerwig maps their " +
                        "inability to communicate with excruciating veracity."
            ),
            Paragraph(
                title = "The small things that make a good movie great",
                imageUrl = null,
                text = "However, it is Gerwig’s tidy pacing, vividly drawn characters (see Timothée " +
                        "Chalamet’s bit-part as a floppy-haired mobile phone sceptic who smokes " +
                        "roll-ups and “trying as much as possible not to participate in our economy”), " +
                        "and eye for period detail (like her use of the Dave Matthews Band) that " +
                        "mark her as a keen observer of the small things that make a good movie great. " +
                        "Her writing is alive with beautiful bon mots, but also an acute sense of " +
                        "class anxiety in post-9/11, pre-financial crash suburban America, with " +
                        "the McPherson family’s worries about Lady Bird’s tuition fees given as " +
                        "much screen time as her romantic exploits."
            )
        ),
        coverUrl = "https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2Ff629b099-4698-40c7-8c31-9f270dd5e243%2F5d76f7c9-51f5-4c2b-ac33-8a55fc4cab74%2Fcover_horizontal.jpg?id=0c09df19-d385-4d62-b782-ebe306a4de9a&table=block&spaceId=f629b099-4698-40c7-8c31-9f270dd5e243&width=1880&userId=db0bfdfe-2f6e-4646-b69c-7397cf9bd8d0&cache=v2",
        color = "#c22f2f",
        backgroundUrl = "https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2Ff629b099-4698-40c7-8c31-9f270dd5e243%2Fe25474fc-297a-4431-b785-639e62dd1937%2Fbackground.jpg?table=block&id=0c09df19-d385-4d62-b782-ebe306a4de9a&spaceId=f629b099-4698-40c7-8c31-9f270dd5e243&width=2000&userId=db0bfdfe-2f6e-4646-b69c-7397cf9bd8d0&cache=v2",
        uid = "237465719432",
        owner = users[0],
        date = Date(),
        comments = emptyList()
    ),
    Article(
        aid = "7656294214",
        title = "HIT ME HARD AND SOFT",
        description = "The pop star teams with her brother Finneas for their third album together, " +
                "expanding the cooly dark vision of their sound. It’s an honest and ambitious album " +
                "when it’s not inert and repetitive.",
        creator = "Billie Eilish",
        type = "Music",
        year = 2024,
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
        aid = "56288952340",
        title = "Poor Things",
        description = "The director of The Favourite teams up again with the fearless Hollywood star" +
                " in a funny, filthy and explosively inventive spin on Frankenstein",
        creator = "Yorgos Lanthimos",
        type = "Movie",
        year = 2023,
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
        aid = "9882735230",
        title = "Radical Optimism",
        description = "Dua Lipa’s star power sounds muffled on her much-anticipated third album, " +
                "which has many interesting ideas for songs and a surprisingly low hit rate.",
        creator = "Dua Lipa",
        type = "Music",
        year = 2024,
        tags = listOf("Pop", "R&B"),
        coverUrl = "https://hips.hearstapps.com/hmg-prod/images/dua-lipa-radical-optimism-release-date-track-list-660fd4e9658a1.jpg?crop=1xw:0.5625xh;center,top",
        color = "#055c62",
        backgroundUrl = "https://www.rollingstone.com/wp-content/uploads/2024/05/dua-lipa-album-is-out.jpg?w=1581&h=1054&crop=1",
        uid = "hjk3h6j41204fsd",
        owner = users[1],
        date = Date()
    ),
    Article(
        aid = "12895729800",
        title = "Dune",
        description = "Set on the desert planet Arrakis, Dune is the story of the boy Paul Atreides," +
                " heir to a noble family tasked with ruling an inhospitable world where the only " +
                "thing of value is the “spice” melange, a drug capable of extending life and " +
                "enhancing consciousness. Coveted across the known universe, melange is a prize " +
                "worth killing for...",
        creator = "Frank Herbert",
        type = "Movie",
        year = 2021,
        tags = listOf("Science Fiction", "Fantasy", "Adventure"),
        coverUrl = "https://static1.colliderimages.com/wordpress/wp-content/uploads/2021/08/dune-poster-social-featured.jpg",
        color = "#a46d58",
        uid = "hjk3h6j41204fsd",
        owner = users[1],
        date = Date()
    ),
    Article(
        aid = "9723400864",
        title = "Fleabag",
        description = "Phoebe Waller-Bridge’s sitcom is full of people who are defeated and " +
                "unlikable – including her own character who masturbates to Barack Obama speeches. " +
                "But it’s utterly riveting",
        creator = "Phoebe Waller-Bridge",
        type = "Series",
        year = 2016,
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
        aid = "89287892374",
        uid = "237465719432",
        isReposted = false,
        date = Date()
    ),
    Post(
        pid = "jkef5s7dfjk23",
        aid = "7656294214",
        uid = "237465719432",
        isReposted = false,
        date = Date()
    ),
    Post(
        pid = "223fgh425kj2g3",
        aid = "56288952340",
        uid = "237465719432",
        isReposted = false,
        date = Date()
    ),
    Post(
        pid = "jh34k5hjk45h",
        aid = "9882735230",
        uid = "hjk3h6j41204fsd",
        isReposted = false,
        date = Date()
    ),
    Post(
        pid = "d234gh5h43jh6g",
        aid = "12895729800",
        uid = "hjk3h6j41204fsd",
        isReposted = false,
        date = Date()
    ),
    Post(
        pid = "23ghf5h34m6k3jh5",
        aid = "9723400864",
        uid = "hjk3h6j41204fsd",
        isReposted = false,
        date = Date()
    )
)

val comment = Comment(
    cid = "j4g5345hkj34h5kj3h246",
    aid = "9882735230",
    article = articles[3],
    uid = "354h6g13fh25jk7l73",
    nickname = "fabkins4u",
    photoUrl = "https://sun9-69.userapi.com/impg/00uihckUHW4fgg4-ZdihyAPUFnH1FtNmwBLSpA/lkt1MWMkUes.jpg?size=1029x1280&quality=95&sign=e294ed0dcb5bdf230f392ba9ba78a988&type=album",
    text = "la-la-la demo comment la-la-la demo comment la-la-la demo comment la-la-la demo comment la-la-la demo comment",
    repliedCid = null,
    date = Date(),
    likedBy = emptyList()
)

val tags = listOf(
    Tag(tid = "1ertf", type = "Film", value = "Drama"),
    Tag(tid = "2jghg", type = "Film", value = "Mystery"),
    Tag(tid = "3sdfe", type = "Film", value = "Thriller"),
    Tag(tid = "iuou4", type = "Film", value = "Fantasy"),
    Tag(tid = "5rtys", type = "Film", value = "Horror"),
    Tag(tid = "6regh", type = "Film", value = "Comedy"),
    Tag(tid = "7dfgr", type = "Film", value = "Romance"),
    Tag(tid = "8rtyg", type = "Film", value = "Crime"),
    Tag(tid = "9rtyy", type = "Film", value = "Sci-Fi"),
    Tag(tid = "10uut", type = "Film", value = "Biography"),
    Tag(tid = "1ytu1", type = "Film", value = "Historical drama"),
    Tag(tid = "1hhj2", type = "Film", value = "Musical"),
    Tag(tid = "13dgk", type = "Film", value = "War"),
    Tag(tid = "43614", type = "Film", value = "Noir"),
    Tag(tid = "1gfh5", type = "Film", value = "Western"),
    Tag(tid = "1sd6f", type = "Book", value = "Fantasy"),
    Tag(tid = "2fg4j", type = "Book", value = "Science Fiction"),
    Tag(tid = "3bvnt", type = "Book", value = "Dystopian"),
    Tag(tid = "4iert", type = "Book", value = "Action"),
    Tag(tid = "5dfgd", type = "Book", value = "Adventure"),
    Tag(tid = "7tyud", type = "Book", value = "Thriller"),
    Tag(tid = "8dfgg", type = "Book", value = "Suspense"),
    Tag(tid = "9dfgd", type = "Book", value = "Historical Fiction"),
    Tag(tid = "10uyi", type = "Book", value = "Classics"),
    Tag(tid = "11uir", type = "Book", value = "Graphic Novel"),
    Tag(tid = "12dfg", type = "Book", value = "Comic Book"),
    Tag(tid = "13aer", type = "Book", value = "Detective"),
    Tag(tid = "1", type = "Music", value = "Rock"),
    Tag(tid = "2", type = "Music", value = "Pop"),
    Tag(tid = "3", type = "Music", value = "Jazz"),
    Tag(tid = "4", type = "Music", value = "Classical"),
    Tag(tid = "5", type = "Music", value = "Hip-hop"),
    Tag(tid = "6", type = "Music", value = "Reggae"),
    Tag(tid = "7", type = "Music", value = "Blues"),
    Tag(tid = "8", type = "Music", value = "Country"),
    Tag(tid = "9", type = "Music", value = "Electronic"),
    Tag(tid = "10", type = "Music", value = "Metal"),
    Tag(tid = "11", type = "Music", value = "Folk"),
    Tag(tid = "12", type = "Music", value = "Indie"),
    Tag(tid = "13", type = "Music", value = "Soul"),
    Tag(tid = "14", type = "Music", value = "R&B"),
    Tag(tid = "15", type = "Music", value = "Gospel"),
    Tag(tid = "16", type = "Music", value = "Alternative"),
    Tag(tid = "17", type = "Music", value = "Punk"),
    Tag(tid = "18", type = "Music", value = "Ska"),
    Tag(tid = "19", type = "Music", value = "Latin"),
    Tag(tid = "20", type = "Music", value = "House"),
    Tag(tid = "21", type = "Music", value = "Trance"),
    Tag(tid = "22", type = "Music", value = "Disco"),
    Tag(tid = "23", type = "Music", value = "K-Pop"),
    Tag(tid = "24", type = "Music", value = "Grunge"),
    Tag(tid = "25", type = "Music", value = "Synthpop"),
    Tag(tid = "26", type = "Music", value = "New Wave"),
    Tag(tid = "27", type = "Music", value = "Ambient"),
    Tag(tid = "28", type = "Music", value = "Jazz Fusion"),
    Tag(tid = "29", type = "Music", value = "Progressive Rock"),
    Tag(tid = "30", type = "Music", value = "Post-Rock")
)

fun getArticleById(articleId: String?): Article? {
    if (articleId == null) {
        return null
    }
    for (article in articles) {
        if (article.aid == articleId) {
            val result = article
            result.isLiked = false
            result.isReposted = false
            return result
        }
    }
    return null

    // TODO: check if it is liked or reposted
}

fun searchTags(query: String): List<Tag> {
    return tags.filter { it.value!!.contains(query, ignoreCase = true) }
}