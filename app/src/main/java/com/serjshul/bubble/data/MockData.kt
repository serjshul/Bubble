package com.serjshul.bubble.data

import com.serjshul.bubble.model.collections.Article
import com.serjshul.bubble.model.collections.Paragraph
import com.serjshul.bubble.model.subcollections.Tag
import com.serjshul.bubble.model.collections.User
import com.serjshul.bubble.model.subcollections.Comment
import com.serjshul.bubble.model.subcollections.Post
import com.serjshul.bubble.model.subcollections.Type
import java.util.Date

val users = listOf(
    User(
        id = "237465719432",
        nickname = "serjshul",
        name = "Serge, 21",
        bio = "Graduated from SPbSTU, read a lot of books just to download yet another app",
        dateOfBirth = Date(),
        photoUrl = "https://sun9-13.userapi.com/impg/0hcngQRHKeTQupgE4o4CD5AYE0ezO-Jta_MTDg/e9YqYdkAXVw.jpg?size=1080x1350&quality=95&sign=468e9c0b5d080643534757230681000e&type=album",
        articleIds = listOf("45g2j23fd8723", "jkef5s7dfjk23", "223fgh425kj2g3"),
        commentIds = emptyList(),
        likeIds = emptyList(),
        followers = listOf("hjk3h6j41204fsd", "354h6g13fh25jk7l73"),
        following = listOf("hjk3h6j41204fsd", "354h6g13fh25jk7l73")
    ),
    User(
        id = "hjk3h6j41204fsd",
        nickname = "laralara",
        name = "Lara Porgeson",
        bio = "The best things come from living outside of your comfort zone",
        dateOfBirth = Date(),
        photoUrl = "https://sun9-33.userapi.com/impg/OCpXCGU_onFqorHoOKdIpd-PpTTv9LVLVf7GUw/-YnVlqx9i4s.jpg?size=2560x2560&quality=95&sign=c438255c1a90959632cfdbdba900bbb4&type=album",
        articleIds = listOf("9882735230", "12895729800", "9723400864"),
        commentIds = emptyList(),
        likeIds = emptyList(),
        followers = listOf("237465719432", "354h6g13fh25jk7l73"),
        following = listOf("237465719432", "354h6g13fh25jk7l73")
    ),
    User(
        id = "354h6g13fh25jk7l73",
        nickname = "fabkins4u",
        name = "Samanta",
        bio = "I’m a cupcake in search of her stud muffin",
        dateOfBirth = Date(),
        photoUrl = "https://sun9-69.userapi.com/impg/00uihckUHW4fgg4-ZdihyAPUFnH1FtNmwBLSpA/lkt1MWMkUes.jpg?size=1029x1280&quality=95&sign=e294ed0dcb5bdf230f392ba9ba78a988&type=album",
        articleIds = emptyList(),
        commentIds = emptyList(),
        likeIds = emptyList(),
        followers = listOf("237465719432", "hjk3h6j41204fsd"),
        following = listOf("237465719432", "hjk3h6j41204fsd")
    )
)

val articles = listOf(
    Article(
        id = "89287892374",
        title = "Lady Bird",
        description = "Writer-director Greta Gerwig’s semiautobiographical Lady Bird is both generous " +
                "and joyous, but when it stings, it stings deep. At one point, Saoirse Ronan, as " +
                "disgruntled high school senior Christine, begs her mother, Laurie Metcalf’s Marion, " +
                "for a magazine at the supermarket: “It’s only \$3! I’m having a bad week!” Marion " +
                "brushes her off, and it could be the usual mom move of just saying no–until she " +
                "reaches the cash register and you realize that this respectable-looking suburban " +
                "woman can barely cover the family groceries.",
        creator = "Greta Gerwig",
        type = Type(id = "", value = "Movie"),
        year = 2018,
        tags = listOf(
            Tag(id = "1ertf", typeId = "Film", value = "Drama"),
            Tag(id = "6regh", typeId = "Film", value = "Comedy")
        ),
        quote = "Marion McPherson: I want you to be the very best version of yourself that you can be.\n" +
                "Christine 'Lady Bird' McPherson: What if this is the best version?",
        content = listOf(
            Paragraph(
                title = "The endearing shagginess and goofy imperfection",
                imageUri = "https://static01.nyt.com/images/2017/11/03/arts/03LADYBIRD1/03LADYBIRD1-superJumbo-v3.jpg",
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
                imageUri = "https://compote.slate.com/images/65093ba9-f66a-4912-92a7-090af2f5ef20.jpeg?crop=1560%2C1040%2Cx0%2Cy0",
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
                imageUri = null,
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
        coverUri = "https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2Ff629b099-4698-40c7-8c31-9f270dd5e243%2F5d76f7c9-51f5-4c2b-ac33-8a55fc4cab74%2Fcover_horizontal.jpg?id=0c09df19-d385-4d62-b782-ebe306a4de9a&table=block&spaceId=f629b099-4698-40c7-8c31-9f270dd5e243&width=1880&userId=db0bfdfe-2f6e-4646-b69c-7397cf9bd8d0&cache=v2",
        color = "#c22f2f",
        backgroundUri = "https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2Ff629b099-4698-40c7-8c31-9f270dd5e243%2Fe25474fc-297a-4431-b785-639e62dd1937%2Fbackground.jpg?table=block&id=0c09df19-d385-4d62-b782-ebe306a4de9a&spaceId=f629b099-4698-40c7-8c31-9f270dd5e243&width=2000&userId=db0bfdfe-2f6e-4646-b69c-7397cf9bd8d0&cache=v2",
        userId = "237465719432",
        owner = users[0],
        date = Date(),
        comments = emptyList()
    ),
    Article(
        id = "7656294214",
        title = "HIT ME HARD AND SOFT",
        description = "The pop star teams with her brother Finneas for their third album together, " +
                "expanding the cooly dark vision of their sound. It’s an honest and ambitious album " +
                "when it’s not inert and repetitive.",
        creator = "Billie Eilish",
        type = Type(id = "", value = "Music"),
        year = 2024,
        tags = listOf(
            Tag(id = "2", typeId = "Music", value = "Pop"),
            Tag(id = "14", typeId = "Music", value = "R&B")
        ),
        quote = "PEOPLE SAY I LOOK HAPPY JUST BECAUSE I GOT SKINNY BUT THE OLD ME IS STILL ME AND MAYBE THE REAL ME AND I THINK SHE’S PRETTY",
        coverUri = "https://billboard.it/wp-content/uploads/2024/04/billie-eilish-hit-me-hard-and-soft-tracklist-album-1.jpg",
        color = "#46475c",
        backgroundUri = "https://readrange.com/wp-content/uploads/elementor/thumbs/2-7-qo9bqja2cuxqfv906vv81m0sg3hdsh3ufo4uhy1hxs.jpg",
        userId = "237465719432",
        owner = users[0],
        date = Date()
    ),
    Article(
        id = "56288952340",
        title = "Poor Things",
        description = "The director of The Favourite teams up again with the fearless Hollywood star" +
                " in a funny, filthy and explosively inventive spin on Frankenstein",
        creator = "Yorgos Lanthimos",
        type = Type(id = "", value = "Movie"),
        year = 2023,
        tags = listOf(
            Tag(id = "1ertf", typeId = "Film", value = "Drama"),
            Tag(id = "6regh", typeId = "Film", value = "Comedy"),
            Tag(id = "7dfgr", typeId = "Film", value = "Romance")
        ),
        quote = "Dr. Godwin Baxter: My father once told me, \"Always carve with compassion.\" He was a fucking idiot, but it's not bad advice.",
        coverUri = "https://www.lab111.nl/wp-content/uploads/2024/01/Poor-Things-Banner-2.jpg",
        color = "#719faf",
        backgroundUri = "https://media.npr.org/assets/img/2023/12/07/poor-things-022_054_poorthings_ov_v30464704_fp_dpo_prohq_uhd-sdr_24_eng-166_eng-5120_a_ops9z8mjw_tiff53_rgb_custom-dbfbdcbf8bfa378f9047be6e3e78ff32b595dc84.jpg",
        userId = "237465719432",
        owner = users[0],
        date = Date()
    ),
    Article(
        id = "9882735230",
        title = "Radical Optimism",
        description = "Dua Lipa’s star power sounds muffled on her much-anticipated third album, " +
                "which has many interesting ideas for songs and a surprisingly low hit rate.",
        creator = "Dua Lipa",
        type = Type(id = "", value = "Music"),
        year = 2024,
        tags = listOf(
            Tag(id = "2", typeId = "Music", value = "Pop"),
            Tag(id = "14", typeId = "Music", value = "R&B")
        ),
        coverUri = "https://hips.hearstapps.com/hmg-prod/images/dua-lipa-radical-optimism-release-date-track-list-660fd4e9658a1.jpg?crop=1xw:0.5625xh;center,top",
        color = "#055c62",
        backgroundUri = "https://www.rollingstone.com/wp-content/uploads/2024/05/dua-lipa-album-is-out.jpg?w=1581&h=1054&crop=1",
        userId = "hjk3h6j41204fsd",
        owner = users[1],
        date = Date()
    ),
    Article(
        id = "12895729800",
        title = "Dune",
        description = "Set on the desert planet Arrakis, Dune is the story of the boy Paul Atreides," +
                " heir to a noble family tasked with ruling an inhospitable world where the only " +
                "thing of value is the “spice” melange, a drug capable of extending life and " +
                "enhancing consciousness. Coveted across the known universe, melange is a prize " +
                "worth killing for...",
        creator = "Frank Herbert",
        type = Type(id = "", value = "Movie"),
        year = 2021,
        tags = listOf(
            Tag(id = "2fg4j", typeId = "Book", value = "Science Fiction"),
            Tag(id = "5dfgd", typeId = "Book", value = "Adventure")
        ),
        coverUri = "https://static1.colliderimages.com/wordpress/wp-content/uploads/2021/08/dune-poster-social-featured.jpg",
        color = "#a46d58",
        userId = "hjk3h6j41204fsd",
        owner = users[1],
        date = Date()
    ),
    Article(
        id = "9723400864",
        title = "Fleabag",
        description = "Phoebe Waller-Bridge’s sitcom is full of people who are defeated and " +
                "unlikable – including her own character who masturbates to Barack Obama speeches. " +
                "But it’s utterly riveting",
        creator = "Phoebe Waller-Bridge",
        type = Type(id = "", value = "Series"),
        year = 2016,
        tags = listOf(
            Tag(id = "1ertf", typeId = "Film", value = "Drama"),
            Tag(id = "6regh", typeId = "Film", value = "Comedy")
        ),
        coverUri = "https://media.myshows.me/shows/760/d/9d/d9df55dc471adbc0376a47f398cafa82.jpg",
        color = "#5f4f5b",
        backgroundUri = "https://media.vanityfair.com/photos/593f04ebe9423741a1f17696/master/pass/Phoebe-Waller-Bridge-Fleabag.jpg",
        userId = "hjk3h6j41204fsd",
        owner = users[1],
        date = Date()
    )
)

val posts = listOf(
    Post(
        id = "45g2j23fd8723",
        articleId = "89287892374",
        userId = "237465719432",
        isReposted = false,
        date = Date()
    ),
    Post(
        id = "jkef5s7dfjk23",
        articleId = "7656294214",
        userId = "237465719432",
        isReposted = false,
        date = Date()
    ),
    Post(
        id = "223fgh425kj2g3",
        articleId = "56288952340",
        userId = "237465719432",
        isReposted = false,
        date = Date()
    ),
    Post(
        id = "jh34k5hjk45h",
        articleId = "9882735230",
        userId = "hjk3h6j41204fsd",
        isReposted = false,
        date = Date()
    ),
    Post(
        id = "d234gh5h43jh6g",
        articleId = "12895729800",
        userId = "hjk3h6j41204fsd",
        isReposted = false,
        date = Date()
    ),
    Post(
        id = "23ghf5h34m6k3jh5",
        articleId = "9723400864",
        userId = "hjk3h6j41204fsd",
        isReposted = false,
        date = Date()
    )
)

val comment = Comment(
    id = "j4g5345hkj34h5kj3h246",
    articleId = "9882735230",
    article = articles[3],
    userId = "354h6g13fh25jk7l73",
    nickname = "fabkins4u",
    photoUrl = "https://sun9-69.userapi.com/impg/00uihckUHW4fgg4-ZdihyAPUFnH1FtNmwBLSpA/lkt1MWMkUes.jpg?size=1029x1280&quality=95&sign=e294ed0dcb5bdf230f392ba9ba78a988&type=album",
    text = "la-la-la demo comment la-la-la demo comment la-la-la demo comment la-la-la demo comment la-la-la demo comment",
    repliedCid = null,
    date = Date(),
    likedBy = emptyList()
)

val types = listOf(
    Type(id = "1", value = "Film"),
    Type(id = "2", value = "TV Show"),
    Type(id = "3", value = "Book"),
    Type(id = "4", value = "Music"),
    Type(id = "5", value = "Podcast"),
    Type(id = "6", value = "Blogger"),
    Type(id = "7", value = "Youtube"),
    Type(id = "8", value = "Tiktok"),
    Type(id = "9", value = "Instagram"),
    Type(id = "10", value = "Twitch"),
    Type(id = "11", value = "X"),
    Type(id = "12", value = "Threads"),
    Type(id = "13", value = "Reddit"),
    Type(id = "14", value = "Brand"),
    Type(id = "15", value = "Meme")
)

val tags = listOf(
    Tag(id = "1ertf", typeId = "Film", value = "Drama"),
    Tag(id = "2jghg", typeId = "Film", value = "Mystery"),
    Tag(id = "3sdfe", typeId = "Film", value = "Thriller"),
    Tag(id = "iuou4", typeId = "Film", value = "Fantasy"),
    Tag(id = "5rtys", typeId = "Film", value = "Horror"),
    Tag(id = "6regh", typeId = "Film", value = "Comedy"),
    Tag(id = "7dfgr", typeId = "Film", value = "Romance"),
    Tag(id = "8rtyg", typeId = "Film", value = "Crime"),
    Tag(id = "9rtyy", typeId = "Film", value = "Sci-Fi"),
    Tag(id = "10uut", typeId = "Film", value = "Biography"),
    Tag(id = "1ytu1", typeId = "Film", value = "Historical drama"),
    Tag(id = "1hhj2", typeId = "Film", value = "Musical"),
    Tag(id = "13dgk", typeId = "Film", value = "War"),
    Tag(id = "43614", typeId = "Film", value = "Noir"),
    Tag(id = "1gfh5", typeId = "Film", value = "Western"),
    Tag(id = "1sd6f", typeId = "Book", value = "Fantasy"),
    Tag(id = "2fg4j", typeId = "Book", value = "Science Fiction"),
    Tag(id = "3bvnt", typeId = "Book", value = "Dystopian"),
    Tag(id = "4iert", typeId = "Book", value = "Action"),
    Tag(id = "5dfgd", typeId = "Book", value = "Adventure"),
    Tag(id = "7tyud", typeId = "Book", value = "Thriller"),
    Tag(id = "8dfgg", typeId = "Book", value = "Suspense"),
    Tag(id = "9dfgd", typeId = "Book", value = "Historical Fiction"),
    Tag(id = "10uyi", typeId = "Book", value = "Classics"),
    Tag(id = "11uir", typeId = "Book", value = "Graphic Novel"),
    Tag(id = "12dfg", typeId = "Book", value = "Comic Book"),
    Tag(id = "13aer", typeId = "Book", value = "Detective"),
    Tag(id = "1", typeId = "Music", value = "Rock"),
    Tag(id = "2", typeId = "Music", value = "Pop"),
    Tag(id = "3", typeId = "Music", value = "Jazz"),
    Tag(id = "4", typeId = "Music", value = "Classical"),
    Tag(id = "5", typeId = "Music", value = "Hip-hop"),
    Tag(id = "6", typeId = "Music", value = "Reggae"),
    Tag(id = "7", typeId = "Music", value = "Blues"),
    Tag(id = "8", typeId = "Music", value = "Country"),
    Tag(id = "9", typeId = "Music", value = "Electronic"),
    Tag(id = "10", typeId = "Music", value = "Metal"),
    Tag(id = "11", typeId = "Music", value = "Folk"),
    Tag(id = "12", typeId = "Music", value = "Indie"),
    Tag(id = "13", typeId = "Music", value = "Soul"),
    Tag(id = "14", typeId = "Music", value = "R&B"),
    Tag(id = "15", typeId = "Music", value = "Gospel"),
    Tag(id = "16", typeId = "Music", value = "Alternative"),
    Tag(id = "17", typeId = "Music", value = "Punk"),
    Tag(id = "18", typeId = "Music", value = "Ska"),
    Tag(id = "19", typeId = "Music", value = "Latin"),
    Tag(id = "20", typeId = "Music", value = "House"),
    Tag(id = "21", typeId = "Music", value = "Trance"),
    Tag(id = "22", typeId = "Music", value = "Disco"),
    Tag(id = "23", typeId = "Music", value = "K-Pop"),
    Tag(id = "24", typeId = "Music", value = "Grunge"),
    Tag(id = "25", typeId = "Music", value = "Synthpop"),
    Tag(id = "26", typeId = "Music", value = "New Wave"),
    Tag(id = "27", typeId = "Music", value = "Ambient"),
    Tag(id = "28", typeId = "Music", value = "Jazz Fusion"),
    Tag(id = "29", typeId = "Music", value = "Progressive Rock"),
    Tag(id = "30", typeId = "Music", value = "Post-Rock")
)

fun getArticleById(articleId: String?): Article? {
    if (articleId == null) {
        return null
    }
    for (article in articles) {
        if (article.id == articleId) {
            val result = article
            result.isLiked = false
            result.isReposted = false
            return result
        }
    }
    return null

    // TODO: check if it is liked or reposted
}

fun getTypeById(id: String): Type? {
    for (type in types) {
        if (type.id == id) {
            return type
        }
    }
    return null
}

fun getAllTypes(): List<Type> {
    return types
}

fun searchTags(query: String): List<Tag> {
    return tags.filter { it.value!!.contains(query, ignoreCase = true) }
}

fun getAllTags(): List<Tag> {
    return tags
}