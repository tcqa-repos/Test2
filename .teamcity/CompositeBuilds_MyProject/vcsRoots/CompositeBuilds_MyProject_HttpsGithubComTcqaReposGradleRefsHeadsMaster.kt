package CompositeBuilds_MyProject.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

object CompositeBuilds_MyProject_HttpsGithubComTcqaReposGradleRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/tcqa-repos/Gradle#refs/heads/master"
    url = "https://github.com/tcqa-repos/Gradle"
    authMethod = password {
        userName = "tcqa-repos"
        password = "credentialsJSON:f450f0e3-c536-4090-89d4-1928a49c4a6b"
    }
})
