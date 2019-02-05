package CompositeBuilds_MySimpleProject_NewSubProject.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

object CompositeBuilds_MySimpleProject_NewSubProject_HttpsGithubComJuliaReshMyProject : GitVcsRoot({
    name = "https://github.com/JuliaResh/MyProject"
    pollInterval = 300
    url = "https://github.com/JuliaResh/MyProject"
    useMirrors = false
})
