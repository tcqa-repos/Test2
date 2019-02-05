package CompositeBuilds_MyProject.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

object CompositeBuilds_MyProject_HttpsGithubComTcqaReposCalculator : GitVcsRoot({
    name = "https://github.com/tcqa-repos/Calculator"
    url = "https://github.com/tcqa-repos/Calculator"
    branchSpec = "+:*"
    authMethod = password {
        userName = "tcqa-repos"
        password = "credentialsJSON:ee803346-9835-43a2-bf3d-eb11d81fa602"
    }
})
