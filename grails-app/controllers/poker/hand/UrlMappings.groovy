package poker.hand

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/pokerGameScreen")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
